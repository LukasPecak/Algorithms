package org.lukas.javach.binary.tree;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by Lukas on 21.09.2017.
 *
 * @author Lukas Pecak
 */
public class SimpleBinaryTreeTest {

    private static Logger log = LoggerFactory.getLogger(SimpleBinaryTreeTest.class);
    private BinaryTree<Integer> tree;

    @Before
    public void addElementsToTree() {
        tree = new SimpleBinaryTree<>(new DfsTreeTraverseStrategy<Integer>());
        tree.add(5);
        tree.add(1);
        tree.add(3);
        tree.add(59);
        tree.add(2);
        tree.add(6);
    }

    @Test
    public void doesNumberOfAddedElementsMatch() {
        assertThat(tree.size(),is(equalTo(6)));
        tree.add(10);
        tree.add(11);
        assertThat(tree.size(), is(equalTo(8)));
    }

    @Test
    public void checkIfStructureIsEmptyWorksCorrect() {
        tree = new SimpleBinaryTree<>(new DfsTreeTraverseStrategy<>());
        assertThat(tree.isEmpty(), is(equalTo(true)));
        tree.add(5);
        assertThat(tree.isEmpty(), is(equalTo(false)));
    }

    @Test
    public void collectionContainsElement() {
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(59), is(true));
        assertThat(tree.contains(6), is(true));
        assertThat(tree.contains(0), is(not(true)));
        tree.add(0);
        assertThat(tree.contains(0), is(true));
    }

    @Test
    public void traverseTree() {
        System.out.println(tree.traverseTree(t->t).count());
        log.info(tree.traverseTree(t -> "<" + t + ">").collect(Collectors.joining(" ")));
    }

}