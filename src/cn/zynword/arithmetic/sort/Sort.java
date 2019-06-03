package cn.zynword.arithmetic.sort;

import java.util.*;

/**
 * Created by zhaoyuening on 2019/1/21.
 */
public class Sort {

    public static void selectSort(int[] arr){
        for (int sorted = 0; sorted < arr.length; sorted++) {
            for (int index = sorted; index < arr.length; index++) {
                if (arr[index] < arr[sorted]) {
                    exchange(arr, index, sorted);
                }
            }
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        int count = 0;
        int lastExchangeIndex = arr.length - 1;
        for (int i = 0; i < arr.length - 1 ; i++) {
            boolean changeFlag = false;
            int tmp = lastExchangeIndex;
            for (int k = 0; k < lastExchangeIndex; k++) {
                if (arr[k] > arr[k + 1]) {
                    exchange(arr, k, k + 1);
                    tmp = k + 1;
                    changeFlag = true;
                }
                count++;
            }

            if (!changeFlag) {
                break;
            }
            lastExchangeIndex = tmp;
        }
        System.out.println(count);
    }


    // 快速排序
    public static int quickSort(int[] arr, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int count = 0;

        if (left < right) {
            int base = arr[left];
            while (left != right) {
                // 从右向左
                while (left < right && arr[right] >= base) {
                    right --;
                    count ++;
                }
                arr[left] = arr[right];

                // 从左向右
                while (left < right && arr[left] <= base) {
                    left ++;
                    count ++;
                }
                arr[right] = arr[left];
            }
            // left下标 right下标重合
            arr[left] = base;
            int midIndex = left;

            // 快排序左右
            count += quickSort(arr,leftIndex,midIndex - 1);
            count += quickSort(arr, midIndex + 1, rightIndex);
        }
        return count;
    }

    public static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }

        int mid = list.size() / 2;
        List<Integer> left = new ArrayList<>(list.subList(0, mid));
        List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

        return mergeSort(left,right);
    }

    private static List<Integer> mergeSort(List<Integer> left, List<Integer> right) {
        if (left.size() == 0) {
            return right;
        }
        if (right.size() == 0) {
            return left;
        }

        // 对左右列排序
        left = mergeSort(new ArrayList<>(left.subList(0, left.size() / 2)), new ArrayList<>(left.subList(left.size() / 2, left.size())));
        right = mergeSort(new ArrayList<>(right.subList(0, right.size() / 2)), new ArrayList<>(right.subList(right.size() / 2, right.size())));

        // 被合并的列表
        List<Integer> resultList = new ArrayList<>();
        // 被合并列表大小
        final int LIST_SIZE = left.size() + right.size();

        // 添加哨兵值
        left.add(Integer.MAX_VALUE);
        right.add(Integer.MAX_VALUE);

        int leftIndex = 0;
        int rightIndex = 0;

        // 对已经排序好的合并
        for (int i = 0; i < LIST_SIZE; i++) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                resultList.add(left.get(leftIndex));
                leftIndex++;
            } else {
                resultList.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        return resultList;
    }


    public static void main(String[] args) {
        // int[] arr = createArr(20,100);
        int[] arr = new int[]{23, 33, 96, 6, 29, 99, 72, 63, 40, 64, 53, 60, 61, 45, 98, 1, 84, 67, 51, 53};
        toString(arr);
//        int count = quickSort(arr, 0, arr.length - 1);
//        System.out.println(count);
        bubbleSort(arr);
        toString(arr);

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(3);
//        list.add(0);
//        list.add(4);
//        list.add(3);
//
//        System.out.println(mergeSort(list));
    }

    public static void toString(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    private static void exchange(int[] arr, int index, int index2) {
        int tmp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = tmp;
    }

    private static int[] createArr(int len, int max) {
        int[] arr = new int[len];
        Random random = new Random(new Date().getTime());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(max);
        }
        return arr;
    }
}
