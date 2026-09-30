import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack {

    private int[] data;
    private int size;

    public ArrayStack(){
        this(10);
    }
    public ArrayStack(int capacity) {
        if (capacity < 1){
            throw new IllegalArgumentException();
        }
        data = new int[capacity];
    }

    public void push(int value) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size] = value;
        size++;
    }
    public int pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        size -= 1;
        return data[size];
    }
    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return data[size-1];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

}

