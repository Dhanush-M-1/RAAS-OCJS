import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatTraffic {
	public static void main(String[] args) throws IOException {
		new ChatTraffic().start();
	}

	String operation;
	public List<String> users = new ArrayList<String>();
	int totalBytes = 0;

	public void start() throws IOException {
		BufferedReader sc= new BufferedReader(new InputStreamReader(System.in));
		String op=null;
		while ((op=sc.readLine())!=null) {
			char firstSymbol = op.toCharArray()[0];
			//System.out.println(firstSymbol);
			boolean isPlus = firstSymbol == '+';
			boolean isMinus = firstSymbol == '-';
			boolean isCommand = isPlus || isMinus;
			//System.out.println(isPlus + "||" + isMinus + "=" + isCommand);

			if (isCommand) {
				String name=op.substring(1);
				if (isPlus) users.add(name);
				if (isMinus) users.remove(name);
				//System.out.println(users);
			} else {
				int firstColon=op.indexOf(":");
				String name=op.substring(0,firstColon);
				String msg=op.substring(firstColon+1);
				int bytes=0;
		           for (String user:users){
		               bytes+=msg.length();
		           }
				totalBytes+=bytes;
			}
		}
		System.out.println(totalBytes);

	}

}
