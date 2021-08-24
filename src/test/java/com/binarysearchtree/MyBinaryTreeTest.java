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
    void given3NodesWhenAddedToBST() {
        MyBinaryTree<Integer> myBinaryTree= new MyBinaryTree<>();
        myBinaryTree.add(56);
        myBinaryTree.add(30);
        myBinaryTree.add(70);
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

}
