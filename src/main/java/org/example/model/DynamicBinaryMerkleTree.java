package org.example.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DynamicBinaryMerkleTree implements BinaryMerkleTree {
    private String hash;
    private DynamicBinaryMerkleTree left;
    private DynamicBinaryMerkleTree right;
    private LinkedListString dataList;
    private LinkedListString hashList;

    public DynamicBinaryMerkleTree() {
        this.dataList = new LinkedListString();
        this.hashList = new LinkedListString();
        this.hash = "";
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

    private void updateTree() {
        if (dataList.length() == 0) {
            this.hash = "";
            return;
        }

        hashList = new LinkedListString();
        for (int i = 0; i < dataList.length(); i++) {
            String data = dataList.get(i);
            if (!data.isEmpty()) {
                hashList.add(computeHash(data));
            }
        }

        while (hashList.length() > 1) {
            LinkedListString nextLevelHashes = new LinkedListString();
            for (int i = 0; i < hashList.length(); i += 2) {
                String leftHash = hashList.get(i);
                String rightHash = (i + 1 < hashList.length()) ? hashList.get(i + 1) : leftHash;
                nextLevelHashes.add(computeHash(leftHash + rightHash));
            }
            hashList = nextLevelHashes;
        }
        this.hash = hashList.get(0);
    }

    @Override
    public String getHash() {
        return hash;
    }

    @Override
    public DynamicBinaryMerkleTree getLeft() {
        return left;
    }

    @Override
    public DynamicBinaryMerkleTree getRight() {
        return right;
    }

    @Override
    public void addLeft(String data) {
        this.dataList.add(data);
        updateTree();
    }

    @Override
    public void addRight(String data) {
        this.dataList.add(data);
        updateTree();
    }

    @Override
    public void addLeftSubtree(BinaryMerkleTree subtree) {
        if (subtree instanceof DynamicBinaryMerkleTree) {
            this.left = (DynamicBinaryMerkleTree) subtree;
            updateTree();
        } else {
            throw new IllegalArgumentException("El subárbol debe ser una instancia de DynamicBinaryMerkleTree");
        }
    }

    @Override
    public void addRightSubtree(BinaryMerkleTree subtree) {
        if (subtree instanceof DynamicBinaryMerkleTree) {
            this.right = (DynamicBinaryMerkleTree) subtree;
            updateTree();
        } else {
            throw new IllegalArgumentException("El subárbol debe ser una instancia de DynamicBinaryMerkleTree");
        }
    }

    @Override
    public String getMerkleRoot() {
        return this.hash;
    }
}