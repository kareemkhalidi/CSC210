/*
 * You will test these functions just like you ran your code for drill00.
 * Right-click on either the 'RunTests.java' file, or the 'Drill01TestClass.java'
 * file in your 'Package Explorer' sidebar on the left. It will provide many options, go
 * to the line that says 'Run As', then choose 'JUnit Test'. In your left sidebar, you
 * should see another tab 'JUnit' with your test results like we saw in class.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Drill01 {
	
	/* -------- Arrays -------- */
	
	/*
	 * Return the item at the index specified by the 
	 * parameter 'index'. Only do this if 'index' exists
	 * in your array. i.e. first check to make sure the
	 * array is big enough to contain such an index. If
	 * the array does not contain this index, return -1.
	 */
	static int getElementAtIndex(int index, int[] array) {
		if(index >= array.length) {
			
			return(-1);
			
		}
		return(array[index]);
	}
	
	/*
	 * Return the sum of all the values in the given array.
	 */
	static int sumValues(int[] array) {
		int r = 0;
		for(int i = 0; i < array.length; i++) {
			
			r += array[i];
			
		}
		return(r);
	}
	
	/*
	 * Return a new array that doubles every element in the 
	 * given array.
	 */
	static int[] doubleElements(int[] array) {
		int[] r = new int[array.length];
		for(int i = 0; i < array.length; i++) {

			r[i] = 2 * array[i];
			
		}
		return r;
	}
	
	/* -------- Lists -------- */
	
	/*
	 * Return the item at the index specified by the 
	 * parameter 'index'. Only do this if 'index' exists
	 * in your list. i.e. first check to make sure the
	 * list is big enough to contain such an index. If
	 * the list does not contain this index, return -1.
	 */
	static int getElementAtIndex(int index, List<Integer> list) {
		if(index >= list.size()) {
			
			return(-1);
			
		}
		return(list.get(index));
	}
	
	/*
	 * Return the sum of all the values in the given list.
	 */
	static int sumValues(List<Integer> list) {
		int r = 0;
		for(int i = 0; i < list.size(); i++) {
			
			r += list.get(i);
			
		}
		return(r);
	}
	
	/*
	 * Return a new list that doubles every element in the 
	 * given list.
	 */
	static List<Integer> doubleElements(List<Integer> list) {
		ArrayList<Integer> r = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			
			r.add(2 * list.get(i));
			
		}
		return(r);
	}

	/* -------- Sets -------- */
	
	/*
	 * Return whether the given set contains the given value.
	 */
	static boolean setContains(Set<Integer> set, int val) {
		return(set.contains(val));
	}
	
	/*
	 * Return a new set containing the intersection 
	 * (common elements) of the given sets.
	 */
	static Set<Integer> setIntersection(Set<Integer> set1, Set<Integer> set2) {
		set1.retainAll(set2);
		return(set1);
	}
	
	/*  -------- HashMaps -------- */
	
	/*
	 * Given a string, return a map with each character as 
	 * a key and the number of times that character appears 
	 * in the string as the value.
	 */
	static Map<Character, Integer> characterCount(String s) {
		Map<Character, Integer> r = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
		
			if(r.containsKey(s.charAt(i))) {
				
				r.replace(s.charAt(i), r.get(s.charAt(i)) + 1);
				
			}
			else {
				
				r.put(s.charAt(i), 1);
				
			}
			
		}
		return(r);
	}
	
	/*
	 * Given a mapping of cities to their population, return the city
	 * with the largest population. If the given map is empty, return 
	 * an empty string.
	 */
	static String largestPopulation(Map<String, Integer> cities) {
		String r = "";
		int pop = 0;
		for(String name : cities.keySet()) {
			
			if(cities.get(name) > pop) {
				
				r = name;
				pop = cities.get(name);
				
			}
			
		}
		
		return (r);
	}

}
