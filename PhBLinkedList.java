/**
 * Class that represents a linked list of nodes used to store a sequence of Persons as a PhoneBook
 * @author Esther Shin 
 */
public class PhBLinkedList implements PhoneBook{
  
  /**
   * the first node of the linked list (null if the list is empty)
   */
  private LLNode firstNode;
  
  /**
   * constructor
   * creates a linked list that is initially empty 
   */
  public PhBLinkedList() {
    firstNode = null;
  }
  
  /**
   * Method that returns the first node
   * @return  the first node of the linked list
   * Runtime Analysis: O(1)
   */
  public LLNode getFirst(){
    return firstNode;
  }
  
  /**
   * Method that sets/changes the first node of the linked list 
   * @param  the node that you want to set as the first node of the linked list
   * Runtime Analysis: O(1)
   */
  public void setFront(LLNode node){
    this.firstNode = node;
  }
  
  /**
   * Method that returns the size (length) of the linked list 
   * @return  the number of nodes in the list 
   * Runtime Analysis: O(n)
   */
  public int size(){
    /**
     * currentLength: stores the current size of the linked list and increments as it moves through the linked list
     */
    int currentLength = 0;
    
    /**
     * nodePointer: variable that starts at the beginning of the linked list and then "points" to each next node
     */
    LLNode nodePointer = getFirst();
    
    /**
     * loops through the linked list as long as the nodePointer is not pointing to a null node (indicating either an 
     *  empty list or the end of the linked list
     */
    while(nodePointer != null){
      nodePointer = nodePointer.getNext();
      currentLength = currentLength + 1;
    }
    return currentLength;
  }
  
  /**
   * Method that inserts a new Person before the i-th component of the linked list sequence 
   * @param i  The position of the node (i-th component) of the linked list at which you want to insert a new Person
   * @param person  the data/value stored in the component that you are inserting (what kind of Person)
   * Runtime Analysis: O(n)
   */
  public void insert(int i, Person person){
    /**
     * insertedNode: the new node that is to be inserted into the linked list with the data Person stored in it
     */
    LLNode insertedNode = new LLNode(person, null);
    
    /**
     * nodePointer: variable that starts at the beginning of the linked list and then "points" to each next node, keeping
     *  track of where in the linked list it is currently at
     */
    int nodePointer = 0;
    if(size() < i){
      i = size();
    }
    if (i == 0){
      firstNode = new LLNode(person, firstNode);
    }
    else{ 
      /**
       * loops through the linked list until it finds where i-th component at which it needs to insert the new node, and then inserts it
       */
      for(LLNode node = getFirst(); node != null; node = node.getNext()){
        nodePointer = nodePointer + 1;
        if(nodePointer == i){
          insertedNode.setNext(node.getNext());
          node.setNext(insertedNode);
        }
      }
    }
  }
  
  /**
   * Method that removes the i-th component of the array sequence and returns the Person (component) removed
   * @return the Person (component) that was removed
   * Runtime Analysis: O(n)
   */
  public Person remove(int i){
    /**
     * nodePointer: variable that starts at the beginning of the linked list and then "points" to each next node, keeping
     *  track of where in the linked list it is currently at
     */
    int nodePointer = 0;
    
    /**
     * preNode: stores the location in the linked list of the previous node of the i-th component to be removed
     */
    int preNode = 0;
    
    /**
     * beforeNode: stores the node that is at the location of preNode (AKA the previous node of the i-th component to be removed)
     */
    LLNode beforeNode = null;
    
    /** 
     * personRemoved: stores the Person that is stored in the node that is to be removed
     */
    Person personRemoved = null;
    
    /**
     * loops through the linked list, finds the i-th component it wants to remove, stores the Person in the node, and then sets the previous
     *  node's reference to the node after the node being removed
     */
    for(LLNode node = getFirst(); node != null; node = node.getNext()){
      if(preNode == i-1){
        beforeNode = node;
      }
      if(nodePointer == i){
        personRemoved = node.getPerson();
        if (beforeNode == null){
          firstNode = node.getNext();
        }
        else{
          beforeNode.setNext(node.getNext());
        }
      }
      preNode = preNode + 1;
      nodePointer = nodePointer + 1;
    }
    return personRemoved;
  }
  
  /**
   * Method that returns Person stored in the i-th component of the linked list sequence
   * @param i  The index of the linked list at which the Person the user wants returned is 
   * @return  The i-th component of the linked list sequence
   * Runtime Analysis: O(n)
   */
  public Person lookup(int i){
    if(size() < i){
      throw new NullPointerException("The phoneBook length is less than i");
    }
    /**
     * nodePointer: variable that starts at the beginning of the linked list and then "points" to each next node, keeping
     *  track of where in the linked list it is currently at
     */
    int nodePointer = 0;
    
    /**
     * personLookedUp: stores the Person that is in the i-th component of the linked list being looked up
     */
    Person personLookedUp = null;
    
    /**
     * loops through the linked list, and once it gets to the node that it wants to look up, it stores 
     *  value of Person that is in that node
     */
    for(LLNode node = getFirst(); node != null; node = node.getNext()){
      if(nodePointer == i){
        personLookedUp = node.getPerson();
      }
      nodePointer = nodePointer + 1;
    }
    return personLookedUp;
  } 
  
  /**
   * Method that calls the iterator for a linked list 
   * @return  a new iterator for the linked list phoneBook sequence
   * Runtime Analysis: O(1)
   */
  public PhBIterator iterator(){
    return new PhBIteratorLinkedList(firstNode);
  }
}