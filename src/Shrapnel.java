public class Shrapnel extends MovingGameObject {

    /**
     * a number that determines which way the Shrapnel is facing
     * for drawing purposes only
     */
    private double direction;

    //==================================================================================================================

    public Shrapnel(Vector position) {
        super(position, "Shrapnel", 16, 5e-4, 1);
        setSpriteFilepath("Images/shrapnel" + (int) (Math.random() * 5 + 1) + ".png");

        direction = Math.random();
        movementVelocity = new Vector((Math.random() - .5) * 2, (Math.random() - .5) * 2).toUnitVector().scaledVector(getMaxSpeed());
    }

    //==================================================================================================================

    public boolean isActive(){
        return getTotalVelocity().magnitude() < getMaxSpeed() / 100;
    }

    @Override
    public void draw() {
        StdDraw.picture(getPositionX(), getPositionY(), getSpriteFilepath(), GameObject.PIXEL_SIZE * 16, GameObject.PIXEL_SIZE * 16, Math.toDegrees(direction));
    }
}
