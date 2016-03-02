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
import org.jsoup.select.Elements;

/**
 * @author PZGK7230
 *
 */
public class BCCXhtml {

	/**
	 * 
	 */
	public BCCXhtml() {
		// TODO Auto-generated constructor stub
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
		
	}

}
