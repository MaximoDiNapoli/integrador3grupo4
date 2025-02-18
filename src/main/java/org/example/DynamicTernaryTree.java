package org.example.model;

public class DynamicTernaryTree implements TernaryTree {
    private int root;
    private DynamicTernaryTree left;
    private DynamicTernaryTree center;
    private DynamicTernaryTree right;

    public DynamicTernaryTree(int root) {
        this.root = root;
        this.left = null;
        this.center = null;
        this.right = null;
    }

    @Override
    public int getRoot() {
        return root;
    }

    @Override
    public DynamicTernaryTree getLeft() {
        return left;
    }

    @Override
    public DynamicTernaryTree getCenter() {
        return center;
    }

    @Override
    public DynamicTernaryTree getRight() {
        return right;
    }

    @Override
    public void addLeft(int a) {
        this.left = new DynamicTernaryTree(a);
    }

    @Override
    public void addCenter(int a) {
        this.center = new DynamicTernaryTree(a);
    }

    @Override
    public void addRight(int a) {
        this.right = new DynamicTernaryTree(a);
    }

    @Override
    public void removeLeft() {
        this.left = null;
    }

    @Override
    public void removeCenter() {
        this.center = null;
    }

    @Override
    public void removeRight() {
        this.right = null;
    }
}
