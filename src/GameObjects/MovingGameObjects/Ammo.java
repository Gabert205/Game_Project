package GameObjects.MovingGameObjects;

import Toolkit.Vector;

public abstract class Ammo extends MovingGameObject {

    /**
     * the max distance this Ammo will be able to travel
     */
    private double range;

    /**
     * the total distance the Ammo has already traveled
     */
    private double distanceTraveled;

    /**
     * the damage the Ammo will do upon impact
     */
    private double damage;

    /**
     * the force the Ammo will exert on the Object it impacts
     */
    private double knockBackForce;

    /**
     * the amount of upgrade points that has been spent on the Ammo's max speed
     */
    private int ammoSpeedUpgradePoints;


    //==================================================================================================================

    public Ammo(String name, int size, double maxSpeed, double mass, double range, double damage, double knockBackForce) {
        super(name, size, maxSpeed, mass);
        this.range = range;
        this.damage = damage;
        this.knockBackForce = knockBackForce;
        this.distanceTraveled = 0;
    }

    //==================================================================================================================

    //region Gets, Sets, and Adds


    public double getMaxSpeed() {
        return super.getMaxSpeed() * ( 1 + ammoSpeedUpgradePoints / 5. );
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void addDistanceTraveled(double distanceTraveledToBeAdded) {
        this.distanceTraveled += distanceTraveledToBeAdded;
    }

    public double getRange() {
        return range;
    }

    public double getDamage() {
        return damage;
    }

    public void addDamage(double damageToBeAdded) {
        this.damage += damageToBeAdded;
    }

    public double getKnockBackForce() {
        return knockBackForce;
    }

    public boolean isActive() {
        return getDistanceTraveled() <= range;
    }

    public int getAmmoSpeedUpgradePoints() {
        return ammoSpeedUpgradePoints;
    }

    public void addAmmoSpeedUpgradePoints(int ammoSpeedUpgradePointsToBeAdded) {
        ammoSpeedUpgradePoints += ammoSpeedUpgradePointsToBeAdded;
    }


    //endregion

    //==================================================================================================================

    public void move() {
        super.move(null, false);
        addDistanceTraveled(getTotalVelocity().magnitude());
    }

    public abstract Ammo clone(Vector position);

    @Override
    public void draw() {
        super.draw(getTotalVelocity().getRadian());
    }
}
