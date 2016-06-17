/**
 * 
 */
package com.janothome.bibleobjects;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;


/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class BibleChapter implements Serializable {

	private static final long serialVersionUID = 1L;
	private String 	chapterName;			// unique
	private Integer	chapterKey;				// unique
    private Integer chapterNumber;			// unique
    private String  startOfChapter;
    private String  endOfChapter;
	private String  chapterContent;
	private Integer numberOfVersets = 0;

	private LinkedHashMap<Integer, BibleVerset> hashVersets;
		
	/**
	 * @param chapterName
	 * @param chapterNumber
	 */
	public BibleChapter(String chapterName, Integer chapterNumber) {
		super();
		
		setChapterName(chapterName);
		setChapterNumber(chapterNumber);
		initHashVersets();
	}

	/**
	 * 
	 */
	private void initHashVersets() {
		this.hashVersets = new LinkedHashMap<Integer, BibleVerset>();
	}
	
	/**
	 * @return the chapterContent
	 */
	public String getChapterContent() {
		return chapterContent;
	}

	// TODO Supprimer setChapterContent et intégrer l'initialisation de "chapterContent" dans le contructeur de BibleChapter()
	/**
	 * @param chapterContent the chapterContent to set
	 */
	public void setChapterContent(String chapterContent) {
		this.chapterContent = chapterContent;
	}

	/**
	 * @return the startOfChapter
	 */
	public String getStartOfChapter() {
		return startOfChapter;
	}

	/**
	 * @return the versets
	 */
	public LinkedHashMap<Integer, BibleVerset> getVersets() {
		return hashVersets;
	}

	/**
	 * @param hashVersets the versets to set
	 */
	public void setVersets(LinkedHashMap<Integer, BibleVerset> hashVersets) {
		this.hashVersets = hashVersets;
	}

	/**
	 * @param startOfChapter the startOfChapter to set
	 */
	public void setStartOfChapter(String startOfChapter) {
		this.startOfChapter = startOfChapter;
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
	private void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	/**
	 * @return the chapterKey
	 */
	protected Integer getChapterKey() {
		return chapterKey;
	}

	/**
	 * @param chapterKey the chapterKey to set
	 */
	protected void setChapterKey(Integer chapterKey) {
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
	private void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	/**
	 * @return the numberOfVersets
	 */
	public Integer getNumberOfVersets() {
		return numberOfVersets;
	}
	
	/**
	 * @return the endOfChapter
	 */
	public String getEndOfChapter() {
		return endOfChapter;
	}

	/**
	 * @param endOfChapter the endOfChapter to set
	 */
	public void setEndOfChapter(String endOfChapter) {
		this.endOfChapter = endOfChapter;
	}

    /**
	 * @param newVerset the verset to add
	 */
	public void addVerset(BibleVerset newVerset) throws Exception {
		Integer newVersetKey = hashVersets.size()+1;
		
		LinkedHashMap<Integer, BibleVerset> hashVersets = this.getVersets();
		// Get a set of the entries
		Set<Entry<Integer, BibleVerset>> mapVersets = hashVersets.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleVerset>> itVersets = mapVersets.iterator();
		// Browse versets
		while(itVersets.hasNext()) {
			Entry<Integer, BibleVerset> me = itVersets.next();
			BibleVerset verset = (BibleVerset) me.getValue();
			// Test sur le VersetKey
			// Ce test sur le VersetKey n'est à priori pas indispensable car setVersetKet() et getVersetKey() ne sont gérées qu'ici dans addVerset()
			// Donc cette exception ne devrait jamais se produire !
			if (newVersetKey == verset.getVersetKey()) {
				// Don't add a verset with a key that already exists
				throw new Exception("Can't add this new verset. Verset key " + newVerset.getVersetKey() + " already used.");
			}
			if (newVerset.getVersetNumber() == verset.getVersetNumber()) {
				// Don't add a verset with a number that already exists
				throw new Exception("Can't add this new verset. Verset number " + newVerset.getVersetNumber() + " already used.");
			}
		}
		newVerset.setVersetKey(newVersetKey);
		hashVersets.put(newVersetKey, newVerset);
		
		// On incrémente le nombre de chapitre du livre
		numberOfVersets++;
    }
	
	/**
	 * @param versetNumber the verset number to get
	 */
	public BibleVerset getVerset(Integer versetNumber) throws Exception {
		if (hashVersets.containsKey(versetNumber)) {
			return (BibleVerset)hashVersets.get(versetNumber);
		} else {
			throw new Exception("Verset " + versetNumber.toString() + " unreachable.");
		}
    }
	
	public String getFullChapterContent() {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		
		if (this.getStartOfChapter() != null) {
			sb.append(this.getStartOfChapter());
		}
		if (this.getChapterContent() != null) {
			sb.append(this.getChapterContent());
		}
		if (this.getEndOfChapter() != null) {
			sb.append(this.getEndOfChapter());
		}
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		LinkedHashMap<Integer, BibleVerset> hashVersets = this.getVersets();
		// Get a set of the entries
		Set<Entry<Integer, BibleVerset>> mapVersets = hashVersets.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleVerset>> itVersets = mapVersets.iterator();
		
		if (this.getStartOfChapter() != null) {
			sb.append(this.getStartOfChapter());
		}
		
		// Browse versets
		while(itVersets.hasNext()) {
			Entry<Integer, BibleVerset> me = itVersets.next();
			BibleVerset verset = (BibleVerset) me.getValue();
			if (verset.toString() != null) {
				sb.append(verset.toString());
			}
		}
		
		if (this.getEndOfChapter() != null) {
			sb.append(this.getEndOfChapter());
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
