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
public class AlumnusTree {
    protected static AlumnusNode root;
    protected static int size, traverseKey;
    protected static ArrayList<Alumnus> traversal;
    
    AlumnusTree(){
        root = null;
        size = 0;
        traverseKey = 0;
        traversal = new ArrayList();
    }
    
    public static void insert(AlumnusNode thisNode){
        AlumnusNode current;
        
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
    
    public static AlumnusNode findInsertionPoint(AlumnusNode thisNode, AlumnusNode thisAlum){
        AlumnusNode point;
    point = thisNode;
    if (thisAlum.info.getID() < point.info.getID() && point.left != null) point = findInsertionPoint(point.left, thisAlum);    
    if (thisAlum.info.getID() > point.info.getID() && point.right != null) point = findInsertionPoint(point.right, thisAlum);    
    return point;
    }
    
    public static AlumnusNode search(int searchValue){
        AlumnusNode current, found;
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
        AlumnusNode current, found;
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
    
    public static void addRoot(Alumnus thisAlum){
        if(root == null){
            AlumnusNode newNode = new AlumnusNode();
            newNode.info.update(thisAlum);
            root = newNode;
            size++;
        }
    }
    
    public static void addLeft(AlumnusNode thisLeaf, Alumnus thisAlum){
        AlumnusNode newNode = new AlumnusNode();
        newNode.info.update(thisAlum); 
        newNode.left = newNode.right = null;
        thisLeaf.left = newNode; 
        size++;
    }
    
    public static void addRight(AlumnusNode thisLeaf, Alumnus thisAlum){
        AlumnusNode newNode = new AlumnusNode();
        newNode.info.update(thisAlum); 
        newNode.left = newNode.right = null;
        thisLeaf.right = newNode; 
        size++;
    }
    
    public static void addLeftSubtree(AlumnusNode thisNode, AlumnusNode newNode){
        AlumnusNode temp, leftEnd;
        temp = thisNode.left;
        leftEnd = newNode;
        while(leftEnd.left != null){
            leftEnd = leftEnd.left;
        }
        thisNode.left = temp;
    }
    
    public static void addRightSubtree(AlumnusNode thisNode, AlumnusNode newNode){
        AlumnusNode temp, rightEnd;
        temp = thisNode.right;
        rightEnd = newNode;
        while(rightEnd.right != null){
            rightEnd = rightEnd.right;
        }
        thisNode.right = temp;
    }
    
    public static void removeSubtree(AlumnusNode thisNode){
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
    
    public void modify(AlumnusNode thisLeaf, Alumnus thisAlum){
        thisLeaf.info.update(thisAlum);
    }
    
    public void clearTree(){
        removeSubtree(root);
    }
    
    public AlumnusNode get(AlumnusNode thisNode){
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
    
    public static void inOrder(AlumnusNode thisNode, boolean recurse){
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

