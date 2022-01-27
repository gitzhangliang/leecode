import entity.ListNode;

/**
 * @author zhangliang
 * @date 2021/6/30.
 */
public class Test23A {
    public static void main(String[] args) {
        ListNode node1 = ListNode.strToListNode("459");
        ListNode node2 = ListNode.strToListNode("168");
        ListNode[] lists = new ListNode[]{node1,node2};
        ListNode listNode = new Test23A().mergeKLists(lists);
        do{
            System.out.println(listNode.val);
            listNode = listNode.next;
        }while (listNode != null);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode aPtr, ListNode bPtr) {
        if (aPtr== null || bPtr == null) {
            return aPtr != null ? aPtr : bPtr;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
