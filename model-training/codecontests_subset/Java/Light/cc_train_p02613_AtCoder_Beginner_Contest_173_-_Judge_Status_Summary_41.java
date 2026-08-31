import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		HashMap<String,Integer> h = new HashMap<>();
		h.put("AC",0);
		h.put("TLE",0);
		h.put("RE",0);
		h.put("WA",0);
		while(n--!=0) {
			String c = s.next();
			h.put(c, h.get(c)+1);
		}
		System.out.println("AC x "+h.get("AC"));
		System.out.println("WA x "+h.get("WA"));
		System.out.println("TLE x "+h.get("TLE"));
		System.out.println("RE x "+h.get("RE"));
		
	}

}
