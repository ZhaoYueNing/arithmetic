package cn.zynword.arithmetic.tree;

import java.util.*;

/**
 * Created by zhaoyuening on 2019/1/26.
 */
public class MinParentNode {

    private static Map<String,Boolean> isParentMap = new HashMap<>();

    private static void putIsParentInfoToMap(BinTreeNode parent, BinTreeNode son,Boolean isParent) {
        String key = getKey(parent, son);
        isParentMap.put(key, isParent);
    }

    private static Boolean isParentInMap(BinTreeNode parent, BinTreeNode son) {
        return isParentMap.get(getKey(parent, son));
    }

    public static int counter = 0;

    private static boolean isParent(BinTreeNode parent, BinTreeNode son) {
        counter ++;
        if (Objects.isNull(parent) || Objects.isNull(son)) {
            return false;
        }

        // 从map中查到结果缓存
        Boolean result = isParentInMap(parent, son);
        if (Objects.nonNull(result)) {
            return result;
        }

        if (parent == son || parent.getLeft() == son || parent.getRight() == son) {
            putIsParentInfoToMap(parent, son, true);
            return true;
        }

        Boolean leftResult = isParent(parent.getLeft(), son);
        Boolean rightResult = isParent(parent.getRight(), son);
        result = leftResult || rightResult;

        putIsParentInfoToMap(parent, son, result);
        return result;
    }

    private static String getKey(BinTreeNode parent, BinTreeNode son) {
        StringBuilder builder = new StringBuilder();
        builder.append(parent.hashCode());
        builder.append("=");
        builder.append(son.hashCode());
        return builder.toString();
    }

    public static BinTreeNode find(BinTreeNode root, BinTreeNode nodeA, BinTreeNode nodeB) {
        if (Objects.isNull(root)) {
            return null;
        }
        Boolean resultA = isParent(root, nodeA);
        Boolean resultB = isParent(root, nodeB);

        // 不是两个的公共父节点
        if (!resultA || !resultB) {
            return null;
        }

        // 继续往下找
        BinTreeNode resultLeft = find(root.getLeft(), nodeA, nodeB);
        BinTreeNode resultRight = find(root.getRight(), nodeA, nodeB);

        if (Objects.isNull(resultLeft) && Objects.isNull(resultRight)) {
            return root;
        }

        return Objects.nonNull(resultLeft) ? resultLeft:resultRight;
    }

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

    public static void main(String[] args) {
        BinTreeNode<Integer> root = createData();
        BinTreeNode<Integer> node1 = root.getRight().getLeft().getLeft();
        BinTreeNode<Integer> node2 = root.getRight().getLeft().getLeft().getLeft();
        BinTreeNode<Integer> binTreeNode = find(root, node1, node2);
        System.out.println(binTreeNode.getData());
        System.out.println(counter);
    }
}
