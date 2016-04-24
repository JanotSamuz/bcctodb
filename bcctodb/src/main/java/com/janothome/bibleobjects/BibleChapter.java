/**
 * 
 */
package com.janothome.bibleobjects;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class BibleChapter {

	private String 	chapterName;			// unique
	private Integer	chapterKey;				// unique
    private Integer chapterNumber;			// unique
    private String  chapterIntroduction;
	private String  chapterContent;
	
	/**
	 * @param chapterName
	 * @param chapterNumber
	 */
	public BibleChapter(String chapterName, Integer chapterNumber) {
		super();
		
		setChapterName(chapterName);
		setChapterNumber(chapterNumber);
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

	/**
	 * @return the chapterName
	 */
	public String getChapterName() {
		return chapterName;
	}

	/**
	 * @param chapterName the chapterName to set
	 */
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	/**
	 * @return the chapterKey
	 */
	public Integer getChapterKey() {
		return chapterKey;
	}

	/**
	 * @param chapterKey the chapterKey to set
	 */
	public void setChapterKey(Integer chapterKey) {
		this.chapterKey = chapterKey;
	}

	/**
	 * @return the chapterNumber
	 */
	public Integer getChapterNumber() {
		return chapterNumber;
	}

	/**
	 * @param chapterNumber the chapterNumber to set
	 */
	public void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	@Override
	public String toString() {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		
		if (this.getChapterIntroduction() != null) {
			sb.append(this.getChapterIntroduction());
		}
		if (this.getChapterContent() != null) {
			sb.append(this.getChapterContent());
		}
		
		return sb.toString();
	}
	
	public enum TypeChapter {
		  
		CHAPTER("Chp"), PSAUME("Ps");
	    
	    private String abreviation;
	      
	    private TypeChapter(String abreviation) {  
	    	this.abreviation = abreviation;  
	    }
	      
	    public String getAbreviation() {  
	    	return this.abreviation;
	    }
	}
}
