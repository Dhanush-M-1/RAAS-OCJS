import java.util.Scanner;

public class BarkToUnlock {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String passwordKey = sc.next();
		int num = sc.nextInt();
		boolean firstChar = true;
		boolean secondChar = true;
		String[] sampleBark = new String[num];
		for(int i = 0; i < num; i++) {
			sampleBark[i] = sc.next();
			String tempString = sampleBark[i];
			if(passwordKey.equals(sampleBark[i])) {
				System.out.print("YES");
				return;
			} else {
				if(firstChar && tempString.charAt(1) == passwordKey.charAt(0)) {
					firstChar = false;
				}
				if(secondChar && tempString.charAt(0) == passwordKey.charAt(1)) {
					secondChar = false;
				}
			}
			if(!firstChar && !secondChar) {
				System.out.println("YES");
				return;
			}
			if(tempString.charAt(1) == passwordKey.charAt(0) && tempString.charAt(0) == passwordKey.charAt(1)) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
		sc.close();
	}
}