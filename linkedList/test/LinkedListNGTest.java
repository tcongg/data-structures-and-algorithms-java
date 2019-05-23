import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedListNGTest {

    public LinkedListNGTest() {
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
     * Test of size method, of class LinkedList.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSize() throws Exception {
        System.out.println("1. Test size");
        LinkedList list = new LinkedList();

        assertEquals(list.size(), 0);

        list.pushBack(1);
        assertEquals(list.size(), 1);

        list.remove(1);
        assertEquals(list.size(), 0);

    }

    /**
     * Test of isEmpty method, of class LinkedList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("2. Test isEmpty");
        LinkedList list = new LinkedList();

        assertTrue(list.isEmpty());

        list.pushBack(1);
        assertFalse(list.isEmpty());
    }

    /**
     * Test of pushFront method, of class LinkedList.
     */
    @Test
    public void testPushFront() {
        System.out.println("3. Test pushFront");
        LinkedList list = new LinkedList();

        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        assertEquals(list.valueAt(0), 3);
        assertEquals(list.valueAt(1), 2);
        assertEquals(list.valueAt(2), 1);
    }

    /**
     * Test of pushBack method, of class LinkedList.
     */
    @Test
    public void testPushBack() {
        System.out.println("4. Test pushBack");
        LinkedList list = new LinkedList();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        assertEquals(list.valueAt(0), 1);
        assertEquals(list.valueAt(1), 2);
        assertEquals(list.valueAt(2), 3);
    }

    /**
     * Test of front method, of class LinkedList.
     */
    @Test
    public void testFront() {
        System.out.println("5. Test front");
        LinkedList list = new LinkedList();

        try {
            list.front();
        } catch (Exception e) {
            System.out.println("Empty list");
        }

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        assertEquals(list.valueAt(0), 1);
        assertEquals(list.valueAt(1), 2);
        assertEquals(list.valueAt(2), 3);
        assertEquals(list.front(), 1);

        list.pushFront(0);
        assertEquals(list.front(), 0);
    }

    /**
     * Test of back method, of class LinkedList.
     */
    @Test
    public void testBack() {
        System.out.println("6. Test back");
        LinkedList list = new LinkedList();

        try {
            list.back();
        } catch (Exception e) {
            System.out.println("Empty list");
        }

        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        assertEquals(list.valueAt(0), 3);
        assertEquals(list.valueAt(1), 2);
        assertEquals(list.valueAt(2), 1);
        assertEquals(list.back(), 1);

        list.pushBack(4);
        assertEquals(list.back(), 4);
    }

    /**
     * Test of valueAt method, of class LinkedList.
     */
    @Test
    public void testValueAt() {
        System.out.println("7. Test valueAt");
        LinkedList list = new LinkedList();
        
        try {
            list.valueAt(1);
        } catch (Exception e) {
            System.out.println("Empty list");
        }

        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        assertEquals(list.valueAt(0), 3);
        assertEquals(list.valueAt(1), 2);
        assertEquals(list.valueAt(2), 1);
    }

    /**
     * Test of popFront method, of class LinkedList.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testPopFront() throws Exception {
        System.out.println("8. Test popFront");
        LinkedList list = new LinkedList();
        
        try {
            list.popFront();
        } catch (Exception e) {
            System.out.println("Empty list");
        }

        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        assertEquals(list.popFront(), 3);
    }

    /**
     * Test of popBack method, of class LinkedList.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testPopBack() throws Exception {
        System.out.println("9. Test popBack");
        LinkedList list = new LinkedList();
        
        try {
            list.popBack();
        } catch (Exception e) {
            System.out.println("Empty list");
        }


        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        assertEquals(list.popBack(), 3);
    }

    /**
     * Test of insert method, of class LinkedList.
     */
    @Test
    public void testInsert() {
        System.out.println("10. Test insert");
        LinkedList list = new LinkedList();
        
        try {
            list.insert(1, 2);
        } catch (Exception e) {
            System.out.println("Empty list");
        }


        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        list.insert(0, 99);
        list.insert(4, 88);
        list.insert(2, 55);
        assertEquals(list.valueAt(0), 99);
        assertEquals(list.valueAt(1), 1);
        assertEquals(list.valueAt(2), 55);
        assertEquals(list.valueAt(3), 2);
        assertEquals(list.valueAt(4), 3);
        assertEquals(list.valueAt(5), 88);
        
        try {
            list.insert(99, 1000);
        } catch (Exception e) {
            System.out.println("Index out of range");
        }
    }

    /**
     * Test of deleteAtIndex method, of class LinkedList.
     */
    @Test
    public void testDeleteAtIndex() {
        System.out.println("11. Test deleteAtIndex");
        LinkedList list = new LinkedList();
        
        try {
            list.deleteAtIndex(1);
        } catch (Exception e) {
            System.out.println("Empty list");
        }

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);

        list.deleteAtIndex(0);
        list.deleteAtIndex(3);
        list.deleteAtIndex(1);
        assertEquals(list.valueAt(0), 2);
        assertEquals(list.valueAt(1), 4);
        
        try {
            list.deleteAtIndex(99);
        } catch (Exception e) {
            System.out.println("Index out of range");
        }
    }

    /**
     * Test of remove method, of class LinkedList.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("12. Test remove");
        LinkedList list = new LinkedList();
        
        try {
            list.remove(0);
        } catch (Exception e) {
            System.out.println("Empty List");
        }

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(3);
        list.pushBack(3);
        list.pushBack(6);

        list.remove(10);
        assertEquals(list.valueAt(0), 1);
        assertEquals(list.valueAt(1), 2);
        assertEquals(list.valueAt(2), 3);
        assertEquals(list.valueAt(3), 4);
        assertEquals(list.valueAt(4), 3);
        assertEquals(list.valueAt(5), 3);
        assertEquals(list.valueAt(6), 6);

        list.remove(1);
        assertEquals(list.valueAt(0), 2);
        assertEquals(list.valueAt(1), 3);
        assertEquals(list.valueAt(2), 4);
        assertEquals(list.valueAt(3), 3);
        assertEquals(list.valueAt(4), 3);
        assertEquals(list.valueAt(5), 6);

        list.remove(6);
        assertEquals(list.valueAt(0), 2);
        assertEquals(list.valueAt(1), 3);
        assertEquals(list.valueAt(2), 4);
        assertEquals(list.valueAt(3), 3);
        assertEquals(list.valueAt(4), 3);

        list.remove(3);
        assertEquals(list.valueAt(0), 2);
        assertEquals(list.valueAt(1), 4);
        
        try {
            list.remove(555);
        } catch (Exception e) {
            System.out.println("Value not found");
        }
    }

    /**
     * Test of valueAtIndexFromEnd method, of class LinkedList.
     */
    @Test
    public void testValueAtIndexFromEnd() {
        System.out.println("13. Test valueAtIndexFromEnd");
        LinkedList list = new LinkedList();
        
        try {
            list.valueAtIndexFromEnd(0);
        } catch (Exception e) {
            System.out.println("Empty List");
        }
        
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);

        assertEquals(list.valueAtIndexFromEnd(0), 4);
        assertEquals(list.valueAtIndexFromEnd(2), 2);
        assertEquals(list.valueAtIndexFromEnd(3), 1);
        
        try {
            list.valueAtIndexFromEnd(0);
        } catch (Exception e) {
            System.out.println("Index out of range");
        }
    }

    /**
     * Test of reverse method, of class LinkedList.
     */
    @Test
    public void testReverse() {
        System.out.println("14. Test reverse");
        LinkedList list = new LinkedList();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        assertEquals(list.valueAt(0), 1);
        assertEquals(list.valueAt(1), 2);
        assertEquals(list.valueAt(2), 3);
        assertEquals(list.valueAt(3), 4);

        list.reverse();
        assertEquals(list.valueAt(0), 4);
        assertEquals(list.valueAt(1), 3);
        assertEquals(list.valueAt(2), 2);
        assertEquals(list.valueAt(3), 1);
    }
}
