public class TreeListElement{
  private Tree value;
    
  private TreeListElement next;

  /**
  * @param inputValue The value of the new TreeListElement
  * @param inputNext The next elements of the TreeListElement
  */
  public TreeListElement(Tree inputValue, TreeListElement inputNext){
    this.value = inputValue;
    this.next = inputNext;
  }
  
  //a)
  
  public void setValue(Tree value){
    this.value=value;
  }

  public Tree getValue(){
    return this.value;
  }

  public TreeListElement getNext(){
    return this.next;
  }

  public void setNext(TreeListElement next){
    this.next=next;
  }
  //b)
  
  //c)
  
  //d)
  
  //e)
  
}
