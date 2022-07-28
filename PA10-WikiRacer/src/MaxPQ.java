/*
* AUTHOR: Kareem Khalidi
* FILE: MaxPQ.java
* ASSIGNMENT: PA10
* COURSE: CSc 210; Spring 2022
* PURPOSE: A max priority queue of List<String> objects.
* 
* USAGE: 
* add List<String> objects to the queue and they will dequeue highest
* to lowest priority
*/

import java.util.Arrays;
import java.util.List;

public class MaxPQ {

	private class Ladder {
		
		public List<String> ladder;
		public int priority;
		
		/*
		 * Ladder object constructor for the ladder object to use in a MaxPQ
		 * 
		 * @param List<String> ladder - the link ladder you want to add to the queue
		 * @param int priority - the priority you want the link ladder to have
		 * 
		 * @return null
		 */
		public Ladder(List<String> ladder, int priority) {
			
			this.ladder = ladder;
			this.priority = priority;
			
		}
		
	}
	
	private Ladder[] heap;
	private int size;
	
	/*
	 * Constructor for a MaxPQ
	 * 
	 * @param String link - the page to find the links on
	 * 
	 * @return Set<String> links - a set of all the links found
	 */
	public MaxPQ() {
		
		this.heap = new Ladder[10];
		this.heap[0] = new Ladder(null, Integer.MAX_VALUE);
		this.size = 0;
		
	}
	
	/*
	 * Adds the link ladder to the MaxPQ with the input priority
	 * 
	 * @param List<String> ladder - the ladder to add
	 * @param int priority - the priority to add it with
	 * 
	 * @return null
	 */
	public void enqueue(List<String> ladder, int priority) {
		
		this.enqueue(new Ladder(ladder, priority));
		
	}
	
	/*
	 * Adds the link ladder to the MaxPQ with the input priority
	 * 
	 * @param List<String> ladder - the ladder to add
	 * @param int priority - the priority to add it with
	 * 
	 * @return null
	 */
	private void enqueue(Ladder ladder) {
		
		if(this.size == this.heap.length - 1) {
			
			this.resizeHeap();
			
		}
		this.size++;
		this.heap[size] = ladder;
		this.bubbleUp(size);
		
	}
	
	/*
	 * Dequeues the highest priority element from the MaxPQ
	 * 
	 * @return List<String> ladder - the highest priority ladder in the MaxPQ
	 */
    public List<String> dequeue() throws Exception {

        if (this.size == 0) {

            throw new Exception();

        } else if (size == 1) {

            Ladder l = this.heap[1];
            this.heap[1] = null;
            this.size--;
            return (l.ladder);

        } else {

            Ladder l = this.heap[1];
            this.heap[1] = this.heap[size];
            this.heap[size] = null;
            this.size--;
            this.bubbleDown(1);
            return (l.ladder);
            
        }

    }
    
	/*
	 * Checks if the MaxPQ is empty or not
	 * 
	 * @return boolean isEmpty - true if MaxPQ is empty and false if not
	 */
    public boolean isEmpty() {

        return (this.size == 0);

    }

	/*
	 * Moves the ladder at the specified index up if its priority is larger than its parents,
	 * and keeps moving it up until its priority is no longer greater than its parents
	 * 
	 * @param int i - the index to bubble up
	 * 
	 * @return null
	 */
    private void bubbleUp(int i) {


        while (this.heap[i].priority > this.heap[i / 2].priority && i > 1) {

            Ladder l = this.heap[i];
            this.heap[i] = this.heap[i / 2];
            this.heap[i / 2] = l;
            i = i / 2;

        }

    }
    
	/*
	 * Moves the ladder at the specified index down if its priority is smaller than its children,
	 * and keeps moving it down until its priority is no longer less than its children.
	 * 
	 * @param int i - the index to bubble down
	 * 
	 * @return null
	 */
    private void bubbleDown(int i) {

        int smallestChildsI = i;
        if (2 * i <= size
                && this.heap[2
                        * i].priority > this.heap[smallestChildsI].priority) {

            smallestChildsI = 2 * i;

        }
        if ((2 * i) + 1 <= size
                && this.heap[(2 * i)
                        + 1].priority > this.heap[smallestChildsI].priority) {

            smallestChildsI = (2 * i) + 1;

        }
        if (i != smallestChildsI) {

            Ladder l = this.heap[i];
            this.heap[i] = this.heap[smallestChildsI];
            this.heap[smallestChildsI] = l;
            this.bubbleDown(smallestChildsI);

        }

    }
    
	/*
	 * Increases the size of the Max heap array by 10, retaining all the values from the original
	 * 
	 * @return null
	 */
    private void resizeHeap() {

        this.heap = Arrays.copyOf(this.heap, this.heap.length + 10);

    }
    
}
