import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
 * For this drill, you will get practice with recursive backtracking. As with
 * the previous drill that emphasized recursion, this drill will be more difficult
 * than other drills for many students. Start early!
 * 
 * Remember these are all recursive backtracking problems. So make sure to ask yourself
 * the questions detailed in the slides. These questions will lead you to the answer.
 * All of the code should be in the general pseudocode shown in the slides. A shortened
 * version:
 * -------------------------------
 * Base Case(s) - if all decisions have been made
 * 
 * Recursive Case - must go through all decisions possible at that point in time
 * 		Choose - choose one decision out of all the options
 * 		Explore - recurse, trying to solve the problem with the choice you just made
 * 		Unchoose - need to undo the choice you made above so that you can try another choice!
 */
public class Drill08 {
    
	
    /* Write a recursive function named canMakeSum that takes a list of
     * integers and an integer target value (sum) and returns true if it is
     * possible to have some set of values from the list that sum to the
     * target value.
     * 
     * For example, the list {2,1,1,3,5} and target value 9 should return true
     * (5 + 3 + 1 = 9).
     * However, the list {5,4,1,6} and target value 8 should return false.
     */
    public static boolean canMakeSum(ArrayList<Integer> list, int sum) {
    	
		return(canMakeSum(list, new ArrayList<Integer>(), sum));
		
    }
    
    private static boolean canMakeSum(ArrayList<Integer> list, ArrayList<Integer> cur, int sum) {
    	
    	if(listSum(cur) == sum) {
    		
    		return(true);
    		
    	}
    	
    	boolean r = false;
    	
    	for(int i : list) {
    		
    		if(Collections.frequency(list, i) > Collections.frequency(cur, i)) {
    			
    			cur.add(i);
    			r = canMakeSum(list, cur, sum);
    			cur.remove(cur.size() - 1);
    			
    		}
    		
    		
    	}
    	
    	return(r);
    	
    }
    
    private static int listSum(ArrayList<Integer> l) {
    	
    	int sum = 0;
    	for(int i : l) {
    		
    		sum += i;
    		
    	}
    	return(sum);
    	
    }
    
    /* Write a recursive function named longestCommonSubsequence that returns the
     * longest common subsequence of two strings. Recall that if a string is a subsequence
     * of another, each of its letters occurs in the longer string in the same order, but
     * not necessarily consecutively.
     * 
     * Some examples:
     *    longestCommonSubsequence("tyler", "kate") -> "te"
     *    longestCommonSubsequence("hannah", "banana") "anna"
     *    longestCommonSubsequence("she sells", "seashells") "sesells"
     *    longestCommonSubsequence("CS210", "arizona") ""
     */
    public static String longestCommonSubsequence(String s1, String s2) {
    	
    	if(s1.length() <= 0 || s2.length() <= 0) {
    		
    		return("");
    		
    	}
    	
    	if(s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
    		
    		return(longestCommonSubsequence(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1)) + s1.substring(s1.length() - 1));
    		
    	}
    	else {
    		
    		String s1Sub = longestCommonSubsequence(s1.substring(0, s1.length() - 1), s2);
    		String s2Sub = longestCommonSubsequence(s1, s2.substring(0, s2.length() - 1));
    		if(s1Sub.length() >= s2Sub.length()) {
    		
    			return(s1Sub);
    		
    		}
    	
    		return(s2Sub);	
    		
    	}
    	
    	
    }
    
    /* Write a recursive function named editDistance that accepts two string
     * parameters and returns the "edit distance" between the two strings as an
     * integer. Edit distance (also called Levenshtein distance) is the minimum
     * number of "changes" required to get from s1 to s2 or vice versa. A "change"
     * is a) inserting a character,
     *    b) deleting a character, or
     *    c) changing a character to a different character.
     *    
     * Some examples:
     *    editDistance("driving", "diving") -> 1
     *    editDistance("debate", "irate") -> 3
     *    editDistance("football", "cookies") -> 6
     */
    public static int editDistance(String s1, String s2) {
    	
    	if(s1.length() == 0) {
    		
    		return(s2.length());
    		
    	}
    	
    	if(s2.length() == 0) {
    		
    		return(s1.length());
    		
    	}
    	
    	int numReplacements = editDistance(s1.substring(1), s2.substring(1)) + ((s1.charAt(0) == s2.charAt(0)) ? 0 : 1);
    	
    	int numInsertions = editDistance(s1, s2.substring(1)) + 1;
    	
    	int numDeletions = editDistance(s1.substring(1), s2) + 1;
    	
    	return(Math.min(Math.min(numReplacements, numInsertions), numDeletions));
    	
    }

}
