import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateExpressionTest {
    Tasks tasks = new Tasks();
    @Test
    void emptyString() {
        assertThrows(IllegalArgumentException.class, () -> tasks.evaluateExpression(""));
    }

    @Test
    void zero() {
        assertEquals(tasks.evaluateExpression("0"), 0);
    }

    @Test
    void normalCases(){
        assertEquals(tasks.evaluateExpression("-1-1"), -2);
        assertEquals(tasks.evaluateExpression("-1+0+1"), 0);
        assertEquals(tasks.evaluateExpression("5+20-8+5"), 22);
    }
}