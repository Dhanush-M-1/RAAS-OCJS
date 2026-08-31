import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob5A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stack = 0;
		int messageCount = 0;
		
		while(br.ready()) {
			String command = br.readLine();
			if(command.charAt(0)=='+')
				stack++;
			else if(command.charAt(0)=='-')
				stack--;
			else {
				messageCount += stack * (command.length() - command.indexOf(':')-1);
			}
		}
		System.out.println(messageCount);
	}
}
