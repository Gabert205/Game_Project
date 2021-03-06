package GameObjects.StationaryGameObjects;

import GameObjects.MovingGameObjects.Ammo;
import Toolkit.Vector;
import GameStructureElements.Game;

public class ProjectileLauncher extends Weapon {

    /**
     * the amount of damage that each shot fires
     */
    private double damagePerShot;

    private Ammo ammoTemplate;

    //==================================================================================================================

    public ProjectileLauncher(String name, double range, double degreesOfInaccuracy, double recoilForce, double knockBackForce, double criticalDamageChance, double criticalDamageAddedDamage, double damagePerShot, double shotDelay) {
        super(name, range, degreesOfInaccuracy, recoilForce, knockBackForce, criticalDamageChance, criticalDamageAddedDamage, shotDelay);
        this.damagePerShot = damagePerShot;
    }

    //==================================================================================================================


    //region Get, Sets, and Adds


    public double getDamagePerShot() {
        return damagePerShot;
    }

    public Ammo getAmmoTemplate() {
        return ammoTemplate;
    }

    public void setAmmoTemplate(Ammo ammoTemplate) {
        this.ammoTemplate = ammoTemplate;
    }

    public void addAmmoSpeedUpgradePoints(int ammoSpeedUpgradePointsToBeAdded) {
        ammoTemplate.addAmmoSpeedUpgradePoints(ammoSpeedUpgradePointsToBeAdded);
    }

    @Override
    public boolean isReadyToFire() {
        return ( Game.currentFrame - getLastShotFiredFrameStamp() ) * Game.FRAME_DELAY >= getShotDelay();
    }

    @Override
    public double getDamagePerSecond() {
        return getDamagePerShot() / getShotDelay();
    }

    //endregion

    //==================================================================================================================

    @Override
    public Ammo fire() {
        Ammo ammo = getAmmoTemplate().clone(getHeadPosition());

        double velocityDirection = getDirection().getRadian();
        velocityDirection += ( Math.random() * 2 - 1 ) * getDegreesOfInaccuracy();
        ammo.movementVelocity = Vector.radianToVector(velocityDirection).scaledVector(ammo.getMaxSpeed());

        setSpriteFilepath(getSpriteFilepath());

        return ammo;
    }

}
