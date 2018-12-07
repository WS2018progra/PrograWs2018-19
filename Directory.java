public class Directory extends Node{

    private Entry[] entries=new Entry[0];

    public Directory(){
        touch();
    }

    public Entry[] getEntries(){
        return this.entries;
    }

    public Entry getEntry(String name){
        for(Entry e: entries){
            if(e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }

    public boolean containsEntries(String name){
        for(Entry e:entries){
            if(e==null){
                return false;
            }
            else if(e.getName().equals(name)){
                return true;
            }
            
        }
        return false;
    }

    public Entry createDirectory(String name){
        Entry[] entries3 = new Entry[entries.length+1];
        for(int i=0;i<entries.length;i++) {
            Entry e = entries[i];
            if(e.getName().equals(name)) {
                System.out.println("Error directory already exists");
                return null;
            }
            entries3[i] = e;
        }
        Entry newEntry = new Entry(name,new Directory());
        entries3[entries.length] = newEntry;
        this.entries = entries3;
        return newEntry;
    }

    public Entry createFile(String name,String content){
        Entry[] entries2 = new Entry[entries.length+1];
        for(int i=0;i<entries.length;i++) {
            Entry e = entries[i];
            if(e.getName().equals(name)) {
                System.out.println("Error file already exists");
                return null;
            }
            entries2[i] = e;
        }
        Entry newEntry = new Entry(name,new File(content));
        entries2[entries.length] = newEntry;
        this.entries = entries2;
        return newEntry;
    }

    public Entry createHardlink(String name,Entry entry){
        Entry[] entries2 = new Entry[entries.length+1];
        for(int i=0;i<entries.length;i++) {
            Entry e = entries[i];
            if(e.getName().equals(name)) {
                System.out.println("Error hardlink already exists");
                return null;
            }
            entries2[i] = e;
        }
        Entry newEntry = new Entry(name,entry.getNode());
        entries2[entries.length] = newEntry;
        this.entries = entries2;
        return newEntry;
    }

    public static Directory createEmpty(){
        return new Directory();
    }
   
    public void accept(String name,Visitor visitor){
        visitor.visitDirectory(name,this);
        for(Entry e:entries) {
            File f = e.getAsFile();
            if(f!=null) {
                visitor.visitFile(e.getName(),f);
            }
             else {
                Directory d = e.getAsDirectory();
                if(d!=null) {
                    d.accept(e.getName(),new Printer(((Printer)visitor).getCurrent()));
                }
            }
        }
        visitor.visitedDirectory();
    }
    
    
}