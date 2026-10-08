import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<T> {

    private T[] data;
    private int size;

    // Purpose: Creates an empty stack with a default starting capacity of 10.
    // Example: ArrayStack<Integer> s = new ArrayStack();
    // s.size() = 0, s.isEmpty() = true
    public ArrayStack() {
        this(10);
    }

    // Purpose: Creates an empty stack with the given starting capacity.
    // Throws IllegalArgumentException if capacity is less than 1.
    // Example: ArrayStack s = new ArrayStack(5);
    // s.size() = 0
    // new ArrayStack(0) = throws IllegalArgumentException
    public ArrayStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        data = (T[]) new Object[capacity];
    }

    // Purpose: Places value on the top of the stack. If the array is full,
    // doubles its capacity first. Amortized O(1); a single resize is O(n).
    // Example: s is empty
    // s.push(4); s.push(7);
    // s.peek() = 7, s.size() = 2
    public void push(T value) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size] = value;
        size++;
    }

    // Purpose: Removes and returns the value on the top of the stack.
    // Throws NoSuchElementException if the stack is empty. O(1).
    // Example: s holds 4, 7 (7 on top)
    // s.pop() = 7, then s.peek() = 4, s.size() = 1
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        size -= 1;
        return data[size];
    }

    // Purpose: Returns the value on the top of the stack without removing it.
    // Throws NoSuchElementException if the stack is empty. O(1).
    // Example: s holds 4, 7 (7 on top)
    // s.peek() = 7, s.size() = 2 (unchanged)
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return data[size - 1];
    }

    // Purpose: Returns true if the stack has no items, false otherwise. O(1).
    // Example: new ArrayStack().isEmpty() = true
    // after s.push(3): s.isEmpty() = false
    public boolean isEmpty() {

        return size == 0;
    }

    // Purpose: Returns the number of items currently in the stack. O(1).
    // Example: s.push(1); s.push(2); s.push(3);
    // s.size() = 3
    public int size() {
        return size;

    }
}