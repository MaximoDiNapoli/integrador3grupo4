package org.example.util;

import org.example.model.DynamicBinaryTree;
import org.example.model.BinaryTree;

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


}
