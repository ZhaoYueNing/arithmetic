package cn.zynword.arithmetic.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by zhaoyuening on 2019/1/22.
 */
public class P187 {

    private static Map<String, Integer> resultMap = new HashMap<>();

    public static Integer getResult(int row, int col) {
        return resultMap.get(row + "_" + col);
    }

    public static void setResult(int row, int col, int result) {
        resultMap.put(row + "_" + col, result);
    }

    public static void init(int[][] arr) {
        setResult(arr.length - 1, arr[0].length - 1, arr[arr.length - 1][arr[0].length - 1]);
    }

    public static int fun(int[][] arr, int row, int col) {
        if (Objects.nonNull(getResult(row, col))) {
            return getResult(row, col);
        }
        if (row >= arr.length || col >= arr[0].length) {
            return Integer.MAX_VALUE;
        }

        int result = 0;
        int downResult = Integer.MAX_VALUE;
        int rightResult = Integer.MAX_VALUE;

        downResult = fun(arr, row + 1, col);
        rightResult = fun(arr, row, col + 1);

        result = Math.min(downResult, rightResult) + arr[row][col];
        setResult(row, col, result);
        return result;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0}
        };
        init(arr);

        System.out.println(fun(arr, 0, 0));
    }

}
