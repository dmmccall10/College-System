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
public class DSAss07_McCallD {
public static StudentTree tree1;
public static AlumnusTree tree2;
public static EmployeeTree tree3;
public static Student list1;
public static Alumnus list2;
public static Employee list3;
public static String HEADING = "Forest Monitor";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean exit = false; // sentinel value to run menu
        String menu = "1. Add Student \n" + "2. Add alumni \n" + "3. Add Employee \n" + "4. Remove Student \n" + "5. Remove Alumni \n" + "6. Remove Employee \n" 
                + "7. Search Students \n"+ "8. Search Alumni \n" + "9. Search Employee \n" + "10 Modify Students \n" + "11. Modify Alumni \n" + "12. Modify Employees \n" 
                + "13. Traverse Students \n" + "14. Traverse Alumni \n" + "15. Traverse Employees \n" + "16. Check Tree Size \n" + "17. Empty Tree \n" + "0. Exit program \n";
        initialize(); // creates new trees to use
        do{
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null, menu, HEADING, JOptionPane.QUESTION_MESSAGE));
            switch(choice){
                case 1: inputStudent(); break;
                case 2: inputAlumnus(); break;
                case 3: inputEmployee(); break;
                case 4: removeStudent(); break;
                case 5: removeAlumnus(); break;
                case 6: removeEmployee(); break;
                case 7: searchStudent(); break;
                case 8: searchAlumnus(); break;
                case 9: searchEmployee(); break;
                case 10: modifyStudent(); break;
                case 11: modifyAlumnus(); break;
                case 12: modifyEmployee(); break;
                case 13: traverseStudent(list1); break;
                case 14: traverseAlumnus(list2); break;
                case 15: traverseEmployee(list3); break;
                case 16: checkSize(); break;
                case 17: emptyTree(); break;
                case 0: exit = true; break;
            }
        }
        while(exit == false);
        
    }
    
    public static void initialize(){
        tree1 = new StudentTree();
        tree2 = new AlumnusTree();
        tree3 = new EmployeeTree();
    }
    
    public static void inputStudent(){
        int limit = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the number of students you wish to input: " , HEADING , JOptionPane.QUESTION_MESSAGE));
        for(int i = 0; i < limit; i++){ // loops until all students are entered
            StudentNode newStud = new StudentNode();
            newStud.inputData(i);
            tree1.insert(newStud);
        }
    }
    
    public static void inputAlumnus(){
        int limit = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the number of Alumni you wish to input: " , HEADING , JOptionPane.QUESTION_MESSAGE));
        for(int i = 0; i < limit; i++){ // loops until all alumni are entered
            AlumnusNode newAlum = new AlumnusNode();
            newAlum.inputData(i);
            tree2.insert(newAlum);
        }
    }
    
    public static void inputEmployee(){
        int limit = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the number of Employees you wish to input: " , HEADING , JOptionPane.QUESTION_MESSAGE));
        for(int i = 0; i < limit; i++){ // loops until all employee are entered
            EmployeeNode newEmployee = new EmployeeNode();
            newEmployee.inputData(i);
            tree3.insert(newEmployee);
        }
    }
    
    public static void removeStudent(){
        boolean exit = false;
        String searchID;
        StudentNode foundStud;
        Student searchStud;
        
        do{
           foundStud = null;
           searchID = JOptionPane.showInputDialog(null, "Please Enter the ID of the Student you wish to remove", HEADING, JOptionPane.QUESTION_MESSAGE);
           
           int x = Integer.parseInt(searchID);
           
           foundStud = tree1.search(x); // searches for ID
           if(foundStud != null){
               tree1.remove(x); // calls remove method
           }
           else{
               JOptionPane.showMessageDialog(null, "Student not found.");
           }
           
           int close = JOptionPane.showConfirmDialog(null, "Would you like to remove another?");
           if(close == JOptionPane.CLOSED_OPTION || close == JOptionPane.NO_OPTION){
               exit = true;
           }
        }
        while(exit == false);
    }
    
    public static void removeAlumnus(){
        boolean exit = false;
        String searchID;
        AlumnusNode foundAlum;
        Alumnus searchAlum;
        
        do{
           foundAlum = null;
           searchID = JOptionPane.showInputDialog(null, "Please Enter the ID of the Alumnus you wish to remove", HEADING, JOptionPane.QUESTION_MESSAGE);
           
           int x = Integer.parseInt(searchID);
           
           foundAlum = tree2.search(x); // searches for id
           if(foundAlum != null){
               tree2.remove(x); // calls remove method
           }
           else{
               JOptionPane.showMessageDialog(null, "Alumnus not found.");
           }
           
           int close = JOptionPane.showConfirmDialog(null, "Would you like to remove another?");
           if(close == JOptionPane.CLOSED_OPTION || close == JOptionPane.NO_OPTION){
               exit = true;
           }
        }
        while(exit == false);
    }
    
    public static void removeEmployee(){
        boolean exit = false;
        String searchID;
        EmployeeNode foundEmployee;
        Employee searchEmployee;
        
        do{
           foundEmployee = null;
           searchID = JOptionPane.showInputDialog(null, "Please Enter the ID of the Employee you wish to remove", HEADING, JOptionPane.QUESTION_MESSAGE);
           
           int x = Integer.parseInt(searchID);
           
           foundEmployee = tree3.search(x); // searches for id
           if(foundEmployee != null){
               tree3.remove(x); // calls remove method
           }
           else{
               JOptionPane.showMessageDialog(null, "Employee not found.");
           }
           
           int close = JOptionPane.showConfirmDialog(null, "Would you like to remove another?");
           if(close == JOptionPane.CLOSED_OPTION || close == JOptionPane.NO_OPTION){
               exit = true;
           }
        }
        while(exit == false);
    }
    
    public static void modifyStudent(){
        boolean exit = false;
        String searchID;
        StudentNode foundStud;
        Student searchStud;
        Student newStud;
        
        do{
           foundStud = null;
           searchID = JOptionPane.showInputDialog(null, "Please Enter the ID of the Student you wish to modify", HEADING, JOptionPane.QUESTION_MESSAGE);
           
           searchStud = new Student();
           searchStud.ID = searchID;
           int x = Integer.parseInt(searchID);
           
           foundStud = tree1.search(x);
           if(foundStud != null){
               JOptionPane.showMessageDialog(null, foundStud.print() + "\n Please enter the new data for this Student");
               newStud = new Student();
               newStud.input(1);
               tree1.modify(foundStud, newStud);
           }
           else{
               JOptionPane.showMessageDialog(null, "Student not found, cannot modify.");
           }
           
           int close = JOptionPane.showConfirmDialog(null, "Would you like to modify another?");
           if(close == JOptionPane.CLOSED_OPTION || close == JOptionPane.NO_OPTION){
               exit = true;
           }
        }
        while(exit == false);
    }
    
    public static void modifyAlumnus(){
        boolean exit = false;
        String searchID;
        AlumnusNode foundAlum;
        Alumnus searchAlum;
        Alumnus newAlum;
        
        do{
           foundAlum = null;
           searchID = JOptionPane.showInputDialog(null, "Please Enter the ID of the Alumnus you wish to modify", HEADING, JOptionPane.QUESTION_MESSAGE);
           
           searchAlum = new Alumnus();
           searchAlum.ID = searchID;
           int x = Integer.parseInt(searchID);
           
           foundAlum = tree2.search(x);
           if(foundAlum != null){
               JOptionPane.showMessageDialog(null, foundAlum.print() + "\n Please enter the new data for this Alumnus");
               newAlum = new Alumnus();
               newAlum.input(1);
               tree2.modify(foundAlum, newAlum);
           }
           else{
               JOptionPane.showMessageDialog(null, "Alumnus not found, cannot modify.");
           }
           
           int close = JOptionPane.showConfirmDialog(null, "Would you like to modify another?");
           if(close == JOptionPane.CLOSED_OPTION || close == JOptionPane.NO_OPTION){
               exit = true;
           }
        }
        while(exit == false);
    }
    
    public static void modifyEmployee(){
        boolean exit = false;
        String searchID;
        EmployeeNode foundEmployee;
        Employee searchEmployee;
        Employee newEmployee;
        
        do{
           foundEmployee = null;
           searchID = JOptionPane.showInputDialog(null, "Please Enter the ID of the Alumnus you wish to modify", HEADING, JOptionPane.QUESTION_MESSAGE);
           
           searchEmployee = new Employee();
           searchEmployee.ID = searchID;
           int x = Integer.parseInt(searchID);
           
           foundEmployee = tree3.search(x);
           if(foundEmployee != null){
               JOptionPane.showMessageDialog(null, foundEmployee.print() + "\n Please enter the new data for this Alumnus");
               newEmployee = new Employee();
               newEmployee.input(1);
               tree3.modify(foundEmployee, newEmployee);
           }
           else{
               JOptionPane.showMessageDialog(null, "Alumnus not found, cannot modify.");
           }
           
           int close = JOptionPane.showConfirmDialog(null, "Would you like to modify another?");
           if(close == JOptionPane.CLOSED_OPTION || close == JOptionPane.NO_OPTION){
               exit = true;
           }
        }
        while(exit == false);
    }
    
    public static void searchStudent(){
        boolean exit = false;
        String searchID;
        StudentNode foundStud;
        Student searchStud;
        
        do{
           foundStud = null;
           searchID = JOptionPane.showInputDialog(null, "Please Enter the ID of the Student you wish to search", HEADING, JOptionPane.QUESTION_MESSAGE);
           
           searchStud = new Student();
           searchStud.ID = searchID;
           int x = Integer.parseInt(searchID);
           
           foundStud = tree1.search(x);
           if(foundStud != null){
               JOptionPane.showMessageDialog(null, foundStud.print());
           }
           else{
               JOptionPane.showMessageDialog(null, "Student not found.");
           }
           
           int close = JOptionPane.showConfirmDialog(null, "Would you like to search another?");
           if(close == JOptionPane.CLOSED_OPTION || close == JOptionPane.NO_OPTION){
               exit = true;
           }
        }
        while(exit == false);
    }
    
    public static void searchAlumnus(){
        boolean exit = false;
        String searchID;
        AlumnusNode foundAlum;
        Alumnus searchAlum;
        
        do{
           foundAlum = null;
           searchID = JOptionPane.showInputDialog(null, "Please Enter the ID of the Alumnus you wish to search", HEADING, JOptionPane.QUESTION_MESSAGE);
           
           searchAlum = new Alumnus();
           searchAlum.ID = searchID;
           int x = Integer.parseInt(searchID);
           
           foundAlum = tree2.search(x);
           if(foundAlum != null){
               JOptionPane.showMessageDialog(null, foundAlum.print());
           }
           else{
               JOptionPane.showMessageDialog(null, "Alumnus not found.");
           }
           
           int close = JOptionPane.showConfirmDialog(null, "Would you like to search another?");
           if(close == JOptionPane.CLOSED_OPTION || close == JOptionPane.NO_OPTION){
               exit = true;
           }
        }
        while(exit == false);
    }
    
    public static void searchEmployee(){
        boolean exit = false;
        String searchID;
        EmployeeNode foundEmployee;
        Employee searchEmployee;
        
        do{
           foundEmployee = null;
           searchID = JOptionPane.showInputDialog(null, "Please Enter the ID of the Employee you wish to search", HEADING, JOptionPane.QUESTION_MESSAGE);
           
           searchEmployee = new Employee();
           searchEmployee.ID = searchID;
           int x = Integer.parseInt(searchID);
           
           foundEmployee = tree3.search(x);
           if(foundEmployee != null){
               JOptionPane.showMessageDialog(null, foundEmployee.print());
           }
           else{
               JOptionPane.showMessageDialog(null, "Employee not found.");
           }
           
           int close = JOptionPane.showConfirmDialog(null, "Would you like to search another?");
           if(close == JOptionPane.CLOSED_OPTION || close == JOptionPane.NO_OPTION){
               exit = true;
           }
        }
        while(exit == false);
    }
    
    public static void traverseStudent(Student list){
        tree1.inOrder(tree1.root, false);
        String output = "";
        if(!tree1.traversal.isEmpty()){
            for(Student student : tree1.traversal){
                output += student.toString();
            }
            JOptionPane.showMessageDialog(null, output);
        }
    }
    
    public static void traverseAlumnus(Alumnus list){
        tree2.inOrder(tree2.root, false);
        String output = "";
        if(!tree2.traversal.isEmpty()){
            for(Alumnus alumnus : tree2.traversal){
                output += alumnus.toString();
            }
            JOptionPane.showMessageDialog(null, output);
        }
    }
    
    public static void traverseEmployee(Employee list){
        tree3.inOrder(tree3.root, false);
        String output = "";
        if(!tree3.traversal.isEmpty()){
            for(Employee employee : tree3.traversal){
                output += employee.toString();
            }
            JOptionPane.showMessageDialog(null, output);
        }
    }
    
    public static void checkSize(){
        boolean exit = false;
        String menu = "1. Check Students Tree \n" + "2. Check Alumnia Tree \n"
         + "3. Check employee tree \n" + "4. Exit.";
        do{
          int choice = Integer.parseInt(JOptionPane.showInputDialog(null, menu, HEADING, JOptionPane.QUESTION_MESSAGE));
          switch(choice){
              case 1: JOptionPane.showMessageDialog(null, "Student Size: " + tree1.getSize()); break;
              case 2: JOptionPane.showMessageDialog(null, "Alumnus Size: " + tree2.getSize()); break;
              case 3: JOptionPane.showMessageDialog(null, "Employee Size: " + tree3.getSize()); break;
              case 4: exit = true; break;
          }
        }
        while(exit == false);
    }
    
    public static void emptyTree(){
        boolean exit = false;
        String menu = "1. Empty Students Tree \n" + "2. Empty Alumnia Tree \n"
         + "3. Empty employee tree \n" + "4. Exit.";
        do{
          int choice = Integer.parseInt(JOptionPane.showInputDialog(null, menu, HEADING, JOptionPane.QUESTION_MESSAGE));
          switch(choice){
              case 1: tree1.clearTree(); break;
              case 2: tree2.clearTree(); break;
              case 3: tree3.clearTree(); break;
              case 4: exit = true; break;
          }
        }
        while(exit == false);
    }
    
}
