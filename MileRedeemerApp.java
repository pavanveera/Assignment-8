import javax.swing.JFrame; //import statement to import the swing class components
public class MileRedeemerApp //class to show the functionalities of the two frames
{
 public static void main(String[] args) 
 {
  try 
  {
   JFrame frameOne = new FrameOne(); // FrameOne onject created
   frameOne.setLocationRelativeTo(null);
   frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close option displayed
   frameOne.setResizable(false);//setting resizable option off
   frameOne.setVisible(true); //setting visibility on
  }
  catch(Exception e) 
  {
   System.out.print("Error Occured"); //In case of an error, this message is displayed on the screen
  }
 }
}