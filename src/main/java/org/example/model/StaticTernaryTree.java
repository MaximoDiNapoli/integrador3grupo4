package org.example.model;

public class StaticTernaryTree implements TernaryTree {
    private final int root;
    private StaticTernaryTree left;
    private StaticTernaryTree center;
    private StaticTernaryTree right;

    public StaticTernaryTree(int root) {
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
    public StaticTernaryTree getLeft() {
        return left;
    }

    @Override
    public StaticTernaryTree getCenter() {
        return center;
    }

    @Override
    public StaticTernaryTree getRight() {
        return right;
    }

    @Override
    public void addLeft(int a) {
        if (this.left == null) {
            this.left = new StaticTernaryTree(a);
        }
    }

    @Override
    public void addCenter(int a) {
        if (this.center == null) {
            this.center = new StaticTernaryTree(a);
        }
    }

    @Override
    public void addRight(int a) {
        if (this.right == null) {
            this.right = new StaticTernaryTree(a);
        }
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
