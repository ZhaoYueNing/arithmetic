package cn.zynword.arithmetic.tree;

/**
 * Created by zhaoyuening on 2019/2/1.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class ConvertTreeToList {
    public TreeNode Convert(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }

        // 对左右子树进行转化
        TreeNode leftListNode = Convert(node.left);
        TreeNode rightListNode = Convert(node.right);

        // 如果左子树是空 根节点为头结点
        TreeNode headNode = node;

        // 左子树列表不为空
        if (leftListNode != null) {
            headNode = leftListNode;

            // 得到最后一个元素
            while (leftListNode.right != null) {
                leftListNode = leftListNode.right;
            }

            // 与根节点连接
            leftListNode.right = node;
            node.left = leftListNode;
        }

        // 右列表与根连接
        if (rightListNode != null) {
            node.right = rightListNode;
            rightListNode.left = node;
        }

        return headNode;
    }
}
