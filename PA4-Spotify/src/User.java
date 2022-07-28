/*
* AUTHOR: Kareem Khalidi
* PURPOSE: User object. Keeps track of a user and their playlists, name,
* 		   and password.
*
* USAGE: 
* Construct a user using the constructor, passing in a name and password. Then, you can
* attempt to login, get the name and playlists, get a string representation of the user, 
* or play a playlist.
*/

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private String password;
	private ArrayList<Playlist> playlists;
	
	/*
     * Constructor for the User object
     *
     * @param String name
     * @param String password
     * 
     * @return null
     */
	public User(String name, String password) {
		
		this.name = name;
		this.password = password;
		this.playlists = new ArrayList<Playlist>();
		
	}
	
	/*
     * Returns the name of the user
     * 
     * @return String name
     */
	public String getName() {
		
		return(this.name);
		
	}
	
	/*
     * Attempts to log a user in, if the password provided matches the users password, 
     * a log in attempt is considered successful.
     *
     * @param String password
     * 
     * @return boolean didTheLoginSucceed
     */
	public boolean attemptLogin(String password) {
		
		if(this.password.equals(password)) {
			
			return(true);
			
		}
		else {
			
			return(false);
			
		}
		
	}
	
	/*
     * Adds a playlists to the users collection of playlists
     *
     * @param Playlist playlist
     * 
     * @return null
     */
	public void addPlaylist(Playlist newPlaylist) {
		
		this.playlists.add(newPlaylist);
		
	}
	
	/*
     * Returns the list of all of this users playlists
     * 
     * @return List<Playlist> userPlaylists
     */
	public List<Playlist> getPlaylists() {
		
		return(this.playlists);
		
	}
	
	/*
     * Selects a playlist to play and plays it
     *
     * @param String name
     * 
     * @return null
     */
	public void selectPlaylist(String name) {
		
		for(Playlist playlist : this.playlists) {
			
			if(playlist.getName().equals(name)) {
				
				playlist.play();
				break;
				
			}
			
		}
		
	}
	/*
     * Represents the user as a string
    * 
    * @return String userAsString
    */
	public String toString() {
		
		return(this.name + ", " + this.playlists.size() + " playlists");
		
	}
	
}
