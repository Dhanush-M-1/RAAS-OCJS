import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ChatServer {

	private Set<String> users;
	private int traffic;
	
	public ChatServer() {
		this.users = new HashSet<String>();
		this.traffic = 0;
	}
	
	public void processCommand(String command) {
		if(command.isEmpty())
			return;
		switch(command.charAt(0)) {
			case '+': 
			{
				users.add(command.substring(1));
				break;
			}
			case '-':
			{
				users.remove(command.substring(1));
				break;
			}
			default:
			{
				traffic += command.substring((command.indexOf(':') + 1)).length() * users.size();
			}
		}
	}
	
	public int getTraffic()
	{
		return traffic;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ChatServer server = new ChatServer(); 
		String command;
		if(input.hasNextLine())
		{//
			command = input.nextLine();
			while(!command.isEmpty() && input.hasNextLine()) {
				server.processCommand(command);
				command = input.nextLine();
			}
			server.processCommand(command);
		}
		System.out.println(server.getTraffic());
		input.close();
	}

}
