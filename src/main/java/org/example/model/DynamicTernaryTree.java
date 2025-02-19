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
        return this.root;
    }

    @Override
    public DynamicTernaryTree getLeft() {
        return this.left;
    }

    @Override
    public DynamicTernaryTree getCenter() {
        return this.center;
    }

    @Override
    public DynamicTernaryTree getRight() {
        return this.right;
    }

    @Override
    public void addLeft(int a) {
        if (this.left != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        this.left = new DynamicTernaryTree(a);
    }

    @Override
    public void addCenter(int a) {
        if (this.center != null) {
            throw new RuntimeException("Ya existe un hijo central");
        }
        this.center = new DynamicTernaryTree(a);
    }

    @Override
    public void addRight(int a) {
        if (this.right != null) {
            throw new RuntimeException("Ya existe un hijo derecho");
        }
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
