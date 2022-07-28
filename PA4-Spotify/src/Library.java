/*
* AUTHOR: Kareem Khalidi
* PURPOSE: Library object, stores a library of songs. Can be added to,
* 		   removed from, seen as a string, etc
*
* USAGE: 
* Store songs in a library. Holds songs in a list, tells you if a song
* exists in the library, can be represented as a string.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Library {

	private ArrayList<Song> songLibrary;
	
	/*
     * Constructor for the Library object
     * 
     * @return null
     */
	public Library() {
		
		songLibrary = new ArrayList<>();
		
	}
	
	/*
     * Returns song with specified title if it exists in the library
     *
     * @param String title
     * 
     * @return Song songWithSpecifiedTitle
     */
	public Song getSong(String title) {
		
		for(Song song : this.songLibrary) {
			
			if(song.getTitle().equals(title)) {
				
				return(song);
				
			}
			
		}
		
		return(null);
		
	}
	
	/*
     * Adds a song to the library, then sorts it alphabetically
     *
     * @param Song song
     * 
     * @return null
     */
	public void addSong(Song song) {
		
		this.songLibrary.add(song);
		Collections.sort(songLibrary, new Comparator<Song>() {
			
			public int compare(Song song1, Song song2) {
				
				return(song1.getTitle().compareTo(song2.getTitle()));
				
			}
			
		});
		
	}
	
	/*
     * Removes a song from the library
     *
     * @param Song song
     * 
     * @return null
     */
	public void removeSong(Song song) {
		
		this.songLibrary.remove(song);
		
	}
	
	/*
     * Returns a string representation of the library
     * 
     * @return String libraryAsString
     */
	public String toString() {
		
		String r = "";
		for(Song song: this.songLibrary) {
			
			r += song.toString() + "\n";
			
		}
		return(r);
	}
	
}
