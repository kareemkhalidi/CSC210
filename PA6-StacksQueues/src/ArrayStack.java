/*
* AUTHOR: Kareem Khalidi
* FILE: ArrayStack.java
* ASSIGNMENT: PA6 - StacksQueues
* COURSE: CSc 210; Spring 2022
* PURPOSE: stack using an array as its data structure
* 
* USAGE: 
* exactly like the standard java stack
*/

import java.util.Arrays;

public class ArrayStack implements StackInterface {

    private int stack[];

    /*
     * Constructor for ArrayStack object
     * 
     * @return null
     */
    public ArrayStack() {

        this.stack = new int[0];

    }

    /*
     * Copy constructor for ArrayStack object
     *
     * @param ArrayStack s
     * 
     * @return null
     */
    public ArrayStack(ArrayStack s) {

        this.stack = s.stack;

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

        this.stack = Arrays.copyOf(this.stack, this.stack.length + 1);
        this.stack[this.stack.length - 1] = value;

    }

    /*
     * removes and returns value from the stack
     * 
     * @return int r
     */
    @Override
    public int pop() {

        if (this.stack.length == 0) {

            return (-1);

        } else {

            int r = this.stack[this.stack.length - 1];
            this.stack = Arrays.copyOf(this.stack, this.stack.length - 1);
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

        if (this.stack.length == 0) {

            return (-1);

        } else {

            return (this.stack[this.stack.length - 1]);

        }

    }

    /*
     * tells user whether stack is empty or not
     * 
     * @return boolean emptystatus
     */
    @Override
    public boolean isEmpty() {

        return (this.stack.length == 0);

    }

    /*
     * returns size of stack to user
     * 
     * @return int size
     */
    @Override
    public int size() {

        return (this.stack.length);

    }

    /*
     * removes all data stored in stack
     * 
     * @return null
     */
    @Override
    public void clear() {

        this.stack = new int[0];

    }

    /*
     * returns a string representation of the stack
     * 
     * @return String stackAsString
     */
    public String toString() {

        String r = "{";
        for (int i = 0; i < this.stack.length; i++) {

            r += this.stack[i];
            if (!(i == this.stack.length - 1)) {

                r += ",";

            }

        }
        r += "}";
        return (r);

    }

    /*
     * checks if two ArrayStacks are equal (same values in same places)
     *
     * @param ArrayStack s
     * 
     * @return boolean equal
     */
    public boolean equals(ArrayStack s) {

        if (this.stack.length != s.stack.length) {

            return (false);

        }
        for (int i = 0; i < this.stack.length; i++) {

            if (this.stack[i] != s.stack[i]) {

                return (false);

            }

        }
        return (true);

    }

}
