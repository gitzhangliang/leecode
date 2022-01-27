import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**合并K个升序链表
 * @author zhangliang
 * @date 2021/6/30.
 */
public class Test23 {
    public static void main(String[] args) {
        ListNode node1 = ListNode.strToListNode("459");
        ListNode node2 = ListNode.strToListNode("168");
        ListNode[] lists = new ListNode[]{node1,node2};
        ListNode listNode = new Test23().mergeTwoLists(lists);
        do{
            System.out.println(listNode.val);
            listNode = listNode.next;
        }while (listNode != null);
    }

    public ListNode mergeTwoLists(ListNode[] lists) {
        List<ListNode> listNodes = new ArrayList<>();
        for (ListNode list : lists) {
            listNodes.add(list);
        }
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (!listNodes.isEmpty()){
            ListNode min = min(listNodes);
            if (min != null) {
                prev.next = min;
                listNodes.remove(min);
                if (min.next != null) {
                    listNodes.add(min.next);
                }
                prev = prev.next;
            }
        }
        return prehead.next;
    }
    private ListNode min(List<ListNode> listNodes){
        int min = Integer.MAX_VALUE;
        ListNode node= null;
        for (ListNode list : listNodes) {
            if(list.val<min){
                node = list;
                min = list.val;
            }
        }
        return node;
    }
}
