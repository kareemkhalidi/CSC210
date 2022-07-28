
public class test {

	public static void main(String args[]) {
		
		MyHashMap<String, Integer> m = new MyHashMap<String, Integer>();
		System.out.println(m.isEmpty());
		m.put("a", 1);
		m.put("i", 2);
		System.out.println(m.isEmpty());
		m.printTable();
		
		
	}
	
	
	
}
