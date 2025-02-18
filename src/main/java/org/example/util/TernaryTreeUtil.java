package org.example.util;

import org.example.model.*;

public class TernaryTreeUtil {

    private TernaryTreeUtil() {
    }

    public static int totalNodes(TernaryTree ternaryTree) {
        if (ternaryTree == null) {
            return 0;
        }
        return 1 + totalNodes(ternaryTree.getLeft()) + totalNodes(ternaryTree.getCenter()) + totalNodes(ternaryTree.getRight());
    }

    public static int height(TernaryTree ternaryTree) {
        if (ternaryTree == null) {
            return 0;
        }
        return 1 + Math.max(Math.max(height(ternaryTree.getLeft()), height(ternaryTree.getCenter())), height(ternaryTree.getRight()));
    }

    public static boolean isFull(TernaryTree ternaryTree) {
        int h = height(ternaryTree);
        return totalNodes(ternaryTree) == (Math.pow(3, h) - 1) / 2;
    }

    public static boolean isComplete(TernaryTree ternaryTree) {
        if (ternaryTree == null) {
            return true;
        }
        if ((ternaryTree.getLeft() == null && (ternaryTree.getCenter() != null || ternaryTree.getRight() != null)) ||
                (ternaryTree.getCenter() == null && ternaryTree.getRight() != null)) {
            return false;
        }
        return isComplete(ternaryTree.getLeft()) && isComplete(ternaryTree.getCenter()) && isComplete(ternaryTree.getRight());
    }

    public static int totalLeaves(TernaryTree ternaryTree) {
        if (ternaryTree == null) {
            return 0;
        }
        if (ternaryTree.getLeft() == null && ternaryTree.getCenter() == null && ternaryTree.getRight() == null) {
            return 1;
        }
        return totalLeaves(ternaryTree.getLeft()) + totalLeaves(ternaryTree.getCenter()) + totalLeaves(ternaryTree.getRight());
    }
}
