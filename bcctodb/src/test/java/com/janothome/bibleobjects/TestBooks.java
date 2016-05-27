/**
 * 
 */
package com.janothome.bibleobjects;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import junit.framework.TestCase;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class TestBooks extends TestCase {

	protected Bible bible;
	
	/**
	 * @param name
	 */
	public TestBooks(String name) {
		super(name);
	}
	
	public void testBooksKeysOrder()
    {
		LinkedHashMap<Integer, BibleBook> hashBooks = bible.getBooks();
		// Get a set of the entries
		Set<Entry<Integer, BibleBook>> mapBooks = hashBooks.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleBook>> itBooks = mapBooks.iterator();
		Integer indice = 0;
		// Browse books
		while(itBooks.hasNext()) {
			Entry<Integer, BibleBook> me = itBooks.next();
			Integer bookKey = (Integer) me.getKey();
			BibleBook book = (BibleBook) me.getValue();
			indice++;
			if (bookKey != indice || book.getBookKey() != indice) {
				assertTrue(false);
			}
		}
		assertTrue(true);
    }
}
