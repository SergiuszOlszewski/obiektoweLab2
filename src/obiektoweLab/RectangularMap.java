package obiektoweLab;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    List<Car> cars;
    Position zero = new Position(0,0);
    Position max;

    RectangularMap(int width, int height){
        this.max = new Position(width,height);
        this.cars = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Position position) {
        return position.greater(this.zero) && position.smaller(this.max) && !isOccupied(position);
    }

    @Override
    public boolean add(Car car) {
        if(!this.canMoveTo(car.getPosition())) return false;
        this.cars.add(car);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int i = 0;
        for(MoveDirection direction : directions){
            cars.get(i).move(direction);
            i = (i+1)%cars.size();
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Position position) {
        for(Car car : cars){
            if(car.getPosition() == position) return car;
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        out.append(new MapVisualizer().dump(this,zero,max));
        for(Car car : cars){
            out.append(car.toString());
            out.append(car.getPosition());
            out.append(isOccupied(car.getPosition()));
            out.append("\n");
        }
        return out.toString();
    }
}
