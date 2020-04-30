package practice;

import util.Helper;

import java.util.Arrays;

/**
 * 堆排序 —— 不稳定但在位
 *
 * @Author: Wang An
 * @Date: 4/25/2020 8:07 AM
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = Helper.initArray(50, 10);
        System.out.println("original array: " + Arrays.toString(array));
        heapSort(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

    /**
     * 对int数组进行堆排序
     *
     * @param array 待排序int数组
     */
    public static void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            Helper.swap(array, i, 0);
            adjustHeap(array, 0, i);
        }
    }

    /**
     * 调整int数组使其成为最大堆
     *
     * @param array  待调整int数组
     * @param parent 从parent结点处开始调整
     * @param length 调整的数组范围为[0, length - 1]
     */
    public static void adjustHeap(int[] array, int parent, int length) {
        int leftChild = 2 * parent + 1;
        while (leftChild < length) {
            int rightChild = leftChild + 1;
            if (rightChild < length && array[rightChild] > array[leftChild]) {
                leftChild = rightChild;
            }

            if (array[parent] > array[leftChild]) {
                return;
            }

            Helper.swap(array, parent, leftChild);
            parent = leftChild;
            leftChild = 2 * parent + 1;
        }
    }
}
