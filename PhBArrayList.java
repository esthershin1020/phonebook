/**
 * Class that uses an array to store a sequence of Persons as a PhoneBook
 * @author Esther Shin 
 */
public class PhBArrayList implements PhoneBook{
  
  /**
   * the inputted phoneBook that is an array of Persons
   */
  private Person[] phoneBook;
  
  /**
   * stores how many Persons are actually in an array, which is the length of the array discounting empty indexes
   */
  private int phBlength;
  
  /**
   * constructor
   * @param phoneBook  the array of Persons being used (represents a phone book that stores Persons in the form of an array sequence
   */
  public PhBArrayList(Person[] phoneBook){
    this.phoneBook = phoneBook;
    this.phBlength = phoneBook.length;
  }
  
  /**
   * Method that returns how many Persons are actually in an array, which is the length of the array disocunting empty indexes
   * @return the current size of the array sequence (not counting empty indexes)
   * Runtime Analysis: O(1)
   */
  public int size(){
    return phBlength;
  }
  
  /**
   * Helper method that "resizes" an array by creating a new array that has 10 more indexes than the original, and copies the information
   *  in the original array to the new array 
   * Runtime Analysis: O(n)
   */
  private void resize(){
    
    /**
     * newPhoneBook: the new array created every time something is inserted and more space is needed in order to do so
     */
    Person[] newPhoneBook = new Person[phBlength + 10];
    
    /**
     * loops through the newly created array in order to copy everything in the original array to the new array
     */
    for(int index = 0; index < phBlength; index = index + 1){
      newPhoneBook[index] = phoneBook[index];
    }
    phoneBook = newPhoneBook;
  }
  
  /**
   * Method that inserts a new Person before the i-th component of the array sequence 
   * @param i  The index (i-th component) of the arrat at which you want to insert a new Person
   * @param person  the data/value stored in the component that you are inserting (what kind of Person)
   * Runtime Analysis: O(n)
   */
  public void insert(int i, Person person){
    if (phBlength == phoneBook.length)
      resize();
    if(phBlength < i){
      i = phBlength;
    }
    /**
     * loops through the array by starting at the second to last index and copying every element one index down until the index 
     *  where the new component is being inserted
     */
    for(int index = phBlength - 1; index >= i; index = index - 1){
      phoneBook[index + 1] = phoneBook[index];
    }
    phBlength = phBlength + 1;
    phoneBook[i] = person;
  }
  
  /**
   * 
   * Helper method that "desizes" the array so that there is never too many empty spaces left after many components have been removed
   * Runtime Analysis: O(n)
   */
  private void desize(){
      Person[] newPhoneBook = new Person[phBlength];
      /**
       * loops through the new array of the smaller length and just copies elements in the original array to the new array so that 
       *  the length of the array is equal to the number of elements in the array
       */
      for(int index = 0; index < phBlength; index = index + 1){
        newPhoneBook[index] = phoneBook[index];
      }
      phoneBook = newPhoneBook;
    }
  
  /**
   * Method that removes the i-th component of the array sequence and returns the Person (component) removed
   * @return the Person (component) that was removed 
   * Runtime Analysis: O(n)
   */
  public Person remove(int i){
    if(phBlength < i){
      return null;
    }
    if (phBlength <= phoneBook.length - 10){
      desize();
    }
    
    /**
     * personRemoved: stores the Person (component) that will be removed
     */
    Person personRemoved = phoneBook[i];
    
    /**
     * loops through the array starting at the index containing the i-th component that will be removed, then "shifts" the 
     *  element on the right to the left element by replacing the left element with the right element
     */
    for(int index = i; index < phBlength - 1; index = index + 1){
      phoneBook[index] = phoneBook[index + 1];
    }
    phBlength = phBlength - 1;
    return personRemoved;
  }
  
  /**
   * Method that returns the i-th component of the array sequence
   * @param i  The index of the array at which the Person the user wants returned is 
   * @return  The i-th component of the array sequence
   * Runtime Analysis: O(1)
   */
  public Person lookup(int i){
    if(phBlength < i){
      throw new IndexOutOfBoundsException("The phoneBook length is less than i");
    }
    else{
      return phoneBook[i];
    }
  }
  
  /**
   * Method that returns the iterator for an array list 
   * @return  a new iterator for the array list phoneBook sequence
   * Runtime Analysis: O(1)
   */
  public PhBIterator iterator(){
    return new PhBIteratorArrayList(phoneBook, 0, phBlength);
  }
}
