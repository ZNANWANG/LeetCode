package interview;

import java.util.Scanner;

/**
 * 疯狂游戏 —— 计算最大密码串的长度
 * AC
 *
 * 题目描述：
 * 在一串由数字组成的密码中，找出由数字2开头和数字5结尾的最大密码串的长度。
 *
 * 输入示例1：
 * 2
 *
 * 输出示例1：
 * 0
 *
 * 输入示例2：
 * 25
 *
 * 输出示例2：
 * 2
 *
 * @Author: Wang An
 * @Date: 4/29/2020 7:25 PM
 */
public class CrazyGame2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            int two = str.indexOf('2');
            int five = str.lastIndexOf('5');
            int ret = 0;
            if(two == -1 || five == -1){
                ret = 0;
            } else {
                ret = five - two + 1;
            }
            System.out.print(ret);
        }
        sc.close();
    }
}
