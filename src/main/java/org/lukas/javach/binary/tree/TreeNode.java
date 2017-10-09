package org.lukas.javach.binary.tree;

/**
 * Created by Lukas on 20.09.2017.
 *
 * @author Lukas Pecak
 */
interface TreeNode<T extends Comparable<T>> {

    T get();

    TreeNode<T> getLeftChild();

    void setLeftChild(TreeNode<T> node);

    TreeNode<T> getRightChild();

    void setRightChild(TreeNode<T> node);

    boolean hasLeftChild();

    boolean hasRightChild();
}
