/**
 * 
 */
package com.janothome.bcctodb;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class BibleBook {

	private int id;
	private String title;
	private String sourceFile;
	
	public BibleBook(){}
	
	/**
	 * 
	 */
	public BibleBook(String title, String sourceFile) {
		super();
		setTitle(title);
		setSourceFile(sourceFile);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
		return "Book [id=" + id + ", title=" + title + ", sourceFile=" + sourceFile + "]"; 
	}

}
