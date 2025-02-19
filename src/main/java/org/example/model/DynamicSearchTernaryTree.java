package org.example.model;

import org.example.model.ISearchTernaryTree;

public class DynamicSearchTernaryTree implements ISearchTernaryTree {

    // Clase interna que representa un nodo del árbol ternario
    private static class Node {
        int value;
        Node left, middle, right;

        public Node(int value) {
            this.value = value;
            this.left = this.middle = this.right = null;
        }
    }

    // Raíz del árbol
    private Node root;

    // Constructor
    public DynamicSearchTernaryTree() {
        this.root = null;
    }

    /**
     * Inserta un valor en el árbol.
     * Complejidad: O(log n) en un árbol balanceado, O(n) en el peor caso si está desbalanceado.
     * @param value Valor entero a insertar.
     */
    @Override
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        } else {
            node.middle = insertRec(node.middle, value);
        }

        return node;
    }

    /**
     * Busca un valor en el árbol.
     * Complejidad: O(log n) en un árbol balanceado, O(n) en el peor caso si está desbalanceado.
     * @param value Valor entero a buscar.
     * @return true si el valor está en el árbol, false en caso contrario.
     */
    @Override
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value < node.value) {
            return searchRec(node.left, value);
        } else if (value > node.value) {
            return searchRec(node.right, value);
        } else {
            return true;
        }
    }

    /**
     * Elimina un valor del árbol.
     * Complejidad: O(log n) en el caso promedio, O(n) en el peor caso si el árbol está desbalanceado.
     * @param value Valor entero a eliminar.
     * @return true si el valor fue eliminado, false si no se encontraba en el árbol.
     */
    @Override
    public boolean delete(int value) {
        if (search(value)) {
            root = deleteRec(root, value);
            return true;
        }
        return false;
    }

    private Node deleteRec(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.value) {
            node.right = deleteRec(node.right, value);
        } else {
            // Si hay nodos en el subárbol medio, eliminamos el último nodo del subárbol medio
            if (node.middle != null) {
                node.middle = deleteRec(node.middle, value);
            } else if (node.right != null) {
                node.value = findMin(node.right);
                node.right = deleteRec(node.right, node.value);
            } else {
                node = node.left;
            }
        }
        return node;
    }

    /**
     * Encuentra el valor mínimo en un subárbol.
     * Complejidad: O(log n) en el caso promedio, O(n) en el peor caso.
     * @param node Nodo raíz del subárbol.
     * @return El valor mínimo encontrado.
     */
    private int findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    /**
     * Imprime el árbol en orden (In-Order Traversal).
     * Complejidad: O(n), ya que cada nodo se visita una vez.
     */
    @Override
    public void inOrderTraversal() {
        inOrderTraversalRec(root);
        System.out.println();
    }

    private void inOrderTraversalRec(Node node) {
        if (node != null) {
            inOrderTraversalRec(node.left);
            System.out.print(node.value + " ");
            inOrderTraversalRec(node.middle);
            inOrderTraversalRec(node.right);
        }
    }
}