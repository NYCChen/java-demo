package leetcode.a01_a10;

/*
给出两个 非空 的链表用来表示两个非负的整数。
其中，它们各自的位数是按照 逆序 的方式存储的，
并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A02AddTwoNumbers {
    public static void main(String[] args) {
        A02AddTwoNumbers A02 = new A02AddTwoNumbers();
        int[] a ={1};
        int[] b = {9,9};
        ListNode l1 = A02.loadLitNode(a);
        ListNode l2 = A02.loadLitNode(b);

        A02.printListNode(l1);
        A02.printListNode(l2);

        /*ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);*/;
        ListNode result = A02.addTwoNumbers(l1, l2);

        A02.printListNode(result);
    }
    public ListNode loadLitNode(int[] b){
        ListNode l2 = null;
        ListNode curr = null;
        for (int i=0; i<b.length; i++) {
            if (i == 0) {
                l2 = new ListNode(b[i]);
                curr = l2;
            } else {
                curr.next = new ListNode(b[i]);
                curr = curr.next;
            }
        }
        return l2;
    }

    public void printListNode(ListNode l){

        ListNode curr = l;
        while (curr != null){
            System.out.print(curr.val);
            curr = curr.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode m = l1, n = l2, temp = result;
        int carry = 0;

        /*while (m != null || n != null){
            int x=(m!=null) ? m.val : 0;
            int y=(n!=null) ? n.val : 0;
            int sum = x + y +  carry;
            carry = sum / 10;
            temp.next = new ListNode(sum %10);
            temp = temp.next;
            if (m != null) m = m.next;
            if (n != null) n = n.next;
        }*/
        while (m != null && n != null){
            int x = m.val;
            int y = n.val;
            System.out.println("" + x + "  "+ y);
            int sum = x + y +  carry;
            System.out.println("mn"+sum);
            carry = sum / 10;
            System.out.println("carry"+carry);
            temp.next = new ListNode(sum %10);
            temp = temp.next;
            m = m.next;
            n = n.next;
        }

        while (m != null){
            int x = m.val;
            int sum = x + carry;
            System.out.println("m"+sum);
            carry = sum/10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            m = m.next;
        }

        while (n != null){
            int x = n.val;
            int sum = x + carry;
            System.out.println("n"+sum);
            carry = sum/10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            n = n.next;
        }
        //System.out.println("3"+carry);
        if (carry > 0){
            temp.next = new ListNode(carry);
        }

        return result.next;
    }
}
class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int i){
        this.val = i;
    }

    public int getVal(){
        return this.val;
    }

}