package ru.module.math;

import java.awt.*;

public class BSPTree {
    /**
     A Node of the tree. All children of the node are either
     to the front or back of the node's partition.
     */
    public static class Node {
        public Node front;
        public Node back;
        public BSPLine partition;
        public List polygons;
    }
    /**
     A Leaf of the tree. A leaf has no partition or front or
     back nodes.
     */
    public static class Leaf extends Node {
        public float floorHeight;
        public float ceilHeight;
        public Rectangle bounds;
        public boolean isBack;
    }
    private Node root;
    /**
     Creates a new BSPTree with the specified root node.
     */
    public BSPTree(Node root) {
        this.root = root;
    }
    /**
     Gets the root node of this tree.
     */
    public Node getRoot() {
        return root;
    }
}
