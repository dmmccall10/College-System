/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsass07_mccalld;

/**
 *
 * @author Dylan
 */
public class AlumnusNode {
    protected Alumnus info;
    protected AlumnusNode left, right;
    
    AlumnusNode(){
        CollegeMember thisMember = new CollegeMember();
            info = new Alumnus();
            left = null;
            right = null;
    }
    
    public void modify(AlumnusNode thisNode){
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
