package org.example;

import org.example.model.*;
import org.example.util.BinaryTreeUtil;

import static org.example.util.BinaryTreeUtil.*;

public class Main {
    public static void main(String[] args) {
        ejercicio1Test();
        ejercicio2Test();
        ejercicio3Test();
        ejercicio4Test();
        ejercicio5Test();
    }

    public static void ejercicio1Test(){
        DynamicBinaryMerkleTree tree = new DynamicBinaryMerkleTree();

        System.out.println("Merkle Root Inicial: " + tree.getMerkleRoot());

        tree.addLeft("Transaction1");
        tree.addRight("Transaction2");
        tree.addLeft("Transaction3");
        tree.addRight("Transaction4");

        System.out.println("Merkle Root después de agregar transacciones: " + tree.getMerkleRoot());
    }

    public static void ejercicio2Test() {
        System.out.println("=== PRUEBAS DE StaticSearchTernaryTree ===");

        StaticSearchTernaryTree tree = new StaticSearchTernaryTree();

        // Insertar valores en el árbol
        System.out.println("Insertando valores en el árbol...");
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(30);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(70);
        tree.insert(70);
        tree.insert(100);
        tree.insert(10);

        // Imprimir el árbol en orden
        System.out.println("Recorrido en orden después de las inserciones:");
        tree.inOrderTraversal();

        // Buscar valores
        System.out.println("¿Existe 40? " + tree.search(40)); // true
        System.out.println("¿Existe 100? " + tree.search(100)); // true
        System.out.println("¿Existe 15? " + tree.search(15)); // false

        // Intentar insertar más de tres nodos medios en el mismo valor
        System.out.println("Intentando insertar más de tres nodos medios en 30 y 70...");
        tree.insert(30);
        tree.insert(70);

        // Eliminar valores
        System.out.println("Eliminando 40...");
        tree.delete(40);
        System.out.println("Eliminando 70...");
        tree.delete(70);

        // Imprimir el árbol después de eliminar
        System.out.println("Recorrido en orden después de eliminaciones:");
        tree.inOrderTraversal();

        System.out.println("\n=== PRUEBAS DE DynamicSearchTernaryTree ===");

        DynamicSearchTernaryTree tree2 = new DynamicSearchTernaryTree();

        System.out.println("Insertando valores en el árbol dinámico...");
        tree2.insert(50);
        tree2.insert(30);
        tree2.insert(70);
        tree2.insert(30);
        tree2.insert(30);
        tree2.insert(20);
        tree2.insert(40);
        tree2.insert(60);
        tree2.insert(80);
        tree2.insert(70);
        tree2.insert(70);
        tree2.insert(100);
        tree2.insert(10);

        System.out.println("Recorrido en orden después de las inserciones (dinámico):");
        tree2.inOrderTraversal();

        System.out.println("¿Existe 40? " + tree2.search(40));
        System.out.println("¿Existe 100? " + tree2.search(100));
        System.out.println("¿Existe 15? " + tree2.search(15));

        System.out.println("Eliminando 40...");
        tree2.delete(40);
        System.out.println("Eliminando 70...");
        tree2.delete(70);

        System.out.println("Recorrido en orden después de eliminaciones (dinámico):");
        tree2.inOrderTraversal();
    }

    public static void ejercicio3Test(){
        // Crear un árbol binario
        DynamicBinaryTree tree = new DynamicBinaryTree(10);
        tree.addLeft(5);
        tree.addRight(15);
        tree.getLeft().addLeft(2);
        tree.getLeft().addRight(7);
        tree.getRight().addLeft(12);
        tree.getRight().addRight(18);

        // Convertir el árbol en un diccionario
        DynamicDictionary dict = BinaryTreeUtil.treeToDictionary(tree);
        System.out.println("Diccionario generado desde el árbol:");
        org.example.model.Set keys = dict.getKeys();
        while (!keys.isEmpty()) {
            int key = keys.choose();
            keys.remove(key);
            System.out.println("Clave: " + key + ", Altura: " + dict.get(key));
        }

        // Convertir el diccionario de vuelta a un árbol
        DynamicBinaryTree reconstructedTree = BinaryTreeUtil.dictionaryToTree(dict);
        System.out.println("Árbol reconstruido desde el diccionario:");
        printTree(reconstructedTree, 0);
    }

    public static void ejercicio4Test(){
        DynamicBinaryTree tree1 = new DynamicBinaryTree(5);
        tree1.addLeft(3);
        tree1.addRight(8);

        DynamicBinaryTree tree2 = new DynamicBinaryTree(2);
        tree2.addLeft(1);
        tree2.addRight(7);

        DynamicBinaryTree mergedTree = mergeTrees(tree1, tree2);

        System.out.println("Merged tree root: " + mergedTree.getRoot());
        System.out.println("Merged tree left: " + mergedTree.getLeft().getRoot());
        System.out.println("Merged tree right: " + mergedTree.getRight().getRoot());

        DynamicStack stack = new DynamicStack();
        stack.add(10);
        stack.add(20);
        stack.add(30);
        stack.add(40);

        DynamicBinaryTree skewedTree = stackToRightSkewedTree(stack);
        System.out.println("Right skewed tree root: " + skewedTree.getRoot());
        System.out.println("Right skewed tree right: " + skewedTree.getRight().getRoot());



        DynamicQueue queue = new DynamicQueue();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        DynamicBinaryTree skewedTreeLeft = queueToLeftSkewedTree(queue);
        System.out.println("Left skewed tree root: " + skewedTreeLeft.getRoot());
        System.out.println("Left skewed tree left: " + skewedTreeLeft.getLeft().getRoot());
    }

    public static void ejercicio5Test(){
        DynamicBinaryTree tree1 = new DynamicBinaryTree(10);
        tree1.addLeft(5);
        tree1.addRight(15);
        tree1.getLeft().addLeft(2);
        tree1.getLeft().addRight(7);
        tree1.getRight().addLeft(12);
        tree1.getRight().addRight(18);

        DynamicBinaryTree tree2 = new DynamicBinaryTree(10);
        tree2.addLeft(5);
        tree2.addRight(15);
        tree2.getLeft().addLeft(2);
        tree2.getLeft().addRight(7);
        tree2.getRight().addLeft(12);
        tree2.getRight().addRight(20);

        BinaryTree intersectionTree = findIntersection(tree1, tree2);

        System.out.println("Intersección del árbol binario:");
        printTree((DynamicBinaryTree) intersectionTree, 0);
    }

    private static void printTree(DynamicBinaryTree tree, int level) {
        if (tree == null) return;
        printTree((DynamicBinaryTree) tree.getRight(), level + 1);
        System.out.println("  ".repeat(level) + tree.getRoot());
        printTree((DynamicBinaryTree) tree.getLeft(), level + 1);
    }


}