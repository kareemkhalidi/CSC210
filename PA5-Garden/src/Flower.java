/*
* AUTHOR: Kareem Khalidi
* FILE: Flower.java
* ASSIGNMENT: PA5 - Garden
* COURSE: CSc 210; Spring 2022
* PURPOSE: Flower object to be planted in the plot. Extends the plant class, and overrides its grow method.
* 
* USAGE: 
* Create new flower object
* Get and/or set the name, grid, size, type
* Grow the flower
*/

public class Flower extends Plant {

    /*
     * Constructor for Flower object
     *
     * @param String name
     * 
     * @return null
     */
    public Flower(String name) {

        super(name);
        this.setGrid(this.getName().substring(0, 1), 2, 2);
        this.setType("flower");

    }

    /*
     * Grows the flower by the specified size by increasing its size variable
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

                this.growSize2();

            } else if (this.getSize() == 3) {

                this.growSize3();

            } else if (this.getSize() == 4) {

                this.growSize4();

            } else if (this.getSize() == 5) {

                this.growSize5();

            }

        }

    }

    /*
     * Helper method for growing a flower to size 2
     * 
     * @return null
     */
    private void growSize2() {

        this.setGrid(this.getName().substring(0, 1), 2, 1);
        this.setGrid(this.getName().substring(0, 1), 1, 2);
        this.setGrid(this.getName().substring(0, 1), 2, 3);
        this.setGrid(this.getName().substring(0, 1), 3, 2);

    }

    /*
     * Helper method for growing a flower to size 3
     * 
     * @return null
     */
    private void growSize3() {

        this.setGrid(this.getName().substring(0, 1), 0, 2);
        this.setGrid(this.getName().substring(0, 1), 1, 1);
        this.setGrid(this.getName().substring(0, 1), 1, 3);
        this.setGrid(this.getName().substring(0, 1), 2, 0);
        this.setGrid(this.getName().substring(0, 1), 2, 4);
        this.setGrid(this.getName().substring(0, 1), 3, 1);
        this.setGrid(this.getName().substring(0, 1), 3, 3);
        this.setGrid(this.getName().substring(0, 1), 4, 2);

    }

    /*
     * Helper method for growing a flower to size 4
     * 
     * @return null
     */
    private void growSize4() {

        this.setGrid(this.getName().substring(0, 1), 0, 1);
        this.setGrid(this.getName().substring(0, 1), 0, 3);
        this.setGrid(this.getName().substring(0, 1), 1, 0);
        this.setGrid(this.getName().substring(0, 1), 1, 4);
        this.setGrid(this.getName().substring(0, 1), 3, 0);
        this.setGrid(this.getName().substring(0, 1), 3, 4);
        this.setGrid(this.getName().substring(0, 1), 4, 1);
        this.setGrid(this.getName().substring(0, 1), 4, 3);

    }

    /*
     * Helper method for growing a flower to size 5
     * 
     * @return null
     */
    private void growSize5() {

        this.setGrid(this.getName().substring(0, 1), 0, 0);
        this.setGrid(this.getName().substring(0, 1), 0, 4);
        this.setGrid(this.getName().substring(0, 1), 4, 0);
        this.setGrid(this.getName().substring(0, 1), 4, 4);

    }

}
