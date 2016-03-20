/**
 * 
 */
package com.janothome.bcctodb;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class BibleBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String 	bookName;			// unique
	private String 	bookAbbreviation;	// unique
    private Integer bookNumber;
    private String 	bookTestament;
    private String 	sourceFile;
    private String 	booksIntroduction;
    private String 	bookIntroduction;
    private LinkedHashMap<Integer, BibleChapter> hashChapters;
	
	/**
	 * @param bookName
	 * @param bookAbbreviation
	 * @param bookNumber
	 * @param bookTestament
	 * @param sourceFile
	 */
	public BibleBook(String bookName, String bookAbbreviation, Integer bookNumber, String bookTestament,
			String sourceFile) {
		super();
		
		setBookName(bookName);
		setBookAbbreviation(bookAbbreviation);
		setBookNumber(bookNumber);
		setBookTestament(bookTestament);
		setSourceFile(sourceFile);
		
		initHashChapters();
	}

	/**
	 * @param bookName
	 */
	public BibleBook(String bookName) {
		super();
		
		setBookName(bookName);
		
		initHashChapters();
	}

	/**
	 * 
	 */
	private void initHashChapters() {
		this.hashChapters = new LinkedHashMap<Integer, BibleChapter>();
	}
	
	/**
	 * @return the bookName
	 */
	public String geBookName() {
		return bookName;
	}

	/**
	 * @param title the title to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the bookAbbreviation
	 */
	public String getBookAbbreviation() {
		return bookAbbreviation;
	}

	/**
	 * @param bookAbbreviation the bookAbbreviation to set
	 */
	public void setBookAbbreviation(String bookAbbreviation) {
		this.bookAbbreviation = bookAbbreviation;
	}

	/**
	 * @return the bookNumber
	 */
	public Integer getBookNumber() {
		return bookNumber;
	}

	/**
	 * @param bookNumber the bookNumber to set
	 */
	public void setBookNumber(Integer bookNumber) {
		this.bookNumber = bookNumber;
	}

	/**
	 * @return the bookTestament
	 */
	public String getBookTestament() {
		return bookTestament;
	}

	/**
	 * @param bookTestament the bookTestament to set
	 */
	public void setBookTestament(String bookTestament) {
		this.bookTestament = bookTestament;
	}

	/**
	 * @return the sourceFile
	 */
	public String getSourceFile() {
		return sourceFile;
	}

	/**
	 * @param sourceFile the sourceFile to set
	 */
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
	
	/**
	 * @return the bookIntroduction
	 */
	public String getBookIntroduction() {
		return bookIntroduction;
	}

	/**
	 * @return the booksIntroduction
	 */
	public String getBooksIntroduction() {
		return booksIntroduction;
	}

	/**
	 * @param booksIntroduction the booksIntroduction to set
	 */
	public void setBooksIntroduction(String booksIntroduction) {
		this.booksIntroduction = booksIntroduction;
	}

	/**
	 * @param bookIntroduction the bookIntroduction to set
	 */
	public void setBookIntroduction(String bookIntroduction) {
		this.bookIntroduction = bookIntroduction;
	}
	
	/**
	 * @return the chapters
	 */
	public LinkedHashMap<Integer, BibleChapter> getChapters() {
		return hashChapters;
	}

	/**
	 * @param hashChapters the chapters to set
	 */
	public void setChapters(LinkedHashMap<Integer, BibleChapter> hashChapters) {
		this.hashChapters = hashChapters;
	}
	
	@Override
	public String toString() {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		LinkedHashMap<Integer, BibleChapter> hashChapters = this.getChapters();
		// Get a set of the entries
		Set<Entry<Integer, BibleChapter>> mapChapters = hashChapters.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleChapter>> itChapters = mapChapters.iterator();
		// Display elements
		while(itChapters.hasNext()) {
			Entry<Integer, BibleChapter> me = itChapters.next();
			BibleChapter chapter = (BibleChapter) me.getValue();
			sb.append(this.getBooksIntroduction());
			sb.append(this.getBookIntroduction());
			sb.append(chapter.toString());
		}
        return sb.toString(); 
	}
	
}
