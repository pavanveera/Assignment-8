import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections; 

public class MileRedeemer  //class to calculate the redeeming mileage. 
{
 ArrayList<Destination> destinationList = new ArrayList<Destination> (); //private instance variable for an array of Destination objects
 int remainingMiles =0;                                                  //an integer to represent the remaining miles after the user's Frequent Flyer miles have been redeemed
 public void readDestinations(Scanner fileScan)      //method uses a Scanner object as the input parameter   
 {
   try
   {
   while(fileScan.hasNext())
   {
     String line = fileScan.nextLine();         //to read and parse the destination data into an array of Destination objects                    
     String[] store=line.split(";");            //the data is separated by ';' and stored in each position
     String city = store[0];                    //data at first position in the string array stored in the variable city
     int normalMileage = Integer.parseInt(store[1]); //data at second position in the string array stored in the variable city  
     int frequentMileage = Integer.parseInt(store[2]); //data at third position in the string array stored in the variable city  
     int additionalMileage = Integer.parseInt(store[3]); //data at fourth position in the string array stored in the variable city  
     String[] temp=store[4].split("-");         //the data separated by '-' which was stored in the last position of original array is now stored in a different array 
     int start = Integer.parseInt(temp[0]);     //the second array last elements stored as first and last month
     int last = Integer.parseInt(temp[1]);
     Destination destination = new Destination(city,normalMileage,frequentMileage,additionalMileage,start,last); 
     destinationList.add(destination);   //adds the destination object to the list after sorted
     }
   }
     catch(Exception e) 
     {
        System.err.println("File input format wrong: "+e.getMessage());
        System.exit(0);
     }
 }
 public String[] getCityNames()           //method to add all the names of the cities read from the file to a temporaray string array
 {
     String[] city = new String[destinationList.size()];  
     int i = 0; 
     for(Destination d: destinationList) 
     {
     city[i] = d.getCity(); //a string array to store all the cities from the destination file to the temp array using for loop
     i++;                   //loops through the array of Destination objects and creates an array of String objects from the city names. 
     }
    // Arrays.sort(city); //sorts the city array
     return city; //returns cities 
 }

 public String[] redeemMiles(int miles, int month)          //The method takes total available miles, and the desired month of departure as input
 {    
      ArrayList<Destination> arrayL = new ArrayList<Destination>(); //declaring an arraylist of destination type to store 
      ArrayList<String> arrayT = new ArrayList<String>();
      Collections.sort(destinationList, new MileageComparator());  //the method sorts the array of Destination objects in descending order by normal mileage 
      for(Destination d: destinationList) //loops throught the destinationList arraylist
      {
        if(month < d.getStartMonth() || month > d.getEndMonth()) //if the month is less than the start month, or greater than the end month 
        {
         if(miles > d.getNormalMiles()) 
          {
          arrayL.add(d);  // If miles is greater than Normal miles then this object is added into abc arrayList 
          miles = (int)(miles - d.getNormalMiles()); // current object miles are decreased by the normal miles redeemed
          }
        }
        else if(month >= d.getStartMonth())   //if the month is greater than or equal to the start month, or lesser than or equal to the last month 
        {
          if(month <= d.getEndMonth())
         {
         if(miles > d.getFrequentFlyerMiles()) // If miles is greater than frequent miles then this object is added into abc arrayList 
          {
          arrayL.add(d); 
          miles = (int)(miles - d.getFrequentFlyerMiles()); // current object miles are decreased by the frequent miles redeemed
          }
         }
        }
      }
       for(Destination d: arrayL) //loops through the arraylist
       {
        String cityPrint = d.getCity();  //tha cuurent value of the city is stored in the string cityPrint
        if(miles < d.getUpgradeMiles()) // If miles is less than additional miles then this object is added into arrayList 
        {
          arrayT.add("* A trip to "+cityPrint+" in Economy class"); 
        }
        else 
        {
          arrayT.add("* A trip to "+cityPrint+" in First class"); 
          miles = (int)(miles - d.getUpgradeMiles()); // current object miles are decreased by the upgrademiles redeemed
        }
      } 
        remainingMiles = miles; ////  saving the miles remaining after the tickets have been redeemed.
        if(arrayT.size() < 1) //checks if client has enough miles else prints below message
        arrayT.add("*** Your client has not accumulated enough Frequent Flyer Miles ***");
        int size = arrayT.size();
        String[] description = new String[size]; 
        description = arrayT.toArray(description);        
        return description; //returns an array of String objects containing descriptions of redeemed tickets to be printed out by the main program
  }
 public int getRemainingMiles()
 {
   return remainingMiles; //This method should return the saved remaining miles.
 }
 public Destination findDestination(String city) //new method added to find the destination with cityname as the argument
 {
     Destination destination = null; //initial value declared as temp and initilaised to null
     for( Destination d: destinationList) 
     {
      if(d.getCity() == city)
      {
      destination = d;
      }
     }
     return destination; //returns the destination value
    }   
}
 


    