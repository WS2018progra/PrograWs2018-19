public class File extends Node{

    private String content;
    
    public File(String content){
        this.content=content;
        lastModified=System.currentTimeMillis();
    }

    public String readContent(){
        return this.content;
    }

    public void writeContent(String content){
        touch();
        this.content=content;
    }
}