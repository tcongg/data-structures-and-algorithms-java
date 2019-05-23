public class LinkedList {

    Node head;
    private int size = 0;

    LinkedList() {
        head = null;
    }

    LinkedList(Node head) {
        this.head = head;
    }

    int size() {
        /*
        Returns number of data elements in list
        Time Complexity: O(1)
        */
        return size;
    }

    Boolean isEmpty() {
        /*
        Returns true if empty
        Time Complexity: O(1)
        */
        return head == null;
    }

    void pushFront(int value) {
        /*
        Adds an item to the front of the list
        Time Complexity: O(1)
        */
        head = new Node(value, head);
        size += 1;
    }

    void pushBack(int value) {
        /*
        Adds an item to the end of the list
        Time Complexity: O(n)
        */
        if (head == null) {
            head = new Node(value, head);
        } else {
            Node tail = head;
            for (int i = 0; i < size - 1; i++) {
                tail = tail.next;
            }
            tail.next = new Node(value, null);
        }
        size += 1;
    }

    int front() {
        /*
        Get value of front item
        Time Complexity: O(1)
        */
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return head.value;
    }

    int back() {
        /*
        Get value of end item
        Time Complexity: O(n)
        */
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return valueAt(size - 1);
    }

    int valueAt(int index) {
        /*
        Returns the value of the nth item (starting at 0 for first)
        Time Complexity: O(n)
        */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node movedNode = head;
        int value = 0;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                value = movedNode.value;
                break;
            }
            movedNode = movedNode.next;
        }
        return value;
    }

    int popFront() throws Exception {
        /*
        Remove front item and return its value
        Time Complexity: O(1)
        */
        if (size == 0) {
            throw new Exception();
        }

        int popValue = head.value;
        head = head.next;
        size -= 1;
        return popValue;
    }

    int popBack() throws Exception {
        /*
        Remove end item and return its value
        Time Complexity: O(n)
        */
        if (size == 0) {
            throw new Exception();
        }

        int popValue;
        if (size == 1) {
            popValue = head.value;
            head = null;
        } else {
            Node movedNode = head;

            while (movedNode.next.next != null) {
                movedNode = movedNode.next;
            }
            popValue = movedNode.next.value;
            movedNode.next = null;
        }

        size -= 1;
        return popValue;
    }

    void insert(int index, int value) {
        /*
        Insert value at index, so current item at that index is pointed to by new item at index
        Time Complexity: O(n)
        */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = new Node(value, head);
        } else {
            Node movedNode = head;
            for (int i = 0; i < index - 1; i++) {
                movedNode = movedNode.next;
            }
            movedNode.next = new Node(value, movedNode.next);
        }
        size += 1;
    }

    void deleteAtIndex(int index) {
        /*
        Removes node at given index
        Time Complexity: O(n)
        */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node movedNode = head;

            for (int i = 0; i < index - 1; i++) {
                movedNode = movedNode.next;
            }
            movedNode.next = movedNode.next.next;
        }

        size -= 1;
    }

    void remove(int value) throws Exception {
        /*
        Removes all given value
        Time complexity: O(n)
        */
        if (size == 0) {
            throw new Exception();
        }

        Node tempNode = head;
        Node movedNode = null;

        while (tempNode != null) {
            if (tempNode.value == value) {
                if (tempNode == head) {
                    head = head.next;
                    tempNode = head;
                } else {
                    movedNode.next = tempNode.next;
                    tempNode = movedNode.next;
                }

                size -= 1;

            } else {
                movedNode = tempNode;
                tempNode = tempNode.next;
            }
        }

    }

    int valueAtIndexFromEnd(int index) {
        /*
        Returns the value of the node at nth position from the end of the list
        Time Complexity: O(n)
        */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return valueAt(size - index - 1);
    }

    void reverse() {
        /*
        Reverse the list
        Time Complexity: O(n)
        */
        if  (size == 0 || size == 1) {
            return;
        }
        
        Node tempNode = head;
        Node prevNode = null;

        for (int i = 0; i < size; i++) {
            Node nextNode = tempNode.next;
            tempNode.next = prevNode;
            prevNode = tempNode;
            tempNode = nextNode;
        }

        head = prevNode;
    }
}
