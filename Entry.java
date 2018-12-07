public class Entry{

public String name;
public Node node;

public Entry(String name,Node node){
    this.name=name;
    this.node=node;
}
public String getName(){
    return this.name;
}

public Node getNode(){
    return this.node;
}
public File getAsFile(){
    if(node instanceof File){
        return (File)node;
    }
    else{
        return null;
    }
}

public Directory getAsDirectory(){
    if(node instanceof Directory){
        return (Directory)node;
    }
    else return null;
}

public Entry createHardLink(String newName){
    return new Entry(newName,this.node);
}
}