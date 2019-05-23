import java.util.Arrays;

public class DynamicArray {

    private int size = 0;
    private int capacity = 8;
    private Object items[];

    public DynamicArray() {
        items = new Object[capacity];
    }

    int size() {
        /*
         Return number of items stored in DynamicArray
         Time complexity: O(1)
         */
        return size;
    }

    int capacity() {
        /*
         Return number of items DynamicArray can hold
         Time complexity: O(1)
         */
        return capacity;
    }

    Boolean isEmpty() {
        /*
         Check DynamicArray is empty or not. Return True if empty, False if not
         Time complexity: O(1)
         */
        return size == 0;
    }

    void pushBack(int value) {
        /*
         Add given item to end of DynamicArray
         Time complexity: O(1)        
         */
        resize();
        items[size] = value;
        size += 1;
    }

    void insert(int index, int value) {
        /*
        Inserts item at index
        Time complexity: O(n)
        */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        
        resize();
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = value;
        size += 1;
    }

    void prepend(int value) {
        /*
        Insert given item at index 0
        Time complexity: O(n)
        */
        insert(0, value);
    }

    int pop() {
        /*
        Remove last item and return its value
        Time complexity: O(1)
        */
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }

        int popValue = (int) items[size - 1];
        delete(size - 1);
        return popValue;
    }

    void delete(int index) {
        /*
        Delete item at index, shifting all trailing items left
        Time complexity: O(n)
        */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size; i++) {
            items[i] = items[i + 1];
        }
        size -= 1;
        resize();
    }

    int at(int index) {
        /*
        Returns item at given index, blows up if index out of bounds
        Time complexity: O(1)
        */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return (int) items[index];
        }
    }

    int find(int value) {
        /*
        Looks for value and returns first index with that value, -1 if not found
        Time complexity: O(n)
        */
        for (int i = 0; i < size; i++) {
            if ((int) items[i] == value) {
                return i;
            }
        }
        return -1;
    }

    void resize() {
        /*
        When you reach capacity, resize to double the size
        When popping an item, if size is 1/4 of capacity, resize to half
        Time complexity: O(n)
        */
        int newCapacity;
        if (size == capacity) {
            newCapacity = items.length * 2;
        } else if (size > 0 && size <= capacity / 4 && capacity > 8) {
            newCapacity = items.length / 2;
        } else {
            return;
        }

        items = Arrays.copyOf(items, newCapacity);
        capacity = newCapacity;
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i] + " ");
        }
    }
}
