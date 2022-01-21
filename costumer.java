package khachhang;

import java.io.Serializable;

public class costumer implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int ID;
private String name;
private String adress;
private int year;
private float point;
costumer Left;
costumer Right;

	public costumer() {
		this.ID = 0;
		this.name = "";
		this.adress = "";
		this.year = 0;
		this.point = 0;
		this.Left=null;
		this.Right=null;
	}
	
	public costumer(int ID, String name, String adress, int year, float point){
		this.ID = ID;
		this.name = name;
		this.adress = adress;
		this.year = year;
		this.point = point;
		this.Left=null;
		this.Right=null;
	}
	
	public void input(int ID, String name, String adress, int year, float point){
		this.ID = ID;
		this.name = name;
		this.adress = adress;
		this.year = year;
		this.point = point;
	}
	
	public void output(int i) {
		System.out.printf("%-20s%-20d %-20s %-20s %-20s %-20s %n",i+1,this.ID,this.name,this.year,this.adress,ranking());
	}
	
	public int get_ID() {
		return this.ID;
	}
	public void set_ID(int ID) {
		this.ID=ID;
	}
	public String get_Name() {
		return this.name;
	}
	public void set_Name(String name) {
		this.name=name;
	}
	public String get_Adress() {
		return this.adress;
	}
	public void set_Adress(String adress) {
		this.adress=adress;
	}
	public int get_Year() {
		return this.year;
	}
	public void set_Year(int year) {
		this.year=year;
	}
	public float get_Point() {
		return this.point;
	}
	public void set_Point(float point) {
		this.point=point;
	}
	
	public String ranking() {
		if(this.point>=808)
			return "Gold";
		else if(this.point>=500)
			return "Silver";
		else
			return "Normal";
	}
}