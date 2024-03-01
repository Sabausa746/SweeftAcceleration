import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LenOfLongSubarrTest {
    Tasks tasks = new Tasks();

    @Test
    void empty(){
        assertThrows(IllegalArgumentException.class,()-> tasks.lenOfLongSubarr(new int[0],10));
    }

    @Test
    void oneElement(){
        assertEquals(1,tasks.lenOfLongSubarr(new int[]{1},1));
    }

    @Test
    void normalCase(){
        assertEquals(4,tasks.lenOfLongSubarr(new int[]{6,2,2,3,4,1},8));
    }

}
