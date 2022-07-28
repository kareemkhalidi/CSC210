/*
* AUTHOR: Kareem Khalidi
* PURPOSE: The Song object. Used to play and keep track of songs,
* 		   how many times theyve been played, etc.
*
* USAGE: 
* Create a song object, and use the constructor and methods to 
* manipulate it to fit your purpose.
*/

public class Song {

	private String title;
	private String artist;
	private int timesPlayed;
	
	/*
     * Constructor for Song class
     *
     * @param String title, title of the song
     * @param String artist, songs artist
     * 
     * @return null
     */
	public Song(String title, String artist) {
		
		this.title = title;
		this.artist = artist;
		this.timesPlayed = 0;
		
	}
	
	/*
     * Method to see the title of a song
     * 
     * @return String title
     */
	public String getTitle() {
		
		return(this.title);
		
	}
	
	/*
     * Method to see the artist of a song
     * 
     * @return String artist
     */
	public String getArtist() {
		
		return(this.artist);
		
	}
	
	/*
     * Method to see how many times a song has been played
     * 
     * @return int timesPlayed
     */
	public int getTimesPlayed() {
		
		return(this.timesPlayed);
		
	}
	
	/*
     * Plays the song by printing its string representation, then incrementing
     * the total num of plays for it.
     * 
     * @return null
     */
	public void play() {
		
		System.out.println(this.toString());
		this.timesPlayed += 1;
		
	}
	
	/*
     * Method to represent the song as a string
     * 
     * @return String songAsAString
     */
	public String toString() {
		
		return(this.title + " by " + this.artist + ", " + this.timesPlayed + " play(s)");
		
	}
	
}
