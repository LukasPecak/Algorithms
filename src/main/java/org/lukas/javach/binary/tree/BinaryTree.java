package org.lukas.javach.binary.tree;

/**
 * Created by Lukas on 20.09.2017.
 *
 * @author Lukas Pecak
 */
public interface BinaryTree<T> {

    void add(TreeNode<T> node);
    boolean remove(TreeNode<T> node);
    boolean contains(TreeNode<T> node);
    boolean isEmpty();
    int size();
}
