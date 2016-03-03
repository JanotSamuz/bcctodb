/**
 * 
 */
package com.janothome.bcctodb;

import java.util.Hashtable;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class Bible {

	private String shortName;
	private String longName;
	private String digitalization;
	private String traduction;
	private String edition;
	private String version;
	private String tradition;
	private String church;
	private String licence;
	private Hashtable<?, ?> books;
	
	/**
	 * 
	 */
	public Bible(String shortName) {
		super();
		Hashtable<?, ?> books = new Hashtable<Object, Object>();
		setShortName(shortName);
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
	 * @return the books
	 */
	public Hashtable<?, ?> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Hashtable<?, ?> books) {
		this.books = books;
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
	
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

}
