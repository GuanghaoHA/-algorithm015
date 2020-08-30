package leetcode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //合并两个有序链表
        //仿照题解
        ListNode node = new ListNode();
        ListNode prev = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return node.next;

        //自己一开始也是使用类似题解这种方式，但自己对指针的理解不太好，没做出来。
//        if (l1 == null && l2 == null) {
//            return null;
//        }
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode node;
//        if (l1.val < l2.val) {
//            node = l1;
//            while (l1.next != null) {
//                if (l2 == null) {
//                    node.next = l1.next;
//                    break;
//                }
//                if (l1.next.val < l2.val) {
//                    node.next = l1.next;
//                    l1 = l1.next;
//                } else {
//                    node.next = l2;
//                    l2 = l2.next;
//                }
//            }
//        } else {
//            node = l2;
//            while (l2.next != null) {
//                if (l1 == null) {
//                    node.next = l2.next;
//                    break;
//                }
//                if (l2.next.val < l1.val) {
//                    node.next = l2.next;
//                    l2 = l2.next;
//                } else {
//                    node.next = l1;
//                    l1 = l1.next;
//                }
//            }
//        }
//        return node;

    }


    public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

}
