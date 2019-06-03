package cn.zynword.arithmetic.matrix;

import java.util.ArrayList;

/**
 * Created by zhaoyuening on 2019/1/30.
 * 顺时针打印矩阵
 */
public class PrintClockwiseMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> resultList = new ArrayList<>();
        // 需要输出次数
        final int PRINT_NUM = (matrix[0].length + 1) / 2;
        for (int i = 0; i < PRINT_NUM; i++) {
            print(matrix, resultList, i);
        }

        return resultList;
    }

    private void print(int[][] matrix, ArrayList<Integer> resultList, Integer index) {
        final int ROW_LEN = matrix[0].length;
        final int COL_LEN = matrix.length;

        // 向右边输出
        for (int rIndex = index; rIndex < ROW_LEN - index && index < COL_LEN; rIndex++) {
            resultList.add(matrix[index][rIndex]);
        }
        // 向下输出
        for (int bIndex = index + 1; bIndex < COL_LEN - index; bIndex++) {
            resultList.add(matrix[bIndex][ROW_LEN - 1 - index]);
        }
        // 向左输出
        for (int lIndex = ROW_LEN - 2 - index; lIndex >= index; lIndex--) {
            resultList.add(matrix[COL_LEN - 1 - index][lIndex]);
        }
        // 向上输出
        for (int uIndex = ROW_LEN - 2 - index; uIndex > index && uIndex < COL_LEN -1 ; uIndex--) {
            resultList.add(matrix[uIndex][index]);
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,4,6,8,10,9,7,5,3}};
        PrintClockwiseMatrix printClockwiseMatrix = new PrintClockwiseMatrix();
        ArrayList<Integer> integers = printClockwiseMatrix.printMatrix(arr);
        System.out.println(integers);

    }


}
