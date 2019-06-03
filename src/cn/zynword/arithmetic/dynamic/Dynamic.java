package cn.zynword.arithmetic.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyuening on 2019/1/22.
 */
public class Dynamic {

    private static Map<Integer, Integer> p181ResultMap = new HashMap<>();

    private static int counter = 0;
    public static int p181(int n) {
        if (p181ResultMap.containsKey(n)) {
            return p181ResultMap.get(n);
        }

        if (n == 0) {
            p181ResultMap.put(0, 0);
            return 0;
        }
        if (n == 1) {
            p181ResultMap.put(1, 1);
            return 1;
        }

        int result = p181(n - 1) + p181(n - 2);
        p181ResultMap.put(n, result);
        counter ++;
        return result;
    }

    public static void p181_2_init() {
        p181ResultMap.put(1, 1);
        p181ResultMap.put(2, 2);
        p181ResultMap.put(3, 3);
        p181ResultMap.put(4, 4);
    }

    public static int p181_2(int n) {
        if (p181ResultMap.containsKey(n)) {
            return p181ResultMap.get(n);
        }

        int result = p181_2(n - 3) + p181_2(n - 1);
        p181ResultMap.put(n, result);
        return result;
    }


    public static void main(String[] args) {
        //System.out.println(p181(20));
        //System.out.println(counter);

        p181_2_init();
        System.out.println(p181_2(6));
    }
}
