import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class ReverseListTest {
    Tasks tasks = new Tasks();
    @Test
    void nullCase(){
        assertThrows(IllegalArgumentException.class, () -> tasks.reverseList(null));
    }

    @Test
    void oneElement(){
        ListNode node = new ListNode(1);
        assertEquals(node, tasks.reverseList(node));
    }

    @Test
    void normalCase(){
        ListNode node1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode node2 = new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(1))));
        assertEquals(node2,tasks.reverseList(node1));
    }
}
