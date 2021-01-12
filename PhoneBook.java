/**
 * This interface stores the method stubs for types that are sequences storing Persons (phoneBooks)
 * @author Esther Shin 
 */
public interface PhoneBook{
  
  /**
   * This method stub represents the size() method that will be overriden in types that extend this interface
   */
  int size();
  
  /**
   * This method stub represents the insert() method that will be overriden in types that extend this interface
   */
  void insert(int i, Person person);
  
  /**
   * This method stub represents the remove() method that will be overriden in types that extend this interface
   */
  Person remove(int i);
  
  /**
   * This method stub represents the lookup() method that will be overriden in types that extend this interface
   */
  Person lookup(int i);
  
  /**
   * This method stub represents the iterator() method that will be overriden in types that extend this interface
   */
  PhBIterator iterator();
}