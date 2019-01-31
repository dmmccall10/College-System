package dsass07_mccalld;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dylan
 */
public class CollegeMember {
    
    protected String ID, fName, lName, gender, DOB, phone;
    public static int DefaultID = 0;

    public CollegeMember() { // constructor for collegeMember objects
        ID = "";
        fName = "";
        lName = "";
        gender = "";
        DOB = "";
        phone = "";
    }
    
    public CollegeMember(CollegeMember thisMember){ //overloaded constructor
    ID = thisMember.ID;
    fName = thisMember.fName;
    lName = thisMember.lName;
    gender = thisMember.gender;
    DOB = thisMember.DOB;
    phone = thisMember.phone;
            
}
    public void update(CollegeMember thisMember){ // update method
        ID = thisMember.ID;
        fName = thisMember.fName;
        lName = thisMember.lName;
        phone = thisMember.phone;
        gender = thisMember.gender;
        DOB = thisMember.DOB;
    }
    
    public void input(int i, String category){
        String HEADING = "Input Data";
        String inputID; // create variables to input 
        String inputPhone;
        String inputFirst;
        String inputLast;
        String inputGender;
        String inputDOB;
        
        inputID = JOptionPane.showInputDialog(null, "Enter College Member ID for member #" + i + ": ", HEADING, JOptionPane.QUESTION_MESSAGE);
        while(!ValidateID(inputID)){ // validate ID
            JOptionPane.showMessageDialog(null, "Please Enter a valid ID");
            inputID = JOptionPane.showInputDialog(null, "Enter College Member ID for member #" + i + ": ", HEADING, JOptionPane.QUESTION_MESSAGE);
        }
        
        inputFirst = JOptionPane.showInputDialog(null, "Please enter the First name of member #" + i + ": ", HEADING, JOptionPane.QUESTION_MESSAGE);
        inputLast = JOptionPane.showInputDialog(null, "Please enter the Last name of member #" + i + ": ", HEADING, JOptionPane.QUESTION_MESSAGE);
        
        inputGender = JOptionPane.showInputDialog(null, "Please enter the Gender of member #" + i + ": ", HEADING, JOptionPane.QUESTION_MESSAGE);
        while(!ValidateGender(inputGender)){
            JOptionPane.showMessageDialog(null, "Please enter Male or Female. (Not case sensitive)");
            inputGender = JOptionPane.showInputDialog(null, "Please enter the Gender of member #" + i + ": ", HEADING, JOptionPane.QUESTION_MESSAGE);
        }
        
        inputPhone = JOptionPane.showInputDialog(null, "Please enter the phone number of member #" + i + " (xxx-xxx-xxxx): ", HEADING, JOptionPane.QUESTION_MESSAGE);
        while(!ValidateTele(inputPhone)){
            JOptionPane.showMessageDialog(null, "Please enter a valid telephone.");
            inputPhone = JOptionPane.showInputDialog(null, "Please enter the phone number of member #" + i + " (xxx-xxx-xxxx): ", HEADING, JOptionPane.QUESTION_MESSAGE);
        }
        
        inputDOB = JOptionPane.showInputDialog(null, "Please enter the Date of Birth of member #" + i + ": (mm/dd/yyyy)", HEADING, JOptionPane.QUESTION_MESSAGE);
        while(!ValidateDOB(inputDOB)){
            JOptionPane.showMessageDialog(null, "Please Enter a Valid Date of Birth.");
            inputDOB = JOptionPane.showInputDialog(null, "Please enter the Date of Birth of member #" + i + ": (mm/dd/yyyy)", HEADING, JOptionPane.QUESTION_MESSAGE);
        }
        
        ID = inputID; // set all values to inserted onees
        phone = inputPhone;
        fName = inputFirst;
        lName = inputLast;
        gender = inputGender;
        DOB = inputDOB;
    }
    
    public int getID(){
        return Integer.parseInt(ID);
    }
    
    public String print(){ 
       String outputString;
      outputString = "ID: " + ID + "\n" + " Firstname: " + fName + "\n Lastname: " + lName + "\n" + " Gender: " + gender + "\n" + 
              " Telephone number: " + phone + "\n Date of Birth: "+ DOB;
      
      return outputString;
   }
    
    protected void Destory(Object ThisObj)
     {
         ThisObj = null; 
         System.gc();
     }
    
    public void finalize()
   {
       Destory(this);
   }
    
    public  boolean ValidateID(String ThisID) { // checks if ID is valid
      
        boolean isValid = true;
        int x; 
        for (x = 0; x < ThisID.length(); x++)
        {
          if (!Character.isDigit(ThisID.charAt(x)))
              isValid = false;
        }
        return isValid;

    }
    
    public boolean ValidateTele(String ThisTele)
    {
	boolean isValid = true;
	int x;
	char SameChar;
	for(x = 1; x <= ThisTele.length(); x++) // For each character of the telephone number
	{
            SameChar = ThisTele.charAt(x-1);
            switch (x)
            {
                case 4: {if (SameChar != '-') isValid = false; break;}
                case 8: {if (SameChar != '-') isValid = false; break;}
                default: {if (!Character.isDigit(SameChar)) isValid = false; break;}
            }
       	}  
	return isValid;
    }
    
    private  boolean ValidateDOB(String thisDate) {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy"); // creates date format to use
        boolean isValid = false;
        df.setLenient(false);
        try{
            df.parse(thisDate); // if thisDate fits
            isValid = true;
        }
        catch(ParseException e){
            
        }
        
        return isValid;
    }
    
    private boolean ValidateGender(String thisGender){
        if(thisGender.equals("Male")|| thisGender.equals("male")|| thisGender.equals("Female")|| thisGender.equals("female")){ // if it matches the case
            return true;
        }
        return false;
    }
    
    public boolean equals(Object thisObject){
  boolean InstanceMatch = false;
if (thisObject instanceof CollegeMember) 
{
CollegeMember ThisMember = new CollegeMember((CollegeMember) thisObject);
if (ID == ThisMember.ID) 
{
    InstanceMatch = true;
}


   
}
return InstanceMatch; 
    }
    
    public int compareTo(Object thisObject){
        
      int result = 0;
      if (thisObject instanceof CollegeMember) 
      {
         CollegeMember ThisMember = new CollegeMember((CollegeMember) thisObject); 
         result = ID.compareTo(ThisMember.ID); 
      }
      return result; 
   }
    
}
