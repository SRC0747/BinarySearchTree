package com.binarysearchtree;

import org.junit.jupiter.api.Test;

public class MyBinaryNode<K extends Comparable<K>>
{
    K key;
    MyBinaryNode<K> left;
    MyBinaryNode<K> right;

    public MyBinaryNode(K key){
        this.key = key;
        this.left = null;
        this.right = null;
    }

}

public class MyBinaryTreeTest {

    @Test
    <MyBinaryTree>
    void givenNodesWhenAddedToBST() {
        MyBinaryTree<Integer> myBinaryTree= new MyBinaryTree<>();
        myBinaryTree.add(56);
        myBinaryTree.add(30);
        myBinaryTree.add(70);
         myBinaryTree.add(22);
        myBinaryTree.add(40);
        myBinaryTree.add(60);
        myBinaryTree.add(95);
        myBinaryTree.add(11);
        myBinaryTree.add(65);
        myBinaryTree.add(3);
        myBinaryTree.add(16);
        myBinaryTree.add(63);
        myBinaryTree.add(67);
        int size = myBinaryTree.getSize();
        Assert.assertEquals(3,size);
    }
}

public class MyBinaryTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;
    private MyBinaryNode<K> addRecursive;

    public void add(K key){
        addRecursive = this.addRecursive(root, key, () -> {
            int compareResult1 = key.compareTo(root.Key);
        });
        this.root = addRecursive;
    }
    private MyBinaryNode<K> addRecursive(MyBinaryNode<K> current, K key) {
        if (current == null)
            return new MyBinaryNode<>(key);
        int compareResult = key.compareTo(current.key);
        if (compareResult == 0)
            return current;
        if (compareResult<0){
            current.left = addRecursive(current,left,key);
        }
        else{
            current.left = addRecursive(current,right,key);
        }
        return current;
    }
      public int getSize(){
        return this.getSizeRecursive(root);
    }
    private int getSizeRecursive(MyBinaryNode<K> current){
        return current == null ? 0: 1 + this.getSizeRecursive(current,left) + this.getSizeRecursive(current,right);
    }
     //Represent the root of binary tree
    public Node root;

    public static boolean flag = false;

    public SearchBinaryTree(){
        root = null;
    }

    //searchNode() will search for the particular node in the binary tree
    public void searchNode(Node temp, int value){
        //Check whether tree is empty
        if(root == null){
            System.out.println("Tree is empty");
        }
        else{
            //If value is found in the given binary tree then, set the flag to true
            if(temp.data == value){
                flag = true;
                return;
            }
            //Search in left subtree
            if(flag == false && temp.left != null){
                searchNode(temp.left, value);
            }
            //Search in right subtree
            if(flag == false && temp.right != null){
                searchNode(temp.right, value);
            }
        }
    }
}
