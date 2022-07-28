/*
* AUTHOR: Kareem Khalidi
* FILE: Plot.java
* ASSIGNMENT: PA5 - Garden
* COURSE: CSc 210; Spring 2022
* PURPOSE: Plot (2d array) of plants simulating a garden.
* 
* USAGE: 
* Create a new plot
* Add plants to the plot
* Grow the plants
* Pick/cut/harvest the plants
* Print the plot
*/

public class Plot {

    private int rows;
    private int columns;
    private Plant[][] plot;

    /*
     * Constructor for Plot object
     *
     * @param int rows
     * 
     * @param int columns
     * 
     * @return null
     */
    public Plot(int rows, int columns) {

        this.rows = rows;
        this.columns = columns;
        this.plot = new Plant[rows][columns];
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                plot[i][j] = new Plant("empty");

            }

        }

    }

    /*
     * Places the specified plant in the plot at the specified location
     * 
     * @param Plant p
     * 
     * @param int row
     * 
     * @param int column
     * 
     * @return null
     */
    public void plant(Plant p, int row, int column) {

        if (!(row >= this.rows) || !(column >= this.columns)) {

            this.plot[row][column] = p;

        }

    }

    /*
     * Grows all plants in the plot by the specified amount
     * 
     * @param int growthRate
     * 
     * @return null
     */
    public void grow(int growthRate) {

        for (int i = 0; i < this.rows; i++) {

            for (int j = 0; j < this.columns; j++) {

                plot[i][j].grow(growthRate);

            }

        }

    }

    /*
     * Grows the plant at specified row and column by the growth rate
     * 
     * @param int growthRate
     * 
     * @param int row
     * 
     * @param int column
     * 
     * @return null
     */
    public void grow(int growthRate, int row, int column) {

        if (row >= this.rows || column >= this.columns) {

            System.out.println();
            System.out.println("Can't grow there.");

        } else if (plot[row][column].getName().equals("empty")) {

            System.out.println();
            System.out.println("Can't grow there.");

        } else {

            plot[row][column].grow(growthRate);

        }

    }

    /*
     * Grows all plants of the specified type or plant
     * 
     * @param int growthRate
     * 
     * @param String nameOrType
     * 
     * @return null
     */
    public void grow(int growthRate, String nameOrType) {

        for (int i = 0; i < this.rows; i++) {

            for (int j = 0; j < this.columns; j++) {

                if (plot[i][j].getName().equals(nameOrType)
                        || plot[i][j].getType().equals(nameOrType)) {

                    plot[i][j].grow(growthRate);

                }

            }

        }

    }

    /*
     * harvests (removes) all vegetables from the plot
     * 
     * @return null
     */
    public void harvest() {

        for (int i = 0; i < this.rows; i++) {

            for (int j = 0; j < this.columns; j++) {

                if (plot[i][j].getType().equals("vegetable")) {

                    plot[i][j] = new Plant("empty");

                }

            }

        }

    }

    /*
     * Harvests (removes) the vegetable at the specified row and column.
     * If not a vegetable, or out of plot range, prints error message instead
     * 
     * @param int row
     * 
     * @param int column
     * 
     * @return null
     */
    public void harvest(int row, int column) {

        if (row >= this.rows || column >= this.columns) {

            System.out.println();
            System.out.println("Can't harvest there.");

        } else if (!plot[row][column].getType().equals("vegetable")) {

            System.out.println();
            System.out.println("Can't harvest there.");

        } else {

            plot[row][column] = new Plant("empty");

        }

    }

    /*
     * Harvests (removes) all vegetables of the specified type
     * 
     * @param String name
     * 
     * @return null
     */
    public void harvest(String name) {

        for (int i = 0; i < this.rows; i++) {

            for (int j = 0; j < this.columns; j++) {

                if (plot[i][j].getName().equals(name)) {

                    plot[i][j] = new Plant("empty");

                }

            }

        }

    }

    /*
     * Picks (removes) all flowers from the plot
     * 
     * @return null
     */
    public void pick() {

        for (int i = 0; i < this.rows; i++) {

            for (int j = 0; j < this.columns; j++) {

                if (plot[i][j].getType().equals("flower")) {

                    plot[i][j] = new Plant("empty");

                }

            }

        }

    }

    /*
     * Picks (removes) the flowers at the specified row and column.
     * If not a flower, or out of plot range, prints error message instead
     * 
     * @param int row
     * 
     * @param int column
     * 
     * @return null
     */
    public void pick(int row, int column) {

        if (row >= this.rows || column >= this.columns) {

            System.out.println();
            System.out.println("Can't pick there.");

        } else if (!plot[row][column].getType().equals("flower")) {

            System.out.println();
            System.out.println("Can't pick there.");

        } else {

            plot[row][column] = new Plant("empty");

        }

    }

    /*
     * Picks (removes) all flowers of the specified type
     * 
     * @param String name
     * 
     * @return null
     */
    public void pick(String name) {

        for (int i = 0; i < this.rows; i++) {

            for (int j = 0; j < this.columns; j++) {

                if (plot[i][j].getName().equals(name)) {

                    plot[i][j] = new Plant("empty");

                }

            }

        }

    }

    /*
     * Cuts (removes) all trees from the plot
     * 
     * @return null
     */
    public void cut() {

        for (int i = 0; i < this.rows; i++) {

            for (int j = 0; j < this.columns; j++) {

                if (plot[i][j].getType().equals("tree")) {

                    plot[i][j] = new Plant("empty");

                }

            }

        }

    }

    /*
     * Cuts (removes) the tree at the specified row and column.
     * If not a tree, or out of plot range, prints error message instead
     * 
     * @param int row
     * 
     * @param int column
     * 
     * @return null
     */
    public void cut(int row, int column) {

        if (row > this.rows || column > this.columns) {

            System.out.println();
            System.out.println("Can't cut there.");

        } else if (!plot[row][column].getType().equals("tree")) {

            System.out.println();
            System.out.println("Can't cut there.");

        } else {

            plot[row][column] = new Plant("empty");

        }

    }

    /*
     * Cuts (removes) all trees of the specified type
     * 
     * @param String name
     * 
     * @return null
     */
    public void cut(String name) {

        for (int i = 0; i < this.rows; i++) {

            for (int j = 0; j < this.columns; j++) {

                if (plot[i][j].getName().equals(name)) {

                    plot[i][j] = new Plant("empty");

                }

            }

        }

    }

    /*
     * Prints the plot
     * 
     * @return null
     */
    public void print() {

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < 5; j++) {

                for (int k = 0; k < columns; k++) {

                    System.out.print(plot[i][k].getGrid()[j]);

                }
                System.out.println();

            }
            
        }

    }

}
