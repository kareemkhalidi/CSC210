/*
* AUTHOR: Kareem Khalidi
* FILE: Vegetable.java
* ASSIGNMENT: PA5 - Garden
* COURSE: CSc 210; Spring 2022
* PURPOSE: Vegetable object to be planted in the plot. Extends the plant class, and overrides its grow method.
* 
* USAGE: 
* Create new vegetable object
* Get and/or set the name, grid, size, type
* Grow the vegetable
*/

public class Vegetable extends Plant {

    /*
     * Constructor for Vegetable object
     *
     * @param String name
     * 
     * @return null
     */
    public Vegetable(String name) {

        super(name);
        this.setGrid(this.getName().substring(0, 1), 0, 2);
        this.setType("vegetable");

    }

    /*
     * Grows the vegetable by the specified size by increasing its size variable
     * and updating its plot to match the new size.
     * 
     * @param int growthRate
     * 
     * @return null
     */
    public void grow(int growthRate) {

        for (int i = 0; i < growthRate; i++) {

            this.setSize(this.getSize() + 1);

            if (this.getSize() == 2) {

                this.setGrid(this.getName().substring(0, 1), 1, 2);

            } else if (this.getSize() == 3) {

                this.setGrid(this.getName().substring(0, 1), 2, 2);

            } else if (this.getSize() == 4) {

                this.setGrid(this.getName().substring(0, 1), 3, 2);

            } else if (this.getSize() == 5) {

                this.setGrid(this.getName().substring(0, 1), 4, 2);

            }

        }

    }

}
