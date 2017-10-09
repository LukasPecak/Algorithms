package org.lukas.javach.binary.tree;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Lukas on 07.10.2017.
 *
 * @author Lukas Pecak
 */
interface TreeTraverseStrategy<T extends Comparable<T>> {
    <R> Stream<R> traverseTree(Function<T, R> function, TreeNode<T> root);
}
