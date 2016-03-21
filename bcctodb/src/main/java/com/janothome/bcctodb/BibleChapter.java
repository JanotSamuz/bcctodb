/**
 * 
 */
package com.janothome.bcctodb;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class BibleChapter {

	private String  chaptersIntroduction;
    private String  chapterIntroduction;
	private String  chapterContent;
	
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

	/**
	 * @return the chaptersIntroduction
	 */
	public String getChaptersIntroduction() {
		return chaptersIntroduction;
	}

	/**
	 * @param chaptersIntroduction the chaptersIntroduction to set
	 */
	public void setChaptersIntroduction(String chaptersIntroduction) {
		this.chaptersIntroduction = chaptersIntroduction;
	}

	/**
	 * @return the chapterIntroduction
	 */
	public String getChapterIntroduction() {
		return chapterIntroduction;
	}

	/**
	 * @param chapterIntroduction the chapterIntroduction to set
	 */
	public void setChapterIntroduction(String chapterIntroduction) {
		this.chapterIntroduction = chapterIntroduction;
	}
	
}
