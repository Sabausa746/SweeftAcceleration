import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfHappyStringsTest {
    Tasks tasks = new Tasks();
    @Test
    void emptyString() {
        assertThrows(IllegalArgumentException.class, () -> tasks.numberOfHappyStrings(new ArrayList<>()));
    }

    @Test
    void shouldReturnZero() {
        assertEquals(tasks.numberOfHappyStrings(List.of("aa","bb","cc")), 0);
        assertEquals(tasks.numberOfHappyStrings(List.of("aab","bbc","acc")), 0);
    }

    @Test
    void shouldReturnOne(){
        assertEquals(tasks.numberOfHappyStrings(List.of("aa","ba","cc")), 0);
        assertEquals(tasks.numberOfHappyStrings(List.of("aab","bcb","acc")), 0);
    }
}