/**
 * 
 */
package com.janothome.bcctodb;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

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
	 * 
	 */
	public BCCBible() {
		super("Bible Chanoine Crampon");
		
		this.setVersion("1.0");
		this.setLongName("La Saint Bible d'après les textes originaux par l'abbé Augustin Crampon, chanoine d'Amiens - Edition 1923");
		this.setDigitalization("Edition numérique/relecture et vérifications par Jean-Marie WEBER pour www.mission-web.com");
		this.setEdition("Edition réisée par les Pères de la Cie de Jésus avec la collaboration de Professeurs de S. Sulpice - SOCIÉTÉ DE S. JEAN L'ÉVANGÉLISTE - 1923");
		this.setLicence("Cette oeuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution - Pas d'Utilisation Commerciale - Partage dans les Mêmes Conditions 3.0 non transposé.");
		this.setTradition("Christianisme");
		this.setChurch("Eglise catholique romaine");
		
		// Insertion des livres dans l'ordre
		this.addBook(new BibleBook("Genèse","Gn",1,"Ancien Testament","Genese.xhtml"));
		this.addBook(new BibleBook("Exode","Ex",2,"Ancien Testament","Exode.xhtml"));
		this.addBook(new BibleBook("Lévitique","Lv",3,"Ancien Testament","Levitique.xhtml"));
		this.addBook(new BibleBook("Nombres","Nb",4,"Ancien Testament","Nombres.xhtml"));
		this.addBook(new BibleBook("Deutéronome","Dt",5,"Ancien Testament","Deuteronome.xhtml"));
		this.addBook(new BibleBook("Josué","Jos",6,"Ancien Testament","josue.xhtml"));
		this.addBook(new BibleBook("Juges","Jg",7,"Ancien Testament","juges.xhtml"));
		this.addBook(new BibleBook("Ruth","Rt",8,"Ancien Testament","ruth.xhtml"));
		this.addBook(new BibleBook("1 Samuel","1 S",9,"Ancien Testament","1Samuel.xhtml"));
		this.addBook(new BibleBook("2 Samuel","2 S",10,"Ancien Testament","2Samuel.xhtml"));
		this.addBook(new BibleBook("1 Rois","1 R",11,"Ancien Testament","1Rois.xhtml"));
		this.addBook(new BibleBook("2 Rois","2 R",12,"Ancien Testament","2Rois.xhtml"));
		this.addBook(new BibleBook("1 Chroniques","1 Ch",13,"Ancien Testament","1Chroniques.xhtml"));
		this.addBook(new BibleBook("2 Chroniques","2 Ch",14,"Ancien Testament","2Chroniques.xhtml"));
		this.addBook(new BibleBook("Esdras","Esd",15,"Ancien Testament","Esdras.xhtml"));
		this.addBook(new BibleBook("Néhémie","Ne",16,"Ancien Testament","Nehemie.xhtml"));
		this.addBook(new BibleBook("Tobie","Tb",17,"Ancien Testament","Tobie.xhtml"));
		this.addBook(new BibleBook("Judith","Jdt",18,"Ancien Testament","Judith.xhtml"));
		this.addBook(new BibleBook("Esther","Est",19,"Ancien Testament","Esther.xhtml"));
		this.addBook(new BibleBook("1 Machabées","1 M",20,"Ancien Testament","1Machabees.xhtml"));
		this.addBook(new BibleBook("2 Machabées","2 M",21,"Ancien Testament","2Machabees.xhtml"));
		this.addBook(new BibleBook("Job","Jb",22,"Ancien Testament","Job.xhtml"));
		this.addBook(new BibleBook("Livre Premier (n° 1-41)","Ps",23,"Ancien Testament","1Psaumes.xhtml"));
		this.addBook(new BibleBook("Livre Deuxième (n° 42-72)","Ps",23,"Ancien Testament","2Psaumes.xhtml"));
		this.addBook(new BibleBook("Livre Troisième (n° 73-89)","Ps",23,"Ancien Testament","3Psaumes.xhtml"));
		this.addBook(new BibleBook("Livre Quatrième (n° 90-106)","Ps",23,"Ancien Testament","4Psaumes.xhtml"));
		this.addBook(new BibleBook("Livre Cinquième (n° 107-150)","Ps",23,"Ancien Testament","5Psaumes.xhtml"));
		this.addBook(new BibleBook("Proverbes","Pr",24,"Ancien Testament","Proverbes.xhtml"));
		this.addBook(new BibleBook("Écclésiaste","Qo",25,"Ancien Testament","Ecclesiaste.xhtml"));
		this.addBook(new BibleBook("Cantique des Cantiques","Ct",26,"Ancien Testament","cantique_des_cantiques.xhtml"));
		this.addBook(new BibleBook("Sagesse","Sg",27,"Ancien Testament","Sagesse.xhtml"));
		this.addBook(new BibleBook("Écclésiastique","Si",28,"Ancien Testament","Ecclesiastique.xhtml"));
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
		this.addBook(new BibleBook("Actes des Apôtres","Ac",51,"Nouveau Testament","Actes.xhtml"));
		this.addBook(new BibleBook("Épître aux Romains","Rm",52,"Nouveau Testament","Romains.xhtml"));
		this.addBook(new BibleBook("Première Épître aux Corinthiens","1 Co",53,"Nouveau Testament","1Corinthiens.xhtml"));
		this.addBook(new BibleBook("Deuxième Épître aux Corinthiens","2 Co",54,"Nouveau Testament","2Corinthiens.xhtml"));
		this.addBook(new BibleBook("Épître de Saint Paul aux Galates","Ga",55,"Nouveau Testament","Galates.xhtml"));
		this.addBook(new BibleBook("Épître de Saint Paul aux Éphésiens","Ep",56,"Nouveau Testament","Ephesiens.xhtml"));
		this.addBook(new BibleBook("Épître de Saint Paul aux Philippiens","Ph",57,"Nouveau Testament","Philippiens.xhtml"));
		this.addBook(new BibleBook("Épître de Saint Paul aux Colossiens","Col",58,"Nouveau Testament","Colossiens.xhtml"));
		this.addBook(new BibleBook("Première Épître aux Thessaloniciens","1 Th",59,"Nouveau Testament","1Thessaloniciens.xhtml"));
		this.addBook(new BibleBook("Deuxième Épître aux Thessaloniciens","2 Th",60,"Nouveau Testament","2Thessaloniciens.xhtml"));
		this.addBook(new BibleBook("Première Épître à Timothée","1 Tm",61,"Nouveau Testament","1Timothee.xhtml"));
		this.addBook(new BibleBook("Deuxième Épître à Timothée","2 Tm",62,"Nouveau Testament","2Timothee.xhtml"));
		this.addBook(new BibleBook("Épître à Tite","Tt",63,"Nouveau Testament","Tite.xhtml"));
		this.addBook(new BibleBook("Épître à Philémon","Phm",64,"Nouveau Testament","Philemon.xhtml"));
		this.addBook(new BibleBook("Épître aux Hébreux","He",65,"Nouveau Testament","Hebreux.xhtml"));
		this.addBook(new BibleBook("Épître de Saint Jacques","Jc",66,"Nouveau Testament","Jacques.xhtml"));
		this.addBook(new BibleBook("Première Épître de Saint Pierre","1 P",67,"Nouveau Testament","1Pierre.xhtml"));
		this.addBook(new BibleBook("Deuxième Épître de Saint Pierre","2 P",68,"Nouveau Testament","2Pierre.xhtml"));
		this.addBook(new BibleBook("Première Épître de Saint Jean","1 Jn",69,"Nouveau Testament","1Jean.xhtml"));
		this.addBook(new BibleBook("Deuxième Épître de Saint Jean","2 Jn",70,"Nouveau Testament","2Jean.xhtml"));
		this.addBook(new BibleBook("Troisième Épître de Saint Jean","3 Jn",71,"Nouveau Testament","3Jean.xhtml"));
		this.addBook(new BibleBook("Épître de Saint Jude","Jude",72,"Nouveau Testament","Jude.xhtml"));
		this.addBook(new BibleBook("Apocalypse","Ap",73,"Nouveau Testament","Apocalypse.xhtml"));

		LinkedHashMap<Integer, BibleBook> hashBooks = this.getBooks();
		// Get a set of the entries
		Set<Entry<Integer, BibleBook>> mapBooks = hashBooks.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, BibleBook>> itBooks = mapBooks.iterator();
		// Display elements
		while(itBooks.hasNext()) {
			Entry<Integer, BibleBook> me = itBooks.next();
			Integer bookKey = (Integer) me.getKey();
			BibleBook book = (BibleBook) me.getValue();
			System.out.println(bookKey.toString()+" - "+book.geBookName());
		}
		
	}

}
