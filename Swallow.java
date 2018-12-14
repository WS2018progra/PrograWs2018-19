package bird;

import bird.swallows.AfricanSwallow;
import bird.swallows.EuropeanSwallow;
import cargo.Nut;

public abstract class Swallow{
    public Object cargo;

    public Swallow(){
        this.cargo=null;
    }
    public Swallow(Object cargo){
        this.cargo=cargo;
    }

    public Object getCargo(){
        return this.cargo;
    }

    public boolean isLadden(){
        return getCargo()!=null;
    }

    protected abstract int getAirspeedVelocity();

    //asv steht hier für AirSpeedVelocity
    //Da dies die letze Abgabe ist wollte ich dir nochmal richtig schönen java code schreiben xD
    protected int calcAirspeedVelocity(int asv){
       return getCargo() instanceof Nut ? ((asv-((Nut)getCargo()).getWeight())>0 ? asv-((Nut)getCargo()).getWeight() : 0) : (asv%2==0 ? asv : asv-1)/2;
    }

    public static Swallow createAfricanSwallow(Object cargo){
        return (Swallow)new AfricanSwallow(cargo);
    }

    public static Swallow createEuropeanSwallow(Object cargo){
        return (Swallow)new EuropeanSwallow(cargo);
    }
}