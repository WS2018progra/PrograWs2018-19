package people;

import bird.Swallow;
import bird.Flock;
import people.UnspecificQuestionException;

public class Troll{
    private boolean confused;

    public Troll(){
        this.confused=false;
    }

    public void pass(){
        if(this.confused){}
        else java.lang.System.exit(-1);
    }

    public int askAboutAirspeedVelocity(Object object) throws UnspecificQuestionException{
        if(object instanceof bird.FlockInterface){
            return (int)((bird.Flock)object).getAverageCruiseAirspeedVelocity();
        }
        else if(object instanceof Swallow){
            Flock<Swallow> swarm = new Flock<Swallow>();
            Swallow newSwallow = (Swallow)object;
            swarm.join(newSwallow);
            return (int)(swarm.getAverageCruiseAirspeedVelocity()+2.0);
        }
        else {
            if(object.equals("Swallow")||
               object.equals("Unladden Swallow")||
               object.equals("European Swallow")||
               object.equals("African Swallow")){
                this.confused=true;
                //werfe exception;
                throw new UnspecificQuestionException();
            }
            return 0;
        }
    }
}