package org.lukas.javach.binary.tree;

/**
 * Created by Lukas on 20.09.2017.
 *
 * @author Lukas Pecak
 */
interface TreeNode<T> extends Comparable<TreeNode<T>> {

    TreeNode<T> getLeftChild();
    TreeNode<T> getRightChild();
    boolean hasLeftChild();
    boolean hasRightChild();
}
