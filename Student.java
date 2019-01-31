/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsass07_mccalld;

import javax.swing.JOptionPane;

/**
 *
 * @author Dylan
 */
public class Student extends CollegeMember {
    protected String major;
    
    Student(){
        major = "";
    }
    
    public void update(Student thisStudent){
        super.update(thisStudent); // calls collegemember udpate method
        major = thisStudent.major;
    }
    
    public void input(int x){
        super.input(x, "Student"); // calls collegemember input method
    
    String inputMajor = JOptionPane.showInputDialog(null, "Please enter student's major", "Student Major Entry", JOptionPane.QUESTION_MESSAGE);
    major = inputMajor; // enters a student major
}
    
    public String print(){
        return super.print() + "\n " + "Major: " + major;
    }
    
    public String toString()
   {
       return "Student: " + print();
   }
    
    public boolean equals(Object thisObject) 
   {
        boolean InstanceMatch = false;
        if (thisObject instanceof Student){
        
            Student ThisMember = new Student();
             if (ID == ThisMember.ID){
            InstanceMatch = true;
            }
                }
        return InstanceMatch; 
            }
   public int compareTo(Object thisObject)
   {
      int result = 0;
      if (thisObject instanceof Student) 
      {
         Student thisMember = new Student(); 
         result = ID.compareTo(thisMember.ID); 
      }
      return result; 
   }
}

