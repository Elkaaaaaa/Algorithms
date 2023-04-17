package L3;

public class List {
    Node head;
    Node tail;
    
    public void revert (){
        Node curNode = head;
        while (curNode != null){
            Node next = curNode.next;
            Node prev = curNode.prev;
            curNode.next = prev;
            curNode.prev = next;
            if (prev == null){
                tail = curNode;
            } 
            if (next == null){
                head = curNode;
            } 
            curNode = next;
        }
    }

    public class Node {
        int value;
        Node next;
        Node prev;
    }

}
