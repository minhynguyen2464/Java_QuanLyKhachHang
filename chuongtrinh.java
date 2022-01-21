package khachhang;
import java.util.LinkedList;

import baithuchanh3.sinhvien;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class chuongtrinh {
		public static boolean write_account(LinkedList<account> accountList, String filename) {
			//File file = new File(filename);
			try {
				FileOutputStream fos = new FileOutputStream(filename); //khai bao fos oos
				ObjectOutputStream oos = new ObjectOutputStream(fos); 
				oos.writeObject(accountList); //thuc hien
				oos.close(); // close
				fos.close();
				return true;
			}catch(Exception e) {e.printStackTrace();}
			return false;
		}
		@SuppressWarnings("unchecked")
		public static LinkedList<account> read_account(String filename){
			LinkedList<account> danhsach = new LinkedList<>();
			try {
				FileInputStream fis = new FileInputStream(filename); //khai bao fis ois
				ObjectInputStream ois = new ObjectInputStream(fis); 
				Object obj = ois.readObject(); //thuc hien
				danhsach = 	(LinkedList<account>) obj; 
				ois.close(); //close
				fis.close();
			}catch (Exception e) {e.printStackTrace();}
			return danhsach;
		}
		
		public static boolean write_costumer(costumer BST_Tree, String filename) {
			//File file = new File(filename);
			try {
				FileOutputStream fos = new FileOutputStream(filename); //khai bao fos oos
				ObjectOutputStream oos = new ObjectOutputStream(fos); 
				oos.writeObject(BST_Tree); //thuc hien
				oos.close(); // close
				fos.close();
				return true;
			}catch(Exception e) {e.printStackTrace();}
			return false;
		}
		public static costumer read_costumer(String filename){
			//LinkedList<account> danhsach = new LinkedList<>();
			costumer danhsach = new costumer();
			try {
				FileInputStream fis = new FileInputStream(filename); //khai bao fis ois
				ObjectInputStream ois = new ObjectInputStream(fis); 
				Object obj = ois.readObject(); //thuc hien
				danhsach = 	(costumer) obj; 
				ois.close(); //close
				fis.close();
			}catch (Exception e) {e.printStackTrace();}
			return danhsach;
		}
		
		public static boolean write_product(LinkedList<products> productList, String filename) {
			//File file = new File(filename);
			try {
				FileOutputStream fos = new FileOutputStream(filename); //khai bao fos oos
				ObjectOutputStream oos = new ObjectOutputStream(fos); 
				oos.writeObject(productList); //thuc hien
				oos.close(); // close
				fos.close();
				return true;
			}catch(Exception e) {e.printStackTrace();}
			return false;
		}
		@SuppressWarnings("unchecked")
		public static LinkedList<products> read_product(String filename){
			//LinkedList<account> danhsach = new LinkedList<>();
			LinkedList<products> danhsach = new LinkedList<>();
			try {
				FileInputStream fis = new FileInputStream(filename); //khai bao fis ois
				ObjectInputStream ois = new ObjectInputStream(fis); 
				Object obj = ois.readObject(); //thuc hien
				danhsach = 	(LinkedList<products>) obj; 
				ois.close(); //close
				fis.close();
			}catch (Exception e) {e.printStackTrace();}
			return danhsach;
		}
//////////////////////////////////////////////////////////////////////////		
		public static void main (String[] agrs) {
			costumer_manager Manager = new costumer_manager();
			costumer BST_Tree= read_costumer("D:\\costumerlist.txt"); //Nhap vao danh sach khach hang
			LinkedList<account> accountList = read_account("D:\\account.txt"); //Nhap vao danh sach tai khoan
			LinkedList<products> productList = read_product("D:\\productlist.txt"); //Nhap vao danh sach san pham
			/*
			products product1 = new products(101,"Asus ROG Phone 5",800);
			products product2 = new products(102,"Xiaomi Mi 11i",760);
			products product3 = new products(103,"Asus ROG Phone 5 Ultimate",1550);
			products product4 = new products(104,"Xiaomi Mi 11 Ultra",915);
			products product5 = new products(105,"Oneplus 8T+5G",750);
			products product6 = new products(106,"Apple Iphone 13 Pro Max",1099);
			productList.add(0,product1);
			productList.add(1,product2);
			productList.add(2,product3);
			productList.add(3,product4);
			productList.add(4,product5);
			productList.add(5,product6);
			*/
			int menu=1;
			while(menu!=0) {
				System.out.println(" ____________________ ");
				System.out.println("|1-Create new account|");
				System.out.println("|2-Login your account|");
				System.out.println("|0-Exit              |");
				System.out.println("|____________________|");
				menu = costumer_manager.sc.nextInt();
				switch(menu) {
					case 1:{ //Tao tai khoan
						Manager.register_account(accountList);
						write_account(accountList,"D:\\account.txt");
						break;
					}
					case 2:{ //Dang nhap tai khoan
						if (Manager.login_account(accountList)==true) { //Dang nhap thanh cong
							System.out.println("Login successsfully");
							if(accountList.get(Manager.account_index(accountList)).get_type()==2) {//Dang nhap vao tai khoan Guest
								int menu_guest=1;
								while (menu_guest!=0) {
									System.out.println("________________________");
									System.out.println("|MENU GUEST            |");
									System.out.println("|1-View customer info  |");
									System.out.println("|2-Buy products        |");
									System.out.println("|0-Save/Exit           |");
									System.out.println("|______________________|");
									menu_guest = costumer_manager.sc.nextInt();
									switch(menu_guest) {
										case 1:{
											System.out.println("1-Search using ID");
											System.out.println("2-Search using Name");
											int choice = costumer_manager.sc.nextInt();
											switch (choice){
												case 1:{
													System.out.println("Insert ID need to search: ");
													int ID_search = costumer_manager.sc.nextInt();
													System.out.printf("%-20s%-20s %-20s %-20s %-20s %-20s %n","STT","ID","Name","Date of birth","Adress","Ranking");
													Manager.customer_search_ID(BST_Tree, ID_search).output(0);
													break;
												}
												case 2:{
													System.out.println("Insert Name need to search: ");
													costumer_manager.sc.nextLine();
													String Name_search = costumer_manager.sc.nextLine();
													System.out.printf("%-20s%-20s %-20s %-20s %-20s %-20s %n","STT","ID","Name","Date of birth","Adress","Ranking");
													Manager.customer_search_name(BST_Tree, Name_search).output(0);
													break;
												}
											}
											break;
										}
										case 2:{
											Manager.buy_products(productList, BST_Tree);
											break;
										}
										case 0:{
											break;
										}
									}
								}
							}
							else { //Dang nhap bang tai khoan admin
								int menu_admin=1;
								while (menu_admin!=0) {
									System.out.println("______________________");
									System.out.println("|MENU ADMIN          |");
									System.out.println("|1-Insert 1 customer |");
									System.out.println("|2-View customer list|");
									System.out.println("|3-Delete customer   |");
									System.out.println("|4-Search customer   |");
									System.out.println("|5-Update customer   |");
									System.out.println("|6-Enter products    |");
									System.out.println("|7-View products     |");
									System.out.println("|0-Save/Exit         |");
									System.out.println("|____________________|");
									menu_admin = costumer_manager.sc.nextInt();
									switch(menu_admin) {
										case 1:{
											Manager.InsertCostumer(BST_Tree);
											break;
										}
										case 2:{
											System.out.printf("%-20s%-20s %-20s %-20s %-20s %-20s %n","STT","ID","Name","Date of birth","Adress","Ranking");
											Manager.OutputcostumerList(BST_Tree);
											break;
										}
										case 3:{
											System.out.println("Insert ID need to delete: ");
											int ID_search = costumer_manager.sc.nextInt();
											Manager.customer_delete_node(BST_Tree, ID_search);
											break;
										}
										case 4:{
											System.out.println("1-Search using ID");
											System.out.println("2-Search using Name");
											int choice = costumer_manager.sc.nextInt();
											switch (choice){
												case 1:{
													System.out.println("Insert ID need to search: ");
													int ID_search = costumer_manager.sc.nextInt();
													System.out.printf("%-20s%-20s %-20s %-20s %-20s %-20s %n","STT","ID","Name","Date of birth","Adress","Ranking");
													Manager.customer_search_ID(BST_Tree, ID_search).output(0);
													break;
												}
												case 2:{
													System.out.println("Insert Name need to search: ");
													costumer_manager.sc.nextLine();
													String Name_search = costumer_manager.sc.nextLine();
													System.out.printf("%-20s%-20s %-20s %-20s %-20s %-20s %n","STT","ID","Name","Date of birth","Adress","Ranking");
													Manager.customer_search_name(BST_Tree, Name_search).output(0);
													break;
												}
											}
											break;
										}
										case 5:{
											Manager.update_costumer(BST_Tree);
											break;
										}
										case 6:{
											Manager.input_product(productList);
											write_product(productList,"D:\\productlist.txt");
											break;
										}
										case 7:{
											Manager.output_product(productList);
											break;
										}
										case 0:{
											write_costumer(BST_Tree,"D:\\costumerlist.txt");
											break;
										}
									}
								}
							}
						}
						else //Dang nhap khong thanh cong
							System.out.println("Login unsucesfully, please retry");
					}
					case 0:{
						break;
					}
				}
			}
		}
}

