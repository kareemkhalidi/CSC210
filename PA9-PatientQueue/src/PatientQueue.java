/*
* AUTHOR: Kareem Khalidi
* PURPOSE: Implementation of a priority queue
*          using a min heap for the patient class
* 
* USAGE: 
* add patients to the queue and then dequeue 
* them based on who has the highest priority to be seen
*/

import java.util.Arrays;

public class PatientQueue {

    public class Patient {

        public String name;
        public int priority;

        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String toString() {
            return name + " (" + priority + ")";
        }

    }

    private Patient[] heap;
    private int size;

    /*
     * empty PatientQueue constructor
     * 
     * @return null
     */
    public PatientQueue() {

        this.heap = new Patient[10];
        this.heap[0] = new Patient("", Integer.MIN_VALUE);
        this.size = 0;

    }

    /*
     * adds a new patient to the array
     *
     * @param String name
     * 
     * @param int priority
     * 
     * @return null
     */
    public void enqueue(String name, int priority) {

        this.enqueue(new Patient(name, priority));

    }

    /*
     * adds a new patient to the array
     *
     * @param Patient patient
     * 
     * @return null
     */
    private void enqueue(Patient patient) {

        if (this.size == this.heap.length - 1) {

            this.resizeHeap();

        }
        this.size++;
        this.heap[size] = patient;
        this.bubbleUp(size);

    }

    /*
     * removes the patient with the lowest priority and
     * returns their name to the user
     * 
     * @return String Patient.name
     */
    public String dequeue() throws Exception {

        if (this.size == 0) {

            throw new Exception();

        } else if (size == 1) {

            Patient p = this.heap[1];
            this.heap[1] = null;
            this.size--;
            return (p.name);

        } else {

            Patient p = this.heap[1];
            this.heap[1] = this.heap[size];
            this.heap[size] = null;
            this.size--;
            this.bubbleDown(1);
            return (p.name);
            
        }

    }

    /*
     * returns the name of the first patient to the user
     * 
     * @return String Patient.name
     */
    public String peek() throws Exception {

        if (this.size == 0) {

            throw new Exception();

        } else {

            return (this.heap[1].name);

        }

    }

    /*
     * returns the priority of the first patient to the user
     * 
     * @return int Patient.priority
     */
    public int peekPriority() throws Exception {

        if (this.size == 0) {

            throw new Exception();

        } else {

            return (this.heap[1].priority);

        }

    }

    /*
     * changes the priority of the specified patient to the new
     * priority specified
     *
     * @param String name
     * 
     * @param int newPriority
     * 
     * @return null
     */
    public void changePriority(String name, int newPriority) {

        int newI = 1;

        for (int i = 1; i <= size; i++) {

            if (this.heap[i].name.equals(name)) {

                this.heap[i].priority = newPriority;
                newI = i;
                break;

            }

        }
        this.bubbleUp(newI);
        this.bubbleDown(newI);

    }

    /*
     * tells user whether the PatientQueue is empty or not
     * 
     * @return boolean isEmpty
     */
    public boolean isEmpty() {

        return (this.size == 0);

    }

    /*
     * returns the size of the patientqueue to the user
     * 
     * @return int size
     */
    public int size() {

        return (this.size);

    }

    /*
     * clears all patients from the patientqueue
     * 
     * @return null
     */
    public void clear() {

        this.heap = new Patient[10];

    }

    /*
     * returns a string representation of the patient queue
     * 
     * @return String PatientQueueAsString
     */
    public String toString() {

        String r = "{";

        for (int i = 1; i <= size; i++) {

            r += this.heap[i].toString();
            if (i != size) {

                r += ", ";

            }

        }

        return (r + "}");

    }

    /*
     * shifts the patient at the specified index up until
     * it cannot move up anymore
     *
     * @param int i
     * 
     * @return null
     */
    private void bubbleUp(int i) {


        while (this.heap[i].priority < this.heap[i / 2].priority && i > 1) {

            Patient p = this.heap[i];
            this.heap[i] = this.heap[i / 2];
            this.heap[i / 2] = p;
            i = i / 2;

        }

    }

    /*
     * shifts the patient at the specified index down until
     * it cannot move down anymore
     *
     * @param int i
     * 
     * @return null
     */
    private void bubbleDown(int i) {

        int smallestChildsI = i;
        if (2 * i <= size
                && this.heap[2
                        * i].priority < this.heap[smallestChildsI].priority) {

            smallestChildsI = 2 * i;

        }
        if ((2 * i) + 1 <= size
                && this.heap[(2 * i)
                        + 1].priority < this.heap[smallestChildsI].priority) {

            smallestChildsI = (2 * i) + 1;

        }
        if (i != smallestChildsI) {

            Patient p = this.heap[i];
            this.heap[i] = this.heap[smallestChildsI];
            this.heap[smallestChildsI] = p;
            this.bubbleDown(smallestChildsI);

        }

    }

    /*
     * doubles the size of the heap array
     * 
     * @return null
     */
    private void resizeHeap() {

        this.heap = Arrays.copyOf(this.heap, 2 * this.heap.length);

    }

}
