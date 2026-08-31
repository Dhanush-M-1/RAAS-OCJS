import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	String s = sc.next();
	    	int len = s.length();
	    	boolean bool = true;
	    	int temp = 0;
	    	String key = "keyence";
	    	if (s.startsWith(key) || s.endsWith(key) || s.equals(key)) {
	    		System.out.println("YES");
	    		return;
	    	}
	    	for (int i = 0; i < 7; i++) {
			if (s.charAt(i) == key.charAt(i)) {
				continue;
			} else {
				temp = 7-i;
				break;
			}
		}
	    	int count  = 0;
	    	for (int i = s.length()-1; i > s.length()-1-temp; i--) {
			if (s.charAt(i) == key.charAt(key.length()-1-count)) {
				count++;
				continue;
			} else {
				System.out.println("NO");
				return;
			}
		}
	    	System.out.println("YES");
	}
}
