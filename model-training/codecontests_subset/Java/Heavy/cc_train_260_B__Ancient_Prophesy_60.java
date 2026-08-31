import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


public class Main {

	static String getCorrectSub(String str, int index) {
		if (str.charAt(index+2) != '-' || str.charAt(index+5) != '-')
			return null;
		try {
			int d = Integer.parseInt("" + str.charAt(index) + str.charAt(index+1));
			int m = Integer.parseInt("" + str.charAt(index+3) + str.charAt(index+4));
			int y = Integer.parseInt("" + str.charAt(index+6) + str.charAt(index+7) + str.charAt(index+8) + str.charAt(index+9));
			if (y < 2013 || y > 2015)
				return null;
			if (m < 1 || m > 12)
				return null;
			switch(m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (d > 31 || d < 1)
					return null;
				break;
			case 2:
				if (d > 28 || d < 1)
					return null;
				break;
			default:
				if (d > 30 || d < 1)
					return null;
			}
			return str.substring(index, index+10);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < str.length()-9; ++i) {
			String sub = getCorrectSub(str, i);
			if (sub == null)
				continue;
			if (map.get(sub) != null) {
				map.put(sub, map.get(sub)+1);
			} else {
				map.put(sub, 0);
			}
		}
		int max = -1;
		String res = null;
		for (Entry<String, Integer> e : map.entrySet()) {
			if (e.getValue() > max) {
				max = e.getValue();
				res = e.getKey();
			}
		}
		System.out.println(res);
		
	}

}
