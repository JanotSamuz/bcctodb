/**
 * 
 */
package com.janothome.bcctodb;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;
import java.io.Serializable;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class Bible implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String shortName;
	private String longName;
	private String digitalization;
	private String traduction;
	private String edition;
	private String version;
	private String tradition;
	private String church;
	private String licence;
	private String canon;
	private LinkedHashMap<Integer, BibleBook> hashBooks;
	
	/**
	 * @param shortName
	 * @param longName
	 * @param digitalization
	 * @param traduction
	 * @param edition
	 * @param version
	 * @param tradition
	 * @param church
	 * @param licence
	 */
	public Bible(String shortName, String longName, String digitalization, String traduction, String edition,
			String version, String tradition, String church, String licence) {
		super();
		
		setShortName(shortName);
		setLongName(longName);
		setDigitalization(digitalization);
		setTraduction(traduction);
		setEdition(edition);
		setVersion(version);
		setTradition(tradition);
		setChurch(church);
		setLicence(licence);
		
		initHashBooks();
	}
	
	/**
	 * @param shortName
	 */
	public Bible(String shortName) {
		super();
		
		setShortName(shortName);
		
		initHashBooks();
	}

	/**
	 * 
	 */
	private void initHashBooks() {
		this.hashBooks = new LinkedHashMap<Integer, BibleBook>();
	}
	
	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @return the longName
	 */
	public String getLongName() {
		return longName;
	}

	/**
	 * @param longName the longName to set
	 */
	public void setLongName(String longName) {
		this.longName = longName;
	}
	
	/**
	 * @return the digitalization
	 */
	public String getDigitalization() {
		return digitalization;
	}

	/**
	 * @param digitalization the digitalization to set
	 */
	public void setDigitalization(String digitalization) {
		this.digitalization = digitalization;
	}
	
	/**
	 * @return the traduction
	 */
	public String getTraduction() {
		return traduction;
	}

	/**
	 * @param traduction the traduction to set
	 */
	public void setTraduction(String traduction) {
		this.traduction = traduction;
	}
	
	/**
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * @param edition the edition to set
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * @return the tradition
	 */
	public String getTradition() {
		return tradition;
	}

	/**
	 * @param tradition the tradition to set
	 */
	public void setTradition(String tradition) {
		this.tradition = tradition;
	}

	/**
	 * @return the church
	 */
	public String getChurch() {
		return church;
	}

	/**
	 * @param church the church to set
	 */
	public void setChurch(String church) {
		this.church = church;
	}

	/**
	 * @return the licence
	 */
	public String getLicence() {
		return licence;
	}

	/**
	 * @param licence the licence to set
	 */
	public void setLicence(String licence) {
		this.licence = licence;
	}
	
	/**
	 * @return the canon
	 */
	public String getCanon() {
		return canon;
	}

	/**
	 * @param canon the canon to set
	 */
	public void setCanon(String canon) {
		this.canon = canon;
	}

	/**
	 * @return the books
	 */
	public LinkedHashMap<Integer, BibleBook> getBooks() {
		return hashBooks;
	}

	/**
	 * @param hashBooks the books to set
	 */
	public void setBooks(LinkedHashMap<Integer, BibleBook> hashBooks) {
		this.hashBooks = hashBooks;
	}
	
	/**
	 * @param newBook the book to add
	 */
	public void addBook(BibleBook newBook) throws Exception {
		Integer newBookKey = hashBooks.size()+1;
		
		LinkedHashMap<Integer, BibleBook> hashBooks = this.getBooks();
		// Get a set of the entries
		Set<Entry<Integer, BibleBook>> mapBooks = hashBooks.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleBook>> itBooks = mapBooks.iterator();
		// Display elements
		while(itBooks.hasNext()) {
			Entry<Integer, BibleBook> me = itBooks.next();
			BibleBook book = (BibleBook) me.getValue();
			if ((newBook.getBookAbbreviation() == book.getBookAbbreviation()) && !newBook.getBookAbbreviation().toLowerCase().equals(new String("ps"))) {
				// Don't add a book with an abbreviation that already exists expect for psaume book (Ps)
				throw new Exception("Book abbreviation " + newBook.getBookAbbreviation() + " already used.");
			}
			if ((newBook.getBookNumber() == book.getBookNumber()) && !newBook.getBookAbbreviation().toLowerCase().equals(new String("ps"))) {
				// Don't add a book with a number that already exists expect for psaume book (Ps)
				throw new Exception("Book number " + newBook.getBookNumber() + " already used.");
			}
			if (newBook.getBookName() == book.getBookName()) {
				// Don't add a book with a name that already exists
				throw new Exception("Book name " + newBook.getBookName() + " already used.");
			}
			if (newBookKey == book.getBookKey()) {
				// Don't add a book with a key that already exists
				throw new Exception("Book key " + newBook.getBookKey() + " already used.");
			}
		}
		newBook.setBookKey(newBookKey);
		hashBooks.put(newBookKey, newBook);
    }
	
	/**
	 * @param bookNumber the book number to get
	 */
	public BibleBook getBook(Integer bookNumber) throws Exception {
		if (hashBooks.containsKey(bookNumber)) {
			return (BibleBook)hashBooks.get(bookNumber);
		} else {
			throw new Exception("Book " + bookNumber.toString() + " unreachable.");
		}
    }
	
	@Override
    public String toString(){
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		LinkedHashMap<Integer, BibleBook> hashBooks = this.getBooks();
		// Get a set of the entries
		Set<Entry<Integer, BibleBook>> mapBooks = hashBooks.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleBook>> itBooks = mapBooks.iterator();
		// Display elements
		while(itBooks.hasNext()) {
			Entry<Integer, BibleBook> me = itBooks.next();
			BibleBook book = (BibleBook) me.getValue();
			sb.append(book.toString());
		}
        return sb.toString();
    }

}
