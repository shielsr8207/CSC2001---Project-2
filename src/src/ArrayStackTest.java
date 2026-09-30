import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {
   public ArrayStack testArray =  new ArrayStack();

   @Test
   public void push() {
       testArray.push(1);
       assertEquals(testArray.peek(), 1);
   }

}
