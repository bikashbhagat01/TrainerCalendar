package com.trainer;

public class CDate implements Comparable<CDate>{

	// Defined CustomDate Class. Assumed all dates are valid
	private int m_day;
	private int m_month;
	private int m_year;
	
	// Setters and getters Created
	public int getM_day() {
		return m_day;
	}
	public void setM_day(int m_day) {
		this.m_day = m_day;
	}
	public int getM_month() {
		return m_month;
	}
	public void setM_month(int m_month) {
		this.m_month = m_month;
	}
	public int getM_year() {
		return m_year;
	}
	public void setM_year(int m_year) {
		this.m_year = m_year;
	}
	
	//Default Constructors
	public CDate(){
		this.m_day = 1;
		this.m_month = 12;
		this.m_year = 2019;
	}
	
	//Copy Constructor
	public CDate(CDate cdate){
		this.m_day = cdate.m_day;
		this.m_month = cdate.m_month;
		this.m_year = cdate.m_year;
		
	}
	
	// Parameterized Constructor
	public CDate(int day, int month, int year){
		this.m_day = day;
		this.m_month = month;
		this.m_year = year;
	}
	
	public CDate(String dateS){
		
		this.m_day = Integer.parseInt(dateS.substring(0,2));
		this.m_month = Integer.parseInt(dateS.substring(3,5));
		this.m_year = Integer.parseInt(dateS.substring(6));
		
	}
	
	public String toString() {
		
	//	return String.format("%2f",this.m_month) + "/" + String.format("%2f",this.m_day) + "/" + this.m_year;
		return this.m_day + "/" + this.m_month + "/"+ this.m_year;
	}
	
	// Compare to function implemented from comparable, to enable sort
	@Override
	public int compareTo(CDate aDate) {
		// TODO Auto-generated method stub
		
		if (this.m_year != aDate.m_year) {
			
			return this.m_year - aDate.m_year;
		}
		if(this.m_month != aDate.m_month){
			return this.m_month - aDate.m_month;
		}
			if(this.m_day != aDate.m_day)
		{
			return this.m_day - aDate.m_day;
		}
			return 0;
	
	} // End of CompareTo()
	
} // End of Class
