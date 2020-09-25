package practice;

public class LinkedList {
    private static class Node{
        private int value;
        private Node next;
        private Node(int v,Node n){
           value=v;
           next=n;
        }
    }
    private Node head;
    private int size=0;

    public void addHead(int value){
        head=new Node(value,head);
        size=size++;
    }
    
    public void addTail(int value){
       Node newNode=new Node(value, null);
       Node curr= head;
       if (head==null){
           head=newNode;
       }
        while (curr.next!=null) {
            curr=curr.next;
        }
        curr.next=newNode;
    }

    public void print(){
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.value+" ");
            temp=temp.next;
        }
    }
    public int removeHead() throws IllegalStateException {
        
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public boolean searchList(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public boolean deleteNode(int delValue) {
        Node temp = head;
        if (delValue == head.value) {
            head = head.next;
            size--;
            return true;
        }

        while (temp.next != null) {
            if (temp.next.value == delValue) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void deleteNodes(int delValue) {
        Node currNode = head;
        Node nextNode;

        while (currNode != null && currNode.value == delValue)/* first node */
        {
            head = currNode.next;
            currNode = head;
        }

        while (currNode != null) {
            nextNode = currNode.next;
            if (nextNode != null && nextNode.value == delValue) {
                currNode.next = nextNode.next;
            } else {
                currNode = nextNode;
            }
        }
    }

    public void sortedInsert(int value) {
        Node newNode = new Node(value, null);
        Node curr = head;

        if (curr == null || curr.value > value) {
            newNode.next = head;
            head = newNode;
            return;
        }
        while (curr.next != null && curr.next.value < value) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addHead(100);
        l1.addTail(200);
        l1.addTail(300);
        l1.addTail(400);
        l1.addTail(500);
        l1.print();
    }
}
