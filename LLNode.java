/**
 * This class is the node a linked list
 * @author Esther Shin 
 */
public class LLNode{
  
  /**
   * the person stored in the node
   */
  private Person person;
  
  /**
   * a reference to the next node of the list
   */
  private LLNode next;
  
  /**
   * the constructor
   * @param person  the person to store in the node
   * @param next  a reference to the next node of the list
   */
  public LLNode(Person person, LLNode next){
    this.person = person; 
    this.next = next;
  }
  
  /**
   * Method that returns the person stored in the node
   * @return the person stored in the node
   * Runtime Analysis: O(1)
   */
  public Person getPerson(){
    return person;
  }
  
  /**
   * Return the next node of the list
   * @return the next node of the list
   * Runtime Analysis: O(1)
   */
  public LLNode getNext(){
    return next;
  }
  
  /**
   * Sets the next node to come after this node
   * @param next  the node that should come after this node in the list
   * Runtime Analysis: O(1)
   */
  public void setNext(LLNode next){
    this.next = next;
  }
}
  
  