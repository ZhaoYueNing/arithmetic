package cn.zynword.arithmetic.tree;

import java.util.Objects;

/**
 * Created by zhaoyuening on 2019/1/22.
 */
public class P88 {
    public static void prePrintTree(BinTreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }

        System.out.print(node.getData() + " ");
        prePrintTree(node.getLeft());
        prePrintTree(node.getRight());
    }

    public static void midPrintTree(BinTreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }

        prePrintTree(node.getLeft());
        System.out.print(node.getData() + " ");
        prePrintTree(node.getRight());
    }

    public static void postPrintTree(BinTreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }

        prePrintTree(node.getLeft());
        prePrintTree(node.getRight());
        System.out.print(node.getData() + " ");
    }


    public static void main(String[] args) {
        BinTreeNode<Integer> head = BinTreeNode.getDemoTree1();
        prePrintTree(head);
        System.out.println();
        midPrintTree(head);
        System.out.println();
        postPrintTree(head);
    }
}
