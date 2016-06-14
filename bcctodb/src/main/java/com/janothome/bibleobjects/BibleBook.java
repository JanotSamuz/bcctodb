/**
 * 
 */
package com.janothome.bibleobjects;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

// TODO Purger tous les commentaires en français pour de l'anglais ! Ne laisser que les éléments de contenu de la BCC en français ! 

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
	private Integer	bookKey;			// unique
    private Integer bookNumber = null;
    private String 	bookTestament = null;
    private String 	sourceFile = null;
    private String 	globalBooksIntroduction = null;
    private String 	bookIntroduction = null;
    private Integer numberOfChapters = 0;
    
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
	public String getBookName() {
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
	 * @return the bookKey
	 */
	public Integer getBookKey() {
		return bookKey;
	}

	/**
	 * @param bookKey the bookKey to set
	 */
	public void setBookKey(Integer bookKey) {
		this.bookKey = bookKey;
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
		return globalBooksIntroduction;
	}

	/**
	 * @param booksIntroduction the booksIntroduction to set
	 */
	public void setBooksIntroduction(String booksIntroduction) {
		this.globalBooksIntroduction = booksIntroduction;
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
	
	/**
	 * @param newChapter the chapter to add
	 */
	public void addChapter(BibleChapter newChapter) throws Exception {
		Integer newChapterKey = hashChapters.size()+1;
		
		LinkedHashMap<Integer, BibleChapter> hashChapters = this.getChapters();
		// Get a set of the entries
		Set<Entry<Integer, BibleChapter>> mapChapters = hashChapters.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleChapter>> itChapters = mapChapters.iterator();
		// Browse chapters
		while(itChapters.hasNext()) {
			Entry<Integer, BibleChapter> me = itChapters.next();
			BibleChapter chapter = (BibleChapter) me.getValue();
			if (newChapter.getChapterName() == chapter.getChapterName()) {
				// Don't add a chapter with a name that already exists
				throw new Exception("Chapter name " + newChapter.getChapterName() + " already used.");
			}
			// Test sur le ChapterKey
			// Ce test sur le ChapterKey n'est à priori pas indispensable car setChapterKet() et getChapterKey() ne sont gérées qu'ici dans addChapter()
			// Donc cette exception ne devrait jamais se produire !
			if (newChapterKey == chapter.getChapterKey()) {
				// Don't add a chapter with a key that already exists
				throw new Exception("Chapter key " + newChapter.getChapterKey() + " already used.");
			}
			// Test sur le ChapterNumber
			if (newChapter.getChapterNumber() == chapter.getChapterNumber()) {
				// Don't add a chapter with a number that already exists
				throw new Exception("Chapter number " + newChapter.getChapterNumber() + " already used.");
			}
		}
		newChapter.setChapterKey(newChapterKey);
		hashChapters.put(newChapterKey, newChapter);
		
		// On incrémente le nombre de chapitre du livre
		numberOfChapters++;
    }
	
	/**
	 * @param chapterNumber the chapter number to get
	 */
	public BibleChapter getChapter(Integer chapterNumber) throws Exception {
		if (hashChapters.containsKey(chapterNumber)) {
			return (BibleChapter)hashChapters.get(chapterNumber);
		} else {
			throw new Exception("Chapter " + chapterNumber.toString() + " unreachable.");
		}
    }
	
	/**
	 * @return the bookWithoutChapitres
	 */
	public Boolean isWithoutChapitres() {
		return (numberOfChapters <= 1);
	}

	/**
	 * @return the numberOfChapters
	 */
	public Integer getNumberOfChapters() {
		return numberOfChapters;
	}

	@Override
	public String toString() {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		LinkedHashMap<Integer, BibleChapter> hashChapters = this.getChapters();
		// Get a set of the entries
		Set<Entry<Integer, BibleChapter>> mapChapters = hashChapters.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleChapter>> itChapters = mapChapters.iterator();
		
		if (this.getBooksIntroduction() != null) {
			sb.append(this.getBooksIntroduction());
		}
		if (this.getBookIntroduction() != null) {
			sb.append(this.getBookIntroduction());
		}
		
		// Browse chapters
		while(itChapters.hasNext()) {
			Entry<Integer, BibleChapter> me = itChapters.next();
			BibleChapter chapter = (BibleChapter) me.getValue();
			if (chapter.toString() != null) {
				sb.append(chapter.toString());
			}
		}
        return sb.toString(); 
	}
	
}
