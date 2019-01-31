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
public class Employee extends CollegeMember {
    protected String department, currentEmployer, jobTitle;
    
    Employee(){
        department = "";
        currentEmployer = "";
        jobTitle = "";
    }
    
    public void update(Employee thisEmployee){
        super.update(thisEmployee);
        department = thisEmployee.department;
        currentEmployer = thisEmployee.currentEmployer;
        jobTitle = thisEmployee.jobTitle;
    }
    
    public void input(int x){
        super.input(x, "Employee");
        String HEADING = "Employee Data Entry";
        String inputDepartment = JOptionPane.showInputDialog(null, "Please enter employee's department", HEADING, JOptionPane.QUESTION_MESSAGE);
        String inputCurrentEmployer = JOptionPane.showInputDialog(null, "Please enter employee's current employer", HEADING, JOptionPane.QUESTION_MESSAGE);
        String inputJobTitle = JOptionPane.showInputDialog(null, "Please enter employee's current job title", HEADING, JOptionPane.QUESTION_MESSAGE);
        
        department = inputDepartment;
        currentEmployer = inputCurrentEmployer;
        jobTitle = inputJobTitle;
    }
    
    public String print(){
        return super.print() + "\n" + "\n" + "department: " + department + "\n" + "Current Employer: " + currentEmployer + "\n" + "Jobtitle: "+ jobTitle;
    }
    
    public String toString(){
        return "Employee: " + print();
    }
    
    public boolean equals(Object thisObject){
        boolean instanceMatch = false;
        if(thisObject instanceof Employee){
            Employee thisMember = new Employee();
            if(ID == thisMember.ID){
                instanceMatch = true;
            }
        }
        return instanceMatch;
    }
    
    public int compareTo(Object thisObject)
   {
      int result = 0;
      if (thisObject instanceof Employee) 
      {
         Employee thisMember = new Employee(); 
         result = ID.compareTo(thisMember.ID); 
      }
      return result; 
   }
}
