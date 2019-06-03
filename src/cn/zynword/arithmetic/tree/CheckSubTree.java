package cn.zynword.arithmetic.tree;

import java.util.Objects;

/**
 * Created by zhaoyuening on 2019/1/30.
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class CheckSubTree {

    /**
     * 判断root2 是不是root1的子树
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        // 如果根节点一致
        if (equalTree(root1, root2)) {
            return true;
        }

        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }


    /**
     * 判断两树是否一致
     * @param root1
     * @param root2
     * @return
     */
    private boolean equalTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            if (root2.left == null && root1.right == null) {
                return true;
            }
            return equalTree(root1.left, root2.left) && equalTree(root1.right, root2.right);
        }

        return false;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}
// {8,#,8,#,9,#,2,#,5},{8,#,9,3,2}