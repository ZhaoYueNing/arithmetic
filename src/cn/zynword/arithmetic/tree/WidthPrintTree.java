package cn.zynword.arithmetic.tree;

import cn.zynword.arithmetic.structure.tree.BinTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by zhaoyuening on 2019/1/3.
 * 宽度优先打印树
 */
public class WidthPrintTree {


    public void printTree(BinTree<String> rootTree) {
        LinkedList<BinTree<String>> queue = new LinkedList<BinTree<String>>();
        BinTree<String> last = rootTree;

        queue.add(rootTree);
        while (!queue.isEmpty()) {
            BinTree<String> binTree = queue.poll();
            System.out.print(binTree.getData() + " ");
            if (Objects.nonNull(binTree.getLeft())) {
                queue.add(binTree.getLeft());
            }
            if (Objects.nonNull(binTree.getRight())) {
                queue.add(binTree.getRight());
            }
            if (last == binTree) {
                System.out.println();
                last = queue.peekLast();
            }
        }
    }

    /**
     * 创建一个树
     */
    public BinTree<String> createBinTree() {
        BinTree<String> rootBinTree = new BinTree<>("1");
        rootBinTree.setLeft(new BinTree<>("2")).setRight(new BinTree<>("3"));
        rootBinTree.getLeft().setLeft(new BinTree<>("6")).setRight(new BinTree<>("7"));
        return rootBinTree;
    }

    public static void main(String[] args) {
        WidthPrintTree widthPrintTree = new WidthPrintTree();
        BinTree<String> binTree = widthPrintTree.createBinTree();
        widthPrintTree.printTree(binTree);
    }
}
