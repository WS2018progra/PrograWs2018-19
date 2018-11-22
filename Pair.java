public class Pair{
    private final String key;
    private final String value;
    Pair(String key,String value){
        this.key=key;
        this.value=value;
    }

    Pair(String key,Integer i){
        this.key=key;
        value=i.toString();
    }

    public String getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }

    public String toString(){
        return "'"+key+"': '"+value+"'";
    }

    public static Pair fromString(String key_value_pair){
        String testArray[]=key_value_pair.split("'");
        Pair p1=new Pair(testArray[1],testArray[3]);
        return p1;
    }

}