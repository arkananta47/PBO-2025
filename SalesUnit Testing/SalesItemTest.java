
/**
 * Write a description of class SalesItemTesting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Cool item1", 10199);
        assertEquals(true, salesIte1.addComment("Bintang", "Cool cool", 5));
    }

    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Cool Item1", 10199);
        assertEquals(false, salesIte1.addComment("Illegal", "Bruh, this item sucks", 0));
    }

    @Test
    public void testDuplicateAuthor()
    {
        SalesItem salesIte1 = new SalesItem("Cool Item 1", 10199);
        assertEquals(true, salesIte1.addComment("Bintang", "Hmm aku belum coba", 4));
        assertEquals(false, salesIte1.addComment("Bintang", "Meh, biasa aja", 2));
    }
}