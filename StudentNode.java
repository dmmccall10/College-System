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
public class StudentNode {
    
    protected Student info;
    protected StudentNode left, right;
    
    StudentNode(){
        CollegeMember thisMember = new CollegeMember();
        info = new Student();
        left = null;
        right = null;
    }
    
    public void modify(StudentNode thisNode){
        info.update(thisNode.info);
        left = thisNode.left;
        right = thisNode.right;
    }
    
    public void inputData(int i){
        info.input(i);
        left = null;
        right = null;
    }
    
    public String print(){
        return info.toString();
    }
}
