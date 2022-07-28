/*
* AUTHOR: Kareem Khalidi
* FILE: MyHashMap.java
* ASSIGNMENT: PA7
* COURSE: CSc 210; Spring 2022
* PURPOSE: generic hashmap implementation
* 
* USAGE: 
* exactly like standard java map.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K, V> {

	public ArrayList<HashNode<K, V>> buckets;
	
	/*
     * constructor for MyHashMap
     * 
     * @return null
     */
	public MyHashMap() {
		
		buckets = new ArrayList<HashNode<K, V>>();
		
		for(int i = 0; i < 8; i++) {
			
			buckets.add(null);
			
		}
		
	}
	
	/*
     * clears all values from map
     * 
     * @return null
     */
	public void clear() {
		
		buckets.clear();
		
		for(int i = 0; i < 8; i++) {
			
			buckets.add(null);
			
		}
		
	}
	
	/*
     * tells user whether the map contains specified key
     *
     * @param K key
     * 
     * @return boolean containsKey
     */
	public boolean containsKey(K key) {
		
		HashNode<K, V> cur = buckets.get(hash(key));
		while(cur != null) {
			
			if(cur.getKey().equals(key)) {
			
				return(true);
			
			}
			cur = cur.getNext();
			
		}
		return(false);
		
	}
	
	/*
     * tells user whether the map contains specified val
     *
     * @param V val
     * 
     * @return boolean containsValue
     */
	public boolean containsValue(V val) {
		
		for(int i = 0; i < buckets.size(); i++) {
			
			HashNode<K, V> cur = buckets.get(i);
			while(cur != null) {
				
				if(cur.getValue().equals(val)) {
				
					return(true);
				
				}
				cur = cur.getNext();
				
			}
			
		}
		return(false);
		
	}
	
	/*
     * gets the value associated with the specified key
     *
     * @param K key
     * 
     * @return V val
     */
	public V get(K key) {
		
		HashNode<K, V> cur = buckets.get(hash(key));
		while(cur != null) {
				
			if(cur.getKey().equals(key)) {
				
				return(cur.getValue());
				
			}
			cur = cur.getNext();
				
		}
		return(null);
		
	}
	
	/*
     * tells user whether the map is empty
     * 
     * @return boolean isEmpty
     */
	public boolean isEmpty() {
		
		for(int i = 0; i < buckets.size(); i++) {
			
			if(buckets.get(i) != null) {
				
				return(false);
				
			}
			
		}
		return(true);
		
	}
	
	/*
     * returns all keys as a set
     * 
     * @return Set<K> keySet
     */
	public Set<K> keySet(){
		
		Set<K> s = new HashSet<K>();
		for(int i = 0; i < buckets.size(); i++) {
			
			HashNode<K, V> cur = buckets.get(i);
			while(cur != null) {
				
				s.add(cur.getKey());
				cur = cur.getNext();
				
			}
			
		}
		return(s);
		
	}
	
	/*
     * prints the map as a table in separate buckets
     * 
     * @return boolean containsKey
     */
	public void printTable() {
		
		int totalconflicts = 0;
		
		for(int i = 0; i < buckets.size(); i++){
			
			String s1 = "Index " + i + ": (";
			String s2 = " conflicts), [";
			int conflicts = 0;
			HashNode<K, V> cur = buckets.get(i);
			while(cur != null) {
				
				s2 += cur.getKey() + ", ";
				conflicts++;
				cur = cur.getNext();
				
				
			}
			if(conflicts != 0) {
				
				conflicts--;
				
			}
			System.out.println(s1 + conflicts + s2 + "]");
			totalconflicts += conflicts;
			
		}
		
		System.out.println("Total # of conflicts: " + totalconflicts);
		
	}
	
	/*
     * puts the key value pair into the map
     *
     * @param K key
     * @param V val
     * 
     * @return V previousValOfKey
     */
	public V put(K key, V val) {
		
		if(this.containsKey(key)) {
			
			HashNode<K, V> cur = buckets.get(hash(key));
			while(cur != null) {
				
				if(cur.getKey().equals(key)) {
					
					V temp = cur.getValue();
					cur.setValue(val);
					return(temp);
					
				}
				cur = cur.getNext();
				
			}
			
		}
		else {
			
			HashNode<K, V> temp = new HashNode<K, V>(key, val);
			temp.setNext(buckets.get(hash(key)));
			buckets.set(hash(key), temp);
			
		}
		return(null);
		
	}
	
	/*
     * removes the specified key and its value from the map
     *
     * @param K key
     * 
     * @return V valueRemoved
     */
	public V remove(K key) {
		
		if(this.containsKey(key)) {
			
			int keyhash = hash(key);
			HashNode<K, V> cur = buckets.get(keyhash);
			if(cur.getKey().equals(key)) {
			
				V temp = cur.getValue();
				buckets.set(keyhash, cur.getNext());
				return(temp);
			
			}
			else {
			
				while(cur.getNext() != null) {
				
					if(cur.getNext().getKey().equals(key)) {
						
						V temp = cur.getNext().getValue();
						cur.setNext(cur.getNext().getNext());
						return(temp);
						
					}
			
					cur = cur.getNext();
					
				}
			
			}
			
		}
		return(null);
		
	}
	
	/*
     * returns the num of key value pairs in the map
     * 
     * @return int size
     */
	public int size() {
		
		int counter = 0;
		for(int i = 0; i < buckets.size(); i++) {
			
			HashNode<K, V> cur = buckets.get(i);
			while(cur != null) {
				
				counter++;
				cur = cur.getNext();
				
			}
			
		}
		
		return(counter);
		
	}
	
	private int hash(K key) {
		
		int hashCode = key.hashCode();
		int index = hashCode % buckets.size();
		return Math.abs(index);
		
	}
	
}
