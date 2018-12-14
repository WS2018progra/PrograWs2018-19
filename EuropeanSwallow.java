package bird.swallows;

import cargo.Nut;
import bird.Swallow;

public class EuropeanSwallow extends Swallow{

    public EuropeanSwallow(){
        super();
    }
    public EuropeanSwallow(Object cargo){
        super(cargo);
    }

    public int getAirspeedVelocity(){
        return getCargo()==null? 11 : calcAirspeedVelocity(11);
    }


}