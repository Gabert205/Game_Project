public class StationaryGameObject extends GameObject {

    /**
     * the unit Vector that the Object is facing - default is facing right
     */
    private Vector direction;

    //==================================================================================================================

    public StationaryGameObject(){
        super("Stationary_Game_Object");
        this.direction = new Vector(1, 0);
        setSpriteFilepath("Images/unknown_tile.png");
    }

    public StationaryGameObject(String name){
        super(name);
        this.direction = new Vector(1, 0);
    }

    public StationaryGameObject(Vector position, String name){
        super(position, name);
        this.direction = new Vector(1, 0);
    }

    //==================================================================================================================

    //region Gets and Sets


    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public double getDirectionRadian(){
        return direction.getRadian();
    }


    //endregion

    //==================================================================================================================
}
