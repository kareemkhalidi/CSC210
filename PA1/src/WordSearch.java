/*
* AUTHOR: Kareem Khalidi
* FILE: WordSearch.java
* ASSIGNMENT: PA1 - Word Search
* COURSE: CSc 210; Spring 2022
* PURPOSE: Reads in 2 text files: a dictionary of words to search for,
* 		   and a grid of words to search for those words in, and then
* 		   locates and lists all the words in the grid.
*
* USAGE: 
* dictionaryFileName gridFileName
*
* where dictionaryFileName is a file with the following format:
*
* ----------- EXAMPLE INPUT -------------
* Input file:
* -------------------------------------------
* | word1
* | word2
* |	word3
* | word4
* | word5
* -------------------------------------------
*
* and gridFileName is a file with the following format:
* 
* ----------- EXAMPLE INPUT -------------
* Input file:
* -------------------------------------------
* | 6
* | 6 
* |	y c o d e j
* |	h s e y p k
* |	l p h b w a
* |	l o b w x z
* |	w o b a a i
* |	p l y y c g
* -------------------------------------------
* 
* The commands shown above are all of the commands that are supported
* by this program. It is assumed that (except for some specific errors), 
* the input is well-formed, and matches the format shown above.
*/

import java.io.*;
import java.util.*;


public class WordSearch {

	/*
	* The main method where all helper methods are called in order to
	* store the dictionary and grid into data structures, scan the grid
	* for any words that appear in the dictionary, and prints them
	*
	* @param String[] args, the arguments for the program
	* @return null
	*/ 
	public static void main(String[] args) throws FileNotFoundException {
		
		//saves dictionary into set
		Set<String> dictSet = readDictToSet(args[0]);
		//saves grid into 2d array
		String[][] gridArray = readGridTo2dArray(args[1]);
		//saves all words found in the grid to an arraylist
		List<String> wordList = checkGridForWords(gridArray, dictSet);
		//prints the list of words
		printWordList(wordList);
		
	}
	
	/*
	* A helper method that reads all the words from the dictionary file
	* into a hash set
	*
	* @param String n, the name of the dictionary file
	* @return HashSet<String> r, a HashSet containing all the words in the dictionary
	*/ 
	private static Set<String> readDictToSet(String n) throws FileNotFoundException{
		
		Set<String> r = new HashSet<String>();
		Scanner f = new Scanner(new File(n));
		while(f.hasNextLine()) {
			
			r.add(f.nextLine().toLowerCase());
			
		}
		f.close();
		return(r);
		
	}
	
	/*
	* A helper method that reads the data from the grid file and
	* stores it into a 2d array
	*
	* @param String n, the name of the grid file
	* @return String[][] r, 2d array containing the grid from the file
	*/ 
	private static String[][] readGridTo2dArray(String n) throws FileNotFoundException{
		
		Scanner f = new Scanner(new File(n));
		int w = Integer.parseInt(f.nextLine());
		int h = Integer.parseInt(f.nextLine());
		String[][] r = new String[w][h];
		for(int i = 0; i < w; i++) {
			
			for(int j = 0; j < h; j++) {
				
				r[i][j] = f.next().toLowerCase();
				
			}
			
		}
		
		return(r);
		
	}
	
	/*
	* A helper method that scans the grid and checks if any combination
	* of letters (left to right, right to left, top to bottom, bottom to
	* top) appears in the dictionary. Returns all words in the grid that do
	* appear in the dictionary in the form of an ArrayList
	*
	* @param String[][] grid, the 2d array containing the grid of words to scan
	* @param Set<String> dict, the set containing all the words from the dictionary file
	* @return ArrayList<String> r, arraylist containing all the words found in both the grid
	* and dictionary file
	*/ 
	private static List<String> checkGridForWords(String[][] grid, Set<String> dict) {
		
		List<String> r = new ArrayList<String>();
		//left to right scan
		for(int i = 0; i < grid.length; i++) {
			
			for(int j = 0; j < grid[0].length - 2; j++) {
				
				String s = grid[i][j] + grid[i][j + 1];
				for(int k = j + 2; k < grid[0].length; k++) {
					
					s += grid[i][k];
					if(dict.contains(s)) {
						
						r.add(s);
						
					}
					
				}
				
			}
			
		}
		//right to left scan
		for(int i = 0; i < grid.length; i++) {
			
			for(int j = grid[0].length - 1; j > 1; j--) {
				
				String s = grid[i][j] + grid[i][j - 1];
				for(int k = j - 2; k >= 0; k--) {
					
					s += grid[i][k];
					if(dict.contains(s)) {
						
						r.add(s);
						
					}
					
				}
				
			}
			
		}
		//top to bottom scan
		for(int i = 0; i < grid[0].length; i++) {
			
			for(int j = 0; j < grid.length - 2; j++) {
				
				String s = grid[j][i] + grid[j + 1][i];
				
				
				for(int k = j + 2; k < grid.length; k++) {
					
					s += grid[k][i];
					if(dict.contains(s)) {
						
						r.add(s);
						
					}
					
				}
				
			}
			
		}
		//bottom to top scan
		for(int i = 0; i < grid[0].length; i++) {
			
			for(int j = grid.length - 1; j > 1; j--) {
				
				String s = grid[j][i] + grid[j - 1][i];
				
				
				for(int k = j - 2; k >= 0; k--) {
					
					s += grid[k][i];
					if(dict.contains(s)) {
						
						r.add(s);
						
					}
					
				}
				
			}
			
		}
		return(r);
		
	}
	
	/*
	* A helper method that prints the wordList (or any arraylist)
	* one element at a time
	*
	* @param List<String> wordList, the arraylist to print
	* @return null
	*/ 
	private static void printWordList(List<String> wordList) {
		
		for(int i = 0; i < wordList.size(); i++) {
			
			System.out.println(wordList.get(i));
			
		}
		
	}
	
}
