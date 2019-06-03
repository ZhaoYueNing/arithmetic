package cn.zynword.arithmetic.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by zhaoyuening on 2019/1/22.
 */
public class P191 {

    private static Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
    private static Integer MAX_VALUE = 0;

    public static int getMax(int[] arr) {
        int max = 0;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void init(int[] arr) {
        MAX_VALUE = getMax(arr);
        for (int num : arr) {
            resultMap.put(num, 1);
        }
    }

    public static Integer getResult(int n) {
        if (resultMap.containsKey(n)) {
            return resultMap.get(n);
        }
        if (n <= MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return null;
    }

    public static int fun(int[] arr,int n) {
        Integer result = getResult(n);
        if (Objects.nonNull(result)) {
            return result;
        }

        result = Integer.MAX_VALUE;
        for (int num : arr) {
            int tmpResult = fun(arr, n - num);
            if (tmpResult == Integer.MAX_VALUE) {
                continue;
            }
            result = Math.min(tmpResult + 1, result);
        }

        resultMap.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3};
        init(arr);
        System.out.println(fun(arr, 20));
    }
}
