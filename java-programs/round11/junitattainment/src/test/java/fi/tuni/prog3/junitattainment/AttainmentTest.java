package fi.tuni.prog3.junitattainment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author janik
 */
public class AttainmentTest {

    @Test
    public void testAttainment() {
        Attainment attainment = new Attainment("Java", "A123", 5);
        Assertions.assertEquals("Java", attainment.getCourseCode());
    }

    @Test
    public void testStudentCode() {
        Attainment attainment = new Attainment("Java", "A123", 5);
        Assertions.assertEquals("A123", attainment.getStudentNumber());
    }

    @Test
    public void testGrade() {
        Attainment attainment = new Attainment("Java", "A123", 5);
        Assertions.assertEquals(5, attainment.getGrade());
    }

    @Test
    public void testAttainmentToString() {
        Attainment attainment = new Attainment("Java", "A123", 5);
        Assertions.assertEquals("Java A123 5", attainment.toString());
    }

    @Test
    public void testCompareTo() {
        Attainment attainment = new Attainment("Java", "A123", 5);
        Attainment attainment2 = new Attainment("Java", "A123", 5);
        Assertions.assertEquals(0, attainment.compareTo(attainment2));
    }

    @Test
    public void testAttainmentThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Attainment attainment = new Attainment(null, null, 6);
            Attainment attainment2 = new Attainment("", "", -1);
        });
    }


    public AttainmentTest() {
    }

       @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
}
