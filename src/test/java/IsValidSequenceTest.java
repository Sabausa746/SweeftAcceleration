import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsValidSequenceTest {
    Tasks tasks = new Tasks();

    @Test
    void illegalArgumentExceptionCase() {
        assertThrows(IllegalArgumentException.class, () -> tasks.isValidSequence(new int[0], new int[]{1, 2, 3}));
    }

    @Test
    void emptySequence() {
        assertTrue(tasks.isValidSequence(new int[]{1, 2, 3, 4, 5}, new int[]{}));
    }

    @Test
    void falseCase() {
        assertFalse(tasks.isValidSequence(new int[]{1, 2, 3, 4, 5}, new int[]{3, 2, 1}));
    }

    @Test
    void trueCase() {
        assertTrue(tasks.isValidSequence(new int[]{5, 1, 22, 25, 6, -1, 8, 10}, new int[]{1, 6, -1, 10}));
    }
}
