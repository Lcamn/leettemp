package editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1666 👎 0

public class MergeTwoSortedLists {
    public static void main(String[] args) {

        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(0);    //创建首节点，节点的val是0.
        ListNode nextNode;                      //声明一个变量用来在移动过程中指向当前节点
        nextNode = l1;                      //指向首节点

        //创建链表
        for (int i = 1; i < 10; i++) {
            ListNode node = new ListNode(i);  //生成新的节点
            nextNode.next = node;               //把新节点连起来
            nextNode = nextNode.next;           //当前节点往后移动
        }       //当for循环完成之后 nextNode指向最后一个节点，

        nextNode = l1;


    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //合并两个 升序链表
            ListNode preHead = new ListNode(-1);
            ListNode prev = preHead;
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
            return preHead.next;





/*
        ListNode prehead = new ListNode(-1); // 创建首节点
        ListNode prev = prehead;  // 指向首节点

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
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        //
        return prehead.next;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}