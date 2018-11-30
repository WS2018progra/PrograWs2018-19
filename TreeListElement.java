public class TreeListElement{
    private Tree value;
    
    private TreeListElement next;

    public TreeListElement(Tree inputValue, TreeListElement inputNext){
        this.value = inputValue;
        this.next = inputNext;
    }
    
    public Tree getValue() {
        return this.value;
    }
    //wird momentan, wie manche anderen Selektoren, garnicht benötigt - aus Routine erstellt.
    public void setValue(Tree value) {
        this.value = value;
    }
    
    public TreeListElement getNext() {
        return this.next;
    }
    
    public void setNext(TreeListElement next) {
        this.next = next;
    }
    
    /**
     * Berechnet die Stringrepräsentation des aktuellen TreeListElement-Objektes, sowie, rekursiv, aller per next-Referenz
     * verbundenen Objekte der TreeList. Die einzelnen Repräsentationen der TreeListElemente werden mit Kommata von einander getrennt.
     * Hierbei wird jeweils die Methode toString() der Klasse Tree aufgerufen um die Arbeit aufzuteilen.
     * @return die String-Repräsentation des aktuellen, sowie, falls vorhanden, aller folgenden TreeListElement-Objekten.
     */
    public String toString() {
        String s = "";
        if(value!=null){
            s += this.value.toString();
        }
        if(next!=null) {
            s = s + "," + next.toString();
        }
        return s;
    }
  
}
