import java.util.*;

public class helpfulMaths {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		if(str.length() == 1) {
			System.out.println(str);
		}
		else {	
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '+') {
					str = str.substring(0, i) + str.substring(i+1, str.length());
				}
			}
			ArrayList <Integer> num = new ArrayList <Integer>();
			for(int j = 0; j < str.length(); j++) {
				num.add((int) str.charAt(j) - 48);
			}
			str = "";
			Collections.sort(num);
			int length = num.size();
			for(int l = 0; l < num.size(); l++) {
				str += num.get(l) + "+";
			}
			
			System.out.println(str.substring(0, str.length() - 1));
		}

	}

}
