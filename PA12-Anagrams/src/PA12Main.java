/*
* AUTHOR: Kareem Khalidi
* FILE: PA12Main.java
* ASSIGNMENT: PA12
* COURSE: CSc 210; Spring 2022
* PURPOSE: Finds all valid anagrams for the input word using only
*          words from the provided dictionary and no more than
*          the specified number of words per anagram
* 
* USAGE: 
* args[0] - the dictionary to use
* args[1] - the word to find anagrams for
* args[2] - the max amount of words to use per anagram
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PA12Main {

    public static void main(String[] args) throws FileNotFoundException {

        // extract dictionary from file and save it
        Set<String> dict = extractDict(args[0]);
        // put the word to find anagrams for into a letter inventory
        LetterInventory input = new LetterInventory(args[1]);
        // find and save all the dict words that are in input
        ArrayList<String> wordsInInput = wordsInString(input, dict);
        
        // find and save all valid anagrams
        ArrayList<ArrayList<String>> anagrams = new ArrayList<ArrayList<String>>();
        if (Integer.parseInt(args[2]) == 0) {

            findAnagrams(input, wordsInInput, Integer.MAX_VALUE,
                new ArrayList<String>(), anagrams);

        } else {

            findAnagrams(input, wordsInInput, Integer.parseInt(args[2]),
                    new ArrayList<String>(), anagrams);

        }

        // print the information found in the required format
        System.out.println("Phrase to scramble: " + args[1] + "\n");
        System.out.println("All words found in " + args[1] + ":");
        System.out.println(wordsInInput.toString() + "\n");
        System.out.println("Anagrams for " + args[1] + ":");
        for (ArrayList<String> s : anagrams) {

            System.out.println(s);

        }

    }

    /*
     * Takes a file name and adds all elements in the file to a Set
     * 
     * @param String dictName - the file to extract data from
     * 
     * @return Set<String> dict - all Strings in the file
     */
    public static Set<String> extractDict(String dictName)
            throws FileNotFoundException {

        Set<String> dict = new HashSet<String>();
        Scanner reader = new Scanner(new File(dictName));
        while (reader.hasNext()) {

            dict.add(reader.next());

        }
        return (dict);

    }

    /*
     * Finds all words that appear in the provided dict, AND the input
     * LetterInventory.
     * 
     * @param LetterInventory input - the letter inventory to see if words
     * appear in
     * 
     * @param Set<String> dict - the dictionary of words to check for in input
     * 
     * @return ArrayList<String> words - all the words that appear in the
     * LetterInventory
     * AND the dictionary.
     */
    public static ArrayList<String> wordsInString(LetterInventory input,
            Set<String> dict) {

        ArrayList<String> words = new ArrayList<String>();
        for (String word : dict) {

            if (input.contains(word)) {

                words.add(word);

            }

        }
        words.sort(null);
        return (words);

    }

    /*
     * Finds all the anagrams for the provided LetterInventory.
     * 
     * @param LetterInventory input - letter inventory object of the string to
     * find anagrams for
     * 
     * @param ArrayList<String> wordsInInput - all words found in both the input
     * and the dictionary provided
     * 
     * @param int max - the max length of an anagram
     * 
     * @param ArrayList<String> cur - the current anagram being recursively
     * built
     * 
     * @param ArrayList<ArrayList<String>> anagrams - all anagrams found so far.
     * 
     * @return int similarity - how similar 2 pages are
     */
    @SuppressWarnings("unchecked")
    public static void findAnagrams(
            LetterInventory input, ArrayList<String> wordsInInput, int max,
            ArrayList<String> cur,
            ArrayList<ArrayList<String>> anagrams) {

        if (input.isEmpty()) {

            anagrams.add((ArrayList<String>) cur.clone());

        }

        if (cur.size() < max) {

            for (String s : wordsInInput) {

                if (input.contains(s)) {

                    cur.add(s);
                    input.subtract(s);
                    findAnagrams(input, wordsInInput, max,
                            cur, anagrams);
                    cur.remove(cur.size() - 1);
                    input.add(s);


                }

            }

        }

    }

}
