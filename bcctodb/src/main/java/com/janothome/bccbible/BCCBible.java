/**
 * 
 */
package com.janothome.bccbible;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.janothome.bibleobjects.Bible;
import com.janothome.bibleobjects.BibleBook;
import com.janothome.bibleobjects.BibleChapter;
import com.janothome.bibleobjects.BibleChapter.TypeChapter;
import com.janothome.bibleobjects.BibleVerset;

/**
 * @author Janot Samuz (janotsamuz+github@gmail.com)
 *
 */
public final class BCCBible extends Bible {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// TODO Supprimer la méthode JSOUP si pas concluante à cause des retours chariots !
	public static final boolean JSOUP_Method = false;

	/**
	 * @throws Exception 
	 * 
	 */
	public BCCBible() throws Exception {
		super("Bible Chanoine Crampon");
		
		this.setVersion("3 juin 2016");
		this.setLongName("La Saint Bible d'après les textes originaux par l'abbé Augustin Crampon, chanoine d'Amiens - Edition 1923");
		this.setDigitalization("Edition numérique/relecture et vérifications par Jean-Marie WEBER pour www.mission-web.com");
		this.setEdition("Edition révisée par les Pères de la Cie de Jésus avec la collaboration de Professeurs de S. Sulpice - SOCIÉTÉ DE S. JEAN L'ÉVANGÉLISTE - 1923");
		this.setLicence("Cette oeuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution - Pas d'Utilisation Commerciale - Partage dans les Mêmes Conditions 3.0 non transposé.");
		this.setTradition("Christianisme");
		this.setChurch("Eglise catholique romaine");
		this.setCanon("Canon catholique");
		
		this.initBooks_Definition();
		
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
				throw new Exception("Unexpected error when reading XTHML file on book <" + book.getBookName() + "> ");
			}
			Document doc = Jsoup.parse(xhtmlText);
			
