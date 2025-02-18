package org.example.model;

public interface TernaryTree {

    int getRoot();

    TernaryTree getLeft();

    TernaryTree getCenter();

    TernaryTree getRight();

    void addLeft(int a);

    void addCenter(int a);

    void addRight(int a);

    void removeLeft();

    void removeCenter();

    void removeRight();
}
