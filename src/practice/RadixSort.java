package practice;

import java.util.Arrays;

/**
 * 基数排序 —— 稳定但不在位
 *
 * @Author: Wang An
 * @Date: 4/24/2020 12:11 PM
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] array = Helper.initPositiveArray(100, 5);
        array = Helper.initArray(50, 10);
//        array = new int[]{-20, -50, 0, 39, 12, 9};
        System.out.println("original array: " + Arrays.toString(array));
        radixSort(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

    /**
     * 针对只含非负整数的int数组的基数排序
     *
     * @param array 待排序int数组，数组中数字均不小于0
     */
    public static void radixSortPositive(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int a : array) {
            max = max > a ? max : a;
        }
        int radix = 1;
        int[] counts = new int[10];
        int[][] buckets = new int[10][array.length];
        while (radix <= max) {
            for (int i = 0; i < array.length; i++) {
                int bucketNum = (array[i] / radix) % 10;
                buckets[bucketNum][counts[bucketNum]++] = array[i];
            }
            int index = 0;
            for (int i = 0; i < buckets.length; i++) {
                int count = counts[i];
                // 注意从0开始，假如从count-1开始会出错，体现了自底向上的思想
                for (int j = 0; j < count; j++) {
                    array[index++] = buckets[i][j];
                }
                counts[i] = 0;
            }
            System.out.println("array: " + Arrays.toString(array));
            radix *= 10;
        }
    }

    /**
     * 对int数组进行基数排序
     *
     * @param array 待排序int数组
     */
    public static void radixSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int a : array) {
            max = max > a ? max : a;
        }
        int[] counts = new int[20];
        //把桶容量扩大为20，负数从小到大在 0-9 号桶，正数从小到大在 10 - 19 号桶
        int[][] buckets = new int[20][array.length];
        int radix = 1;
        while (radix <= max) {
            //将数组中的每一个数字填充到相应的桶内
            for (int i = 0; i < array.length; i++) {
                int current = array[i];
                int num = (current / radix) % 10;
                num += 10;
                buckets[num][counts[num]++] = current;
            }
            System.out.println(Arrays.toString(counts));
            int index = 0;
            //记住从0开始回填数字，不能从counts[i] - 1开始，否则自底向上按照基数排序好的顺序会被破坏，基数排序就失效了。
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < counts[i]; j++) {
                    array[index++] = buckets[i][j];
                }
                counts[i] = 0;
            }
            System.out.println(Arrays.toString(array));
            radix *= 10;
        }
    }
}
