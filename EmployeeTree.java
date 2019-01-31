/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsass07_mccalld;

import static dsass07_mccalld.StudentTree.root;
import java.util.ArrayList;

/**
 *
 * @author Dylan
 */
public class EmployeeTree {
    protected static EmployeeNode root;
    protected static int size, traverseKey;
    protected static ArrayList<Employee> traversal;
    
    EmployeeTree(){
        root = null;
        size = 0;
        traverseKey = 0;
        traversal = new ArrayList();
    }
    
    public static void insert(EmployeeNode thisNode){
        EmployeeNode current;
        
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
    
    public static EmployeeNode findInsertionPoint(EmployeeNode thisNode, EmployeeNode thisEmployee){
        EmployeeNode point;
    point = thisNode;
    if (thisEmployee.info.getID() < point.info.getID() && point.left != null) point = findInsertionPoint(point.left, thisEmployee);    
    if (thisEmployee.info.getID() > point.info.getID() && point.right != null) point = findInsertionPoint(point.right, thisEmployee);    
    return point;
    }
    
    public static EmployeeNode search(int searchValue){
        EmployeeNode current, found;
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
        EmployeeNode current, found;
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
    
    public static void addRoot(Employee thisEmployee){
        if(root == null){
            EmployeeNode newNode = new EmployeeNode();
            newNode.info.update(thisEmployee);
            root = newNode;
            size++;
        }
    }
    
    public static void addLeft(EmployeeNode thisLeaf, Employee thisEmployee){
        EmployeeNode newNode = new EmployeeNode();
        newNode.info.update(thisEmployee); 
        newNode.left = newNode.right = null;
        thisLeaf.left = newNode; 
        size++;
    }
    
    public static void addRight(EmployeeNode thisLeaf, Employee thisEmployee){
        EmployeeNode newNode = new EmployeeNode();
        newNode.info.update(thisEmployee); 
        newNode.left = newNode.right = null;
        thisLeaf.right = newNode; 
        size++;
    }
    
    public static void addLeftSubtree(EmployeeNode thisNode, EmployeeNode newNode){
        EmployeeNode temp, leftEnd;
        temp = thisNode.left;
        leftEnd = newNode;
        while(leftEnd.left != null){
            leftEnd = leftEnd.left;
        }
        thisNode.left = temp;
    }
    
    public static void addRightSubtree(EmployeeNode thisNode, EmployeeNode newNode){
        EmployeeNode temp, rightEnd;
        temp = thisNode.right;
        rightEnd = newNode;
        while(rightEnd.right != null){
            rightEnd = rightEnd.right;
        }
        thisNode.right = temp;
    }
    
    public static void removeSubtree(EmployeeNode thisNode){
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
    
    public void modify(EmployeeNode thisLeaf, Employee thisEmployee){
        thisLeaf.info.update(thisEmployee);
    }
    
    public void clearTree(){
        removeSubtree(root);
    }
    
    public EmployeeNode get(EmployeeNode thisNode){
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
    
    public static void inOrder(EmployeeNode thisNode, boolean recurse){
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

