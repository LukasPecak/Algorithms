package org.lukas.javach.binary.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Lukas on 07.10.2017.
 *
 * @author Lukas Pecak
 */
public class DfsTreeTraverseStrategy<T extends Comparable<T>> implements TreeTraverseStrategy<T> {

    private static Logger log = LoggerFactory.getLogger(DfsTreeTraverseStrategy.class);

    @Override
    public <R> Stream<R> traverseTree(Function<T, R> function, TreeNode<T> root) {
        Collection<T> nodes = new ArrayList<>();
        traverse(root, nodes);
        return nodes.stream().map(function);
    }

    private void traverse(TreeNode<T> node, Collection<T> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(visitNode(node));
        traverse(node.getLeftChild(), nodes);
        traverse(node.getRightChild(), nodes);
    }

    private T visitNode(TreeNode<T> node) {
        log.info("Visiting node : %s", node);
        return node.get();
    }
}
