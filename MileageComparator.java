import java.util.Comparator; 

class MileageComparator implements Comparator<Destination> //Compares two objects of Destination type
{
  public int compare(Destination obj1, Destination obj2) 
  {
      if(obj1.getNormalMiles() > obj2.getNormalMiles()) ////checks if normal miles of second instance is lesser than first
      {
        return -1;
      }
      else if(obj1.getNormalMiles() < obj2.getNormalMiles()) //checks if normal miles of second instance is greater than first
      {
        return 1;
      }
      else return 0;
    }
}