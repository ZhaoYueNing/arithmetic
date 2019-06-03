package cn.zynword.arithmetic.tree;

import java.util.*;

/**
 * Created by zhaoyuening on 2019/1/30.
 * 按层打印树
 */
public class TierPrintTree {

    public static void main(String[] args) {
        TierPrintTree tierPrintTree = new TierPrintTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        ArrayList<Integer> integers = tierPrintTree.PrintFromTopToBottom(root);
        System.out.println(integers);
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> treeQueue = new LinkedList<>();
        int len = 1;
        treeQueue.add(root);

        for (int i = 1; i <= len; i++) {
            TreeNode node = treeQueue.poll();
            resultList.add(node.val);
            if (node.left != null) {
                treeQueue.add(node.left);
            }
            if (node.right != null) {
                treeQueue.add(node.right);
            }


            // 本层的最后一个元素
            if (i == len) {
                len = treeQueue.size();
                i = 0;
            }
        }
        return resultList;
    }
}
