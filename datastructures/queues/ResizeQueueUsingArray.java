class ResizeQueueUsingArray<T>{

private T[] queue;
private int N;
private int head = -1;
private int tail = -1;

    public ResizeQueueUsingArray(int size){
        queue = (T[]) new Object[size];
        N = 0;
    }
    
    public boolean isEmpty(){
        return (N == 0);
    }
    
    public void enqueue(T data) {
        if (N >= queue.length/2) {
            resize();
            System.out.println("Resizing>>>");
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
        
        if (N <= (queue.length)/2) {
            System.out.println("Reducing size>>>" + N + ">>"+ (queue.length)/2);
            reduceSize();
        }
        
        if (N == 0) {
            System.out.println("Queue is empty !!");
            return null;
        }
        
        N--;
        
        T data = (T) queue[head];
        queue[head] = null;
        
       if (head == queue.length-1) {
            head = 0;
       } else{
           head++;
       }
       
       return data;
    }
    
    private void resize() {
        T[] newQueue = (T[]) new Object[2*queue.length];
        for(int i = 0; i< queue.length;i++){
            newQueue[i] = queue[i];
        }
        
        queue = newQueue;
    }
    
    private void reduceSize() {
        T[] newQueue = (T[]) new Object[queue.length/2];
        for(int i = 0; i< queue.length;i++){
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }
    
    public int size() {
        return N;
    }
}

public class Client{
    public static void main(String[] args) {
        ResizeQueueUsingArray queue = new ResizeQueueUsingArray<String>(3);
        System.out.println("Add First");
        queue.enqueue("First");
        System.out.println("Add Second");
        queue.enqueue("Second");
        System.out.println("Add Third");
        queue.enqueue("Third");
        System.out.println("Add Fourth");
        queue.enqueue("Four");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
