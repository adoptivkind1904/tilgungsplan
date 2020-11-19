package plan.utils;

public class LastDayOfMonth {
	private int day;
	private int month;
	private int year;
	
	
	
	public LastDayOfMonth(int month, int year) {
		super();
		setMonth(month);
		this.year = year;
		this.day = lastDay();
	}


	/**
	 * berechnet den letzten Tag eines Monats (Schaltjahre nicht berücksichtigt)
	 * @return letzten Tag des Monats
	 */
	protected int lastDay() {
		switch(month) {
		case 1: return 31;
		case 2: return 28;
		case 3: return 31;
		case 4: return 30;
		case 5: return 31;
		case 6: return 30;
		case 7: return 31;
		case 8: return 31;
		case 9: return 30;
		case 10: return 31;
		case 11: return 30;
		case 12: return 31;
		
		}
		return 31;
	}

	/**
	 * erhöht den aktuellen Monat um 1, das Jahr bei Jahreswechsel
	 */
	public void incMonth() {
		month++;
		if(month>12) {
			month = 1;
			year++;
		}
		this.day = lastDay();
	}


	public int getDay() {
		return day;
	}



	public void setDay(int day) {
		this.day = day;
	}



	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		if(month>12) {
			this.month=1;
		}
		else {
			this.month = month;
		}
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}
	
	
}
