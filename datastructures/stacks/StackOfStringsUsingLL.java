class StackOfStringsUsingLL{

private Node first;

private class Node {
    String data;
    Node next;
}

public StackOfStringsUsingLL(){
    this.first = null;
}

public boolean isEmpty(){
    return this.first == null;
}

public void push(String data) {
    Node newNode = new Node();
    newNode.data = data;
    
    if (first == null) {
        first = newNode;
    } else {
        newNode.next = first;
        first = newNode;
    }
}

public String pop() {
    if (first == null) {
        return null;
    } 
    
    String data = first.data;
    first = first.next;
    return data;
}
}

public class Client{
    public static void main(String[] args) {
        StackOfStringsUsingLL ll = new StackOfStringsUsingLL();
        ll.push("First");
        ll.push("Second");
        ll.push("Third");
        System.out.println(ll.pop());
        ll.push("Four");
        System.out.println(ll.pop());
        System.out.println(ll.pop());
        System.out.println(ll.pop());
        System.out.println(ll.pop());
    }
}
