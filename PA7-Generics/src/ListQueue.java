/*
* AUTHOR: Kareem Khalidi
* FILE: ListQueue.java
* ASSIGNMENT: PA7 - Generics
* COURSE: CSc 210; Spring 2022
* PURPOSE: generic queue using a linked list as its data structure
* 
* USAGE: 
* exactly like the standard java queue
*/

public class ListQueue<T> implements QueueInterface<T> {

    public class Node<E> {

        public E value;
        public Node<E> next;
        public Node<E> prev;

        public Node(E value) {

            this.value = value;

        }

    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /*
     * Constructor for ListQueue object
     * 
     * @return null
     */
    public ListQueue() {

        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    /*
     * Copy constructor for ListQueue object
     *
     * @param ListQueue<T> q
     * 
     * @return null
     */
    public ListQueue(ListQueue<T> q) {

        this.head = q.head;
        this.tail = q.tail;
        this.size = q.size;

    }

    /*
     * adds value to the queue
     *
     * @param T value
     * 
     * @return null
     */

    @Override
    public void enqueue(T value) {

        if (this.head == null) {

            this.head = new Node<T>(value);
            this.tail = this.head;

        } else {

            this.tail.next = new Node<T>(value);
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;

        }

        this.size++;

    }

    /*
     * removes and returns value from the queue
     * 
     * @return T r
     */
    @Override
    public T dequeue() {

        if (this.size == 0) {

            return (null);

        } else if (this.size == 1) {

            T r = this.head.value;
            this.head = null;
            this.tail = null;
            this.size--;
            return (r);

        } else {

            T r = this.head.value;
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;
            return (r);

        }

    }

    /*
     * returns front value of the queue
     * 
     * @return T value
     */
    @Override
    public T peek() {

        return (this.head.value);

    }

    /*
     * tells user whether queue is empty or not
     * 
     * @return boolean emptystatus
     */
    @Override
    public boolean isEmpty() {

        return (this.head == null);

    }

    /*
     * returns size of queue to user
     * 
     * @return int size
     */
    @Override
    public int size() {

        return (this.size);

    }

    /*
     * removes all data stored in queue
     * 
     * @return null
     */
    @Override
    public void clear() {

        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    /*
     * returns a string representation of the queue
     * 
     * @return String queueAsString
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
     * checks if two ListQueues are equal (same values in same places)
     *
     * @param ListQueue<T> q
     * 
     * @return boolean equal
     */
    public boolean equals(ListQueue<T> q) {

        if (this.size != q.size) {

            return (false);

        } else {

            Node<T> cur = this.tail;
            Node<T> cur2 = q.tail;
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
