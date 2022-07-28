import java.lang.reflect.Array;
import java.util.*;	

public class Drill03 {

	/*
	 * Takes a string and two characters as parameters.
	 * Returns a string that is the same as the passed in string
	 * except that all occurrences of the first character are replaced
	 * with the second.
	 * You must use recursion to solve this problem.
	 */
	public static String replaceAll(String s, char from, char to) {
		
		if(s.isEmpty()) {
			
			return("");
			
		}
		else {
			
			if(s.charAt(0) == from) {
				
				return(to + replaceAll(s.substring(1), from, to));
				
			}
			else {

				return(s.charAt(0) + replaceAll(s.substring(1), from, to));
				
			}
		}
	}

	/*
	 * Takes an integer as a parameter.
	 * Returns true if the digits are in sorted order ascending.
	 * Returns false otherwise.
	 * You must use recursion to solve this problem.
	 */
	public static boolean digitsSorted(int x) {
		
		String xString = Integer.toString(Math.abs(x));
		if(xString.length() == 1) {
			
			return(true);
			
		}
		else {
			
			if(Integer.parseInt(String.valueOf(xString.charAt(xString.length() - 1)))
				>= Integer.parseInt(String.valueOf(xString.charAt(xString.length() - 2)))) {
				
				return(true && digitsSorted(x / 10));
				
			}
			else {
				
				return(false);
				
			}
			
		}
		
	}

	/*
	 * Write a recursive function which returns the input string
	 * but with adjacent duplicate char- acters removed. Do not use
	 * any String functions other than .charAt(), .length(), .isEmpty()
	 * and .substring(). Do not use any loops. We recommend you use a
	 * helper function so we have provided the helper function header
	 * below
	 * You must use recursion to solve this problem.
	 */
	public static String removeAdjacentDuplicateChars(String s) {
		
		if(s.length() == 0 || s.length() == 1) {
			
			return(s);
			
		}
		else {
			
			if(s.charAt(0) == s.charAt(1)) {
		
				return(removeAdjacentDuplicateChars(s.substring(1)));
				
			}
			else {
				
				return(s.charAt(0) + removeAdjacentDuplicateChars(s.substring(1)));
				
			}
			
		}
			
	}

	/*
	 * Write a recursive function that returns the number of occurrences
	 * of an integer n inside of an array of integers. You may not use
	 * loops or any array functions. You may use array.length to determine
	 * the length of the array. We recommend you use a helper similar to the
	 * one above. It would be useful if your helper function kept track of
	 * which index in the array you are currently checking.
	 * You must use recursion to solve this problem.
	 */
	public static int countOccurrences(int[] arr, int n) {
		
			return(countHelper(arr, n, 0));
		
	}
	
	private static int countHelper(int[] arr, int n, int index) {
		
		if(arr.length == 0 || index == arr.length) {
			
			return(0);
			
		}
		else {
			
			if(arr[index] == n) {
				
				return(1 + countHelper(arr, n, index + 1));
				
			}
			else {
				
				return(countHelper(arr, n, index + 1));
				
			}
			
		}
		
	}
	
}
