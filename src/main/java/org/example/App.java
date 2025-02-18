package org.example;

import org.example.model.BinaryTree;
import org.example.model.DynamicBinaryTree;
import org.example.model.TernaryTree;
import org.example.model.DynamicTernaryTree;

public class App {

    public static void main(String[] args) {
        BinaryTree binaryTree = new DynamicBinaryTree(5);
        binaryTree.addLeft(2);
        binaryTree.addRight(3);
        binaryTree.getLeft().addLeft(1);
        binaryTree.getLeft().addRight(1);
        binaryTree.getRight().addLeft(1);
        binaryTree.getRight().addRight(2);
        binaryTree.getRight().getRight().addLeft(1);
        binaryTree.getRight().getRight().addRight(1);

        TernaryTree ternaryTree = new DynamicTernaryTree(5);
        ternaryTree.addLeft(2);
        ternaryTree.addCenter(8);
        ternaryTree.addRight(3);
        ternaryTree.getLeft().addLeft(1);
        ternaryTree.getLeft().addCenter(9);
        ternaryTree.getLeft().addRight(1);
        ternaryTree.getRight().addLeft(1);
        ternaryTree.getRight().addCenter(4);
        ternaryTree.getRight().addRight(2);
        ternaryTree.getRight().getRight().addLeft(1);
        ternaryTree.getRight().getRight().addCenter(1);
        ternaryTree.getRight().getRight().addRight(1);
    }

}