			this.initBook_FillIt(doc, book, xhtmlText);
			
		}
	}
	
	private void initBooks_Definition() throws Exception {
		TypeChapter psaume = TypeChapter.PSAUME;
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
			this.addBook(new BibleBook("Premier livre des Machabées","1Mach",20,"Ancien Testament","1Machabees.xhtml"));
			this.addBook(new BibleBook("Deuxième livre des Machabées","2Mach",21,"Ancien Testament","2Machabees.xhtml"));
			this.addBook(new BibleBook("Job","Jb",22,"Ancien Testament","Job.xhtml"));
			this.addBook(new BibleBook("Psaumes - Livre Premier (1-41)",psaume.getAbreviation(),23,"Ancien Testament","1Psaumes.xhtml"));
			this.addBook(new BibleBook("Psaumes - Livre Deuxième (42-72)",psaume.getAbreviation(),23,"Ancien Testament","2Psaumes.xhtml"));
			this.addBook(new BibleBook("Psaumes - Livre Troisième (73-89)",psaume.getAbreviation(),23,"Ancien Testament","3Psaumes.xhtml"));
			this.addBook(new BibleBook("Psaumes - Livre Quatrième (90-106)",psaume.getAbreviation(),23,"Ancien Testament","4Psaumes.xhtml"));
			this.addBook(new BibleBook("Psaumes - Livre Cinquième (107-150)",psaume.getAbreviation(),23,"Ancien Testament","5Psaumes.xhtml"));
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
			throw new Exception("Unexpected error when adding book.");
		}
	}
	
	private void initBook_FillIt(Document doc, BibleBook book, String xhtmlText) throws Exception {
		String bodyHtml = null;
		String bodyTag = "body";
		String bookIntro = null;
		String bookContent = null;
		Integer intCheckIncludingChapitres = 0;
		Integer intCheckWithoutChapitres = 0;
		Boolean bookWithoutChapitres = false;
		
		if (JSOUP_Method) {
			Element body = doc.select(bodyTag).first();
			bodyHtml = body.html();
		} else {
			Integer bodyIndice = 0;
			// TODO Ajouter un StartOf et un EndOf pour disposer de l'ensemble du livre au format xhtml
			String regexBodyHtml = "(?:<body>)([\\S\\s]*)(?:<\\/body>)";
			Pattern pBodyHtml = Pattern.compile(regexBodyHtml);
			Matcher mBodyHtml = pBodyHtml.matcher(xhtmlText);
			if (mBodyHtml.groupCount() != 1) {
				throw new Exception("Unexpected error when getting xhtml body content (Err #1) from book <" + book.getBookName() + ">");
			}
			while (mBodyHtml.find()) {
				bodyIndice++;
				bodyHtml = mBodyHtml.group(1);
			}
			if (bodyIndice != 1) {
				throw new Exception("Unexpected error when getting xhtml body content (Err #2) from book <" + book.getBookName() + ">");
			}
		}
		String regexIntroIncludingChapitres = "([\\S\\s]*?)(<h3 class=\"sigil_not_in_toc\">(?:Psaume .*|<u>Chapitre .*<\\/u>)<\\/h3>?[\\S\\s]*)";
		Pattern pIntroIncludingChapitres = Pattern.compile(regexIntroIncludingChapitres);
		Matcher mIntroIncludingChapitres = pIntroIncludingChapitres.matcher(bodyHtml);
		if (mIntroIncludingChapitres.groupCount() != 2) {
			throw new Exception("Unexpected error when getting introduction (Err #2) from book <" + book.getBookName() + ">");
		}
		while (mIntroIncludingChapitres.find()) {
			intCheckIncludingChapitres++;
			bookIntro = mIntroIncludingChapitres.group(1);
			bookContent = mIntroIncludingChapitres.group(2);
		}
		// Gérer les livres sans chapitres
		if ( (intCheckIncludingChapitres == 0) && (
				(book.getBookName().equals(new String("Abdias"))) || 
				(book.getBookName().equals(new String("Épître de Saint Paul à Philémon"))) || 
				(book.getBookName().equals(new String("Deuxième Épître de Saint Jean"))) || 
				(book.getBookName().equals(new String("Troisième Épître de Saint Jean"))) ||
				(book.getBookName().equals(new String("Épître de Saint Jude")))
			  
			) ) {
			bookWithoutChapitres = true;
			String regexIntroWithoutChapitres = "([\\S\\s]*?)(<h2 align=\"center\">(?:.*)<\\/h2>?[\\S\\s]*)";
			Pattern pIntroWithoutChapitres = Pattern.compile(regexIntroWithoutChapitres);
			Matcher mIntroWithoutChapitres = pIntroWithoutChapitres.matcher(bodyHtml);
			if (mIntroWithoutChapitres.groupCount() != 2) {
				throw new Exception("Unexpected error when getting introduction (Err #4) from book <" + book.getBookName() + ">");
			}
			while (mIntroWithoutChapitres.find()) {
				intCheckWithoutChapitres++;
				bookIntro = mIntroWithoutChapitres.group(1);
				bookContent = mIntroWithoutChapitres.group(2);
			}
			if (intCheckWithoutChapitres != 1) {
				throw new Exception("Unexpected error when getting introduction (Err #5) from book <" + book.getBookName() + ">");
			}
		} else if (intCheckIncludingChapitres != 1) {
			throw new Exception("Unexpected error when getting introduction (Err #3) from book <" + book.getBookName() + ">");
		}
		if (bookIntro != null && bookIntro.length() > 0) {
			book.setBookIntroduction(bookIntro);
		}
		initBook_ChaptersContent(doc, book, bookContent, bookWithoutChapitres);
	}
	
	private void initBook_ChaptersContent(Document doc, BibleBook book, String bookContent, Boolean bookWithoutChapitres) throws Exception {
		
		if (bookWithoutChapitres) {
			// Il n'y a qu'un seul chapitre non nommé (pas de tag H3)
			// Le contenu du chapitre sera alors tout le texte après le tag H2 du titre du livre
			// TODO Revoir le titre du chapitre (dans le constructeur BibleChapter) dans le cas d'un livre sans chapitre - utiliser une constante ?!
			BibleChapter uniqueChapter = new BibleChapter("", 1);
			uniqueChapter.setChapterContent(bookContent);
			initBook_VersetsContent(doc, book, uniqueChapter, bookContent);
			book.addChapter(uniqueChapter);
		} else {
			BibleChapter newChapter = null;
			Integer chapterIndice = 0;
			Integer chapterNumber = 0;
			String chapterNameWithTags = null;
			String chapterName = null;
			String chapterContent = null;
			String startOfChapter = null;
			String endOfChapter = null;
			Integer indiceTagChapitres = 0;
			String regexChapitresWithTags = "(<h3 class=\"sigil_not_in_toc\">(Psaume .*|<u>Chapitre .*<\\/u>)<\\/h3>?[\\S]*?)([\\S\\s]*?(?=(?=<h3 class=\"sigil_not_in_toc\">(?:Psaume .*|<u>Chapitre .*<\\/u>)<\\/h3>)|(?=\\Z)))";
			Pattern pChapitresWithTags = Pattern.compile(regexChapitresWithTags);
			Matcher mChapitresWithTags = pChapitresWithTags.matcher(bookContent);
			if (mChapitresWithTags.groupCount() != 3) {
				throw new Exception("Unexpected error when getting chapitres (Err #1) from book <" + book.getBookName() + ">");
			}
			while (mChapitresWithTags.find()) {
				chapterIndice++;
				// TODO Affecter chapterNumber avec le numéro réel de chapitre ou psaume et pas l'indice ! => voir testBCCChaptersNumber() 
				chapterNumber = chapterIndice;
				startOfChapter = mChapitresWithTags.group(1);
				chapterNameWithTags = mChapitresWithTags.group(2);
				
				String regexChapitres = "(?:<u>)(Chapitre .*)(?:<\\/u>)";
				Pattern pChapitres = Pattern.compile(regexChapitres);
				Matcher mChapitres = pChapitres.matcher(chapterNameWithTags);
				if (mChapitres.groupCount() != 1) {
					throw new Exception("Unexpected error when getting chapitres (Err #2) from book <" + book.getBookName() + ">");
				}
				indiceTagChapitres = 0;
				while (mChapitres.find()) {
					indiceTagChapitres++;
					chapterName = mChapitres.group(1);
				}
				if (indiceTagChapitres > 1) {
					throw new Exception("Unexpected error when getting chapitres (Err #3) from book <" + book.getBookName() + ">");
				} else if (indiceTagChapitres == 0) {
					// Il ne s'agit pas d'un chapitre de type "<u>Chapitre xx</u>" mais plutôt d'un psaume
					chapterName = chapterNameWithTags;
				}
				chapterContent = mChapitresWithTags.group(3);
				newChapter = new BibleChapter(chapterName, chapterNumber);
				
				Integer chapitrePrepareIndice = 0;
				String VersetsContent = null;
				String regexPrepareChapitre = "([\\S\\s]*<p>?)([\\S\\s]*)(<\\/p>[\\S\\s]*)";
				Pattern pPrepareChapitre = Pattern.compile(regexPrepareChapitre);
				Matcher mPrepareChapitre = pPrepareChapitre.matcher(chapterContent);
				if (mPrepareChapitre.groupCount() != 3) {
					throw new Exception("Unexpected error when getting versets (Err #1) from book <" + book.getBookName() + "> of chapter #" + newChapter.getChapterNumber().toString());
				}
				while (mPrepareChapitre.find()) {
					chapitrePrepareIndice++;
					startOfChapter = startOfChapter + mPrepareChapitre.group(1);
					VersetsContent = mPrepareChapitre.group(2);
					endOfChapter = mPrepareChapitre.group(3);
				}
				if (chapitrePrepareIndice != 1) {
					throw new Exception("Unexpected error when getting versets (Err #2) from book <" + book.getBookName() + "> of chapter #" + newChapter.getChapterNumber().toString());
				}
				
				newChapter.setStartOfChapter(startOfChapter);
				newChapter.setChapterContent(VersetsContent);
				newChapter.setEndOfChapter(endOfChapter);
				initBook_VersetsContent(doc, book, newChapter, VersetsContent);
				try {
					book.addChapter(newChapter);
				} catch (Exception e) {
					throw new Exception("Unexpected error when adding chapter #" + chapterNumber.toString() + " (<" + chapterName + ">) from book <" + book.getBookName() + ">" + " - " + e.getMessage());
				}
			}
		}
	}
	
	private void initBook_VersetsContent(Document doc, BibleBook book, BibleChapter chapter, String VersetsContent) throws Exception {
		Integer versetIndice = 0;
		
		String regexVersets = "^([\\S\\s]*?[\\s]+([\\d]+)[\\s]{1})([\\S\\s]*?)(?=(?=^[\\s]+[\\d]+[\\s]{1})|(?=\\Z))";
		Pattern pVersets = Pattern.compile(regexVersets, Pattern.MULTILINE);
		Matcher mVersets = pVersets.matcher(VersetsContent);
		if (mVersets.groupCount() != 3) {
			throw new Exception("Unexpected error when getting versets (Err #3) from book <" + book.getBookName() + "> of chapter #" + chapter.getChapterNumber().toString());
		}
		while (mVersets.find()) {
			versetIndice++;
			String versetIntroduction = mVersets.group(1);
			Integer versetNumber = Integer.parseInt(mVersets.group(2));
			String versetContent = mVersets.group(3);
			BibleVerset newVerset = new BibleVerset(versetNumber);
			newVerset.setVersetContent(versetContent);
			newVerset.setVersetIntroduction(versetIntroduction);
			try {
				chapter.addVerset(newVerset);
			} catch (Exception e) {
				throw new Exception("Unexpected error when adding verset #" + versetNumber.toString() + " of chapter #" + chapter.getChapterNumber().toString() + " (<" + chapter.getChapterName() + ">) from book <" + book.getBookName() + ">" + " - " + e.getMessage());
			}
		}
	}
	
}
