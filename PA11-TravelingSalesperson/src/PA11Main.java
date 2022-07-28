/*
* AUTHOR: Kareem Khalidi
* FILE: TravelingSalesperson.java
* ASSIGNMENT: PA11
* COURSE: CSc 210; Spring 2022
* PURPOSE:
* Find the shortest trip possible for the input file
* using the specified algorithm.
* 
* USAGE: 
* Put the name of the input file in args[0] and the
* algorithm to use (HEURISTIC, BACKTRACK, MINE, or TIME)
* in args[1], then run the program.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PA11Main {

    public static void main(String[] args) throws FileNotFoundException {

        DGraph g = extractData(new File(args[0]));

        if (args[1].equalsIgnoreCase("heuristic")) {

            Trip t = heuristic(g);
            System.out.println(t.toString(g));

        } else if (args[1].equalsIgnoreCase("backtrack")) {

            Trip t = backtrack(g);
            System.out.println(t.toString(g));

        } else if (args[1].equalsIgnoreCase("mine")) {

            Trip t = mine(g);
            System.out.println(t.toString(g));

        } else if (args[1].equalsIgnoreCase("time")) {

            time(g);

        }

    }

    /*
     * Puts the data from the input file into a DGraph
     *
     * @param File f, the file to get data from
     * 
     * @return DGraph g, the graph representation of the file data
     */
    private static DGraph extractData(File f) throws FileNotFoundException {

        Scanner s = new Scanner(f);
        String comment = s.nextLine();
        while (comment.charAt(0) == '%' && !s.hasNextInt()) {
            
            comment = s.nextLine();

        }
        DGraph g = new DGraph(s.nextInt());
        s.nextLine();
        while (s.hasNextInt()) {

            int startNode = s.nextInt();
            int endNode = s.nextInt();
            double distance = s.nextDouble();
            g.addEdge(startNode, endNode, distance);

        }
        s.close();
        return (g);

    }

    /*
     * Finds the shortest path using the heuristic algorithm
     *
     * @param DGraph g, the graph representing the citys and their distances
     * 
     * @return Trip t, the shortest trip possible
     */
    private static Trip heuristic(DGraph g) {

        Trip t = new Trip(g.getNumNodes());
        t.chooseNextCity(1);
        int curCity = 1;

        for (int i = 2; i <= g.getNumNodes(); i++) {

            int closestCity = -1;
            double distance = Integer.MAX_VALUE;
            for (int j : g.getNeighbors(curCity)) {

                if (g.getWeight(curCity, j) < distance
                        && t.isCityAvailable(j)) {

                    closestCity = j;
                    distance = g.getWeight(curCity, j);

                }

            }

            t.chooseNextCity(closestCity);
            curCity = closestCity;

        }

        return (t);

    }

    /*
     * Finds the shortest path using the recursive backtracking algorithm
     *
     * @param DGraph g, the graph representing the citys and their distances
     * 
     * @return Trip t, the shortest trip possible
     */
    private static Trip backtrack(DGraph g) {

        Trip t = new Trip(g.getNumNodes());
        t.chooseNextCity(1);
        Trip min = new Trip(g.getNumNodes());
        backtrack(g, t, min);
        return (min);

    }

    /*
     * The recursive part of the backtrack method
     *
     * @param DGraph g, the graph representing the citys and their distances
     * 
     * @param Trip cur, the trip representing the current recursive case
     * 
     * @param Trip min, the shortest trip found so far
     */
    private static void backtrack(DGraph g, Trip cur, Trip min) {

        if (cur.citiesLeft().size() == 0) {

            if (cur.tripCost(g) < min.tripCost(g)) {

                min.copyOtherIntoSelf(cur);

            }

        }

        if (cur.tripCost(g) < min.tripCost(g)) {

            for (int c : cur.citiesLeft()) {

                cur.chooseNextCity(c);
                backtrack(g, cur, min);
                cur.unchooseLastCity();

            }

        }

    }

    /*
     * Finds the shortest path using the recursive backtracking algorithm.
     * This method is a more optimized version of the corresponding backtrack
     * method.
     *
     * @param DGraph g, the graph representing the citys and their distances
     * 
     * @return Trip t, the shortest trip possible
     */
    private static Trip mine(DGraph g) {

        Trip t = new Trip(g.getNumNodes());
        t.chooseNextCity(1);
        Trip min = heuristic(g);
        mine(g, t, min);
        return (min);

    }

    /*
     * The recursive part of the mine method.
     * This method is a more optimized version of the corresponding backtrack
     * method.
     *
     * @param DGraph g, the graph representing the citys and their distances
     * 
     * @param Trip cur, the trip representing the current recursive case
     * 
     * @param Trip min, the shortest trip found so far
     */
    private static void mine(DGraph g, Trip cur, Trip min) {

        if (cur.citiesLeft().size() == 0 && cur.tripCost(g) < min.tripCost(g)) {

            min.copyOtherIntoSelf(cur);

        }
        else {

            for (int c : cur.citiesLeft()) {

                cur.chooseNextCity(c);
                if (cur.tripCost(g) < min.tripCost(g)) {

                    mine(g, cur, min);

                }
                cur.unchooseLastCity();

            }

        }

    }


    /*
     * Tests all 3 algorithms and prints how long each one takes to run
     *
     * @param DGraph g, the graph representing the citys and their distances
     */
    private static void time(DGraph g) {

        long duration = 0;
        Trip t = new Trip(1);
        for (int i = 0; i < 100; i++) {

            long startTime = System.nanoTime();
            t = heuristic(g);
            long endTime = System.nanoTime();
            duration += (endTime - startTime);

        }
        duration /= 50000000;
        System.out.println("heuristic: cost = " + t.tripCost(g) + ", "
                + duration + " milliseconds");

        duration = 0;
        t = new Trip(1);
        for (int i = 0; i < 100; i++) {

            long startTime = System.nanoTime();
            t = mine(g);
            long endTime = System.nanoTime();
            duration += (endTime - startTime);

        }
        duration /= 50000000;
        System.out.println("mine: cost = " + t.tripCost(g) + ", " + duration
                + " milliseconds");

        duration = 0;
        t = new Trip(1);
        for (int i = 0; i < 100; i++) {

            long startTime = System.nanoTime();
            t = backtrack(g);
            long endTime = System.nanoTime();
            duration += (endTime - startTime);
        
        }
        duration /= 50000000;
        System.out.println("backtrack: cost = " + t.tripCost(g) + ", "
                + duration + " milliseconds");

    }

}
