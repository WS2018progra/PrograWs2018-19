package bird;
import java.util.ArrayList;
import bird.Swallow;

public class Flock<S extends Swallow> implements FlockInterface<S>{
    
    public ArrayList<S> swarm;

    public Flock(){
        swarm=new ArrayList<S>();
    }

    public void join(S swallow){
        swarm.add(swallow);
    }


    //Aber uns sagen dass man die methoden namen nicht zu lang machen soll xDDDD
    public double getAverageCruiseAirspeedVelocity(){
        if(swarm.size()==0){
            System.out.println("Error the swarm has no members");
            return 0;
        }
        if(swarm.size()==1){
            return ((Swallow)this.swarm.get(0)).getAirspeedVelocity()-2.0;
        }
        else {

            double average=0;
            int position;

            for(position=0;position<swarm.size();position++){
                if(position<2){
                    average+=(((Swallow)swarm.get(position)).getAirspeedVelocity()-2-position);
                }
                else average+=((Swallow)swarm.get(position)).getAirspeedVelocity();
            }

           return average=average/(position+1);
        }
    }
}