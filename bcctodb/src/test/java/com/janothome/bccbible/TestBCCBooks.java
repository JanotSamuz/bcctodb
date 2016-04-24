/**
 * 
 */
package com.janothome.bccbible;

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

import com.janothome.bccbible.BCCBible;
import com.janothome.bibleobjects.BibleBook;
import com.janothome.bibleobjects.TestBooks;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class TestBCCBooks extends TestBooks {
	
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
		this.bible = new BCCBible();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBCCBooksNumber()
    {
		LinkedHashMap<Integer, BibleBook> hashBooks = bible.getBooks();
		assertTrue(hashBooks.size() == 77);
    }
	
	
	
	public void testBCCBooksName() throws Exception
    {
		LinkedHashMap<Integer, BibleBook> hashBooks = bible.getBooks();
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
				e.printStackTrace();
				assertTrue(false);
			}
			Document doc = Jsoup.parse(xhtmlText);
			Element el = doc.select("h2").last();
			String titleBookFromXhtml = new String();
			if (el == null) {
				throw new Exception("Unexpected error when reading XTHML file.");
			} else {
				titleBookFromXhtml = el.text();
			}
			if (!book.getBookName().equals(titleBookFromXhtml)) {
				assertTrue(false);
			}
		}
		assertTrue(true);
    }
	
	public void testBCCBooksContent() throws Exception
    {
		LinkedHashMap<Integer, BibleBook> hashBooks = bible.getBooks();
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
				e.printStackTrace();
				assertTrue(false);
			}
			Document doc = Jsoup.parse(xhtmlText);
			Element el = doc.select("body").first();
			String bodyBookFromXhtml = new String();
			if (el == null) {
				throw new Exception("Unexpected error when reading XTHML file.");
			} else {
				bodyBookFromXhtml = el.html();
			}
			if (!book.toString().equals(bodyBookFromXhtml)) {
				assertTrue(false);
			}
		}
		assertTrue(true);
    }
	
}
