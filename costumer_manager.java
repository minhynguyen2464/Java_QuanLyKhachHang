package khachhang;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;


public class costumer_manager {
	public static int index=0;
	public static int stt=0;
	static Scanner sc = new Scanner(System.in);
	
	public costumer BST_add_node(costumer T,costumer newnode) {
		 if (T==null) 
			 return newnode;
		 else {
				if (newnode.get_ID()<T.get_ID()) 
				{
				T.Left=BST_add_node(T.Left,newnode);
				return T;
				}
				else {
				T.Right=BST_add_node(T.Right,newnode);
				return T;	
				}
		 	}							
	}
	public void AddCostumer(costumer T) {	
		System.out.println("INPUT COSTUMER INFORMATION: ");
		int kt=1;
		while(kt!=0) {
			int ID = 0;
			String Name="";
			int DOB = 0;
			String Adress="";
			float Point = 0;
			System.out.print("Costumer ID : ");
			ID = sc.nextInt();
			sc.nextLine();
			System.out.print("Costumer Name: ");
			Name = sc.nextLine();
			System.out.print("Costumer DOB: ");
			DOB=sc.nextInt();
			sc.nextLine();
			System.out.print("Costumer Adress: ");
			Adress=sc.nextLine();
			System.out.print("Costumer Point: ");
			Point = sc.nextFloat();
			sc.nextLine();
			costumer newcostumer = new costumer(ID,Name,Adress,DOB,Point);
			T=BST_add_node(T, newcostumer);
			System.out.println("Ban co muon nhap tiep khong Khong/0 Co/1: ");
			kt = sc.nextInt();
		}
	}
	
	public void OutputcostumerList(costumer T) {
		if (T==null) System.out.println("Cay rong");
		else
		{ 	
			if (T.Left!=null) OutputcostumerList(T.Left);
			T.output(stt++);
			if (T.Right!=null) OutputcostumerList(T.Right);
		}
	}
	
	public void InsertCostumer(costumer T) {
		System.out.println("INPUT COSTUMER INFORMATION: ");
			int ID = 0;
			String Name="";
			int DOB = 0;
			String Adress="";
			float Point = 0;
			System.out.print("Costumer ID : ");
			ID = sc.nextInt();
			sc.nextLine();
			System.out.print("Costumer Name: ");
			Name = sc.nextLine();
			System.out.print("Costumer DOB: ");
			DOB=sc.nextInt();
			sc.nextLine();
			System.out.print("Costumer Adress: ");
			Adress=sc.nextLine();
			System.out.print("Costumer Point: ");
			Point = sc.nextFloat();
			sc.nextLine();
			costumer newcostumer = new costumer(ID,Name,Adress,DOB,Point);
			T = BST_add_node(T,newcostumer);
	}
	
	//Node trai nhat
	public costumer TheLeftmost_node(costumer T) {
		if (T.Left==null) return T;
		else return TheLeftmost_node(T.Left);
	}
	//Xoa nod BT
	public costumer delete_node(costumer T, int ID) {
		if (T==null) return null;
		else
		if (T.get_ID()==ID) { 
			costumer T1=T.Left;	
			costumer T2=T.Right;
			if ((T1==null)&&(T2==null)) return null;
			else if (T2==null) return T1;
			else if (T1==null) return T2;
			else
			{ 	T=T1;
				while (T1.Left!=null) {T1=T1.Left;}
				T1.Left=T2;
				return T;
			}
		
		}
		else {	T.Left=delete_node(T.Left,ID);
				T.Right=delete_node(T.Right,ID);
				return T;}
				
			}
		//Xoa node BST
		public costumer customer_delete_node(costumer T, int ID) {
			if (T==null) return null;
			else if (T.get_ID()==ID) {
				if (T.Left==null) return T.Right;
				else if (T.Right==null) return T.Left;
				else {
					costumer LeftMost = TheLeftmost_node(T.Right);
					T.input(LeftMost.get_ID(),LeftMost.get_Name(),LeftMost.get_Adress(),LeftMost.get_Year(),LeftMost.get_Point());
					T.Right=delete_node(T.Right,LeftMost.get_ID());
					return T;
					}
				}
			else {
					if (T.get_ID()>ID) T.Left=customer_delete_node(T.Left,ID);
					else T.Right=customer_delete_node(T.Right,ID);
					return T;
				}
			}
		
