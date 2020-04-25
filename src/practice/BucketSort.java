package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 桶排序 —— 稳定但不在位
 *
 * @Author: Wang An
 * @Date: 4/24/2020 1:26 PM
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] array = Helper.initArray(50, 10);
        System.out.println("original array: " + Arrays.toString(array));
        bucketSort(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

    /**
     * 对int数组进行桶排序
     *
     * @param array 待排序int数组
     */
    public static void bucketSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int max = 0;
        int min = 0;
        for (int a : array) {
            max = max > a ? max : a;
            min = min < a ? min : a;
        }
        int bucketNum = max - min + 1;
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new LinkedList<>());
        }
        for (int i = 0; i < array.length; i++) {
            int num = getBucketNum(array, i, min);
            buckets.get(num).add(array[i]);
            InsertionSort.insertionSort(buckets.get(num));
        }
        int index = 0;
        for (int i = 0; i < buckets.size(); i++) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                array[index++] = buckets.get(i).get(j);
            }
        }
    }

    /**
     * 获得当前数字准备放入的桶的索引
     *
     * @param array 待排序int数组
     * @param index 待入桶数字的索引
     * @param min   待排序数组的最小值
     * @return 当前数字将被进入的桶的索引
     */
    public static int getBucketNum(int[] array, int index, int min) {
        return (array[index] - min) / array.length;
    }
}
