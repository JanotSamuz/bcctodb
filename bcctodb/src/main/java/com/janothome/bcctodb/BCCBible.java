/**
 * 
 */
package com.janothome.bcctodb;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public final class BCCBible extends Bible {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @throws Exception 
	 * 
	 */
	public BCCBible() throws Exception {
		super("Bible Chanoine Crampon");
		
		this.setVersion("1.0");
		this.setLongName("La Saint Bible d'après les textes originaux par l'abbé Augustin Crampon, chanoine d'Amiens - Edition 1923");
		this.setDigitalization("Edition numérique/relecture et vérifications par Jean-Marie WEBER pour www.mission-web.com");
		this.setEdition("Edition réisée par les Pères de la Cie de Jésus avec la collaboration de Professeurs de S. Sulpice - SOCIÉTÉ DE S. JEAN L'ÉVANGÉLISTE - 1923");
		this.setLicence("Cette oeuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution - Pas d'Utilisation Commerciale - Partage dans les Mêmes Conditions 3.0 non transposé.");
		this.setTradition("Christianisme");
		this.setChurch("Eglise catholique romaine");
		this.setCanon("Canon catholique");
		
		// Insertion des livres dans l'ordre
		try {
			this.addBook(new BibleBook("Genèse","Gn",1,"Ancien Testament","Genese.xhtml"));
			this.addBook(new BibleBook("Exode","Ex",2,"Ancien Testament","Exode.xhtml"));
			this.addBook(new BibleBook("Lévitique","Lv",3,"Ancien Testament","Levitique.xhtml"));
			this.addBook(new BibleBook("Nombres","Nb",4,"Ancien Testament","Nombres.xhtml"));
			this.addBook(new BibleBook("Deutéronome","Dt",5,"Ancien Testament","Deuteronome.xhtml"));
			this.addBook(new BibleBook("Josué","Jos",6,"Ancien Testament","josue.xhtml"));
			this.addBook(new BibleBook("Juges","Jg",7,"Ancien Testament","juges.xhtml"));
			this.addBook(new BibleBook("Ruth","Rt",8,"Ancien Testament","ruth.xhtml"));
			this.addBook(new BibleBook("Premier Livre de Samuel","1 S",9,"Ancien Testament","1Samuel.xhtml"));
			this.addBook(new BibleBook("Deuxième Livre de Samuel","2 S",10,"Ancien Testament","2Samuel.xhtml"));
			this.addBook(new BibleBook("Premier livre des Rois","1 R",11,"Ancien Testament","1Rois.xhtml"));
			this.addBook(new BibleBook("Deuxième livre des Rois","2 R",12,"Ancien Testament","2Rois.xhtml"));
			this.addBook(new BibleBook("Premier livre des Chroniques","1 Ch",13,"Ancien Testament","1Chroniques.xhtml"));
			this.addBook(new BibleBook("Deuxième livre des Chroniques","2 Ch",14,"Ancien Testament","2Chroniques.xhtml"));
			this.addBook(new BibleBook("Esdras","Esd",15,"Ancien Testament","Esdras.xhtml"));
			this.addBook(new BibleBook("Livre de Néhémie","Ne",16,"Ancien Testament","Nehemie.xhtml"));
			this.addBook(new BibleBook("Tobie","Tb",17,"Ancien Testament","Tobie.xhtml"));
			this.addBook(new BibleBook("Judith","Jdt",18,"Ancien Testament","Judith.xhtml"));
			this.addBook(new BibleBook("Esther","Est",19,"Ancien Testament","Esther.xhtml"));
			this.addBook(new BibleBook("Premier livre des Machabées","1 M",20,"Ancien Testament","1Machabees.xhtml"));
			this.addBook(new BibleBook("Deuxième livre des Machabées","2 M",21,"Ancien Testament","2Machabees.xhtml"));
			this.addBook(new BibleBook("Job","Jb",22,"Ancien Testament","Job.xhtml"));
			this.addBook(new BibleBook("Psaumes - Livre Premier (1-41)","Ps",23,"Ancien Testament","1Psaumes.xhtml"));
			this.addBook(new BibleBook("Psaumes - Livre Deuxième (42-72)","Ps",23,"Ancien Testament","2Psaumes.xhtml"));
			this.addBook(new BibleBook("Psaumes - Livre Troisième (73-89)","Ps",23,"Ancien Testament","3Psaumes.xhtml"));
			this.addBook(new BibleBook("Psaumes - Livre Quatrième (90-106)","Ps",23,"Ancien Testament","4Psaumes.xhtml"));
			this.addBook(new BibleBook("Psaumes - Livre Cinquième (107-150)","Ps",23,"Ancien Testament","5Psaumes.xhtml"));
			this.addBook(new BibleBook("Proverbes","Pr",24,"Ancien Testament","Proverbes.xhtml"));
			this.addBook(new BibleBook("Ecclésiaste ou Qohélet","Qo",25,"Ancien Testament","Ecclesiaste.xhtml"));
			this.addBook(new BibleBook("Cantique des cantiques","Ct",26,"Ancien Testament","cantique_des_cantiques.xhtml"));
			this.addBook(new BibleBook("Sagesse","Sg",27,"Ancien Testament","Sagesse.xhtml"));
			this.addBook(new BibleBook("Ecclésiastique ou Siracide","Si",28,"Ancien Testament","Ecclesiastique.xhtml"));
			this.addBook(new BibleBook("Isaïe","Is",29,"Ancien Testament","Isaie.xhtml"));
			this.addBook(new BibleBook("Jérémie","Jr",30,"Ancien Testament","Jeremie.xhtml"));
			this.addBook(new BibleBook("Lamentations","Lm",31,"Ancien Testament","Lamentations.xhtml"));
			this.addBook(new BibleBook("Baruch","Ba",32,"Ancien Testament","Baruch.xhtml"));
			this.addBook(new BibleBook("Ézéchiel","Ez",33,"Ancien Testament","Ezechiel.xhtml"));
			this.addBook(new BibleBook("Daniel","Dn",34,"Ancien Testament","Daniel.xhtml"));
			this.addBook(new BibleBook("Osée","Os",35,"Ancien Testament","Osee.xhtml"));
			this.addBook(new BibleBook("Joël","Jl",36,"Ancien Testament","Joel.xhtml"));
			this.addBook(new BibleBook("Amos","Am",37,"Ancien Testament","Amos.xhtml"));
			this.addBook(new BibleBook("Abdias","Ab",38,"Ancien Testament","Abdias.xhtml"));
			this.addBook(new BibleBook("Jonas","Jon",39,"Ancien Testament","Jonas.xhtml"));
			this.addBook(new BibleBook("Michée","Mi",40,"Ancien Testament","Michee.xhtml"));
			this.addBook(new BibleBook("Nahum","Na",41,"Ancien Testament","Nahum.xhtml"));
			this.addBook(new BibleBook("Habacuc","Ha",42,"Ancien Testament","Habacuc.xhtml"));
			this.addBook(new BibleBook("Sophonie","So",43,"Ancien Testament","Sophonie.xhtml"));
			this.addBook(new BibleBook("Aggée","Ag",44,"Ancien Testament","Aggee.xhtml"));
			this.addBook(new BibleBook("Zacharie","Za",45,"Ancien Testament","Zacharie.xhtml"));
			this.addBook(new BibleBook("Malachie","Ml",46,"Ancien Testament","Malachie.xhtml"));
			this.addBook(new BibleBook("Évangile selon Saint Matthieu","Mt",47,"Nouveau Testament","Matthieu.xhtml"));
			this.addBook(new BibleBook("Évangile selon Saint Marc","Mc",48,"Nouveau Testament","Marc.xhtml"));
			this.addBook(new BibleBook("Évangile selon Saint Luc","Lc",49,"Nouveau Testament","Luc.xhtml"));
			this.addBook(new BibleBook("Évangile selon Saint Jean","Jn",50,"Nouveau Testament","Jean.xhtml"));
			this.addBook(new BibleBook("Les Actes des Apôtres","Ac",51,"Nouveau Testament","Actes.xhtml"));
			this.addBook(new BibleBook("Épître de Saint Paul aux Romains","Rm",52,"Nouveau Testament","Romains.xhtml"));
			this.addBook(new BibleBook("Première Épître de Saint Paul aux Corinthiens","1 Co",53,"Nouveau Testament","1Corinthiens.xhtml"));
			this.addBook(new BibleBook("Deuxième Épître de Saint Paul aux Corinthiens","2 Co",54,"Nouveau Testament","2Corinthiens.xhtml"));
			this.addBook(new BibleBook("Épître de Saint Paul aux Galates","Ga",55,"Nouveau Testament","Galates.xhtml"));
			this.addBook(new BibleBook("Épître de Saint Paul aux Éphésiens","Ep",56,"Nouveau Testament","Ephesiens.xhtml"));
			this.addBook(new BibleBook("Épître de Saint Paul aux Philippiens","Ph",57,"Nouveau Testament","Philippiens.xhtml"));
			this.addBook(new BibleBook("Épître de Saint Paul aux Colossiens","Col",58,"Nouveau Testament","Colossiens.xhtml"));
			this.addBook(new BibleBook("Première Épître de Saint Paul aux Thessaloniciens","1 Th",59,"Nouveau Testament","1Thessaloniciens.xhtml"));
			this.addBook(new BibleBook("Deuxième Épître de Saint Paul aux Thessaloniciens","2 Th",60,"Nouveau Testament","2Thessaloniciens.xhtml"));
			this.addBook(new BibleBook("Première Épître de Saint Paul à Timothée","1 Tm",61,"Nouveau Testament","1Timothee.xhtml"));
			this.addBook(new BibleBook("Deuxième Épître de Saint Paul à Timothée","2 Tm",62,"Nouveau Testament","2Timothee.xhtml"));
			this.addBook(new BibleBook("Épître de Saint Paul à Tite","Tt",63,"Nouveau Testament","Tite.xhtml"));
			this.addBook(new BibleBook("Épître de Saint Paul à Philémon","Phm",64,"Nouveau Testament","Philemon.xhtml"));
			this.addBook(new BibleBook("Épître de saint Paul aux Hébreux","He",65,"Nouveau Testament","Hebreux.xhtml"));
			this.addBook(new BibleBook("Épître de Saint Jacques","Jc",66,"Nouveau Testament","Jacques.xhtml"));
			this.addBook(new BibleBook("Première Épître de Saint Pierre","1 P",67,"Nouveau Testament","1Pierre.xhtml"));
			this.addBook(new BibleBook("Deuxième Épître de Saint Pierre","2 P",68,"Nouveau Testament","2Pierre.xhtml"));
			this.addBook(new BibleBook("Première Épître de Saint Jean","1 Jn",69,"Nouveau Testament","1Jean.xhtml"));
			this.addBook(new BibleBook("Deuxième Épître de Saint Jean","2 Jn",70,"Nouveau Testament","2Jean.xhtml"));
			this.addBook(new BibleBook("Troisième Épître de Saint Jean","3 Jn",71,"Nouveau Testament","3Jean.xhtml"));
			this.addBook(new BibleBook("Épître de Saint Jude","Jude",72,"Nouveau Testament","Jude.xhtml"));
			this.addBook(new BibleBook("Apocalypse","Ap",73,"Nouveau Testament","Apocalypse.xhtml"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		LinkedHashMap<Integer, BibleBook> hashBooks = this.getBooks();
		// Get a set of the entries
		Set<Entry<Integer, BibleBook>> mapBooks = hashBooks.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleBook>> itBooks = mapBooks.iterator();
		// Display elements
		while(itBooks.hasNext()) {
			Entry<Integer, BibleBook> me = itBooks.next();
			//Integer bookKey = (Integer) me.getKey();
			BibleBook book = (BibleBook) me.getValue();
			String xhtmlText = new String();
			ClassLoader classLoader = getClass().getClassLoader();
			try {
				xhtmlText = IOUtils.toString((InputStream) classLoader.getResource("xhtml/"+book.getSourceFile()).getContent(), "UTF-8");
			} catch (IOException e) {
				throw new Exception("Unexpected error when reading XTHML file on book <" + book.geBookName() + "> ");
			}
			Document doc = Jsoup.parse(xhtmlText);
			
			// Fill books introduction
			this.initBooksIntroduction(doc, book);
			
			
			// Fill book introduction
			this.initBookIntroduction(doc, book);
			
			// Fill chapters
			this.initChapters(doc, book);
		}
	}
	
	private void initBooksIntroduction(Document doc, BibleBook book) throws Exception {
		String bookTag = "h2";
		Element firstTitle = doc.select(bookTag).first();
		Element lastTitle = doc.select(bookTag).last();
		if (firstTitle == null || lastTitle == null) {
			throw new Exception("Unexpected error when reading XTHML file for books introduction on book <" + book.geBookName() + ">");
		} else if (!firstTitle.text().equals(lastTitle.text())) {
			// H2 présent 2 fois : Titre de l'ensemble des livres + Titre du livre
			java.lang.StringBuilder sbBooksIntroduction = new java.lang.StringBuilder();
			sbBooksIntroduction.append(firstTitle.outerHtml());
			sbBooksIntroduction.append(System.getProperty("line.separator"));
			Elements siblings = firstTitle.siblingElements();
			List<Element> elementsBetween = new ArrayList<Element>();
			for (int i = 0; i < siblings.size(); i++) {
				Element sibling = siblings.get(i);
				if (! bookTag.equals(sibling.tagName()))
					elementsBetween.add(sibling);
				else {
					processElementsBetween(elementsBetween, sbBooksIntroduction);
					elementsBetween.clear();
					break;
				}
			}
			book.setBooksIntroduction(sbBooksIntroduction.toString());
		}
	}
	
	private void initBookIntroduction(Document doc, BibleBook book) throws Exception {
		String bookTagLast = "h2";
		String chapterTagFirst = "h3";
		java.lang.StringBuilder sbBookIntroduction = new java.lang.StringBuilder();
		Element lastBookTitle = doc.select(bookTagLast).last();
		if (lastBookTitle == null ) {
			throw new Exception("Unexpected error when reading XTHML file for book introduction on book <" + book.geBookName() + ">");
		}
		sbBookIntroduction.append(lastBookTitle.outerHtml());
		sbBookIntroduction.append(System.getProperty("line.separator"));
		Element firstChapterTitle = doc.select(chapterTagFirst).first();
		if ((lastBookTitle != null) && (firstChapterTitle != null)) {
			// H2 et H3 présents : Titre du livre + Titre du chapitre
			Elements siblings = doc.getElementsByIndexGreaterThan(lastBookTitle.elementSiblingIndex());
			List<Element> elementsBetween = new ArrayList<Element>();
			for (int i = 0; i < siblings.size(); i++) {
				Element sibling = siblings.get(i);
				if (! chapterTagFirst.equals(sibling.tagName()))
					elementsBetween.add(sibling);
				else {
					processElementsBetween(elementsBetween, sbBookIntroduction);
					elementsBetween.clear();
					break;
				}
			}
		} else if ((lastBookTitle != null) && (firstChapterTitle == null)) {
			// H2 seulement présent : Titre du livre seulement
			Elements siblings = lastBookTitle.siblingElements();
			List<Element> elementsBetween = new ArrayList<Element>();
			for (int i = 0; i < siblings.size(); i++) {
				Element sibling = siblings.get(i);
				if (! sibling.html().startsWith("<br> 1 "))
					elementsBetween.add(sibling);
				else {
					processElementsBetween(elementsBetween, sbBookIntroduction);
					elementsBetween.clear();
					break;
				}
			}
		}
		book.setBookIntroduction(sbBookIntroduction.toString());
	}
	
	// TODO Development in progress...
	private void initChapters(Document doc, BibleBook book) throws Exception {
		String bookTagLast = "h2";
		String chapterTagFirst = "h3";
		java.lang.StringBuilder sbChapterContent = new java.lang.StringBuilder();
		Element lastBookTitle = doc.select(bookTagLast).last();
		if (lastBookTitle == null ) {
			throw new Exception("Unexpected error when reading XTHML file for book introduction on book <" + book.geBookName() + ">");
		}
		sbChapterContent.append(lastBookTitle.outerHtml());
		sbChapterContent.append(System.getProperty("line.separator"));
		Element firstChapterTitle = doc.select(chapterTagFirst).first();
		if ((lastBookTitle != null) && (firstChapterTitle != null)) {
			// H2 et H3 présents : Titre du livre + Titre du chapitre
			Elements siblings = doc.getElementsByIndexGreaterThan(lastBookTitle.elementSiblingIndex());
			List<Element> elementsBetween = new ArrayList<Element>();
			for (int i = 0; i < siblings.size(); i++) {
				Element sibling = siblings.get(i);
				if (! chapterTagFirst.equals(sibling.tagName()))
					elementsBetween.add(sibling);
				else {
					processElementsBetween(elementsBetween, sbChapterContent);
					elementsBetween.clear();
					break;
				}
			}
		} else if ((lastBookTitle != null) && (firstChapterTitle == null)) {
			// H2 seulement présent : Titre du livre seulement
			// 1 seul chapitre à ajouter
			Elements siblings = lastBookTitle.siblingElements();
			List<Element> elementsBetween = new ArrayList<Element>();
			boolean bFound = false;
			for (int i = 0; i < siblings.size(); i++) {
				Element sibling = siblings.get(i);
				if (sibling.html().startsWith("<br> 1 ") || bFound) {
					elementsBetween.add(sibling);
					bFound = true;
				}	
			}
			processElementsBetween(elementsBetween, sbChapterContent);
			elementsBetween.clear();
		}
		//book.setBookIntroduction(sbChapterContent.toString());
	}
	
	private static void processElementsBetween(List<Element> elementsBetween, java.lang.StringBuilder sb) {
		for (Element element : elementsBetween) {
			sb.append(element.toString());
			sb.append(System.getProperty("line.separator"));
		}
	}

}
