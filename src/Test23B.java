import entity.ListNode;

/**
 * @author zhangliang
 * @date 2021/6/30.
 */
public class Test23B {
    public static void main(String[] args) {
        ListNode node1 = ListNode.strToListNode("459");
        ListNode node2 = ListNode.strToListNode("168");
        ListNode node3 = ListNode.strToListNode("168");
        ListNode node4 = ListNode.strToListNode("168");
        ListNode[] lists = new ListNode[]{node1,node2,node3,node4};
        ListNode listNode = new Test23B().mergeKLists(lists);
        do{
            System.out.println(listNode.val);
            listNode = listNode.next;
        }while (listNode != null);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
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
