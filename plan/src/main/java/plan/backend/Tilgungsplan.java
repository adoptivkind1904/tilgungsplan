package plan.backend;

import java.util.ArrayList;
import plan.utils.LastDayOfMonth;
import plan.utils.Utils;

public class Tilgungsplan {
	private double betrag;
	private double sollzins;
	private double tilgungStart;
	private int zinsbindung;
	private double festeRate;
	private ArrayList<TilgungsplanEintrag> eintraege;

	public Tilgungsplan(double betrag, double sollzins, double tilgungStart, int zinsbindung) {
		super();
		this.betrag = betrag;
		this.sollzins = sollzins;
		this.tilgungStart = tilgungStart;
		this.zinsbindung = zinsbindung;
		festeRate = Utils.runden(betrag*(sollzins/100/12)+betrag*(tilgungStart/100/12));
		eintraege = new ArrayList<TilgungsplanEintrag>();
		LastDayOfMonth date = new LastDayOfMonth(11, 2020);
		
		eintraege.add(new TilgungsplanEintrag(date, betrag*-1, 0.0, sollzins, betrag*-1, betrag*-1));
	}
	
	/**
	 * berechnet den gesamten Tilgungsplan
	 */
	public void calcPlan() {
		
		//ersten richtigen Eintrag berechnen
		double firstZinsen = Utils.runden(betrag*sollzins/100/12);
		double firstTilgAusz = Utils.runden(festeRate-firstZinsen);
		double firstRestschuld = Utils.runden(-1*betrag + firstTilgAusz);
		
		LastDayOfMonth firstDate = new LastDayOfMonth(eintraege.get(0).getDatum().getMonth(), eintraege.get(0).getDatum().getYear());
		firstDate.incMonth();
		TilgungsplanEintrag first = new TilgungsplanEintrag(firstDate, firstRestschuld, firstZinsen, sollzins, firstTilgAusz, festeRate);
		eintraege.add(first);
		TilgungsplanEintrag next = first;

		//weitere Einträge bis Ende der Zinsbindung berechnen
		for(int i = 0; i<(zinsbindung*12)-1; i++) {
			next = next.calcNext();
			eintraege.add(next);
		}
		
		// Eintrag am Ende der Zinsbindung
		double zinsenGes= 0.0;
		double tilgGes= 0.0;
		double rateGes = 0.0; 
		for(TilgungsplanEintrag tpe: eintraege) {
			zinsenGes+= tpe.getZinsen();
			if(tpe.getTilgAusz()>=0) {
				tilgGes+=tpe.getTilgAusz();
			}
			if(tpe.getRate()>=0) {
				rateGes+=tpe.getRate();
			}
		}
		zinsenGes=Utils.runden(zinsenGes);
		tilgGes = Utils.runden(tilgGes);
		rateGes = Utils.runden(rateGes);
		eintraege.add(new TilgungsplanEintrag(next.getDatum(), next.getRestschuld(), zinsenGes, next.getZinssatz(), tilgGes, rateGes));
	}
	

	public double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

	public double getSollzins() {
		return sollzins;
	}

	public void setSollzins(double sollzins) {
		this.sollzins = sollzins;
	}

	public double getTilgungStart() {
		return tilgungStart;
	}

	public void setTilgungStart(double tilgungStart) {
		this.tilgungStart = tilgungStart;
	}

	public int getZinsbindung() {
		return zinsbindung;
	}

	public void setZinsbindung(int zinsbindung) {
		this.zinsbindung = zinsbindung;
	}

	public ArrayList<TilgungsplanEintrag> getEintraege() {
		return eintraege;
	}

	public void setEintraege(ArrayList<TilgungsplanEintrag> eintraege) {
		this.eintraege = eintraege;
	}

	public double getFesteRate() {
		return festeRate;
	}

	public void setFesteRate(double festeRate) {
		this.festeRate = festeRate;
	}
	
	
	
}
