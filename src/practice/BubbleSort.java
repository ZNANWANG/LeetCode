package practice;

import util.Helper;

import java.util.Arrays;

/**
 * 冒泡排序 —— 稳定且在位
 *
 * @Author: Wang An
 * @Date: 4/25/2020 8:56 AM
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = Helper.initArray(50, 10);
        System.out.println("original array: " + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

    /**
     * 对int数组进行冒泡排序
     *
     * @param array 待排序int数组
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    Helper.swap(array, j, j + 1);
                }
                System.out.println(Arrays.toString(array));
            }
        }
    }
}
