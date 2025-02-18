package org.example.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.ArrayList;
import java.util.List;

public class DynamicBinaryMerkleTree implements BinaryMerkleTree {
    private String hash;
    private DynamicBinaryMerkleTree left;
    private DynamicBinaryMerkleTree right;
    private List<String> dataList;

    public DynamicBinaryMerkleTree() {
        this.dataList = new ArrayList<>();
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
        if (dataList.isEmpty()) {
            this.hash = "";
            return;
        }

        List<String> tempHashes = new ArrayList<>();
        for (String data : dataList) {
            tempHashes.add(computeHash(data));
        }

        while (tempHashes.size() > 1) {
            List<String> nextLevelHashes = new ArrayList<>();
            for (int i = 0; i < tempHashes.size(); i += 2) {
                String leftHash = tempHashes.get(i);
                String rightHash = (i + 1 < tempHashes.size()) ? tempHashes.get(i + 1) : "";
                nextLevelHashes.add(computeHash(leftHash + rightHash));
            }
            tempHashes = nextLevelHashes;
        }
        this.hash = tempHashes.get(0);
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
        dataList.add(data);
        updateTree();
    }

    @Override
    public void addRight(String data) {
        dataList.add(data);
        updateTree();
    }

    @Override
    public String getMerkleRoot() {
        return this.hash;
    }

}