public class Tree
{
    private int label;
  
    private TreeList children;
  
    public Tree(int inputLabel, TreeList inputChildren){
        this.label = inputLabel;
        this.children = inputChildren;
    }
    
    public int getLabel() {
        return this.label;
    }
    
    public TreeList getChildren() {
        return this.children;
    }
    
    public void setLabel(int label) {
        this.label = label;
    }
    
    public void setChildren(TreeList children) {
        this.children = children;
    }
    
    /**
     * Erstellt eine String-Repräsentation des Baum-Objektes mit der Form
     * "label->[children]", wobei die einzelnen Kinder ihre String-Repräsentation in der Klasse TreeListElement mit der
     * Methode toString() jeweils (rekursiv) selbst berechnen.
     * Wenn ein Objekt der Klasse Tree keine Referenz auf eine neue TreeList hat, ist children entsprechend leer.
     ± @return die String-Repräsentation des aktuellen Tree-Objektes.
     */
    public String toString(){
        String s = this.label + "->[";
        if(children != null) {
            TreeListElement head = children.getHead();
            if(head != null) {
                s+=head.toString();
            }
        }
        return s+"]";
    }
    
    /**
     * Berechnet den Verzweigungsgrad, d.h. die maximale Anzahl von Elementen aller TreeList Objekte. Wenn das aktuelle
     * Tree-Objekt keine Kinder hat, ist der Verzweigungsgrad 0.
     * @return der Verzweigunsgrad des aktuellen Baumes
     */
    public int branchingDegree(){
        if(children==null) return 0;
        TreeListElement currentTLE = children.getHead();
        int thisDegree=0, maxChildDegree=0;
        while(currentTLE!=null){
            Tree currentT = currentTLE.getValue();
            if(currentT != null){
                thisDegree++;
                int currentTdegree = currentT.branchingDegree();
                maxChildDegree = (currentTdegree > maxChildDegree) ? currentTdegree : maxChildDegree;
            }
            currentTLE = currentTLE.getNext();
        }
        int max = (thisDegree > maxChildDegree) ? thisDegree : maxChildDegree;
        return max;
    }
    
    /**
     * Berechnet ob eine gegebene Zahl Label mindestens eines Objektes einer TreeList welche mit den Baum zusammenhängt ist.
     * @return true, wenn Zahl enthalten, ansonsten false.
     */
    public boolean contains(int toSearch){
        if(this.label==toSearch) return true;
        if(this.children==null) return false;
        TreeListElement currentTLE = this.children.getHead();
        while(currentTLE!=null){
            Tree currentT = currentTLE.getValue();
            if(currentT != null && currentT.contains(toSearch)) return true;
            currentTLE = currentTLE.getNext();
        }
        return false;
    }
    
    /**
     * Erstellt ein Objekt der Klasse Tree mit gegebenen Wert und fügt alle zusätzlich gegebenen Tree-Objekte der
     * TreeList des neu erzeugten Tree-Objektes hinzu. Deren children-Referenz muss natürlich nicht null sein, das heißt,
     * diese können selbst wieder eigene Tree-Lists mit Bäumen besitzen.
     * @param value Wert für das Label des neu erzeugten Tree-Objektes
     * @param children beliebig viele Tree-Objekte, welche der TreeList des neu erzeugten Tree-Objektes hinzugefügt werden.
     * @return das neu erzeugte Tree-Objekt mit gegebenem Wert und gegebenen Kindern.
     */
    public static Tree buildTree(int value, Tree... children){
        if(children.length!=0) {
            TreeList treeList = new TreeList();
            TreeListElement current = new TreeListElement(children[0],null);
            treeList.setHead(current);
            TreeListElement next;
            for(int i=0;i<children.length-1;i++) {
                next = new TreeListElement(children[i+1],null);
                current.setNext(next);
                current = next;
            }
            return new Tree(value,treeList);
        } else {
            return new Tree(value,null);
        }
    }
  
  /**
  * Method for trying out some of the implemented commands.
  * @param args input strings from the console
  */
  
  public static void main(String[] args){
    Tree[] trees = {buildTree(1,buildTree(2),buildTree(3),buildTree(4)), buildTree(-1) , buildTree(4,buildTree(1,buildTree(1,buildTree(1,buildTree(1),buildTree(1),buildTree(1)),buildTree(1),buildTree(1))),buildTree(2),buildTree(2,buildTree(2))),
    buildTree(72, buildTree(27), buildTree(11), buildTree(54,buildTree(89,buildTree(10),buildTree(20),buildTree(42))), buildTree(23)),
    buildTree(54,buildTree(89,buildTree(10),buildTree(20),buildTree(42)))};
    
    for(Tree tree:trees){
      if(tree != null){
          System.out.println(trees.toString());
        String test = "";
        test = test + tree.toString() + "\n";
        test = test + "Branching Degree: " + tree.branchingDegree() + "\n";
        test = test + "2 contained: " + tree.contains(2) + "\n";
        test = test + "42 contained: " + tree.contains(42) + "\n";
        test = test + "1 contained: " + tree.contains(1) + "\n";
        SimpleIO.output(test);
      }
    }
    
  }
  
}
