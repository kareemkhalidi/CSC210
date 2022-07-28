/*
* AUTHOR: Kareem Khalidi
* FILE: ListStack.java
* ASSIGNMENT: PA7 - Generics
* COURSE: CSc 210; Spring 2022
* PURPOSE: generic stack using a linked list as its data structure
* 
* USAGE: 
* exactly like the standard java stack
*/

public class ListStack<T> implements StackInterface<T> {

    public class Node<E> {

        public E value;
        public Node<E> next;
        public Node<E> prev;

        public Node(E value) {

            this.value = value;

        }

    }

    private Node<T> tail;
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
     * @param ListStack<T> s
     * 
     * @return null
     */
    public ListStack(ListStack<T> s) {

        this.tail = s.tail;
        this.size = s.size;

    }

    /*
     * adds value to the stack
     *
     * @param T value
     * 
     * @return null
     */
    @Override
    public void push(T value) {

        if (this.tail == null) {

            this.tail = new Node<T>(value);

        }
        else {

            this.tail.next = new Node<T>(value);
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;

        }

        size++;

    }

    /*
     * removes and returns value from the stack
     * 
     * @return T r
     */
    @Override
    public T pop() {

        if (this.tail == null) {

            return (null);

        } else if (this.tail.prev == null) {

            T r = this.tail.value;
            this.tail = null;
            size--;
            return (r);

        } else {

            T r = this.tail.value;
            this.tail = this.tail.prev;
            this.tail.next = null;
            size--;
            return (r);

        }

    }

    /*
     * returns top value of the stack
     * 
     * @return T value
     */
    @Override
    public T peek() {

        if (this.tail == null) {

            return (null);

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
        Node<T> cur = this.tail;
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
     * @param ListStack<T> s
     * 
     * @return boolean equal
     */
    public boolean equals(ListStack<T> s) {

        if (this.size != s.size) {

            return (false);

        } else {

            Node<T> cur = this.tail;
            Node<T> cur2 = s.tail;
            for (int i = 0; i < size; i++) {

                if (!cur.value.equals(cur2.value)) {

                    return (false);

                }
                cur = cur.prev;
                cur2 = cur2.prev;

            }

            return (true);

        }

    }

}
