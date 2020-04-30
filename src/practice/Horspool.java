package practice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * horspool算法 —— 字符串匹配中的输入增强技术
 * 输入增强思想：对模式进行预处理以得到它的一些信息，把这些信息存储在表中，然后在给定文本中实际查找模式时使用这些信息。
 *
 * @Author: Wang An
 * @Date: 4/24/2020 10:58 AM
 */
public class Horspool {
    public static void main(String[] args) {
        String text = "i am king of the world!, i am so exciting!";
        text = "";
        String pattern = "ing";
        System.out.println(horspool(text, pattern));
    }

    /**
     * hospool算法共包括对四种情况地分析和处理，见图horpool.png
     *
     * @param text    文本字符串
     * @param pattern 模式字符串
     * @return 匹配的子字符串首字符索引的集合
     */
    public static ArrayList<Integer> horspool(String text, String pattern) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] table = shiftTable(pattern.toCharArray());
        int i = pattern.length() - 1;
        while (i < text.length()) {
            char last = text.charAt(i);
            int k = 0;
            // 计算匹配字符总数
            while (k < pattern.length() && text.charAt(i - k) == pattern.charAt(pattern.length() - 1 - k)) {
                k++;
            }
            // 如果匹配完成，返回匹配子字符串的首字符索引
            if (k == pattern.length()) {
                result.add(i - pattern.length() + 1);
            }
            // 移动文本最后字符所对应的距离
            i += table[last];
            //System.out.println(result);
        }
        return result;
    }

    /**
     * 构造模式字符移动距离表
     *
     * @param pattern 模式字符数组
     * @return 字符移动距离表
     */
    public static int[] shiftTable(char[] pattern) {
        int[] table = new int[128];
        for (int i = 0; i < table.length; i++) {
            table[i] = pattern.length;
        }
        int length = pattern.length;
        // 记住模式最后一位字符不进行移动距离计算
        for (int i = 0; i < pattern.length - 1; i++) {
            table[pattern[i]] = length - i - 1;
        }
        System.out.println(Arrays.toString(table));
        return table;
    }
}
