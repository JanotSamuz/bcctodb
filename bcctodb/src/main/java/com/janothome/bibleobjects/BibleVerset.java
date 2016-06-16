/**
 * 
 */
package com.janothome.bibleobjects;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class BibleVerset {

	private Integer	versetKey;				// unique
	private Integer versetNumber;			// unique
	private String  versetIntroduction;
	private String  versetContent;

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

	/**
	 * @return the versetIntroduction
	 */
	public String getVersetIntroduction() {
		return versetIntroduction;
	}

	/**
	 * @param versetIntroduction the versetIntroduction to set
	 */
	public void setVersetIntroduction(String versetIntroduction) {
		this.versetIntroduction = versetIntroduction;
	}
	
	@Override
	public String toString() {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		
		if (this.getVersetIntroduction() != null) {
			sb.append(this.getVersetIntroduction());
		}
		
		sb.append(this.getVersetContent());
		
		return sb.toString();
	}
}
