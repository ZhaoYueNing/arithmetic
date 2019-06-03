package cn.zynword.arithmetic;

import cn.zynword.arithmetic.common.TreeNode;

import java.util.*;

/**
 * Created by zhaoyuening on 2019/5/24.
 */
public class Main {


    public int maxPathSum(TreeNode root) {
        Integer maxValue = getMaxValue(root);
        return Math.max(currentMax, maxValue);
    }

    private Integer currentMax = Integer.MIN_VALUE;

    private Integer getMaxValue(TreeNode node){
        if (node.left == null && node.right == null){
            return node.val;
        }

        Integer leftMax = node.left == null ? Integer.MIN_VALUE : getMaxValue(node.left);
        Integer rightMax = node.right == null ? Integer.MIN_VALUE : getMaxValue(node.right);

        // 不可向上发展最大值
        currentMax = Math.max(currentMax,leftMax);
        currentMax = Math.max(currentMax,rightMax);
        if (node.left != null && node.right != null){
            currentMax = Math.max(currentMax,leftMax + rightMax + node.val);
        }

        // 可向上发展最大值
        Integer max = node.val + Math.max(leftMax,rightMax);
        max = Math.max(max,node.val);

        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Main test = new Main();
        int result = test.maxPathSum(root);
        System.out.println(result);
    }



}
