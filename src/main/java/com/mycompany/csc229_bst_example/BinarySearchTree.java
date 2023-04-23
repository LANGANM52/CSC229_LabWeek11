package com.mycompany.csc229_bst_example;

/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        if (root == null) {
            return;
        }
        doInOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        doInOrder(root.getRight());
    }

    public void preOrderTraversal() {
        doPreOrder(this.root);
    }

    private void doPreOrder(BstNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }

    public Integer findHeight() {
        return doGetHeight(this.root);
    }

    private Integer doGetHeight(BstNode root) {
        if (root == null) {
            return -1;
        }
        Integer leftHeight = doGetHeight(root.getLeft());
        Integer rightHeight = doGetHeight(root.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getDepth(BstNode node) {
        return doGetDepth(this.root, node);
    }

    private int doGetDepth(BstNode root, BstNode node) {
        if (root == null) {
            return -1;
        }
        if (root == node) {
            return 0;
        }
        int leftDepth = doGetDepth(root.getLeft(), node);
        if (leftDepth != -1) {
            return leftDepth + 1;
        }
        int rightDepth = doGetDepth(root.getRight(), node);
        if (rightDepth != -1) {
            return rightDepth + 1;
        }
        return -1;
    }

    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
    }

    private void print(String prefix, BstNode node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "/__" : "\\__") + node.getData());
            print(prefix + (isLeft ? "|   " : "    "), node.getLeft(), true);
            print(prefix + (isLeft ? "|   " : "    "), node.getRight(), false);
        }
    }

}
