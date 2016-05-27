/**
 * 
 */
package com.janothome.bccbible;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class BCCEpub {

	String  BCCPath;

	/**
	 * @return the bccPath
	 */
	public String getBCCPath() {
		return BCCPath;
	}

	/**
	 * @param bccPath the bccPath to set
	 */
	public void setBCCPath(String BCCPath) {
		this.BCCPath = BCCPath;
	}

	/**
	 * 
	 */
	public BCCEpub() {
		super();
		// Initialisation des paramètres
		this.BCCPath = "H:\\Documents\\Projet-BIBLE\\Bible_Crampon_1923_complete\\Bible_Crampon_1923_missionweb_upgraded.epub";
	}
	
	public void Read() throws Exception {
		
		// read epub file
		EpubReader epubReader = new EpubReader();
		try {
			Book book = epubReader.readEpub(new FileInputStream(getBCCPath()));
			// print the first title
			List<String> titles = book.getMetadata().getTitles();
			System.out.println("book title:" + (titles.isEmpty() ? "book has no title" : titles.get(0)));
		} catch (IOException e) {
			throw new Exception("Unexpected error when reading epub.");
		}
		
	}
	
}
