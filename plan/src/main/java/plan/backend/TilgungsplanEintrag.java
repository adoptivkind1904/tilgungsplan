package plan.backend;

import plan.utils.LastDayOfMonth;
import plan.utils.Utils;

public class TilgungsplanEintrag {
	private LastDayOfMonth datum;
	private double restschuld;
	private double zinsen;
	private double zinssatz;
	private double tilgAusz;
	private double rate;
	
	
	public TilgungsplanEintrag(LastDayOfMonth datum, double restschuld, double zinsen,double zinssatz, double tilgAusz, double rate) {
		super();
		this.datum = datum;
		this.restschuld = restschuld;
		this.zinsen = zinsen;
		this.zinssatz = zinssatz;
		this.tilgAusz = tilgAusz;
		this.rate = rate;
	}
	
	/**
	 * berechnet den nächsten Eintrag, ausgehend vom aktuellen
	 * @return nächster Eintrag des Tilgungsplans
	 */
	public TilgungsplanEintrag calcNext() {
		LastDayOfMonth nextdatum = new LastDayOfMonth(datum.getMonth(), datum.getYear());
		nextdatum.incMonth();
		
		double nextzinsen = Utils.runden(-1*restschuld*zinssatz/100/12);
		double nextTilgAusz = Utils.runden(rate-nextzinsen);
		double nextRestschuld = Utils.runden(restschuld + nextTilgAusz);
		return new TilgungsplanEintrag(nextdatum, nextRestschuld, nextzinsen, zinssatz, nextTilgAusz, rate);
	
	}
	
	public LastDayOfMonth getDatum() {
		return datum;
	}
	public void setDatum(LastDayOfMonth datum) {
		this.datum = datum;
	}
	public double getRestschuld() {
		return restschuld;
	}
	public void setRestschuld(double restschuld) {
		this.restschuld = restschuld;
	}
	public double getZinsen() {
		return zinsen;
	}
	public void setZinsen(double zinsen) {
		this.zinsen = zinsen;
	}
	public double getTilgAusz() {
		return tilgAusz;
	}
	public void setTilgAusz(double tilgAusz) {
		this.tilgAusz = tilgAusz;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getZinssatz() {
		return zinssatz;
	}

	public void setZinssatz(double zinssatz) {
		this.zinssatz = zinssatz;
	}
	
	
}
