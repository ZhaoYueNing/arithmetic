package cn.zynword.arithmetic.tree;

/**
 * Created by zhaoyuening on 2019/2/1.
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int left, int root) {
        if ((root - left) < 2) {
            return true;
        }
        // 根节点的值
        final int ROOT_VAL = sequence[root];
        // 中间位置 left -> mid-1 左子树 mid -> root-1 右字数
        int mid = left;

        // 从左起找出中间位置
        while (sequence[mid] < ROOT_VAL && mid < root - 1) {
            mid ++;
        }

        int right = mid;
        // 右子树应该大于根值
        while (sequence[right] > ROOT_VAL && right < root - 1) {
            right ++;
        }

        // 证明左右子树不成立
        if (right != root - 1) {
            return false;
        }

        return verify(sequence, left, mid - 1) && verify(sequence, mid, right);
    }

    public static void main(String[] args) {
        VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
        boolean result = verifySquenceOfBST.VerifySquenceOfBST(new int[]{4, 8, 6, 12, 16, 14, 10});
        System.out.println(result);
    }
}
