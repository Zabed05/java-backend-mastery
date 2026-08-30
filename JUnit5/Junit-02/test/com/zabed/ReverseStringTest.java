import com.zabed.ReverseString;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class ReverseStringTest {
    @Test
    void testReverseString() {
        ReverseString rev = new ReverseString();
        String actual = rev.reverseString("JAVA");

        String expected = "AVAJ";

        assertEquals(expected, actual);
    }
}