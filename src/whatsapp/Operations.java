package whatsapp;

import java.util.HashMap;
import java.util.Scanner;

public class Operations {
	Scanner sc = new Scanner(System.in);
	HashMap<Integer,Login> userDetails = new HashMap<>();
	//adding users initially
	public void addUser(Login l) {				// add new user
		userDetails.put(l.userCount, l);
	}
	public void show() {
		for(Integer i : userDetails.keySet()) {
			System.out.println("USER NAME : "+userDetails.get(i).name);
		}
	}
	//checking user details
	public boolean check(String name1,String password1) {	     // checking user availability
		for(Integer i : userDetails.keySet()) {
			if(name1.equals(userDetails.get(i).name) && password1.equals(userDetails.get(i).password)) 
				return true;
		}
		return false;
	}
	//showcase chat persons except logged in person
	public void chats(String name1) {
		int count=1;
		for(Integer i : userDetails.keySet()) {
			if(!(userDetails.get(i).name.equals(name1))) {
				System.out.println("ID - "+userDetails.get(i).userCount+" : "+userDetails.get(i).name);
				count++;
			}
		}
		System.out.print("ENTER THEIR ID TO CHAT WITH THEM : ");
		int chatter = sc.nextInt();
		//sc.nextLine();
		for(Integer i : userDetails.keySet()) {
			if(userDetails.get(i).userCount==chatter) {
				System.out.println("Enter a message to chat with "+userDetails.get(i).name);
				sc.nextLine();
				String message = sc.nextLine();
				System.out.println(message);
				userDetails.get(i).message_count++;
			}
		}
	}
	public void notifications() {
		
	}
}
