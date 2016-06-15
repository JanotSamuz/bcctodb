/**
 * 
 */
package com.janothome.bibleobjects;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class BibleVerset {

	private String  versetContent;
	private Integer	versetKey;				// unique
	
	private Integer versetNumber;			// unique

	/**
	 * @param versetNumber
	 */
	public BibleVerset(Integer versetNumber) {
		super();
		
		setVersetNumber(versetNumber);
	}
	
	/**
	 * @return the versetNumber
	 */
	public Integer getVersetNumber() {
		return versetNumber;
	}

	/**
	 * @param versetNumber the versetNumber to set
	 */
	private void setVersetNumber(Integer versetNumber) {
		this.versetNumber = versetNumber;
	}
	
	/**
	 * @return the versetContent
	 */
	public String getVersetContent() {
		return versetContent;
	}

	/**
	 * @return the versetKey
	 */
	protected Integer getVersetKey() {
		return versetKey;
	}

	/**
	 * @param versetKey the versetKey to set
	 */
	protected void setVersetKey(Integer versetKey) {
		this.versetKey = versetKey;
	}
	
	// TODO Supprimer setVersetContent et intégrer l'initialisation de "versetContent" dans le contructeur de BibleVerset()
	/**
	 * @param versetContent the versetContent to set
	 */
	public void setVersetContent(String versetContent) {
		this.versetContent = versetContent;
	}
	
	@Override
	public String toString() {
		return this.getVersetContent();
	}
}
