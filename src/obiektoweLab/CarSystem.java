package obiektoweLab;
import java.util.ArrayList;
import java.util.List;

public class CarSystem {

    public static void main(String[] args) {
    	MoveDirection[] directions=null;
        try{
        	directions = OptionParser.parse(args);
        	}
        catch(IllegalArgumentException ex){
        	System.out.println("zly argumenty");
        }
        List<HayStack> hayStacks = new ArrayList<>();
        hayStacks.add(new HayStack(new Position(-4,-4)));
        hayStacks.add(new HayStack(new Position(7,7)));
        hayStacks.add(new HayStack(new Position(3,6)));
        hayStacks.add(new HayStack(new Position(2,0)));
        IWorldMap map = new UnboundedMap(hayStacks);
        map.add(new Car(map));
        map.add(new Car(map,3,4));
        map.run(directions);
        System.out.println(map);
    }

}