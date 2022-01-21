package khachhang;

import java.io.Serializable;

public class products implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int ID;
private String name;
private float price;
	public products(){
	}
	
	public products(int ID, String name, float price) {
		this.ID = ID;
		this.name = name;
		this.price = price;
	}
	
	public void product_output(int stt) {
		System.out.printf("%-2d %-20d %-30s %-20.2f\n", stt,this.ID, this.name, this.price);
	}
	
	public void set_product_ID(int ID) {
		this.ID = ID;
	}
	public int get_product_ID() {
		return this.ID;
	}
	
	public void set_product_name(String name) {
		this.name = name;
	}
	public String get_product_name() {
		return this.name;
	}
	
	public void set_product_price(float price) {
		this.price = price;
	}
	public float get_product_price() {
		return this.price;
	}
}
