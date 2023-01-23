package whatsapp;

public class Login {
	static int count=1;
	String name;
	String password;
	int userCount;
	int message_count=0;
	String[] userMsg;
	Login(String name,String password){
		this.name=name;
		this.password=password;
		this.userCount=count++;
		this.message_count=message_count;   //no. of unread messages
		this.userMsg=userMsg;   // msg received
	}
}
