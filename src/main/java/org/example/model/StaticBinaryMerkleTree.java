package org.example.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class StaticBinaryMerkleTree implements BinaryMerkleTree {
    private String hash;
    private StaticBinaryMerkleTree left;
    private StaticBinaryMerkleTree right;

    public StaticBinaryMerkleTree(String data) {
        this.hash = computeHash(data);
        this.left = null;
        this.right = null;
    }

    private String computeHash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(data.getBytes());
            return Base64.getEncoder().encodeToString(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al calcular el hash", e);
        }
    }

    @Override
    public String getHash() {
        return hash;
    }

    @Override
    public StaticBinaryMerkleTree getLeft() {
        return left;
    }

    @Override
    public StaticBinaryMerkleTree getRight() {
        return right;
    }

    @Override
    public void addLeft(String data) {
        this.left = new StaticBinaryMerkleTree(data);
        updateHash();
    }

    @Override
    public void addRight(String data) {
        this.right = new StaticBinaryMerkleTree(data);
        updateHash();
    }

    @Override
    public void addLeftSubtree(BinaryMerkleTree subtree) {
        if (subtree instanceof StaticBinaryMerkleTree) {
            this.left = (StaticBinaryMerkleTree) subtree;
            updateHash();
        } else {
            throw new IllegalArgumentException("El subárbol debe ser una instancia de StaticBinaryMerkleTree");
        }
    }

    @Override
    public void addRightSubtree(BinaryMerkleTree subtree) {
        if (subtree instanceof StaticBinaryMerkleTree) {
            this.right = (StaticBinaryMerkleTree) subtree;
            updateHash();
        } else {
            throw new IllegalArgumentException("El subárbol debe ser una instancia de StaticBinaryMerkleTree");
        }
    }

    private void updateHash() {
        String leftHash = (left != null) ? left.getHash() : "";
        String rightHash = (right != null) ? right.getHash() : "";
        this.hash = computeHash(leftHash + rightHash);
    }

    @Override
    public String getMerkleRoot() {
        return this.hash;
    }
}
