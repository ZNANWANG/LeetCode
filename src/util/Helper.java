package practice;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Wang An
 * @Date: 4/24/2020 11:23 AM
 */
public class Helper {
    /**
     * 生成一个单元数字在[-range,range]范围内且长度为length的数组。
     *
     * @param range  区间左右端点绝对值，需不小于0，区间范围为[-range,range]
     * @param length 数组长度，需不小于0
     * @return 一个单元数字在[-range,range]范围内且长度为length的数组
     */
    public static int[] initArray(int range, int length) {
        if (length < 0 || length < 0) {
            return null;
        }
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(2 * range) - range;
        }
        return array;
    }

    /**
     * 生成一个单元数字在[0,range]范围内且长度为length的数组。
     *
     * @param range  区间左右端点绝对值，需不小于0，区间范围为[0,range]
     * @param length 数组长度，需不小于0
     * @return 一个单元数字在[0, range]范围内且长度为length的数组
     */
    public static int[] initPositiveArray(int range, int length) {
        if (length < 0 || length < 0) {
            return null;
        }
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }

    /**
     * 显示二维int型整数数组
     *
     * @param array 二维int型整数数组
     */
    public static void display(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    /**
     * 交换int数组的两个数字
     *
     * @param array int数组
     * @param i     第一个交换数字的索引
     * @param j     第二个交换数字的索引
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 输出[x, y]或者[y, x]范围内的任意一个int型整数
     *
     * @param x 范围上限或者下限
     * @param y 范围下限或者上限
     * @return [x, y]或者[y, x]范围内的任意一个int型整数
     */
    public static int random(int x, int y) {
        int max = x > y ? x : y;
        int min = x < y ? x : y;
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
