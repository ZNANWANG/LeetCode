package practice;

import util.Helper;

import java.util.Arrays;

/**
 * 分布计数排序 —— 稳定但不在位
 *
 * @Author: Wang An
 * @Date: 4/24/2020 11:22 AM
 */
public class DistributionCountingSort {
    public static void main(String[] args) {
        int[] array = Helper.initArray(50, 10);
        System.out.println("original array: " + Arrays.toString(array));
        distributionCountingSort(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

    /**
     * 对int数组进行分布计数排序
     *
     * @param array 待排序int数组
     */
    public static void distributionCountingSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a : array) {
            max = max > a ? max : a;
            min = min < a ? min : a;
        }
        int[] counts = new int[max - min + 1];
        for (int a : array) {
            counts[a - min]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        System.out.println(Arrays.toString(counts));
        int[] copy = Arrays.copyOf(array, array.length);
        for (int i = copy.length - 1; i >= 0; i--) {
            int index = --counts[copy[i] - min];
            array[index] = copy[i];
        }
    }
}
