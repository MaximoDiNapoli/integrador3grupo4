package org.example;

import org.example.model.DynamicBinaryMerkleTree;
import org.example.model.DynamicBinaryTree;

import static org.example.util.BinaryTreeUtil.mergeTrees;

public class Main {
    public static void main(String[] args) {
        ejercicio1Test();
        ejercicio4Test();
    }


    public static void ejercicio1Test(){
        DynamicBinaryMerkleTree tree = new DynamicBinaryMerkleTree();

        System.out.println("Merkle Root Inicial: " + tree.getMerkleRoot());

        tree.addLeft("Transaction1");
        tree.addRight("Transaction2");
        tree.addLeft("Transaction3");
        tree.addRight("Transaction4");

        System.out.println("Merkle Root después de agregar transacciones: " + tree.getMerkleRoot());
    }


    public static void ejercicio4Test(){
        DynamicBinaryTree tree1 = new DynamicBinaryTree(5);
        tree1.addLeft(3);
        tree1.addRight(8);

        DynamicBinaryTree tree2 = new DynamicBinaryTree(2);
        tree2.addLeft(1);
        tree2.addRight(7);

        DynamicBinaryTree mergedTree = mergeTrees(tree1, tree2);

        System.out.println("Merged tree root: " + mergedTree.getRoot());
        System.out.println("Merged tree left: " + mergedTree.getLeft().getRoot());
        System.out.println("Merged tree right: " + mergedTree.getRight().getRoot());
    }
}