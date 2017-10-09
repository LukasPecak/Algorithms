package org.lukas.javach.binary.tree;

/**
 * Created by Lukas on 21.09.2017.
 *
 * @author Lukas Pecak
 */
public class SimpleTreeNode<T extends Comparable<T>> implements TreeNode<T> {

    private final T nodeData;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    SimpleTreeNode(T element) {
        nodeData = element;
    }

    public T get() {
        return nodeData;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setLeftChild(TreeNode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("Null references can damage the tree structure");
        }
        leftChild = node;
    }

    public void setRightChild(TreeNode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("Null references can damage the tree structure");
        }
        rightChild = node;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    @Override
    public String toString() {
        return nodeData.toString();
    }
}
