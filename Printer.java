public class Printer implements Visitor {
    private String previous = "";
    private String current = "";
    
    public Printer() {}
    public Printer(String previous) {
        this.previous = previous;
    }
    public String getPrevious() {
        return this.previous;
    }
    public String getCurrent() {
        return this.current;
    }
    public void visitFile(String name, File file) {
        System.out.println(file.getLastModified() + " " + previous + current + name);
        System.out.println("> " + file.readContent());
    }
    public void visitDirectory(String name, Directory directory){
        if(name!=null && name.length()>0){
            current = current + name + "/";
        } else {
            current = current + "/";
        }
        System.out.println(directory.getLastModified() + " " + previous + current);
    }
    public void visitedDirectory() {
        //current = previous;
    }
}
