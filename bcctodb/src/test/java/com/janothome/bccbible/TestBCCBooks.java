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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.janothome.bccbible.BCCBible;
import com.janothome.bibleobjects.BibleBook;
import com.janothome.bibleobjects.BibleChapter;
import com.janothome.bibleobjects.TestBooks;
import com.janothome.bibleobjects.BibleChapter.TypeChapter;

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
			Element el = null;
			String titleBookH2FromXhtml = null;
			String titleBookHEADFromXhtml = null;
			
			titleBookHEADFromXhtml = doc.title();
			
			el = doc.select("h2").last();
			titleBookH2FromXhtml = new String();
			if (el == null) {
				throw new Exception("Unexpected error when reading XTHML file.");
			} else {
				titleBookH2FromXhtml = el.text();
			}
			
			/*el = doc.select("title").first();
			titleBookHEADFromXhtml = new String();
			if (el == null) {
				throw new Exception("Unexpected error when reading XTHML file.");
			} else {
				titleBookHEADFromXhtml = el.text();
			}*/
			
			if (!book.getBookName().equals(titleBookH2FromXhtml) || !book.getBookName().equals(titleBookHEADFromXhtml)) {
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
	
	public void testBCCChaptersNumber() throws Exception
    {
		TypeChapter psaume = TypeChapter.PSAUME;
		Integer lastPsaumesCounter = 0;
		Integer psaumesCounter = 0;
		Integer indicePsaumesBooks = 0;
		
		LinkedHashMap<Integer, BibleBook> hashBooks = bible.getBooks();
		// Get a set of the entries
		Set<Entry<Integer, BibleBook>> mapBooks = hashBooks.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleBook>> itBooks = mapBooks.iterator();
		// Browse books
		while(itBooks.hasNext()) {
			Entry<Integer, BibleBook> me = itBooks.next();
			//Integer bookKey = (Integer) me.getKey();
			BibleBook book = (BibleBook) me.getValue();
			
			if (book.getBookAbbreviation() == psaume.getAbreviation()) {
				indicePsaumesBooks++;
				if (indicePsaumesBooks >= 2) {
					psaumesCounter = psaumesCounter + lastPsaumesCounter;
				}
				lastPsaumesCounter = book.getNumberOfChapters();
			}
			
			LinkedHashMap<Integer, BibleChapter> hashChapters = book.getChapters();
			// Get a set of the entries
			Set<Entry<Integer, BibleChapter>> mapChapters = hashChapters.entrySet();
			// Get an iterator
			Iterator<Entry<Integer, BibleChapter>> itChapters = mapChapters.iterator();
			
			if (!book.isWithoutChapitres()) {
				// Test pour les livres avec des chapitres
				// Browse chapters
				while(itChapters.hasNext()) {
					Entry<Integer, BibleChapter> meSub = itChapters.next();
					BibleChapter chapter = (BibleChapter) meSub.getValue();
					
					String chapterTitle = chapter.getChapterName();
					String regexChapitre = "(?:Psaume |Chapitre )(\\d*)";
					Pattern pChapitre = Pattern.compile(regexChapitre);
					Matcher mChapitre = pChapitre.matcher(chapterTitle);
					if (mChapitre.groupCount() != 1) {
						assertTrue(false);
					}
					Integer indiceTagChapitres = 0;
					while (mChapitre.find()) {
						indiceTagChapitres++;
						String chapterNumberStr = mChapitre.group(1);
						if (book.getBookAbbreviation() == psaume.getAbreviation() && indicePsaumesBooks > 1) {
							if ((chapter.getChapterNumber() + psaumesCounter) != Integer.parseInt(chapterNumberStr)) {
								assertTrue(false);
							}
						} else {
							if (chapter.getChapterNumber() != Integer.parseInt(chapterNumberStr)) {
								assertTrue(false);
							}
						}
					}
					if (indiceTagChapitres != 1) {
						assertTrue(false);
					}
				}
			} else {
				// Test pour les livres sans chapitres
				// Browse chapters (only one !)
				while(itChapters.hasNext()) {
					Entry<Integer, BibleChapter> meSub = itChapters.next();
					BibleChapter chapter = (BibleChapter) meSub.getValue();
					if (chapter.getChapterNumber() != 1) {
						assertTrue(false);
					}
				}
			}
		}
		assertTrue(true);
    }
	
	public void testBCCBooksWithoutChapters() throws Exception
    {
		LinkedHashMap<Integer, BibleBook> hashBooks = bible.getBooks();
		// Get a set of the entries
		Set<Entry<Integer, BibleBook>> mapBooks = hashBooks.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleBook>> itBooks = mapBooks.iterator();
		// Browse books
		while(itBooks.hasNext()) {
			Entry<Integer, BibleBook> me = itBooks.next();
			//Integer bookKey = (Integer) me.getKey();
			BibleBook book = (BibleBook) me.getValue();
			
			LinkedHashMap<Integer, BibleChapter> hashChapters = book.getChapters();
			
			if (book.isWithoutChapitres() && hashChapters.size() != 1) {
				assertTrue(false);
			}
			
			// Get a set of the entries
			Set<Entry<Integer, BibleChapter>> mapChapters = hashChapters.entrySet();
			// Get an iterator
			Iterator<Entry<Integer, BibleChapter>> itChapters = mapChapters.iterator();
			
			// Browse chapters (only one !)
			while(itChapters.hasNext()) {
				Entry<Integer, BibleChapter> meSub = itChapters.next();
				BibleChapter chapter = (BibleChapter) meSub.getValue();
				
				// aucun titre du chapitre n'est attendu ici
				String chapterTitle = chapter.getChapterName();
				// TODO Revoir le titre du chapitre (dans le constructeur BibleChapter) dans le cas d'un livre sans chapitre - utiliser une constante ?!
				if (book.isWithoutChapitres() && chapterTitle != null && chapterTitle.length() != 0) {
					assertTrue(false);
				}
			}
		}
		assertTrue(true);
    }
}
