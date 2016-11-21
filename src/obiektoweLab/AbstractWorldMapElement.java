package obiektoweLab;

public abstract class AbstractWorldMapElement implements IMapElement{
    protected Position position;

    public Position getPosition(){
        return this.position;
    }

}