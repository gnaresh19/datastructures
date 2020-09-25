class QueueUsingArrays<T>{

private T[] queue;
private int N;
private int head = -1;
private int tail = -1;

    public QueueUsingArrays(int size){
        queue = (T[]) new Object[size];
        N = 0;
    }
    
    public boolean isEmpty(){
        return (N == 0);
    }
    
    public void enqueue(T data) {
        if (N == queue.length) {
            System.out.println("Queue is full !!");
            return;
        }
        
        N++; //length of queue
        
        if (head == -1 && tail == -1) {
            head = tail = 0;
        }
        else if (tail == queue.length-1) {
            tail = 0;
        } 
        else {
            tail++;
        }
        queue[tail] = data;
    }
    
    public T dequeue() {
        if (N == 0) {
            System.out.println("Queue is empty !!");
            return null;
        }
        
        N--;
        
        T data = (T) queue[head];
        
       if (head == queue.length-1) {
            head = 0;
       } else{
           head++;
       }
       
       return data;
    }
    
    public int size() {
        return N;
    }
}

public class Client{
    public static void main(String[] args) {
        QueueUsingArrays queue = new QueueUsingArrays<String>(3);
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.enqueue("Four");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
