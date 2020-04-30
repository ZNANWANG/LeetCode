package practice;

import util.Helper;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: Wang An
 * @Date: 4/24/2020 1:37 PM
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = Helper.initArray(50, 10);
        System.out.println("original array: " + Arrays.toString(array));
        insertionSort1(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

    /**
     * 对int数组进行插入排序
     *
     * @param array 待排序int数组
     */
    public static void insertionSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && array[preIndex] > temp) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = temp;
        }
    }

    /**
     * 对int数组进行插入排序
     *
     * @param array 待排序int数组
     */
    public static void insertionSort1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int preIndex = i - 1;
            while (preIndex >= 0 && array[preIndex + 1] < array[preIndex]) {
                Helper.swap(array, preIndex, preIndex + 1);
                preIndex--;
            }
        }
    }

    /**
     * 对Integer列表进行插入排序
     *
     * @param list 待排序Integer列表
     */
    public static void insertionSort(LinkedList<Integer> list) {
        if (list.size() < 2) {
            return;
        }
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i);
            int preIndex = i - 1;
            while (preIndex >= 0 && list.get(preIndex) > temp) {
                list.set(preIndex + 1, list.get(preIndex));
                preIndex--;
            }
            list.set(preIndex + 1, temp);
        }
    }
}
