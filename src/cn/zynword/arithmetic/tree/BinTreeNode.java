package cn.zynword.arithmetic.tree;

/**
 * Created by zhaoyuening on 2019/1/22.
 */
public class BinTreeNode<T> {
    private T data;
    private BinTreeNode<T> parent;
    private BinTreeNode<T> left;
    private BinTreeNode<T> right;

    public BinTreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public BinTreeNode<T> setData(T data) {
        this.data = data;
        return this;
    }

    public BinTreeNode<T> getLeft() {
        return left;
    }

    public BinTreeNode<T> setLeft(BinTreeNode<T> left) {
        this.left = left;
        left.setParent(this);
        return this;
    }

    public BinTreeNode<T> getRight() {
        return right;
    }

    public BinTreeNode<T> setRight(BinTreeNode<T> right) {
        this.right = right;
        right.setParent(this);
        return this;
    }

    public BinTreeNode<T> createLeftNode(T leftData) {
        this.setLeft(new BinTreeNode<>(leftData));
        return this;
    }

    public BinTreeNode<T> createRightNode(T rightData) {
        this.setRight(new BinTreeNode<>(rightData));
        return this;
    }

    public BinTreeNode<T> getParent() {
        return parent;
    }

    public BinTreeNode<T> setParent(BinTreeNode<T> parent) {
        this.parent = parent;
        return this;
    }

    public static BinTreeNode<Integer> getDemoTree1() {
        BinTreeNode<Integer> head = new BinTreeNode<>(3);
        head.setLeft(new BinTreeNode<>(5).setRight(new BinTreeNode<>(6)));
        head.setRight(new BinTreeNode<>(1).setLeft(new BinTreeNode<>(2).setLeft(new BinTreeNode<>(4))).setRight(new BinTreeNode<>(0)));
        return head;
    }
}
