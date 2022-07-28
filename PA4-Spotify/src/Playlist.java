/*
* AUTHOR: Kareem Khalidi
* PURPOSE: Playlist object. Stores a list of songs. Has a name to identify it.
* 		   Can play all the songs in list, and also do everything library can
* 		   except for get a certain song from the playlist
*
* USAGE: 
* Create the playlist and add or remove songs to it. Can play all songs in the list,
* or get the playlists name.
*/

import java.util.ArrayList;
import java.util.List;

public class Playlist {

	private String name;
	private List<Song> contents;
	
	/*
     * Constructor for Playlist object for a playlist with 0 initial songs
     *
     * @param String name
     * 
     * @return null
     */
	public Playlist(String name) {
		
		this.name = name;
		this.contents = new ArrayList<Song>();
		
	}
	
	/*
     * Constructor for Playlist object for a playlist with initial songs
     *
     * @param String name
     * @param List<Song> contents
     * 
     * @return null
     */
	public Playlist(String name, List<Song> contents) {
		
		this.name = name;
		this.contents = new ArrayList<Song>(contents);
		
	}
	
	/*
     * Returns the name of the playlist
     * 
     * @return String name
     */
	public String getName() {
		
		return(this.name);
		
	}
	
	/*
     * Adds a song to the playlist
     *
     * @param Song song
     * 
     * @return null
     */
	public void addSong(Song song) {
		
		this.contents.add(song);
		
	}
	
	/*
     * Plays all songs in the playlist
     * 
     * @return null
     */
	public void play() {
		
		for(Song song : this.contents) {
			
			song.play();
			
		}
		
	}
	
	/*
     * Removes a song from the playlist
     *
     * @param Song song
     * 
     * @return null
     */
	public void removeSong(Song song) {
		
		this.contents.remove(song);
		
	}
	
}
