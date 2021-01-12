/**
 * This class is a demo application that utilizes the PhoneBook ADT and makes sure that my other classes work
 * @author Esther Shin 
 */
public class Demo{
  
  /**
   * method that removes any duplicate names that are in both p1 and p2 from only the p2 PhoneBook
   * @param p1  one input PhoneBook
   * @param p2  the second input PhoneBook being compared to p1
   * Runtime Analysis: O(n^2)
   */
  public static void removeDuplicates(PhoneBook p1, PhoneBook p2){
    
    /**
     * p1Iterator: stores an iterator for p1
     */
    PhBIterator p1Iterator = p1.iterator();
    /**
     * loops through the first phoneBook (p1) and compares each element one at a time to every single element in p2.
     */
    while(p1Iterator.hasNext()){
      
      /**
       * beingCompared:the Person that is being checked for in p2
       */
      Person beingCompared = p1Iterator.next();
      
      /**
       * p2Iterator: stores an iterator for p2
       */
      PhBIterator p2Iterator = p2.iterator();
      
      /**
       * counter: stores the index of where in the list the element being removed is
       */
      int counter = 0;
      
      /**
       * loops through the second phoneBook (p2) and compares each element of p2 to a single element in p1 to see if there 
       *  are any elements in p2 that are also in p1. It then removes any repeat elements from p2. 
       */
      while(p2Iterator.hasNext()){
        Person theOneBeingComparedTo = p2Iterator.next();
        if(beingCompared.equals(theOneBeingComparedTo)){
          p2.remove(counter).getPersonID();
          counter = counter - 1;
        }
        counter = counter + 1;
      }
    }
  }
  
  /**
   * main method: starts the program by creating people and phonebooks in the form of an array list and linked list, 
   *  and prints the names after certain methods have been applied 
   * How my main method tests:
   *  1. It makes an array list consisting of p1 through p6
   *  2. Then it inserts p7 through p10 at certain parts of the array 
   *  3. When the new array is printed, the result should be "CharlesAlexisRossTrashCharlotteDotLeeanAnemoneBobKatie"
   *  4. Then, I make a linked list consisting of 6 nodes that contain people l1 through l6
   *  5. Then it inserts p6, p9, p4, and p10 at certain parts of the linked list 
   *  6. When the new linked list is printed, the result should be "LeeanRachelRossMonChandlerKatieAnemoneJoeyGuntherSpence"
   *  7. Then, I remove duplicates from the linked list (the duplicates are Leean, Ross, Katie, Anemone), and print the linked list and the unchanged array list
   *  8. The result should be "CharlesAlexisRossTrashCharlotteDotLeeanAnemoneBobKatie" for the array list and "RachelMonChandlerJoeyGuntherSpence" for the new linked list
   * @param args  string that determines what algorithm will be used 
   */
  public static void main(String[] args){
    Person p1 = new Person("Alexis", "012");
    Person p2 = new Person("Trash", "123");
    Person p3 = new Person("Charlotte", "234");
    Person p4 = new Person("Anemone", "345");
    Person p5 = new Person("Bob", "456");
    Person p6 = new Person("Katie", "567");
    Person p7 = new Person("Dot", "012");
    Person p8 = new Person("Charles", "123");
    Person p9 = new Person("Leean", "890");
    Person p10 = new Person("Ross", "234");
    Person l1 = new Person("Rachel", "325"); 
    Person l2 = new Person("Mon", "983");
    Person l3 = new Person("Chandler", "037");
    Person l4 = new Person("Joey", "019");
    Person l5 = new Person("Gunther", "488");
    Person l6 = new Person("Spence", "283");
    Person[] PhB = {p1, p2, p3, p4, p5, p6};
    PhBArrayList a1 = new PhBArrayList(PhB);
    PhBLinkedList LL1 = new PhBLinkedList();
    LL1.insert(0, l1);
    LL1.insert(1, l2);
    LL1.insert(2, l3);
    LL1.insert(3, l4);
    LL1.insert(4, l5);
    LL1.insert(5, l6);
    /**
     * For Array, the position that minimizes execution time would be an insertion at the end. For LL, the position that minimizes
    execution would be an insertion at the front
     */
    a1.insert(3, p7);
    a1.insert(0, p8);
    a1.insert(5, p9);
    a1.insert(2, p10);
    LL1.insert(3, p6);
    LL1.insert(0, p9);
    LL1.insert(5, p4);
    LL1.insert(2, p10);
    System.out.println(a1.lookup(0).getPersonID() + a1.lookup(1).getPersonID() + a1.lookup(2).getPersonID() +
                       a1.lookup(3).getPersonID() + a1.lookup(4).getPersonID() + a1.lookup(5).getPersonID() +
                       a1.lookup(6).getPersonID() + a1.lookup(7).getPersonID() + a1.lookup(8).getPersonID() +
                       a1.lookup(9).getPersonID());
    System.out.println(LL1.lookup(0).getPersonID() + LL1.lookup(1).getPersonID() + LL1.lookup(2).getPersonID() +
                       LL1.lookup(3).getPersonID() + LL1.lookup(4).getPersonID() + LL1.lookup(5).getPersonID() +
                       LL1.lookup(6).getPersonID() + LL1.lookup(7).getPersonID() + LL1.lookup(8).getPersonID() +
                       LL1.lookup(9).getPersonID());                   
    removeDuplicates(a1, LL1);
    System.out.println(a1.lookup(0).getPersonID() + a1.lookup(1).getPersonID() + a1.lookup(2).getPersonID() +
                       a1.lookup(3).getPersonID() + a1.lookup(4).getPersonID() + a1.lookup(5).getPersonID() +
                       a1.lookup(6).getPersonID() + a1.lookup(7).getPersonID() + a1.lookup(8).getPersonID() +
                       a1.lookup(9).getPersonID());
    System.out.println(LL1.lookup(0).getPersonID() + LL1.lookup(1).getPersonID() + LL1.lookup(2).getPersonID() +
                       LL1.lookup(3).getPersonID() + LL1.lookup(4).getPersonID() + LL1.lookup(5).getPersonID());
  }
}