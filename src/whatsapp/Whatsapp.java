//whatsapp model
//this is the main content checked once again.
package whatsapp;

import java.util.Scanner;

public class Whatsapp {
	static Scanner sc = new Scanner(System.in);
	static Operations ops = new Operations();
	
	public static void main(String[] args) {

		System.out.print("ENTER HOW MANY USERS DO YOU WANT TO CREATE ACCOUNT(min 2) : ");
		int n = sc.nextInt();
		if(n<2) {
			System.out.println("Please enter minimum of 2 users...");
			main(args);
			return;
		}
		int count =1;
		while(n>0) {
			System.out.print("ENTER USER"+count+" NAME : ");
			String name = sc.next();
			System.out.print("ENTER PASSWORD : ");
			String password = sc.next();
			System.out.println();
			Login l = new Login(name,password);
			ops.addUser(l);
			n--;count++;
		}
		choices();
	}
	public static void choices() {
		System.out.println("1) LOG IN \n2) QUIT");
		int choice = sc.nextInt();
		switch(choice) {
		case 1 : 
			System.out.println("**************************************");
			System.out.println("\tWHATSAPP USER LOG IN : ");
			System.out.println("**************************************\n");
			OneUser();
			break;
		case 2 :
			System.out.println("Thank you...");
			return;  // exit state
		default :
			System.out.println("Enter only given choices...");
			choices();
			break;
		}
	}
	public static void OneUser() {

		boolean loop=true;
		while(loop) {
			System.out.print("ENTER USER NAME : ");
			String name1 = sc.next();
			System.out.print("ENTER PASSWORD : ");
			String password1 = sc.next();
			System.out.println();
			if(ops.check(name1,password1)) {
				System.out.println(name1+" Logged In Successfully...");
				int userChoice = UserOptionChoice();
				OneUserOptions(userChoice,name1);
			}
			else {
				System.out.println("Invalid User Details...");
			}
			choices();
			return;
		}
	}
	public static int UserOptionChoice() {
		System.out.println("1)CHATTING \n2)CREATE GROUP \n3)STATUS \n4)LOGOUT");
		int userChoice = sc.nextInt();
		return userChoice;
	}
	public static void OneUserOptions(int userChoice,String name1){
		switch(userChoice) {
		case 1 : 
			System.out.println("CHATS WITH FRIENDS...");
			ops.chats(name1);
			UserOptionChoice();
			break;
		case 2 :
			System.out.println("CREATE GROUPS...");
			UserOptionChoice();
			break;
		case 3 : 
			System.out.println("STATUSSSS....");
			UserOptionChoice();
			break;
		case 4 :
			System.out.println(name1+" Log Outted...");
			choices();
			break;
		default :
			System.out.println("Enter only given choicesss...");
			break;
		}
	}
}
