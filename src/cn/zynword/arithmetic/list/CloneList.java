package cn.zynword.arithmetic.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyuening on 2019/2/1.
 */
public class CloneList {
    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode,RandomListNode> cloneNodeMap = new HashMap<>();

        // 先创建所有的克隆node 并将对应关系存储到Map中
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNodeMap.put(node, cloneNode);
            node = node.next;
        }

        // 按原链表组装
        node = pHead;
        while (node != null) {
            RandomListNode cloneNode = cloneNodeMap.get(node);
            cloneNode.next = cloneNodeMap.get(node.next);
            cloneNode.random = cloneNodeMap.get(node.random);
            node = node.next;
        }

        return cloneNodeMap.get(pHead);
    }

    public static void main(String[] args) {

    }
}
