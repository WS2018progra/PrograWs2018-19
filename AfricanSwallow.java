package bird.swallows;

import cargo.Nut;
import bird.Swallow;

public class AfricanSwallow extends Swallow{

    public AfricanSwallow(){
        super();
    }
    public AfricanSwallow(Object cargo){
        super(cargo);
    }

    public int getAirspeedVelocity(){
        return getCargo()==null? 12 : calcAirspeedVelocity(12);
    }


}