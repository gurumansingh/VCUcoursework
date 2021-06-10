package cmsc256;

import java.util.Iterator;

public class HashTableQuadraticProbing<K,V> extends HashTableOpenAddressing<K,V>{

	public int quadraticProbe(int index, K keyIn) {
		boolean found = false;
		int removedStateIndex = -1; 
		int probe = getHashIndex(keyIn);
		int n = 0;

		if(table[index] == null) {
			return index;
		}
		while (!found && table[index] != null) {
			if (table[index].isIn()) {
				if (keyIn.equals(table[index].getKey())) {
					found = true; 
				}else {
					index = ((probe + ((int) Math.pow(n,2))) % table.length);
					n++;
				}
			}
			else if (removedStateIndex == -1) { 
					removedStateIndex = index;
					index = ((probe + ((int) Math.pow(n,2))) % table.length);
					n++;
			}
		}
		
		if ((found = true) || (removedStateIndex == -1)) {
			return index;
		}
		else {
			return removedStateIndex;
		}
	}
	@Override
	public V put(K key, V value) {
		if(key == null || value == null) {
			throw new IllegalArgumentException();
		}
		V oldValue = null;
		Entry<K, V> newEntry = new Entry<K,V>(key, value);
		int index = super.getHashIndex(key);
		index = quadraticProbe(index, key);
		if(table[index] == null || table[index].isRemoved()) {
			table[index] = newEntry;
			numEntries++;
		}
		else {
			oldValue = table[index].getValue();
			table[index].setValue(value);
		}
		if (isFull()) {
			enlargeHashTable();
		}
		return oldValue;
			
	}
	

	@Override
	public V remove(K key) {
		if(contains(key) == false){
			return null;
		}
		V removedValue = null;
		int index = super.getHashIndex(key);
		index = quadraticProbe(index,key);
		if(key.equals(table[index].getKey())) {
			table[index].setToRemoved();
			removedValue = table[index].getValue();
			numEntries--;
		}
		else{
			return null;
		}
		return removedValue;
	}

	@Override
	public V getValue(K key) {
		int index = super.getHashIndex(key);
		index = quadraticProbe(index,key);
		Entry <K, V> item = table[index];
		if ((item != null) && item.isIn())
		return item.getValue();
		
		return null;
	}

	@Override
	public boolean contains(K key) {
		return getValue(key) != null;
	}
	
	public static void main(String[] args){
		HashTableQuadraticProbing<String, Integer> purchases = new HashTableQuadraticProbing<>();		 
		String[] names = {"Pax", "Eleven", "Angel", "Abigail", "Jack"};
		 purchases.put(names[0], 654);
		 purchases.put(names[1], 341);
		 purchases.put(names[2], 70);
		 purchases.put(names[3], 867);
		 purchases.put(names[4], 5309);
		 System.out.println("Contents with linear probing:\n" + purchases.toString());
		 System.out.println("Replaced old value was " + purchases.put(names[1], 170));
		 System.out.println("Contents after changing Eleven to 170:\n"
		 + purchases.toString());
		 System.out.println("Calling getValue() on Pax, Eleven, & Angel:");
		 System.out.println("\tPax: " + purchases.getValue(names[0]));
		 System.out.println("\tEleven: " + purchases.getValue(names[1]));
		 System.out.println("\tAngel: " + purchases.getValue(names[2]));
		 purchases.remove(names[0]);
		 purchases.remove(names[2]);
		 System.out.println("Contents after removing Pax & Angel:\n" + purchases);
		 purchases.put("Gino", 348);
		 System.out.println("Contents after adding Gino:\n" + purchases);
		 Iterator<String> keyIter = purchases.getKeyIterator();
		 Iterator<Integer> valueIter = purchases.getValueIterator();
		 System.out.println("Contents of the hash table:");
		 
		 while(keyIter.hasNext())
			 System.out.println("Key-" + keyIter.next() + " : Value-" + valueIter.next());
	}
}