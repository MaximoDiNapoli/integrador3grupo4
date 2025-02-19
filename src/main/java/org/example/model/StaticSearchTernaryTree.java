package org.example.model;

public class StaticSearchTernaryTree {
    
    private final TernaryTree ternaryTree;

    public StaticSearchTernaryTree(int root) {
        this.ternaryTree = new StaticTernaryTree(root);
    }

    private StaticSearchTernaryTree(TernaryTree ternaryTree) {
        this.ternaryTree = ternaryTree;
    }

    public int getRoot() {
        return this.ternaryTree.getRoot();
    }

    public StaticSearchTernaryTree getLeft() {
        TernaryTree left = this.ternaryTree.getLeft();
        return (left != null) ? new StaticSearchTernaryTree(left) : null;
    }

    public StaticSearchTernaryTree getMiddle() {
        TernaryTree middle = this.ternaryTree.getMiddle();
        return (middle != null) ? new StaticSearchTernaryTree(middle) : null;
    }

    public StaticSearchTernaryTree getRight() {
        TernaryTree right = this.ternaryTree.getRight();
        return (right != null) ? new StaticSearchTernaryTree(right) : null;
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
