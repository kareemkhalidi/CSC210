import java.util.HashSet;
import java.util.Set;

public class Drill07 {

	/*
	 * Takes in a string of the HTML source for a webPage.
	 * Returns a Set<String> containing all of the valid wiki link
	 * titles found in the HTML source.
	 * 
	 * In order for a link to be a valid wikiLink for our case, it must
	 * match the pattern:
	 * <a href="/wiki/Marine_mammal">
	 * and NOT contain the character '#' nor ':'. From the above match, you
	 * would then extract the link name which in this case is:
	 * Marine_mammal
	 * Refer to the testcases for more examples.
	 * 
	 * The fact that the input to this parameter is HTML is largely
	 * irrelevant to this function. It is just a string processing function.
	 * You take in a string, and need to search for matches to a specific
	 * pattern in that string. We went through a brief description of HTML
	 * in class if you are curious.
	 * 
	 * Your first job is to pass all of the tests. This means you either have
	 * a functionally correct algorithm, or are close to one. However, performance
	 * and efficiency will be very important for this PA. After finding a functionally
	 * correct algorithm, spend time designing other approaches to see if
	 * you can determine a more efficient approach. It will pay off when
	 * writing the PA! i.e. do not do anything inefficient, for
	 * instance, you should only go through the string once.
	 */
	public static Set<String> findWikiLinks(String html) {
		
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
