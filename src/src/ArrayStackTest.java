import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {
    // A fresh, empty stack is created for each test.
    public ArrayStack testArray = new ArrayStack();

    // Purpose: Checks that each push places the new value on top of the stack.
    @Test
    public void push() {
        testArray.push(1);
        assertEquals(1, testArray.peek());
        testArray.push(2);
        assertEquals(2, testArray.peek());
        testArray.push(3);
        assertEquals(3, testArray.peek());
    }

    // Purpose: Checks that pop removes and returns values in last-in, first-out
    //  order, and throws NoSuchElementException once the stack is empty.
    @Test
    public void pop() {
        testArray.push(1);
        testArray.push(2);
        testArray.push(3);
        testArray.pop();
        assertEquals(2, testArray.peek());
        assertEquals(2, testArray.pop());
        assertEquals(1, testArray.pop());
        assertThrows(NoSuchElementException.class, () -> testArray.pop());
    }

    // Purpose: Checks that peek returns the top value without removing it,
    // and throws NoSuchElementException on an empty stack.
    @Test
    public void peek() {
        testArray.push(1);
        testArray.push(2);
        assertEquals(2, testArray.peek());
        testArray.pop();
        assertEquals(1, testArray.peek());
        testArray.pop();
        assertThrows(NoSuchElementException.class, () -> testArray.peek());
    }

    // Purpose: Checks that isEmpty is false while the stack holds items
    // and becomes true after the last item is popped.
    @Test
    public void isEmpty() {
        testArray.push(1);
        testArray.push(2);
        assertFalse(testArray.isEmpty());
        testArray.pop();
        assertFalse(testArray.isEmpty());
        testArray.pop();
        assertTrue(testArray.isEmpty());
    }

    // Purpose: Checks that size tracks pushes and pops correctly, including
    // after pushing past the default capacity of 10 (forcing a resize).
    @Test
    public void size() {
        testArray.push(1);
        testArray.push(2);
        assertEquals(2, testArray.size());
        testArray.pop();
        testArray.pop();
        assertEquals(0, testArray.size());
        for (int i = 12; i >= 0; i--) {
            testArray.push(i);
        }
        assertEquals(13, testArray.size());
    }
}