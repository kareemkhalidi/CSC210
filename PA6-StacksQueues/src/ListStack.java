/*
* AUTHOR: Kareem Khalidi
* FILE: ListStack.java
* ASSIGNMENT: PA6 - StacksQueues
* COURSE: CSc 210; Spring 2022
* PURPOSE: stack using a linked list as its data structure
* 
* USAGE: 
* exactly like the standard java stack
*/

public class ListStack implements StackInterface {

    public class Node {

        public int value;
        public Node next;
        public Node prev;

        public Node(int value) {

            this.value = value;

        }

    }

    private Node tail;
    private int size;

    /*
     * Constructor for ListStack object
     * 
     * @return null
     */
    public ListStack() {

        this.tail = null;
        this.size = 0;

    }

    /*
     * Copy constructor for ListStack object
     *
     * @param ListStack s
     * 
     * @return null
     */
    public ListStack(ListStack s) {

        this.tail = s.tail;
        this.size = s.size;

    }

    /*
     * adds value to the stack
     *
     * @param int value
     * 
     * @return null
     */
    @Override
    public void push(int value) {

        if (this.tail == null) {

            this.tail = new Node(value);

        }
        else {

            this.tail.next = new Node(value);
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;

        }

        size++;

    }

    /*
     * removes and returns value from the stack
     * 
     * @return int r
     */
    @Override
    public int pop() {

        if (this.tail == null) {

            return (-1);

        } else if (this.tail.prev == null) {

            int r = this.tail.value;
            this.tail = null;
            size--;
            return (r);

        } else {

            int r = this.tail.value;
            this.tail = this.tail.prev;
            this.tail.next = null;
            size--;
            return (r);

        }

    }

    /*
     * returns top value of the stack
     * 
     * @return int value
     */
    @Override
    public int peek() {

        if (this.tail == null) {

            return (-1);

        } else {

            return (this.tail.value);

        }

    }

    /*
     * tells user whether stack is empty or not
     * 
     * @return boolean emptystatus
     */
    @Override
    public boolean isEmpty() {

        return (this.tail == null);

    }

    /*
     * returns size of stack to user
     * 
     * @return int size
     */
    @Override
    public int size() {

        return (this.size);

    }

    /*
     * removes all data stored in stack
     * 
     * @return null
     */
    @Override
    public void clear() {

        this.tail = null;
        this.size = 0;

    }

    /*
     * returns a string representation of the stack
     * 
     * @return String stackAsString
     */
    public String toString() {

        String r = "}";
        Node cur = this.tail;
        for (int i = 0; i < size; i++) {

            r = cur.value + r;
            cur = cur.prev;
            if (i != size - 1) {

                r = "," + r;

            }

        }

        r = "{" + r;
        return (r);

    }

    /*
     * checks if two ListStacks are equal (same values in same places)
     *
     * @param ListStack s
     * 
     * @return boolean equal
     */
    public boolean equals(ListStack s) {

        if (this.size != s.size) {

            return (false);

        } else {

            Node cur = this.tail;
            Node cur2 = s.tail;
            for (int i = 0; i < size; i++) {

                if (cur.value != cur2.value) {

                    return (false);

                }
                cur = cur.prev;
                cur2 = cur2.prev;

            }

            return (true);

        }

    }

}
