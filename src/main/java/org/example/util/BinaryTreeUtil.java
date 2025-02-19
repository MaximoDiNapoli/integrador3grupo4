package org.example.util;

import org.example.model.*;

import java.util.Stack;

public class BinaryTreeUtil {

    public static DynamicBinaryTree mergeTrees(DynamicBinaryTree t1, DynamicBinaryTree t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        DynamicBinaryTree mergedTree = new DynamicBinaryTree(t1.getRoot() + t2.getRoot());

        if (t1.getLeft() != null || t2.getLeft() != null) {
            mergedTree.addLeft(mergeTreesHelper(t1.getLeft(), t2.getLeft()));
        }
        if (t1.getRight() != null || t2.getRight() != null) {
            mergedTree.addRight(mergeTreesHelper(t1.getRight(), t2.getRight()));
        }

        return mergedTree;
    }

    private static int mergeTreesHelper(BinaryTree t1, BinaryTree t2) {
        if (t1 == null) return t2.getRoot();
        if (t2 == null) return t1.getRoot();
        return t1.getRoot() + t2.getRoot();
    }



    public static DynamicBinaryTree stackToRightSkewedTree(DynamicStack stack) {
        if (stack.isEmpty()) return null;

        DynamicBinaryTree root = new DynamicBinaryTree(stack.getTop());
        stack.remove();
        DynamicBinaryTree current = root;

        while (!stack.isEmpty()) {
            current.addRight(stack.getTop());
            stack.remove();
            current = (DynamicBinaryTree) current.getRight();
        }

        return root;
    }




    public static DynamicBinaryTree queueToLeftSkewedTree(DynamicQueue queue) {
        if (queue.isEmpty()) return null;

        DynamicBinaryTree root = new DynamicBinaryTree(queue.getFirst());
        queue.remove();
        DynamicBinaryTree current = root;

        while (!queue.isEmpty()) {
            current.addLeft(queue.getFirst());
            queue.remove();
            current = (DynamicBinaryTree) current.getLeft();
        }

        return root;
    }



    // Método para calcular la altura de un nodo y llenar el diccionario
    private static int fillDictionary(DynamicBinaryTree node, DynamicDictionary dict, int height) {
        if (node == null) {
            return -1;
        }

        // Guardar la altura del nodo en el diccionario
        dict.add(node.getRoot(), height);

        // Recorrer hijos
        int leftHeight = fillDictionary((DynamicBinaryTree) node.getLeft(), dict, height + 1);
        int rightHeight = fillDictionary((DynamicBinaryTree) node.getRight(), dict, height + 1);

        // Retornar la altura máxima
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Método para convertir un árbol binario en un diccionario
    public static DynamicDictionary treeToDictionary(DynamicBinaryTree tree) {
        DynamicDictionary dict = new DynamicDictionary();
        fillDictionary(tree, dict, 0);
        return dict;
    }

    // Método para reconstruir un árbol bisolnario a partir de un diccionario
    public static DynamicBinaryTree dictionaryToTree(DynamicDictionary dict) {
        DynamicBinaryTree tree = null;
        org.example.model.Set keys = dict.getKeys();
        while (!keys.isEmpty()) {
            int key = keys.choose();
            keys.remove(key);
            if (tree == null) {
                tree = new DynamicBinaryTree(key);
            } else {
                insertIntoTree(tree, key);
            }
        }
        return tree;
    }

    // Método auxiliar para insertar nodos en el árbol
    private static void insertIntoTree(DynamicBinaryTree tree, int key) {
        if (key < tree.getRoot()) {
            if (tree.getLeft() == null) {
                tree.addLeft(key);
            } else {
                insertIntoTree((DynamicBinaryTree) tree.getLeft(), key);
            }
        } else {
            if (tree.getRight() == null) {
                tree.addRight(key);
            } else {
                insertIntoTree((DynamicBinaryTree) tree.getRight(), key);
            }
        }
    }
}
