package org.example.model;



public interface BinaryMerkleTree {

    String getHash();
    BinaryMerkleTree getLeft();
    BinaryMerkleTree getRight();
    void addLeft(String data);
    void addRight(String data);
    String getMerkleRoot();
}
