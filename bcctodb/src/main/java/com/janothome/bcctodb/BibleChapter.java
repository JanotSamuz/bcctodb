/**
 * 
 */
package com.janothome.bcctodb;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class BibleChapter {

	private String chapterContent;
	
	/**
	 * 
	 */
	public BibleChapter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the chapterContent
	 */
	public String getChapterContent() {
		return chapterContent;
	}

	/**
	 * @param chapterContent the chapterContent to set
	 */
	public void setChapterContent(String chapterContent) {
		this.chapterContent = chapterContent;
	}

	@Override
	public String toString() {
        return this.getChapterContent(); 
	}
	
}
