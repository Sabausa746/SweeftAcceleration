import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FindIntersectionTest {
    Tasks tasks = new Tasks();

    @Test
    void EmptyCase(){
        assertThrows(IllegalArgumentException.class, ()-> tasks.findIntersection(new int[] {12,3,4,5},new int[0]));
        assertThrows(IllegalArgumentException.class, ()-> tasks.findIntersection(new int[0],new int[] {12,3,4,5}));
    }

    @Test
    void SameArr(){
        int[] arr = new int[]{1,2};
        assertArrayEquals(arr,tasks.findIntersection(arr,arr));
    }

    @Test
    void NormalCase(){
        //მაგ. nums1 = [1,2,3,3,4,5], nums2 = [3,4,4,5,6,7], result = [3,4,5].
        assertArrayEquals(new int[]{3,4,5},tasks.findIntersection(new int[]{1,2,3,3,4,5},new int[]{3,4,4,5,6,7}));
    }
}
