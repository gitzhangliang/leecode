import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**两数相加
 * @author zhangliang
 * @date 2021/6/25.
 */
public class Test2 {

    public static void main(String[] args) {
        ListNode node1 = ListNode.strToListNode("243");
        ListNode node2 = ListNode.strToListNode("564");
        ListNode listNode = new Test2().twoNumAdd(node1, node2);
        do{
            System.out.println(listNode.val);
            listNode = listNode.next;
        }while (listNode != null);
        System.out.println("--------------");

        ListNode listNode1 = new Test2().t(node1, node2);
        do{
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }while (listNode1 != null);
    }

    public ListNode twoNumAdd(ListNode node1,ListNode node2){
        List<String> one = trs(node1);
        List<String> two = trs(node2);
        int oneInt = Integer.parseInt(new StringBuilder(String.join("", one)).reverse().toString());
        int twoInt = Integer.parseInt(new StringBuilder(String.join("", two)).reverse().toString());
        int sum = oneInt + twoInt;
        String s = String.valueOf(sum);
        s = new StringBuilder(s).reverse().toString();
        return ListNode.strToListNode(s);
    }

    public List<String> trs(ListNode node){
        List<String> one = new ArrayList<>();
        do{
            one.add(node.val+"");
            node = node.next;
        }while (node != null);
        return one;
    }

    public ListNode t(ListNode node1,ListNode node2){
        List<String> list = new ArrayList<>();
        int c = 0;
        do{
            int i1 = node1 == null ? 0 : node1.val;
            int i2 = node2 == null ? 0 : node2.val;
            int i = i1+i2+c;
            String s = String.valueOf(i);
            if(s.length()>1){
                c=Integer.parseInt(s.charAt(0)+"");
                list.add(String.valueOf(Integer.parseInt(s.charAt(1)+"")));
            }else{
                c = 0;
                list.add(String.valueOf(Integer.parseInt(s.charAt(0)+"")));
            }
            node1 = node1 == null ?null:node1.next;
            node2 = node2 == null ?null:node2.next;
        }while (node1 != null || node2 != null);
        if (c > 0) {
            list.add(String.valueOf(c));
        }
        String join = String.join("", list);
        return ListNode.strToListNode(join);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
