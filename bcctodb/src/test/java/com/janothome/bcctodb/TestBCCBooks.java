/**
 * 
 */
package com.janothome.bcctodb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import junit.framework.TestCase;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class TestBCCBooks extends TestCase {

	private BCCBible bccBible = new BCCBible();
	
	/**
	 * @param name
	 */
	public TestBCCBooks(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBCCBooksNumber()
    {
		LinkedHashMap<Integer, BibleBook> hashBooks = bccBible.getBooks();
		assertTrue(hashBooks.size() == 77);
    }
	
	public void testBCCBooksOrder()
    {
		LinkedHashMap<Integer, BibleBook> hashBooks = bccBible.getBooks();
		// Get a set of the entries
		Set<Entry<Integer, BibleBook>> mapBooks = hashBooks.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleBook>> itBooks = mapBooks.iterator();
		Integer indice = 0;
		// Display elements
		while(itBooks.hasNext()) {
			Entry<Integer, BibleBook> me = itBooks.next();
			Integer bookKey = (Integer) me.getKey();
			indice++;
			if (bookKey != indice) {
				assertTrue(false);
			}
		}
		assertTrue(true);
    }
	
	public void testBCCBooksName() throws Exception
    {
		LinkedHashMap<Integer, BibleBook> hashBooks = bccBible.getBooks();
		// Get a set of the entries
		Set<Entry<Integer, BibleBook>> mapBooks = hashBooks.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleBook>> itBooks = mapBooks.iterator();
		// Display elements
		while(itBooks.hasNext()) {
			Entry<Integer, BibleBook> me = itBooks.next();
			//Integer bookKey = (Integer) me.getKey();
			BibleBook book = (BibleBook) me.getValue();
			String xhtmlText = new String();
			ClassLoader classLoader = getClass().getClassLoader();
			try {
				xhtmlText = IOUtils.toString((InputStream) classLoader.getResource("xhtml/"+book.getSourceFile()).getContent(), "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Document doc = Jsoup.parse(xhtmlText);
			//Elements elements = doc.select("body").first().children();
			//for (Element el : elements)
			//Element el = elements.first();
			Element el = doc.select("h2").last();
			String titleBookFromXhtml = new String();
			if (el == null) {
				throw new Exception("Unexpected error when reading XTHML file.");
			} else {
				titleBookFromXhtml = el.text();
			}
			if (!book.geBookName().equals(titleBookFromXhtml)) {
				assertTrue(false);
			}
		}
		assertTrue(true);
    }
	
}
