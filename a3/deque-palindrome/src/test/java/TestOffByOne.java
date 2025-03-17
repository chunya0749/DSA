///* IMPORTANT:
// * Uncomment this file after you have implemented OffByOne

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('f', 'c'));
    }
}