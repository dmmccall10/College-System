/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsass07_mccalld;

import java.util.ArrayList;

/**
 *
 * @author Dylan
 */
public class StudentTree {
    protected static StudentNode root;
    protected static int size, traverseKey;
    protected static ArrayList<Student> traversal;
    
    StudentTree(){
        root = null;
        size = 0;
        traverseKey = 0;
        traversal = new ArrayList();
    }
    
    public static void insert(StudentNode thisNode){
        StudentNode current;
        
        if(root == null){
            addRoot(thisNode.info);
        }
        else{
            current = findInsertionPoint(root, thisNode);
            if(thisNode.info.getID() < current.info.getID()){
                addLeft(current, thisNode.info);
            }
            else{
                addRight(current, thisNode.info);
            }
        }
    }
    
    public static StudentNode findInsertionPoint(StudentNode thisNode, StudentNode thisStudent){
        StudentNode point;
    point = thisNode;
    if (thisStudent.info.getID() < point.info.getID() && point.left != null) point = findInsertionPoint(point.left, thisStudent);    
    if (thisStudent.info.getID() > point.info.getID() && point.right != null) point = findInsertionPoint(point.right, thisStudent);    
    return point;
    }
    
    public static StudentNode search(int searchValue){
        StudentNode current, found;
        current = root;
        found = null;
        
        while(current.info.getID() != searchValue && current.info != null){
            if(searchValue < current.info.getID()){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        
        if(current.info.getID() == searchValue){
            found = current;
        }
        else{
            found = null;
        }
        return found;
    }
    
    public static void remove(int searchValue){
        StudentNode current, found;
        current = root;
        found = null;
        
        while(current.info.getID() != searchValue && current.info != null){
            if(searchValue < current.info.getID()){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        
        if(current.info.getID() == searchValue){
            removeSubtree(current);
            current = null;
        }
    }
    
    public static void addRoot(Student thisStudent){
        if(root == null){
            StudentNode newNode = new StudentNode();
            newNode.info.update(thisStudent);
            root = newNode;
            size++;
        }
    }
    
    public static void addLeft(StudentNode thisLeaf, Student thisStudent){
        StudentNode newNode = new StudentNode();
        newNode.info.update(thisStudent); 
        newNode.left = newNode.right = null;
        thisLeaf.left = newNode; 
        size++;
    }
    
    public static void addRight(StudentNode thisLeaf, Student thisStudent){
        StudentNode newNode = new StudentNode();
        newNode.info.update(thisStudent); 
        newNode.left = newNode.right = null;
        thisLeaf.right = newNode; 
        size++;
    }
    
    public static void addLeftSubtree(StudentNode thisNode, StudentNode newNode){
        StudentNode temp, leftEnd;
        temp = thisNode.left;
        leftEnd = newNode;
        while(leftEnd.left != null){
            leftEnd = leftEnd.left;
        }
        thisNode.left = temp;
    }
    
    public static void addRightSubtree(StudentNode thisNode, StudentNode newNode){
        StudentNode temp, rightEnd;
        temp = thisNode.right;
        rightEnd = newNode;
        while(rightEnd.right != null){
            rightEnd = rightEnd.right;
        }
        thisNode.right = temp;
    }
    
    public static void removeSubtree(StudentNode thisNode){
        if(thisNode.left == null && thisNode.right == null){
            kill(thisNode);
            size--;
        }
        else{
            if(thisNode.left != null){
                removeSubtree(thisNode.left);
            }
            if(thisNode.right != null){
                removeSubtree(thisNode.right);
            }
            kill(thisNode);
        }
    }
    
    public void modify(StudentNode thisLeaf, Student thisStudent){
        thisLeaf.info.update(thisStudent);
    }
    
    public void clearTree(){
        removeSubtree(root);
    }
    
    public StudentNode get(StudentNode thisNode){
        return thisNode;
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty(){
        if(size > 0){
            return false;
        }
        else{
            return true;
        }
    }
    
    public static void inOrder(StudentNode thisNode, boolean recurse){
        if(!recurse && traversal.size() > 0){
            traversal.clear();
        }
        if(thisNode != null){
            if(thisNode.left != null){
                inOrder(thisNode.left, true);
            }
            traversal.add(thisNode.info);
            if(thisNode.right != null){
                inOrder(thisNode.right, true);
            }
        }
    }
    
    
    public static void kill(Object thisObject){
        thisObject = null;
        System.gc();
    }
}
