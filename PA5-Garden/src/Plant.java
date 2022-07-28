/*
* AUTHOR: Kareem Khalidi
* FILE: Plant.java
* ASSIGNMENT: PA5 - Garden
* COURSE: CSc 210; Spring 2022
* PURPOSE: Plant object to allow creation, growth, removal, etc, of plants in the plot
*
* USAGE: 
* Create new plant object
* Get and/or set the name, grid, size, type
*/

public class Plant {

    private String name;
    private int size;
    private String[] plantGrid;
    private String type;

    /*
     * Constructor for Plant object
     *
     * @param String name
     * 
     * @return null
     */
    public Plant(String name) {
        
        this.size = 1;
        this.name = name.toLowerCase();
        this.plantGrid = new String[] { ".....", ".....", ".....", ".....",
                "....." };
        this.type = "plant";

    }

    /*
     * Updates the plants name with the new name
     *
     * @param String name
     * 
     * @return null
     */
    public void setName(String name) {

        this.name = name;

    }

    /*
     * Updates the specified square in the plantGrid to the specified string
     *
     * @param String s
     * 
     * @param int x
     * 
     * @param int y
     * 
     * @return null
     */
    public void setGrid(String s, int x, int y) {

        plantGrid[x] = plantGrid[x].substring(0, y) + s
                + plantGrid[x].substring(y + 1);

    }

    /*
     * Updates the plants current size to the amount specified
     *
     * @param int size
     * 
     * @return null
     */
    public void setSize(int size) {

        this.size = size;

    }

    /*
     * Updates the plant type to the specified type
     *
     * @param String type
     * 
     * @return null
     */
    public void setType(String type) {

        this.type = type;

    }

    /*
     * Returns the plants name
     * 
     * @return this.name
     */
    public String getName() {

        return (this.name);

    }

    /*
     * Returns the plants grid
     * 
     * @return this.plantGrid
     */
    public String[] getGrid() {

        return (this.plantGrid);

    }

    /*
     * Returns the plants size
     *
     * @return this.size
     */
    public int getSize() {

        return (this.size);
        
    }

    /*
     * Returns the plants type
     * 
     * @return this.type
     */
    public String getType() {

        return (this.type);

    }

    /*
     * Empty method that gets a body in the subclasses
     * 
     * @param int growthRate
     * 
     * @return null
     */
    public void grow(int growthRate) {
    }

}
