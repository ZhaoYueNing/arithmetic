package cn.zynword.arithmetic.structure.tree;

import java.io.Serializable;

/**
 * Created by zhaoyuening on 2019/1/3.
 */
public class BinTree<T> implements Serializable {
    private static final long serialVersionUID = -4544002075643595352L;

    private T data;
    private BinTree<T> parent;
    private BinTree<T> left;
    private BinTree<T> right;

    public BinTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public BinTree<T> setData(T data) {
        this.data = data;
        return this;
    }

    public BinTree<T> getLeft() {
        return left;
    }

    public BinTree<T> setLeft(BinTree<T> left) {
        this.left = left;
        this.left.setParent(this);
        return this;
    }

    public BinTree<T> getRight() {
        return right;
    }

    public BinTree<T> setRight(BinTree<T> right) {
        this.right = right;
        this.right.setParent(this);
        return this;
    }

    public BinTree<T> getParent() {
        return parent;
    }

    public BinTree<T> setParent(BinTree<T> parent) {
        this.parent = parent;
        return this;
    }
}
