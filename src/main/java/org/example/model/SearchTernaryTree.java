package org.example.model;

public interface SearchTernaryTree {

    /**
     * Inserta un valor en el árbol.
     * @param value Valor entero a insertar.
     */
    void insert(int value);

    /**
     * Busca un valor en el árbol.
     * @param value Valor entero a buscar.
     * @return true si el valor está en el árbol, false en caso contrario.
     */
    boolean search(int value);

    /**
     * Elimina un valor del árbol.
     * @param value Valor entero a eliminar.
     * @return true si el valor fue eliminado, false si no se encontraba en el árbol.
     */
    boolean delete(int value);

    /**
     * Imprime el árbol en orden (In-Order Traversal).
     */
    void inOrderTraversal();
}