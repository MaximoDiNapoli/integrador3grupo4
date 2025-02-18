package org.example.model;

public interface SearchTernaryTree {

    int getRoot();

    SearchTernaryTree getLeft();

    SearchTernaryTree getCenter();

    SearchTernaryTree getRight();

    void add(int a);

    void addCenter(int a);

    void removeLeft();

    void removeCenter();

    void removeRight();
}
