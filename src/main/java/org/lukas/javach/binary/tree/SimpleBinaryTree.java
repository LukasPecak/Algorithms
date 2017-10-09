package org.lukas.javach.binary.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Lukas on 20.09.2017.
 *
 * @author Lukas Pecak
 */
public class SimpleBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    private static Logger log = LoggerFactory.getLogger(SimpleBinaryTree.class);
    private TreeNode<T> root;
    private int size;
    private TreeTraverseStrategy<T> traversStrategy;

    SimpleBinaryTree(TreeTraverseStrategy<T> traversStrategy) {
        if (traversStrategy == null) {
            throw new IllegalArgumentException("Tree travers strategy needed to construct a SimpleBinaryTree object");
        }
        this.traversStrategy = traversStrategy;
    }

    @Override
    public void add(T element) {
        if (log.isDebugEnabled()) {
            log.debug(String.format("Adding value %s to binary tree", element));
        }
        TreeNode<T> node = new SimpleTreeNode<>(element);
        if (root == null) {
            root = node;
            size++;
            return;
        }
        TreeNode<T> currentNode = root;
        while ((element.compareTo(currentNode.get()) < 0 && currentNode.hasLeftChild()) ||
                (element.compareTo(currentNode.get()) > 0) && currentNode.hasRightChild()) {
            if (element.compareTo(currentNode.get()) == 0) {
                return;
            }
            if (element.compareTo(currentNode.get()) < 0) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }
        if (element.compareTo(currentNode.get()) < 0) {
            currentNode.setLeftChild(new SimpleTreeNode<>(element));
        } else {
            currentNode.setRightChild(new SimpleTreeNode<>(element));
        }
        size++;
    }

    @Override
    public boolean contains(T element) {
        return element != null && traverseTree(element::equals).anyMatch(t -> t);
    }

    @Override
    public <R> Stream<R> traverseTree(Function<T, R> function) {
        return traversStrategy.traverseTree(function, root);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("Simple binary tree containing %d elements", size);
    }
}
