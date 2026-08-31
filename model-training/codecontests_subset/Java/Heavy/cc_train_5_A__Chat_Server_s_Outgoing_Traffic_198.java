import java.util.*;

public class CharServer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> members = new ArrayList<String>();
		int traffic = 0;
		while(scan.hasNext()) {
			String command = scan.nextLine();
			if(command.charAt(0) == '+') {
				String temp = command.substring(1);
				members.add(temp);
			} else if (command.charAt(0) == '-') {
				String temp = command.substring(1);
				members.remove(temp);
			} else {
				String[] temp = command.split(":");
				int l = 0;
				if(temp.length == 1) {
					l += 0;
				} else 
					l = temp[1].length();
				traffic += l * members.size();
			}
		}
		scan.close();
		System.out.println(traffic);
	}
}
