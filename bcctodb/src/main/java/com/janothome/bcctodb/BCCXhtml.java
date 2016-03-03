/**
 * 
 */
package com.janothome.bcctodb;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public class BCCXhtml {

	/**
	 * 
	 */
	public BCCXhtml() {
		super();
	}
	
	public void Read() {
		String xhtmlText = new String();
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			xhtmlText = IOUtils.toString((InputStream) classLoader.getResource("xhtml/Genese.xhtml").getContent(), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Document doc = Jsoup.parse(xhtmlText);
		//Elements elements = doc.select("body").first().children();
		//for (Element el : elements)
		//Element el = elements.first();
		Element el = doc.select("h1").first();
		if (el == null)
			System.out.println("Erreur");
		else
			System.out.println("element: " + el.text());
		
		
		Bible BCCbible = new Bible("Bible Chanoine Crampon");
		BCCbible.setVersion("1.0");
		BCCbible.setLongName("La Saint Bible d'après les textes originaux par l'abbé Augustin Crampon, chanoine d'Amiens - Edition 1923");
		BCCbible.setDigitalization("Edition numérique/relecture et vérifications par Jean-Marie WEBER pour www.mission-web.com");
		BCCbible.setEdition("Edition réisée par les Pères de la Cie de Jésus avec la collaboration de Professeurs de S. Sulpice - SOCIÉTÉ DE S. JEAN L'ÉVANGÉLISTE - 1923");
		BCCbible.setLicence("Cette oeuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution - Pas d'Utilisation Commerciale - Partage dans les Mêmes Conditions 3.0 non transposé.");
		BCCbible.setTradition("Christianisme");
		BCCbible.setChurch("Eglise catholique romaine");
		
	}

}
