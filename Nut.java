package cargo;

public class Nut{
    public String name;
    public int weight;

    public Nut(String name,int weight){
        if(this.name==null)name="";
        else this.name=name;
        this.weight=weight;
    }
    public Nut(){
        this.name="";
        this.weight=0;
    }

    //Selektoren

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setWeight(int weight){
        this.weight=weight;
    }

    public int getWeight(){
        return this.weight;
    }

}
