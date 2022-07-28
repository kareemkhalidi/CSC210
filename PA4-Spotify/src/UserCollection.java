/*
* AUTHOR: Kareem Khalidi
* PURPOSE: Collection of users. Keeps track of all the users in Spotify.
*
* USAGE: 
* Stores a list of all the Users. Can check if a user with specified username already exists,
* attempt to log a user in by verifying if their password and username match, add new users,
* and see a string representation of all users.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserCollection {

	private ArrayList<User> users;
	
	/*
     * Constructor for the UserCollection object
     * 
     * @return null
     */
	public UserCollection() {
		
		this.users = new ArrayList<User>();
		
	}
	
	/*
     * Method for checking if a user exists in the UserCollection
     *
     * @param String username
     * 
     * @return boolean doesTheUserExist
     */
	public boolean userExists(String username) {
		
		for(User user : this.users) {
			
			if(user.getName().equals(username)) {
				
				return(true);
				
			}
			
		}
		
		return(false);
		
	}
	
	/*
     * Attempts to log in a user
     *
     * @param String username
     * @param String password
     * 
     * @return User userThatWasLoggedIn
     */
	public User login(String username, String password) {
		
		for(User user : this.users) {
			
			if(user.getName().equals(username)) {
				
				if(user.attemptLogin(password)) {
					
					return(user);
					
				}
				else {
					
					return(null);
					
				}
				
			}
			
		}
		
		return(null);
		
	}
	
	/*
     * Adds a user to the UserCollection
     *
     * @param User user
     * 
     * @return null
     */
	public void addUser(User user) {
		
		users.add(user);
		Collections.sort(users, new Comparator<User>() {
			
			public int compare(User user1, User user2) {
				
				return(user1.getName().compareTo(user2.getName()));
				
			}
			
		});
		
	}
	
	/*
     * represents the UserCollection as a string
     * 
     * @return String UserCollectionAsString
     */
	public String toString() {
		
		String r = "{ ";
		for(User user : this.users) {
			
			r += user.getName() + ": " + user.getPlaylists().size() + " playlist(s), ";
			
		}
		r += "}";
		return(r);
	}
	
}
