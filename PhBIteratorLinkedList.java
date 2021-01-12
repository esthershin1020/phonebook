/**
 * A class that iterates over the elements of a linked list
 * @author Esther Shin 
 */
import java.util.NoSuchElementException;

public class PhBIteratorLinkedList implements PhBIterator{
  
  /**
   * stores the node containing the next value of the iteration
   */
  private LLNode nodePointer;
  
  /** 
   * constructor 
   * created an iterator for the linked list 
   * @param firstNode  the node from which the iteration is started
   */
  public PhBIteratorLinkedList(LLNode firstNode){
    this.nodePointer = firstNode;
  }
  
  /**
   * Method that returns whether there is still more data in the linked list
   * @return  true if the iteration is not at the end of the linked list and false when it is at the end
   * Runtime Analysis: O(1)
   */
  public boolean hasNext(){
    if(nodePointer != null){
      return true;
    }
    else{
      return false;
    }
  }
  
  /**
   * Method that returns the current element of the linked list as the linked list is iterated through
   * @return  the next element of the linked list as we iterate through the linked list 
   * @throws NoSuchElementException if there are no more elements
   * Runtime Analysis: O(1)
   */
  public Person next(){
    /**
     * stores the Person that is stored in the node being checked
     */
    Person save = null;
    if(nodePointer == null){
      throw new NoSuchElementException();
    }
    else{
      save = nodePointer.getPerson();
      nodePointer = nodePointer.getNext();
    }
   return save;
  }
}