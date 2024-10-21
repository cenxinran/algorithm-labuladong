    package b_00_hexinkuangjia.b_002_shuangzhizhen_shuzu;

    /**
     * @className: Solution002DeleteDuplicates
     * @author: Docer
     * @date: 2024/10/18 14:01
     * @Version: 1.0
     * @description: 83. 删除排序链表中的重复元素
     */
    public class Solution002DeleteDuplicates {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null) {
                if (fast.val != slow.val) {
                    slow.next = fast;
                    slow = slow.next;
                }
                fast = fast.next;
            }
            slow.next = null;
            return head;
        }

        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }
