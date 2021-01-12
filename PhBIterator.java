/**
 * This interface stores the method stubs for an iterator 
 * @author Esther Shin 
 */
public interface PhBIterator{
  
  /**
   * This method stub represents the hasNext() method that will be overridden in iterators that implement this interface. 
   * @return true if there is a next element in the list 
   */
  boolean hasNext();
  
  /**
   * This method stub represents the next() method that will be overriden in iterators that implement this interface
   * @return  the next Person in the list 
   */
  Person next();
}