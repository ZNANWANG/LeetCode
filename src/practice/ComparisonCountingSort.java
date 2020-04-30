package practice;

import util.Helper;

import java.util.Arrays;

/**
 * 比较计数排序 —— 稳定但不在位
 *
 * @Author: Wang An
 * @Date: 4/24/2020 11:01 AM
 */
public class ComparisonCountingSort {
    public static void main(String[] args) {
        int[] array = Helper.initArray(50, 10);
        System.out.println("original array: " + Arrays.toString(array));
        comparisonCountingSort(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

    /**
     * 将数组进行比较计数排序
     *
     * @param array 待排序数组
     */
    public static void comparisonCountingSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        //初始化计数数组
        int[] counts = new int[array.length];
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    counts[i]++;
                } else {
                    counts[j]++;
                }
            }
        }
        System.out.println(Arrays.toString(counts));
        //计数代表最终在排序数组中的索引，按照计数数字进行排序。
        int[] copy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < copy.length; i++) {
            array[counts[i]] = copy[i];
        }
    }
}
