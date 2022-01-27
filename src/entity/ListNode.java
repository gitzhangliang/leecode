package entity;

/**
 * @author zhangliang
 * @date 2021/6/30.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode strToListNode(String s){
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        for (int i = 0; i < s.length(); i++) {
            int n = Integer.parseInt(s.charAt(i) + "");
            if(i == 0){
                listNode.val = n ;
            }else{
                listNode.next = new ListNode(n);
                listNode= listNode.next;
            }
        }
        return head;
    }
}
