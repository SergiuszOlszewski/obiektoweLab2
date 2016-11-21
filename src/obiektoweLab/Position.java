package obiektoweLab;

public class Position {

    public final int x;
    public final int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + this.x + ',' + this.y + ")";
    }

    public boolean smaller(Position other){
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean greater(Position other){
        return this.x >= other.x && this.y >= other.y;
    }

    public Position add(Position other){
        return new Position(this.x + other.x, this.y + other.y);
    }

    public boolean equals(Object other){
        if (this == other) return true;
        if(!(other instanceof Position)) return false;
        Position that = (Position) other;
        return this.x == that.x && this.y == that.y;
    }

}