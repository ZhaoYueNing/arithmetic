package cn.zynword.arithmetic.tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * Created by zhaoyuening on 2019/1/22.
 */
public class P95 {

    public static BinTreeNode<Integer> createData() {
        BinTreeNode<Integer> head = new BinTreeNode<>(1);
        head.createLeftNode(2).getLeft()
                .createRightNode(4).getRight()
                .createLeftNode(7).createRightNode(8).getRight()
                .createRightNode(11).getRight()
                .createLeftNode(13).createRightNode(14);
        head.createRightNode(3).getRight()
                .createLeftNode(5).createRightNode(6).getLeft()
                .createLeftNode(9).createRightNode(10).getLeft()
                .createLeftNode(12).getLeft()
                .createLeftNode(15).createRightNode(16);

        return head;
    }

    public static List<Integer> solve(BinTreeNode<Integer> head) {
        List<Integer> printList = new ArrayList<>();
        Set<Integer> printedSet = new HashSet<>();
        Stack<BinTreeNode<Integer>> stack = new Stack<>();

        if (Objects.isNull(head)) {
            return printList;
        }

        BinTreeNode<Integer> left = head;
        BinTreeNode<Integer> right = head;


        print(head, printedSet, printList);

        return printList;
    }

    // 打印最左
    private static void print(BinTreeNode<Integer> node, Set<Integer> printedSet, List<Integer> printList) {
        if (Objects.isNull(node)) {
            return;
        }

        LinkedList<BinTreeNode<Integer>> queue = new LinkedList<>();
        LinkedList<BinTreeNode<Integer>> leftList = new LinkedList<>();
        LinkedList<BinTreeNode<Integer>> leafList = new LinkedList<>();
        LinkedList<BinTreeNode<Integer>> rightList = new LinkedList<>();
        Set<Integer> leftRightSet = new HashSet<>();

        BinTreeNode<Integer> rightNode = node;
        queue.add(node);
        leftList.add(node);

        while (!queue.isEmpty()) {
            BinTreeNode<Integer> popNode = queue.poll();

            if (Objects.nonNull(popNode.getLeft())) {
                queue.add(popNode.getLeft());
            }
            if (Objects.nonNull(popNode.getRight())) {
                queue.add(popNode.getRight());
            }

            // 如果是叶子节点
            if (Objects.isNull(popNode.getLeft()) && Objects.isNull(popNode.getRight()) && !leftRightSet.contains(popNode.getData())) {
                leafList.add(popNode);
            }

            // 如果是最右节点
            if (popNode == rightNode && !queue.isEmpty()) {
                rightNode = queue.peekLast();
                // 最左
                BinTreeNode<Integer> firstNode = queue.peekFirst();
                leftList.add(firstNode);
                leftRightSet.add(firstNode.getData());
                // 最右
                BinTreeNode<Integer> lastNode = queue.peekLast();
                rightList.addFirst(lastNode);
                leftRightSet.add(lastNode.getData());
            }


        }

        for (BinTreeNode<Integer> printNode : leftList) {
            printNode(printNode, printedSet, printList);
        }
        for (BinTreeNode<Integer> printNode : leafList) {
            printNode(printNode, printedSet, printList);
        }
        for (BinTreeNode<Integer> printNode : rightList) {
            printNode(printNode, printedSet, printList);
        }
    }

    private static void printNode(BinTreeNode<Integer> node, Set<Integer> printedSet, List<Integer> printList) {
        if (Objects.nonNull(node) && Objects.nonNull(node.getData()) && !printedSet.contains(node.getData())) {
            printedSet.add(node.getData());
            printList.add(node.getData());
        }
    }

    // 打印子节点
    private static void printLeaf(BinTreeNode<Integer> node, Set<Integer> printedSet, List<Integer> printList) {
        if (Objects.isNull(node)) {
            return;
        }

        if (Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight()) && !printedSet.contains(node.getData())) {
            printedSet.add(node.getData());
            printList.add(node.getData());
        }

        printLeaf(node.getLeft(), printedSet, printList);
        printLeaf(node.getRight(), printedSet, printList);
    }

    // 打印最右
    private static void printRight(BinTreeNode<Integer> node, Set<Integer> printedSet, List<Integer> printList) {
        if (Objects.isNull(node)) {
            return;
        }

        if (!printedSet.contains(node.getData())) {
            printedSet.add(node.getData());
            printList.add(node.getData());
        }

        if (Objects.nonNull(node.getRight())) {
            printRight(node.getRight(), printedSet, printList);
        } else if (Objects.nonNull(node.getLeft())) {
            printRight(node.getLeft(), printedSet, printList);
        }
    }

    public static void main(String[] args) {
        List<Integer> printList = solve(createData());
        for (Integer integer : printList) {
            System.out.print(integer + " ");
        }

    }
}
