package practice;

import util.Helper;

import java.util.Arrays;

/**
 * 选择排序 —— 不稳定但在位
 *
 * @Author: Wang An
 * @Date: 4/25/2020 8:50 AM
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = Helper.initArray(50, 10);
        System.out.println("original array: " + Arrays.toString(array));
        selectionSort(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

    /**
     * 对int数组进行选择排序
     *
     * @param array 待排序int数组
     */
    public static void selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int minIndex = -1;
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    minIndex = j;
                    min = array[j];
                }
            }
            Helper.swap(array, i, minIndex);
        }
    }
}
