public abstract class Node{

    public long lastModified;

    public long getLastModified() {
        return this.lastModified;
    }

    public void touch(){
        this.lastModified=System.currentTimeMillis();
    }

}