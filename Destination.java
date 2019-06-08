
public class Destination   //Write a class  Private instance variables and public accessor methods should be written for this information.
{
  private String city;           //private instance variables that encapsulates information such as the name of the destination city; normal miles required for a ticket;
                                 //�Frequent Flyer� miles; additional miles for upgrading; start month of the �Frequent Flyer� program and end 
                                  //month of the �Frequent Flyer� program. 
  private int normalMiles;
  private int frequentFlyerMiles;
  private int upgradeMiles;
  private int startMonth;
  private int endMonth;
  Destination(String city,int normalMiles, int frequentFlyerMiles, int upgradeMiles, int startMonth, int endMonth) //constructor
  {
      this.city = city;                              //initialises the private instance variable with the argument
      this.normalMiles = normalMiles;                 //initialises the private instance variable with the argument
      this.frequentFlyerMiles = frequentFlyerMiles; //initialises the private instance variable with the argument
      this.upgradeMiles = upgradeMiles;              //initialises the private instance variable with the argument
      this.startMonth = startMonth;                 //initialises the private instance variable with the argument
      this.endMonth = endMonth;                   //initialises the private instance variable with the argument
  }
//public accessor methods 
  public void setCity(String city)
  {
    this.city = city;                          //set method to set the current instance of the variale with reference value 
  }
  public String getCity()
  {
    return city;                                //get method to return the current instance value
  }
  public void setNormalMiles(int normalMiles)
  {
    this.normalMiles = normalMiles;          //set method to set the current instance of the variale with reference value 
  }
  public int getNormalMiles()
  {
    return normalMiles;                    ////get method to return the current instance value
  }
  public void setFrequentFlyerMiles(int frequentFlyerMiles)
  {
    this.frequentFlyerMiles = frequentFlyerMiles;      // //set method to set the current instance of the variale with reference value 
  }
  public int getFrequentFlyerMiles()
  {
    return frequentFlyerMiles;                   //get method to return the current instance value
  }
  public void setUpgradeMiles(int upgradeMiles)
  {
    this.upgradeMiles = upgradeMiles;                   //set method to set the current instance of the variale with reference value 
  }
  public int getUpgradeMiles()
  {
    return upgradeMiles;                        //get method to return the current instance value
  }
  public void setStartMonth(int startMonth)
  {
    this.startMonth = startMonth;                    // //set method to set the current instance of the variale with reference value 
  }
  public int getStartMonth()
  {
    return startMonth;                             //get method to return the current instance value
  }
  public void setEndMonth(int endMonth)
  {
    this.endMonth = endMonth;                        //set method to set the current instance of the variale with reference value 
  }
  public int getEndMonth()
  {
    return endMonth;                            //get method to return the current instance value
  }
}