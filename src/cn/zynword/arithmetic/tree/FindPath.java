package cn.zynword.arithmetic.tree;

import java.util.ArrayList;

/**
 * Created by zhaoyuening on 2019/2/1.
 */
public class FindPath {


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        return find(root, 0, target);
    }

    private ArrayList<ArrayList<Integer>> find(TreeNode node,int sum,int target){
        if (node == null) {
            return new ArrayList<>();
        }

        int newSum = sum + node.val;

        if (newSum > target) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (newSum == target && node.left == null && node.right == null) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.val);
            resultList.add(list);
            return resultList;
        }

        // 左右
        ArrayList<ArrayList<Integer>> leftResult = find(node.left, newSum, target);
        ArrayList<ArrayList<Integer>> rightResult = find(node.right, newSum, target);

        addToResult(leftResult, resultList, node);
        addToResult(rightResult, resultList, node);
        return resultList;
    }

    private void addToResult(ArrayList<ArrayList<Integer>> subResult, ArrayList<ArrayList<Integer>> result,TreeNode node) {
        if (subResult == null) {
            return;
        }

        subResult.forEach(list -> list.add(0, node.val));
        result.addAll(subResult);
    }
}
