package leetCode;

import util.Helper;
import util.ListNode;

/**
 * @Author: Wang An
 * @Date: 4/26/2020 12:55 AM
 */
public class Q2 {
    public static void main(String[] args){
        ListNode l1 = initL3();
        ListNode l2 = initL4();
        ListNode result = addTwoNumbers(l1, l2);
        Helper.displayLinkedList(result);
    }

    public static ListNode initL1(){
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        return head;
    }

    public static ListNode initL2(){
        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        return head;
    }

    public static ListNode initL3(){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(8);
        head.next = node1;
        return head;
    }

    public static ListNode initL4(){
        ListNode head = new ListNode(0);
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer sb = new StringBuffer();
        while(l1 != null){
            sb.insert(0, l1.val);
            l1 = l1.next;
        }
        int num1 = Integer.parseInt(sb.toString());
        sb = new StringBuffer();
        while(l2 != null){
            sb.insert(0, l2.val);
            l2 = l2.next;
        }
        int num2 = Integer.parseInt(sb.toString());
        int ret = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + ret);
        ListNode head = null, tail = null;
        do{
            int digit = ret % 10;
            ListNode node = new ListNode(digit);
            if(head == null){
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            ret /= 10;
            System.out.println("digti: " + digit);
        }while (ret != 0);
        return head;
    }
}
