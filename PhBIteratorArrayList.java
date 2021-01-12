/**
 * A class that iterates over the elements of an array list 
 * @author Esther Shin 
 */
import java.util.NoSuchElementException;

public class PhBIteratorArrayList implements PhBIterator{
  
  /**
   * the inputted phoneBook that is an array of Persons
   */
  private Person[] phoneBook;
  
  /**
   * the index of the element of the array that is being checked
   */
  private int elementBeingChecked;
  
  /**
   * stores how many Persons are actually in an array, which is the length of the array disocunting empty indexes
   */
  private int phBlength;
  
  /**
   * constructor
   * creates an interator for the array list
   * @param phoneBook  the array list to iterate through
   * @param elementBeingChecked  the element of the array list to check
   * @param phBlength  the number of elements in the array list
   */
  public PhBIteratorArrayList(Person[] phoneBook, int elementBeingChecked, int phBlength){
    this.phoneBook = phoneBook;
    this.elementBeingChecked = elementBeingChecked;
    this.phBlength = phBlength;
  }
  
  /**
   * Method that returns whether there is still more data in the array list
   * @return  true if the iteration is not at the end of the array and false when it is at the end
   * Runtime Analysis: O(1)
   */
  public boolean hasNext(){
    if(elementBeingChecked < phBlength){
      return true;
    }
    else{
      return false;
    }
  }
  
  /**
   * Method that returns the current element of the array list as the array is iterated through
   * @return  the next element of the array as we iterate through the array 
   * @throws NoSuchElementException if there are no more elements 
   * Runtime Analysis: O(1)
   */
  public Person next(){
    /**
     * stores the Person that is stored in the array element being checked
     */
    Person save = null;
    if(elementBeingChecked >= phBlength){
      throw new NoSuchElementException();
    }
    else{
      save = phoneBook[elementBeingChecked];
      elementBeingChecked = elementBeingChecked + 1;
    }
    return save;
  }
}