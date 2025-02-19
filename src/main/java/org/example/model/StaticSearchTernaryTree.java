package org.example.model;

public class StaticSearchTernaryTree implements ISearchTernaryTree {

    private static final int MAX_SIZE = 100;
    private int[] values;
    private int[] left;
    private int[] middle;
    private int[] right;
    private int size;

    public StaticSearchTernaryTree() {
        values = new int[MAX_SIZE];
        left = new int[MAX_SIZE];
        middle = new int[MAX_SIZE];
        right = new int[MAX_SIZE];
        size = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            left[i] = -1;
            middle[i] = -1;
            right[i] = -1;
        }
    }

    /**
     * Inserta un valor en el árbol.
     * Complejidad: O(log n) en un árbol balanceado, O(n) en el peor caso si está desbalanceado.
     * @param value Valor entero a insertar.
     */
    @Override
    public void insert(int value) {
        if (size >= MAX_SIZE) {
            System.out.println("El árbol está lleno, no se pueden insertar más valores.");
            return;
        }

        if (size == 0) {
            values[size++] = value;
            return;
        }

        int index = 0;
        while (true) {
            if (value < values[index]) {
                if (left[index] == -1) {
                    left[index] = size;
                    values[size++] = value;
                    return;
                }
                index = left[index];
            } else if (value > values[index]) {
                if (right[index] == -1) {
                    right[index] = size;
                    values[size++] = value;
                    return;
                }
                index = right[index];
            } else {
                if (middle[index] == -1) {
                    middle[index] = size;
                    values[size++] = value;
                    return;
                } else {
                    System.out.println("No se pueden insertar más de 3 hijos para un mismo valor.");
                    return;
                }
            }
        }
    }

    /**
     * Busca un valor en el árbol.
     * Complejidad: O(log n) en un árbol balanceado, O(n) en el peor caso si está desbalanceado.
     * @param value Valor entero a buscar.
     * @return true si el valor está en el árbol, false en caso contrario.
     */
    @Override
    public boolean search(int value) {
        int index = 0;
        while (index != -1) {
            if (value < values[index]) {
                index = left[index];
            } else if (value > values[index]) {
                index = right[index];
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un valor del árbol (borrado lógico).
     * Complejidad: O(n) ya que debemos reorganizar los nodos.
     * @param value Valor entero a eliminar.
     * @return true si el valor fue eliminado, false si no se encontraba en el árbol.
     */
    @Override
    public boolean delete(int value) {
        for (int i = 0; i < size; i++) {
            if (values[i] == value) {
                values[i] = values[size - 1];
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Imprime el árbol en orden (In-Order Traversal).
     * Complejidad: O(n), ya que se visitan todos los nodos.
     */
    @Override
    public void inOrderTraversal() {
        inOrderTraversalRec(0);
        System.out.println();
    }

    private void inOrderTraversalRec(int index) {
        if (index == -1 || index >= size) {
            return;
        }
        inOrderTraversalRec(left[index]);
        System.out.print(values[index] + " ");
        inOrderTraversalRec(middle[index]);
        inOrderTraversalRec(right[index]);
    }
}