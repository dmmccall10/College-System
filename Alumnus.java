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
public class Alumnus extends CollegeMember {
    protected String major, currentEmployer, jobTitle;

    public Alumnus(){
        major = "";
        currentEmployer = "";
        jobTitle = "";
    }
    
    public void update(Alumnus thisAlum){
        super.update(thisAlum);
        major = thisAlum.major;
        currentEmployer = thisAlum.currentEmployer;
        jobTitle = thisAlum.jobTitle;
    }
    
    public void input(int x){
        super.input(x, "Alumnus");
        String HEADING = "Alumnus Data Entry";
        String inputMajor = JOptionPane.showInputDialog(null, "Please enter Alumni's major", HEADING, JOptionPane.QUESTION_MESSAGE);
        String inputCurrentEmployer = JOptionPane.showInputDialog(null, "Please enter Alumni's Current employer", HEADING, JOptionPane.QUESTION_MESSAGE);
        String inputJobTitle = JOptionPane.showInputDialog(null, "Please enter Alumni's current job title", HEADING, JOptionPane.QUESTION_MESSAGE);
        
        major = inputMajor;
        currentEmployer = inputCurrentEmployer;
        jobTitle = inputJobTitle;
    }
    
    public String print(){
        return super.print() + "\n" + "\n" + "Major: " + major + "\n" + "Current Employer: " + currentEmployer + "\n" + "Jobtitle: "+ jobTitle;
    }
    
    public String toString(){
        return "Alumnus: " + print();
    }
    
    public boolean equals(Object thisObject){
        boolean instanceMatch = false;
        if(thisObject instanceof Alumnus){
            Alumnus thisMember = new Alumnus();
            if(ID == thisMember.ID){
                instanceMatch = true;
            }
        }
        return instanceMatch;
    }
    
    public int compareTo(Object thisObject)
   {
      int result = 0;
      if (thisObject instanceof Alumnus) 
      {
         Alumnus thisMember = new Alumnus(); 
         result = ID.compareTo(thisMember.ID); 
      }
      return result; 
   }
}
