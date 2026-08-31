import java.util.Scanner;

public class Main {
	
	private static final String KEYENCE = "keyence";
	private static final String YES = "YES";
	private static final String NO = "NO";

	public static void main(String[] args) {
		new Main().execute();
	}

	public void execute() {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		for(int i=0, len = KEYENCE.length(); i<=len; i++) {
			String s1 = KEYENCE.substring(0,i);
			String s2 = KEYENCE.substring(i);
			if(s.startsWith(s1) && s.endsWith(s2)) {
				System.out.println(YES);
				return;
			}
		}
		System.out.println(NO);
		sc.close();
	}

}
