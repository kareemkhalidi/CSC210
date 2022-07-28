/*
* AUTHOR: Kareem Khalidi
* FILE: WordSearch.java
* ASSIGNMENT: PA1 - Word Search
* COURSE: CSc 210; Spring 2022
* PURPOSE: Reads in a csv file and runs one of two commands on it:
*          one to count the number of entrys in each category,
*          and one to count the number of entrys in each location for
*          a certain category
*
* USAGE: 
* fileName command locationCategory
*
* where fileName is the name of a file with the following format:
*
* ----------- EXAMPLE INPUT -------------
* Input file:
* -------------------------------------------
* | Company,Title,Category,Location,Responsibilities,Minimum Qualifications,RecommendedQualifications
* -------------------------------------------
* 
* The commands available are CATCOUNT, which counts the number of entrys in each category and prints it
* and LOCATIONS category, which prints out all the locations for entrys with the specified categories
* and how many entrys have that location and category.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PA2Main {

    /*
     * The main method where all helper methods are called in order to
     * store the dictionary and grid into data structures, scan the grid
     * for any words that appear in the dictionary, and prints them
     *
     * @param String[] args, the arguments for the program
     * 
     * @return null
     */
    public static void main(String[] args) throws FileNotFoundException {

        String fileName = args[0];
        String command = args[1];
        if (command.toLowerCase().equals("catcount")) {

            catcount(fileName);

        } else if (command.toLowerCase().equals("locations")) {

            String locationsCat = args[2];
            for (int i = 3; i < args.length; i++) {

                locationsCat += " " + args[i];

            }
            locations(fileName, locationsCat);

        } else {

            System.out.println("Invalid Command");

        }

    }

    /*
     * The method for evaluating and printing the CATCOUNT command
     *
     * @param String fileName, the file to perform CATCOUNT on
     * 
     * @return null
     */
    private static void catcount(String fileName) throws FileNotFoundException {

        Scanner f = new Scanner(new File(fileName));
        Map<String, Integer> catcountMap = new HashMap<>();
        ArrayList<String> keys = new ArrayList<>();
        f.nextLine();
        while (f.hasNextLine()) {

            String[] temp = f.nextLine().split(",");
            if (catcountMap.containsKey(temp[2])) {

                catcountMap.replace(temp[2], catcountMap.get(temp[2]) + 1);

            } else {

                catcountMap.put(temp[2], 1);
                keys.add(temp[2]);

            }

        }

        System.out.println("Number of positions for each category");
        System.out.println("-------------------------------------");
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {

            System.out
                    .println(keys.get(i) + ", " + catcountMap.get(keys.get(i)));

        }

    }

    /*
     * The method for evaluating the LOCATIONS command
     *
     * @param String fileName, the name of the file to perform LOCATIONS on
     * 
     * @param String category, the category to perform LOCATIONS on
     * 
     * @return null
     */
    private static void locations(String fileName, String category)
            throws FileNotFoundException {

        Scanner f = new Scanner(new File(fileName));
        Map<String, Integer> locationsMap = new HashMap<>();
        ArrayList<String> keys = new ArrayList<>();
        f.nextLine();
        while (f.hasNextLine()) {

            String[] temp = f.nextLine().split(",");
            if (temp[2].equals(category)) {

                if (locationsMap.containsKey(temp[3])) {

                    locationsMap.replace(temp[3],
                            locationsMap.get(temp[3]) + 1);

                }
                else {

                    locationsMap.put(temp[3], 1);
                    keys.add(temp[3]);

                }

            }

        }

        System.out.println("LOCATIONS for category: " + category);
        System.out.println("-------------------------------------");
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {

            System.out.println(
                    keys.get(i) + ", " + locationsMap.get(keys.get(i)));

        }

    }

}

