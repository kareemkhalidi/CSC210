/*
* AUTHOR: Kareem Khalidi
* FILE: WikiRacer.java
* ASSIGNMENT: PA10
* COURSE: CSc 210; Spring 2022
* PURPOSE: Given 2 wikipedia pages, finds a path of links
* 		   between the 2.
* 
* USAGE: 
* Put the start link in args[0] and the end link in args[1].
* Run program, and output in console is a path of links between
* the pages.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WikiRacer {

	/*
	 * Do not edit this main function
	 */
	public static void main(String[] args) throws Exception {
		List<String> ladder = findWikiLadder(args[0], args[1]);
		System.out.println(ladder);
	}
	
	/*
	 * Do not edit the method signature/header of this function
	 * TODO: Fill this function in.
	 */
	private static List<String> findWikiLadder(String start, String end) throws Exception {
		
		//MaxPQ object to store our ladders
		MaxPQ lpq = new MaxPQ();
		
		//initializing the max pq with the start ladder
		List<String> ladder = new ArrayList<>();
		ladder.add(start.toLowerCase());
		lpq.enqueue(ladder, 0);
		
		//while loop to iterate through the max pq until there are no ladders left
		while(!(lpq.isEmpty())) {
			
			//takes the highest priority partial ladder from the maxpq and gets all the 
			//links on the last page in the ladder
			List<String> partialLadder = lpq.dequeue();
			Set<String> links = WikiScraper.findWikiLinks(partialLadder.get(partialLadder.size() - 1));
			
			//if the end link is one of the links on this page, add it to the partial ladder to complete
			//it and then return the completed ladder to the user. (makes sure to fix capitalization in
			//first link because it was converted to lowercase when being added to the maxpq.
			if(links.contains(end)) {
				
				partialLadder.add(end);
				String[] s = partialLadder.get(0).split("_");
				String startCap = "";
				for(int i = 0; i < s.length; i++) {
					
					startCap += s[i].substring(0, 1).toUpperCase() + s[i].substring(1).toLowerCase();
					
				}
				partialLadder.set(0, startCap);
				return(partialLadder);
				
			}
			
			//memoization, filling the Map with all the links on that page
			links.parallelStream().forEach(link -> {
				WikiScraper.findWikiLinks(link);
				});
			
			//for each link on this page, add it to the partial ladder and add that new ladder
			//to the maxpq with a priority equal to the amount of links that link has in common
			//with the end link
			for(String link : links) {
				
				List<String> tempLadder = new ArrayList<>(partialLadder);
				tempLadder.add(link);
				lpq.enqueue(tempLadder, similarity(link, end));
				
			}
			
		}
		
		return new ArrayList<String>();
		
	}
	
	/*
	 * Returns the similarity of the 2 specified pages.
	 * 
	 * @param String p1 - the first page to check the similarity of
	 * @param String p2 - the second page to check the similarity of
	 * 
	 * @return int similarity - how similar 2 pages are
	 */
	private static int similarity(String p1, String p2) {
		
		Set<String> links = WikiScraper.findWikiLinks(p1);
		links.retainAll(WikiScraper.findWikiLinks(p2));
		return(links.size());
		
	}

}
