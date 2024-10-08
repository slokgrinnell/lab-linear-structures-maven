import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.linear.BuiltinPriorityQueue;

public class BuiltinPriorityQueueTests {
  @Test
  public void test1() throws Exception{
    Comparator<Integer> compare = new IntComparator();
    BuiltinPriorityQueue intQueue = new BuiltinPriorityQueue<>(5, compare);
    intQueue.put(1);
    intQueue.put(2); 
    intQueue.put(3);

    assertEquals(1, intQueue.peek());
  }

  @Test
  public void test2() throws Exception{
    Comparator<String> compare = new StringComparator();
    BuiltinPriorityQueue intQueue = new BuiltinPriorityQueue<>(5, compare);
    intQueue.put("YASH");
    intQueue.put("SLOK"); 
    intQueue.put("CSC207");

    assertEquals("CSC207", intQueue.peek());
  }
}

class StringComparator implements Comparator<String> {
  public int compare(String str1, String str2) {
    // Efficiency hack: If two strings occupy the same memory
    // they are equal.
    if (str1 == str2) { return 0; }
    // Safety check: If either string is null, compareTo may fail,
    // so we make sure neither is null.  We treat null as "smaller"
    // than any other string.
    if (str1 == null) { return -1; }
    if (str2 == null) { return 1; }
    // Finally, we can use the built-in `compareTo` method.
    return str1.compareTo(str2);
  } // compare(String, STring)
} // StringComparator

class IntComparator implements Comparator<Integer> {
  public int compare(Integer i, Integer j) {
    // While this method sometimes gets implemented as i-j, that
    // implementation presents overflow risks, so we choose a
    // somewhat more verbose approach.
    if (i < j) { return -1; }
    else if (j < i) { return 1; }
    else return 0;
  } // compare(Integer, Integer)
} // IntegerComparator