import java.util.*;

public class OutgoingTraffic {

	public OutgoingTraffic() {
		Scanner sc = new Scanner(System.in);
		TreeSet<String> set = new TreeSet<String>();
		int ret = 0;
		while(sc.hasNext()) {
			String line = sc.nextLine();
			if(first(line) == '+' || first(line) == '-') {
				char ch = line.charAt(0);
				String rest = line.substring(1);
				if(ch == '+')
					set.add(rest);
				else
					set.remove(rest);
			}
			else {
				String msg = (line + " ").split(":")[1].trim();	
				ret += set.size() * msg.length();
			}
		}
		System.out.println(ret);
	}
	
	char first(String s) { return s.charAt(0); }

	public static void main(String[] args) {
		new OutgoingTraffic();

	}

}
