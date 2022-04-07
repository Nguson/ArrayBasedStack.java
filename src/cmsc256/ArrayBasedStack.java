package cmsc256;

import java.util.Arrays;

public class ArrayBasedStack<T> implements StackInterface<T>{

    private T[] data;
    private int topOfStack;
    private static final int INITIAL_CAPACITY = 5;

    public ArrayBasedStack() {
        data = (T[])new Object[INITIAL_CAPACITY];
        topOfStack = -1;
    }

    private T[] expandArray(){
        data = Arrays.copyOf(data, data.length * 2);
        return data;
    }

    private boolean isArrayFull(){
        return topOfStack >= data.length - 1;
    }

    public ArrayBasedStack(int capacity){

        if(capacity <= 0) {
            throw new IllegalArgumentException("Array initial size error.");
        }
       clear();
    }

    @Override
    public void push(Object newEntry) {
        if(isArrayFull() == true){
            expandArray();
        }
        topOfStack++;
        data[topOfStack] = (T)newEntry;
    }

    @Override
    public T pop() {
        if(topOfStack == -1){
            throw new EmptyStackException();
        }
        else {
            T top = data[topOfStack];
            topOfStack--;
            return top;
        }
    }

    @Override
    public T peek() {
        if(topOfStack == -1){
            throw new EmptyStackException();
        }
        else {
            T top = data[topOfStack];
            return top;
        }
    }

    @Override
    public boolean isEmpty() {
        if (topOfStack == -1){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[INITIAL_CAPACITY];
        data = tempStack;
        topOfStack = -1;
    }
}
