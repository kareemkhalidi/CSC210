/*
* AUTHOR: Kareem Khalidi
* FILE: ArrayQueue.java
* ASSIGNMENT: PA6 - StacksQueues
* COURSE: CSc 210; Spring 2022
* PURPOSE: queue using an array as its data structure
* 
* USAGE: 
* exactly like the standard java queue
*/

import java.util.Arrays;

public class ArrayQueue implements QueueInterface {

    private int[] queue;

    /*
     * Constructor for ArrayQueue object
     * 
     * @return null
     */
    public ArrayQueue() {

        this.queue = new int[0];

    }

    /*
     * Copy constructor for ArrayQueue object
     *
     * @param ArrayQueue q
     * 
     * @return null
     */
    public ArrayQueue(ArrayQueue q) {

        this.queue = q.queue;

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

        this.queue = Arrays.copyOf(this.queue, this.queue.length + 1);
        this.queue[this.queue.length - 1] = value;

    }

    /*
     * removes and returns value from the queue
     * 
     * @return int r
     */
    @Override
    public int dequeue() {
        int r = queue[0];
        queue = Arrays.copyOfRange(queue, 1, queue.length);
        return (r);
    }

    /*
     * returns front value of the queue
     * 
     * @return int value
     */
    @Override
    public int peek() {

        return (queue[0]);

    }

    /*
     * tells user whether queue is empty or not
     * 
     * @return boolean emptystatus
     */
    @Override
    public boolean isEmpty() {

        return (queue.length == 0);

    }

    /*
     * returns size of queue to user
     * 
     * @return int size
     */
    @Override
    public int size() {

        return (queue.length);

    }

    /*
     * removes all data stored in queue
     * 
     * @return null
     */
    @Override
    public void clear() {

        queue = new int[0];

    }

    /*
     * returns a string representation of the queue
     * 
     * @return String queueAsString
     */
    public String toString() {

        String r = "{";
        for (int i = 0; i < this.queue.length; i++) {

            r += this.queue[i];
            if (!(i == this.queue.length - 1)) {

                r += ",";

            }

        }
        r += "}";
        return (r);

    }

    /*
     * checks if two ArrayQueues are equal (same values in same places)
     *
     * @param ArrayQueue q
     * 
     * @return boolean equal
     */
    public boolean equals(ArrayQueue q) {

        if (this.queue.length != q.queue.length) {

            return (false);

        }
        for (int i = 0; i < this.queue.length; i++) {

            if (this.queue[i] != q.queue[i]) {

                return (false);

            }

        }
        return (true);

    }

}
