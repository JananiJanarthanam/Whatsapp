//whatsapp model
//this is the main content checked once again.
package whatsapp;

import java.util.Scanner;

public class Whatsapp {
	static Scanner sc = new Scanner(System.in);
	static Operations ops = new Operations();
	static OneUser ou = new OneUser();        // error
	
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
			OneUser ou = new OneUser();
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
	static class OneUser{		// error
		String name1;
		public OneUser() {
			boolean loop=true;
			while(loop) {
				System.out.print("ENTER USER NAME : ");
				name1 = sc.next();
				System.out.print("ENTER PASSWORD : ");
				String password1 = sc.next();
				System.out.println();
				if(ops.check(name1,password1)) {
					System.out.println(name1+" Logged In Successfully...");
					OneUserOptions();
				}
				else {
					System.out.println("Invalid User Details...");
				}
				choices();
				return;
			}
		}
	}
	public static void OneUserOptions(){
		System.out.println("1)CHATTING \n2)CREATE GROUP \n3)STATUS \n4)LOGOUT");
		int userChoice = sc.nextInt();
		switch(userChoice) {
		case 1 : 
			System.out.println("CHATS WITH FRIENDS...");
			ops.chats(ou.name1);
			OneUserOptions();
			break;
		case 2 :
			System.out.println("CREATE GROUPS...");
			OneUserOptions();
			break;
		case 3 : 
			System.out.println("STATUSSSS....");
			OneUserOptions();
			break;
		case 4 :
			System.out.println(ou.name1+" Log Outted...");
			choices();
			break;
		default :
			System.out.println("Enter only given choicesss...");
			break;
		}
	}
}
