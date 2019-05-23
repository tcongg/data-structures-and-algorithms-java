import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author C pc
 */
public class DynamicArrayNGTest {

    public DynamicArrayNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of size method, of class DynamicArray.
     */
    @Test
    public void testSize() {
        System.out.println("1. Test size");
        DynamicArray array = new DynamicArray();

        assertEquals(array.size(), 0);

        array.pushBack(1);
        assertEquals(array.size(), 1);
    }

    /**
     * Test of capacity method, of class DynamicArray.
     */
    @Test
    public void testCapacity() {
        System.out.println("2. Test capacity");
        DynamicArray array = new DynamicArray();

        assertEquals(array.capacity(), 8);

        for (int i = 0; i <= 8; i++) {
            array.pushBack(i);
        }

        assertEquals(array.capacity(), 16);

        for (int i = 0; i <= 4; i++) {
            array.pop();
        }

        assertEquals(array.capacity(), 8);
    }

    /**
     * Test of isEmpty method, of class DynamicArray.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("3. test isEmpty");
        DynamicArray array = new DynamicArray();

        assertTrue(array.isEmpty());

        array.pushBack(1);
        assertFalse(array.isEmpty());
    }

    /**
     * Test of pushBack method, of class DynamicArray.
     */
    @Test
    public void testPushBack() {
        System.out.println("4. Test pushBack");
        DynamicArray array = new DynamicArray();

        array.pushBack(1);
        assertEquals(array.at(0), 1);

        array.pushBack(2);
        assertEquals(array.at(0), 1);
        assertEquals(array.at(1), 2);

    }

    /**
     * Test of insert method, of class DynamicArray.
     */
    @Test
    public void testInsert() {
        System.out.println("5. Test insert");

        DynamicArray array = new DynamicArray();

        try {
            array.insert(1, 0);
        } catch (Exception e) {
            System.out.println("Empty list");
        }

        array.pushBack(1);
        array.pushBack(2);
        array.pushBack(3);

        array.insert(0, 99);
        array.insert(4, 88);
        array.insert(2, 55);
        assertEquals(array.at(0), 99);
        assertEquals(array.at(1), 1);
        assertEquals(array.at(2), 55);
        assertEquals(array.at(3), 2);
        assertEquals(array.at(4), 3);
        assertEquals(array.at(5), 88);

        try {
            array.insert(99, 0);
        } catch (Exception e) {
            System.out.println("Index out of range");
        }
    }

    /**
     * Test of prepend method, of class DynamicArray.
     */
    @Test
    public void testPrepend() {
        System.out.println("6. Test prepend");
        DynamicArray array = new DynamicArray();

        array.prepend(1);
        assertEquals(array.at(0), 1);

        array.prepend(2);
        assertEquals(array.at(0), 2);
        assertEquals(array.at(1), 1);

        array.prepend(3);
        assertEquals(array.at(0), 3);
        assertEquals(array.at(1), 2);
        assertEquals(array.at(2), 1);
    }

    /**
     * Test of pop method, of class DynamicArray.
     */
    @Test
    public void testPop() {
        System.out.println("7.Test pop");
        DynamicArray array = new DynamicArray();

        try {
            array.pop();
        } catch (Exception e) {
            System.out.println("Empty list");
        }

        array.pushBack(1);
        array.pushBack(2);
        array.pushBack(3);
        assertEquals(array.pop(), 3);

    }

    /**
     * Test of delete method, of class DynamicArray.
     */
    @Test
    public void testDelete() {
        System.out.println("8. Test delete");
        DynamicArray array = new DynamicArray();

        try {
            array.delete(1);
        } catch (Exception e) {
            System.out.println("Empty list");
        }

        array.pushBack(1);
        array.pushBack(2);
        array.pushBack(3);
        array.pushBack(4);
        array.delete(0);
        assertEquals(array.size(), 3);
        assertEquals(array.at(0), 2);
        assertEquals(array.at(1), 3);
        assertEquals(array.at(2), 4);

        array.delete(2);
        assertEquals(array.at(0), 2);
        assertEquals(array.at(1), 3);

        try {
            array.delete(99);
        } catch (Exception e) {
            System.out.println("Index out of range");
        }
    }

    /**
     * Test of at method, of class DynamicArray.
     */
    @Test
    public void testAt() {
        System.out.println("9. Test at");

        DynamicArray array = new DynamicArray();

        try {
            array.at(1);
        } catch (Exception e) {
            System.out.println("Empty list");
        }

        array.pushBack(1);
        assertEquals(array.at(0), 1);

        array.pushBack(2);
        assertEquals(array.at(0), 1);
        assertEquals(array.at(1), 2);

        try {
            array.at(99);
        } catch (Exception e) {
            System.out.println("Index out of range");
        }
    }

    /**
     * Test of find method, of class DynamicArray.
     */
    @Test
    public void testFind() {
        System.out.println("10. Test find");
        DynamicArray array = new DynamicArray();

        try {
            array.find(99);
        } catch (Exception e) {
            System.out.println("Empty list");
        }

        array.pushBack(1);
        array.pushBack(2);
        array.pushBack(3);
        array.pushBack(4);

        assertEquals(array.find(999), -1);
        assertEquals(array.find(1), 0);
        assertEquals(array.find(2), 1);
        assertEquals(array.find(3), 2);
        assertEquals(array.find(4), 3);

        for (int i = 5; i <= 10; i++) {
            array.pushBack(i);
        }

        assertEquals(array.find(5), 4);
        assertEquals(array.find(9), 8);

        try {
            array.delete(888888);
        } catch (Exception e) {
            System.out.println("Value not found");
        }
    }
}
