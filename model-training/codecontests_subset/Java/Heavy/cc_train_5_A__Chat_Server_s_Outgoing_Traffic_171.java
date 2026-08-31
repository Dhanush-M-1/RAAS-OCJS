import java.util.*;
import java.io.*;
public class A0005_ChatServersOutgoingTraffic {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> commands = readInput(in);
		int peopleInChat = 0, result = 0;
		
		for (int i=0; i<commands.size(); i++) {
			char first = commands.get(i).charAt(0);
			if (first == '+')
				peopleInChat++;
			else if (first == '-')
				peopleInChat--;
			else
				result += peopleInChat*getMessageLength(commands.get(i));
		}
		System.out.println(result);
	}

	public static int getMessageLength(String command) {
		for (int i=0; i<command.length(); i++)
			if (command.charAt(i)==':')
				return command.substring(i+1).length();
		return 0;
	}
	
	public static ArrayList<String> readInput(BufferedReader in) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		String line = in.readLine();
		while(line != null) {
			list.add(line);
			if (in.ready())
				line = in.readLine();
			else
				line = null;
		}
		return list;
	}
}