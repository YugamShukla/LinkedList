public class MergingTwoSortedLists {

private class ListNode {
int val;
ListNode next;
ListNode(int x) { val = x; }
}

ListNode head1;
ListNode head2;

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
ListNode list1 = l1;
ListNode list2 = l2;

ListNode head = new ListNode(0);
ListNode merged = head;

if(l1 == null && l2 != null){
return l2;
}

if(l1 != null && l2 == null){
return l1;
}

while(list1 != null && list2 != null){
if(list1.val < list2.val){
merged.next = list1;
list1 = list1.next;
}
else{
merged.next = list2;
list2 = list2.next;
}
merged = merged.next;
}
//If list1 alone is present
while(list1 != null){
merged.next = list1;
list1 = list1.next;
merged = merged.next;
}

//If list2 alone is present
while(list2 != null){
merged.next = list2;
list2 = list2.next;
merged = merged.next;
}
return head.next;
}

public void display(ListNode head){
ListNode temp = head;
while(temp != null){
System.out.print(temp.val+" ");
temp = temp.next;
}
System.out.println();
}

public static void main(String[] args){
MergingTwoSortedLists obj = new MergingTwoSortedLists();
obj.head1 = obj.new ListNode(1);
obj.head1.next = obj.new ListNode(3);
obj.head2 = obj.new ListNode(2);
obj.head2.next = obj.new ListNode(4);
obj.display(obj.head1);
obj.display(obj.head2);
obj.display(obj.mergeTwoLists(obj.head1,obj.head2));

}
}
