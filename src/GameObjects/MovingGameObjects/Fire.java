package GameObjects.MovingGameObjects;

import GameStructureElements.Game;
import Toolkit.Vector;

public class Fire extends MovingGameObject {

    private final double extraRadian;
    private final double minSpeed;

    public Fire(Vector position, double maxSpeed, double minSpeed, double direction) {
        super(position, "Fire", 4, maxSpeed, 0);
        this.extraRadian = Math.random() * 2 * Math.PI;
        this.minSpeed = minSpeed * Game.FRAME_DELAY;
        this.movementVelocity = Vector.radianToVector(direction + ( Math.random() - .5 ) * 2).unitVector().scale(getMaxSpeed() * Math.sqrt(Math.random()));
        setSpriteFilepath("Images/Fire/fire" + (int) ( Math.random() * 10 + 1 ) + ".png");
    }

    //==================================================================================================================

    public boolean isActive() {
        return getTotalVelocity().magnitude() > minSpeed;
    }

    //==================================================================================================================

    @Override
    public void draw() {
        super.draw(getTotalVelocity().getRadian() + extraRadian);
    }
}
