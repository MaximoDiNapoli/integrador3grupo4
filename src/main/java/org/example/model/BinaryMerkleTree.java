package org.example.model;

public interface BinaryMerkleTree {

    String getHash();
    BinaryMerkleTree getLeft();
    BinaryMerkleTree getRight();
    void addLeft(String data);
    void addRight(String data);
    void addLeftSubtree(BinaryMerkleTree subtree);  // Agregar un subárbol en la izquierda
    void addRightSubtree(BinaryMerkleTree subtree); // Agregar un subárbol en la derecha
    String getMerkleRoot();
}