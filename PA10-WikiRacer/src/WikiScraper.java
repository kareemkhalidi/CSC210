/*
* AUTHOR: Kareem Khalidi
* FILE: WikiScraper.java
* ASSIGNMENT: PA10
* COURSE: CSc 210; Spring 2022
* PURPOSE: Finds all the links on the provided wikipedia link
* 
* USAGE: 
* Call WikiScraper.findWikiLinks(String link), inputting the link to
* the page you want to find all the links form the return value is a Set
* of all the links found on the page.
*/

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WikiScraper {
	
	//memoization implementation storing all the links that have already been scraped
	private static Map<String, Set<String>> memoMap = new HashMap<>();
	
	/*
	 * Returns all links found on the input link
	 * 
	 * @param String link - the page to find the links on
	 * 
	 * @return Set<String> links - a set of all the links found
	 */
	public static Set<String> findWikiLinks(String link) {
		
		if(memoMap.containsKey(link)) {
			
			return(memoMap.get(link));
			
		}
		else {
			
			String html = fetchHTML(link);
			Set<String> links = scrapeHTML(html);
			memoMap.put(link, links);
			return links;
			
		}
		
	}
	
	/*
	 * Returns the html representation of the input links page
	 * 
	 * @param String link - the page to return the html of
	 * 
	 * @return String html - html representation of the input link
	 */
	private static String fetchHTML(String link) {
		StringBuffer buffer = null;
		try {
			URL url = new URL(getURL(link));
			InputStream is = url.openStream();
			int ptr = 0;
			buffer = new StringBuffer();
			while ((ptr = is.read()) != -1) {
			    buffer.append((char)ptr);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return buffer.toString();
	}
	
	/*
	 * Takes in the name of the page and returns its full url
	 * 
	 * @param String link - the link we want to get the full url for
	 * 
	 * @return String url - full url for the specified link
	 */
	private static String getURL(String link) {
		return "https://en.wikipedia.org/wiki/" + link;
	}
	
	/*
	 * Goes through html strings and returns all links following
	 * the pattern "a href= "/wiki/"
	 * 
	 * @param String html - the html to search through
	 * 
	 * @return Set<String> links - all the links found in the html
	 */
	private static Set<String> scrapeHTML(String html) {
		
		Set<String> links = new HashSet<String>();
		
		if(html.contains("a href=\"/wiki/")) {
			
			String[] htmlSplit = html.split("a href=\"/wiki/");
			
			for(int i = 0; i < htmlSplit.length; i++) {
			
				if(htmlSplit[i].contains("\"")) {
					
					String s = htmlSplit[i].substring(0, htmlSplit[i].indexOf('"'));
					
					if(!s.contains(":") && !s.contains("#") && !s.contains("<")) {
					
						links.add(s);
					
					}
					
				}
			
			}
			
		}
		
		return(links);
		
	}
	
}
