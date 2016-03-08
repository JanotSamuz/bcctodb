/**
 * 
 */
package com.janothome.bcctodb;

import java.io.Serializable;

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
	}

	/**
	 * @param bookName
	 */
	public BibleBook(String bookName) {
		super();
		setBookName(bookName);
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
	
	@Override
	public String toString() {
		return "Book [name=" + bookName + ", sourceFile=" + sourceFile + "]"; 
	}
	
}
