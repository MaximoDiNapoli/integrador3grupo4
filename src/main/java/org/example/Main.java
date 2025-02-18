package org.example;

import org.example.model.DynamicBinaryMerkleTree;
import org.example.model.StaticBinaryMerkleTree;

public class Main {
    public static void main(String[] args) {
        DynamicBinaryMerkleTree tree = new DynamicBinaryMerkleTree();

        System.out.println("Merkle Root Inicial: " + tree.getMerkleRoot());

        tree.addLeft("Transaction1");
        tree.addRight("Transaction2");
        tree.addLeft("Transaction3");
        tree.addRight("Transaction4");

        System.out.println("Merkle Root después de agregar transacciones: " + tree.getMerkleRoot());

    }
}