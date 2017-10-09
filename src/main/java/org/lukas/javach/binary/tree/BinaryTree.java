package org.lukas.javach.binary.tree;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Lukas on 20.09.2017.
 *
 * @author Lukas Pecak
 */
public interface BinaryTree<T> {

    void add(T element);

    boolean contains(T element);

    <R> Stream<R> traverseTree(Function<T, R> function);

    boolean isEmpty();

    int size();
}
