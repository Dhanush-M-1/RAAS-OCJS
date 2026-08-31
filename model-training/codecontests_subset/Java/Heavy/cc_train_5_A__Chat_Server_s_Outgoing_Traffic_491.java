import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _0783ChatServersOutgoingTraffic {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command;
		Set<String> chat = new HashSet<>();
		int bytes=0;
		while(sc.hasNextLine()) {
			command=sc.nextLine();
			if(command.charAt(0)=='+') {
				chat.add(command.substring(1));
			}
			else if(command.charAt(0)=='-') {
				chat.remove(command.substring(1));
			}
			else {
				String temp=command.substring(command.indexOf(':')+1);
				bytes+=temp.length()*chat.size();			}
		}
		sc.close();
		System.out.println(bytes);
		
	}

}
