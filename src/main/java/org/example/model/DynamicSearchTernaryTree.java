package org.example.model;

public class DynamicSearchTernaryTree {
    
    private final TernaryTree ternaryTree;

    public DynamicSearchTernaryTree(int root) {
        this.ternaryTree = new DynamicTernaryTree(root);
    }

    private DynamicSearchTernaryTree(TernaryTree ternaryTree) {
        this.ternaryTree = ternaryTree;
    }

    public int getRoot() {
        return this.ternaryTree.getRoot();
    }

    public DynamicSearchTernaryTree getLeft() {
        TernaryTree left = this.ternaryTree.getLeft();
        return (left != null) ? new DynamicSearchTernaryTree(left) : null;
    }

    public DynamicSearchTernaryTree getMiddle() {
        TernaryTree middle = this.ternaryTree.getMiddle();
        return (middle != null) ? new DynamicSearchTernaryTree(middle) : null;
    }

    public DynamicSearchTernaryTree getRight() {
        TernaryTree right = this.ternaryTree.getRight();
        return (right != null) ? new DynamicSearchTernaryTree(right) : null;
    }

    public void add(int a) {
        if (a < this.getRoot()) {
            if (this.getLeft() != null) {
                this.getLeft().add(a);
            } else {
                this.ternaryTree.addLeft(a);
            }
        } else if (a == this.getRoot()) {
            if (this.getMiddle() != null) {
                this.getMiddle().add(a);
            } else {
                this.ternaryTree.addMiddle(a);
            }
        } else {
            if (this.getRight() != null) {
                this.getRight().add(a);
            } else {
                this.ternaryTree.addRight(a);
            }
        }
    }

    public void removeLeft() {
        this.ternaryTree.removeLeft();
    }

    public void removeMiddle() {
        this.ternaryTree.removeMiddle();
    }

    public void removeRight() {
        this.ternaryTree.removeRight();
    }
}