		//Tim kiem khach hang theo ID
		public costumer customer_search_ID(costumer T, int ID) {
			if (T==null)
				return null;
			else if (T.get_ID()==ID)
				return T;
			else if (T.get_ID()>ID) 
				return customer_search_ID(T.Left,ID);
			else
				return customer_search_ID(T.Right,ID);
		}
		//Tim kiem khach hang theo ten
		public costumer customer_search_name(costumer T, String name) {
			if (T==null)
				return null;
			else if (T.get_Name().compareTo(name)==0) 
				return T;
			else if (customer_search_name(T.Left,name)!=null) 
				return customer_search_name(T.Left,name);
			else
				return customer_search_name(T.Right,name);
		}
		//Cap nhat khach hang
		public void update_costumer(costumer T) {
			ArrayList<costumer> tempList = new ArrayList<costumer>();
			Queue<costumer> myQueue = new LinkedList<costumer>();
			myQueue.add(T);
			while(!myQueue.isEmpty()) {
				costumer tempNode = myQueue.poll();
				tempList.add(tempNode);
				if (tempNode.Left!=null)
					myQueue.add(tempNode.Left);
				if(tempNode.Right!=null)
					myQueue.add(tempNode.Right);
			}
			System.out.println("Enter customer ID to update: ");
			int ID_search = sc.nextInt();
			for (int i=0; i<tempList.size();i++){
				if (tempList.get(i).get_ID()==ID_search) {
					System.out.println("What do you want to update");
					System.out.println("1-ID");
					System.out.println("2-Name");
					System.out.println("3-Adress");
					System.out.println("4-Date of Birth");
					System.out.println("5-Point");
					int choice = sc.nextInt();
					switch(choice) {
						case 1:{
							System.out.println("Enter update ID: ");
							int ID_update = sc.nextInt();
							tempList.get(i).set_ID(ID_update);
							break;
						}
						case 2:{
							System.out.println("Enter update Name: ");
							sc.nextLine();
							String name_update = sc.nextLine();
							tempList.get(i).set_Name(name_update);
							break;
						}
						case 3:{
							System.out.println("Enter update Adress: ");
							sc.nextLine();
							String Adress_update = sc.nextLine();
							tempList.get(i).set_Adress(Adress_update);
							break;
						}
						case 4:{
							System.out.println("Enter update DOB: ");
							int DOB_update = sc.nextInt();
							tempList.get(i).set_Year(DOB_update);
							break;
						}
						case 5:{
							System.out.println("Enter update Point: ");
							float Point_update = sc.nextFloat();
							tempList.get(i).set_Point(Point_update);
							break;
						}
					}
					tempList.get(i).output(0);	
				}
			}
		}
		//Nhap username, password
		public void register_account(LinkedList<account> accountList) {
			System.out.println("1-Create Admin account");
			System.out.println("2-Create Guests account");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:{
					System.out.print("Enter new username: ");
					sc.nextLine();
					String username = sc.nextLine();
					for(int i=0; i<accountList.size(); i++)
						if (username.compareTo(accountList.get(i).get_username())==0) {
							System.out.println("Username already existed");
							return;
						}
					System.out.print("Enter new password: ");			
					String password = sc.nextLine();
					int type = 1;
					account newacc = new account(username,password,type);
					accountList.add(newacc);
					break;
				}
				case 2:{
					System.out.print("Enter new username: ");
					sc.nextLine();
					String username = sc.nextLine();
					for(int i=0; i<accountList.size(); i++)
						if (username.compareTo(accountList.get(i).get_username())==0) {
							System.out.println("Username already existed");
							return;
						}
					System.out.print("Enter new password: ");			
					String password = sc.nextLine();
					int type = 2;
					account newacc = new account(username,password,type);
					accountList.add(newacc);
					break;
				}
			}
		}
		
		public boolean login_account(LinkedList<account> accountList) {
			index=-1;
			System.out.print("Enter username: ");
			sc.nextLine();
			String username = sc.nextLine();
			for(int i=0; i<accountList.size(); i++) {
				if(username.compareTo(accountList.get(i).get_username())==0) {
					System.out.print("Enter password: ");
					String password = sc.nextLine();
					if(password.compareTo(accountList.get(i).get_password())==0) {
						index = i;
						return true;
					}
						
				}
			}
			return false;
		}
		
		public int account_index(LinkedList<account> accountList) {
			int vitri = index;
			return vitri;
		}
		
		public void input_product(LinkedList<products> productList) {
			int check = 1;
			while (check==1) {
				System.out.println("Enter product ID: ");
				int ID = sc.nextInt();
				System.out.println("Enter product name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter product price (USD): ");
				float price = sc.nextFloat();
				products new_product = new products(ID,name,price);
				productList.add(new_product);
				System.out.println("Do you want to add more 1/Yes 0/No");
				check = sc.nextInt();
			}
		}
		
		public void output_product(LinkedList<products> productList) {
			System.out.printf("%-2s %-20s %-30s %-20s\n", "STT","ID", "Product name", "Price");
			for (int i=0; i<productList.size(); i++) {
				productList.get(i).product_output(i+1);
			}
		}
		public void buy_products(LinkedList<products> productList, costumer T) {
			ArrayList<costumer> tempList = new ArrayList<costumer>();
			Queue<costumer> myQueue = new LinkedList<costumer>();
			myQueue.add(T);
			while(!myQueue.isEmpty()) {
				costumer tempNode = myQueue.poll();
				tempList.add(tempNode);
				if (tempNode.Left!=null)
					myQueue.add(tempNode.Left);
				if(tempNode.Right!=null)
					myQueue.add(tempNode.Right);
			}
			System.out.println("Enter your ID here: ");
			int ID_search = sc.nextInt();
			for(int i=0; i<tempList.size(); i++) {
				if (ID_search == tempList.get(i).get_ID()) {
					output_product(productList);
					System.out.println("1 USD = 0.1 point");
					System.out.println("Enter your product STT want to buy: ");
					int choice = sc.nextInt();
					float old_point = tempList.get(i).get_Point();
					float new_point = (float) (old_point+productList.get(choice-1).get_product_price()*0.1);
					System.out.println("You got more "+(new_point-old_point)+" points");
					System.out.println("Your total point is "+new_point+" points");
					tempList.get(i).set_Point(new_point);
				}
			}
		}
}

