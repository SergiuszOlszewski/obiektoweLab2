package obiektoweLab;

//import java.util.ArrayList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap{

    private List<HayStack> hayStacks;

    public UnboundedMap(List<HayStack> hayStacks){
        this.hayStacks = hayStacks;
    }


    @Override
    public Object objectAt(Position position) {
        for(HayStack hayStack : hayStacks){
            if(hayStack.getPosition().equals(position)) return hayStack;
        }
        return super.objectAt(position);
    }
    
    protected Position getLowerLeft(){
        
        Position answer = null;
        for(Car car : cars){
            if(answer == null || car.getPosition().smaller(answer)) answer = car.getPosition();
        }
        for(HayStack hayStack : hayStacks){
            if(answer == null || hayStack.getPosition().smaller(answer)) answer = hayStack.getPosition();
        }
        return answer;
    }
    
    protected Position getUpperRight(){
        Position answer = null;
        for(Car car : cars){
            if(answer == null || car.getPosition().greater(answer)) answer = car.getPosition();
        }
        for(HayStack hayStack : hayStacks){
            if(answer == null || hayStack.getPosition().greater(answer)) answer = hayStack.getPosition();
        }
        return answer;
    }

    
}