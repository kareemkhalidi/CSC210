import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Drill02 {
	
	/* -------- Stacks/Queues -------- */
 
	/*
	 * Given a stack as input, return a stack that has the same
	 * values, but in reverse order.
	 * Remember you can always view the testcases in this project for
	 * expected results.
	 */
	static Stack<Integer> reverseStack(Stack<Integer> in) {
		
		Stack<Integer> r = new Stack<>();
		while(!in.isEmpty()) {
			
			r.push(in.pop());
			
		}
		return(r);
		
	}

	/*
	 * Given a queue, return a new queue that has the same values in
	 * reverse order.
	 * Remember you can always view the testcases in this project for
	 * expected results.
	 */
	static Queue<Integer> reverseQueue(Queue<Integer> in) {
		
		Stack<Integer> temp = new Stack<>();
		Queue<Integer> r = new LinkedList<>();
		while(!in.isEmpty()) {
			
			temp.push(in.remove());
			
		}
		while(!temp.isEmpty()) {
			
			r.add(temp.pop());
			
		}
		return(r);
		
	}
	
	
	/* -------- Recursion -------- */

	/*
	 * Takes a number of characters to print as a parameter and returns
	 * a String with one or two asterisks in the middle surrounded by
	 * alligators.
	 * See the file included in this project: drill02-README.md
	 * Remember you can always view the testcases in this project for
	 * expected results.
	 */
    public static String zigzag(int n) {
    	
    	if(n == 0) {
    		
    		return("");
    		
    	}
    	else if(n == 1) {
    		
    		return("*");
    		
    	}
    	else if(n == 2) {
    		
    		return("**");
    		
    	}
    	else {
    		
    		return("<" + zigzag(n - 2) + ">");
    		
    	}
    	
    }

    /*
     * Takes a String and a character as parameters and returns
     * the string with all copies of the character moved to the end
     * and capitalized.
     * See the file included in this proejct: drill02-README.md
     * Remember you can always view the testcases in this project for
	 * expected results.
     */
    public static String moveToEnd(String s, char c) {
    	
    	if(s.length() == 0) {
    		
    		return("");
    		
    	}
    	else {
    		
    		if(Character.toLowerCase(s.charAt(0)) == Character.toLowerCase(c)) {
    			
    			return(moveToEnd(s.substring(1), c) + Character.toUpperCase(c));
    			
    		}
    		else {
    			
    			return(s.charAt(0) + moveToEnd(s.substring(1), c));
    			
    		}
    		
    	}
    	
    }

}
