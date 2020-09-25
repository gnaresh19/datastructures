class StackUsingArrays<T>{

private T[] stack;
private int N;

    public StackUsingArrays(int size){
        stack = (T[]) new Object[size];
        N = 0;
    }
    
    public boolean isEmpty(){
        return (N == 0);
    }
    
    public void push(T data) {
        if (N == stack.length) {
            System.out.println("Stack Full !!!");
            return;
        }
        
       stack[N++] = data;
    }
    
    public T pop() {
        if(N == 0) {
            return null;
        }
        
        return stack[--N];
    }
}

public class Client{
    public static void main(String[] args) {
        StackUsingArrays stack = new StackUsingArrays<String>(3);
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Four");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
