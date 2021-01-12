/**
 * @author Esther Shin 
 */
public class Person {
  
  /**
   * the personID (AKA name) of a person
   */
  private String personID;
  
  /**
   * the person's phone number
   */
  private String phoneNum;
  
  /**
   * constructor
   * @param personID  the name being assigned to a person
   * @param phoneNum  the phoneNum being assigned to a person
   */
  public Person(String personID, String phoneNum){
    this.personID = personID;
    this.phoneNum = phoneNum;
  }
  
  /**
   * Method that sets/assigns/changes a person's name to the personID input
   * @param personID  the name given to a person
   * Runtime Analysis: O(1)
   */
  public void setPersonID(String personID){
    this.personID = personID;
  }
  
  /**
   * Method that return the personID of the person
   * @return  the personID of a person 
   * Runtime Analysis: O(1)
   */
  public String getPersonID(){
    return personID;
  }
  
  /**
   * Method that sets/assigns/changes a person's phone number to the phoneNum input 
   * @return  the phone number of a person 
   * Runtime Analysis: O(1)
   */
  public void setPhoneNum(String phoneNum){
    this.phoneNum = phoneNum;
  }
  
  /**
   * Method that return the phone number of the person
   * @return  the phone number of a person 
   * Runtime Analysis: O(1)
   */
  public String getPhoneNum(){
    return phoneNum;
  }
  
  /**
   * Method that checks whether a person is equal to (in other words is the same as) another person;
   * it checks if the name and number are the same 
   * @param person  the person being compared to your chosen person
   * @return  whether or not the two people are equal to/are the same as each other
   * Runtime Analysis: O(1)
   */
  private boolean equals(Person person){
    if(getPhoneNum().equals(person.getPhoneNum()) && getPersonID().equals(person.getPersonID())){
      return true;
    }
    else{
      return false;
    }
  }
}
  
  