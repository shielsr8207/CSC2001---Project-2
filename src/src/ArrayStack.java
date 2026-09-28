import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack {

    private int[] data;
    private int size;
    public ArrayStack(int capacity) {
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
}

