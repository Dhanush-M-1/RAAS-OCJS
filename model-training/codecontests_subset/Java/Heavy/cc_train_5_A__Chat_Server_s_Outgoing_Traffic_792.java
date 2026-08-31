import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class CF5A {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		while (scanner.hasNext()) {
		    String line = scanner.nextLine();
		    char action = line.charAt(0);
		    if (action == '+') {
		    	set.add(line.substring(1, line.length()));
		    }
		    else if (action == '-') {
		    	set.remove(line.substring(1, line.length()));
		    }
		    else {
		    	String[] info = line.split(":");
		    	String message = "";
		    	if (info.length > 1) message = info[1];
		    	count += (message.length() * set.size());
		    }
		}
		System.out.print(count);
		scanner.close();
		
	}

}
