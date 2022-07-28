/*
* AUTHOR: Kareem Khalidi
* FILE: ListQueue.java
* ASSIGNMENT: PA6 - StacksQueues
* COURSE: CSc 210; Spring 2022
* PURPOSE: queue using a linked list as its data structure
* 
* USAGE: 
* exactly like the standard java queue
*/

public class ListQueue implements QueueInterface {

    public class Node {

        public int value;
        public Node next;
        public Node prev;

        public Node(int value) {

            this.value = value;

        }

    }

    private Node head;
    private Node tail;
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
     * @param ListQueue q
     * 
     * @return null
     */
    public ListQueue(ListQueue q) {

        this.head = q.head;
        this.tail = q.tail;
        this.size = q.size;

    }

    /*
     * adds value to the queue
     *
     * @param int value
     * 
     * @return null
     */

    @Override
    public void enqueue(int value) {

        if (this.head == null) {

            this.head = new Node(value);
            this.tail = this.head;

        } else {

            this.tail.next = new Node(value);
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;

        }

        this.size++;

    }

    /*
     * removes and returns value from the queue
     * 
     * @return int r
     */
    @Override
    public int dequeue() {

        if (this.size == 0) {

            return (-1);

        } else if (this.size == 1) {

            int r = this.head.value;
            this.head = null;
            this.tail = null;
            this.size--;
            return (r);

        } else {

            int r = this.head.value;
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;
            return (r);

        }

    }

    /*
     * returns front value of the queue
     * 
     * @return int value
     */
    @Override
    public int peek() {

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
     * checks if two ListQueues are equal (same values in same places)
     *
     * @param ListQueue q
     * 
     * @return boolean equal
     */
    public boolean equals(ListQueue q) {

        if (this.size != q.size) {

            return (false);

        } else {

            Node cur = this.tail;
            Node cur2 = q.tail;
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
