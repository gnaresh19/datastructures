class QueueUsingLL<T>{

private Node<T> head;
private Node<T> tail;

private class Node<T> {
    T data;
    Node next;
}

public QueueUsingLL(){
    this.head = null;
    this.tail = null;
}

public boolean isEmpty(){
    return (this.head == null && this.tail == null);
}

public void enqueue(T data) {
    Node newNode = new Node();
    newNode.data = data;
    
    if (tail == null) {
        tail = newNode;
        head = newNode;
    } else {
        tail.next = newNode;
        tail = newNode;
    }
}

public T dequeue() {
    if (head == null) {
        return null;
    } else if (head == tail) {
        T data = head.data;
        head = null;
        tail = null;
        return data;
    }
    
    T data = head.data;
    head = head.next;
    return data;
}
}

public class Client{
    public static void main(String[] args) {
        QueueUsingLL ll = new QueueUsingLL<String>();
        ll.enqueue("First");
        ll.enqueue("Second");
        ll.enqueue("Third");
        System.out.println(ll.dequeue());
        ll.enqueue("Four");
        System.out.println(ll.dequeue());
        System.out.println(ll.dequeue());
        System.out.println(ll.dequeue());
        System.out.println(ll.dequeue());
    }
}
