import java.util.Scanner;

public class BarktoUnlock {
	
	private static Scanner sc;

	public static void main(String[] args) {
	
		String all = "";
		boolean f1 = false,f2 = false;
		
		sc = new Scanner(System.in);
		
		String pass = sc.nextLine();
		char ch1 = pass.charAt(0);
		char ch2 = pass.charAt(1);

		int n = sc.nextInt();
		
		String[] words = new String[n];
		
		sc.nextLine();
			
		for(int i=0;i<n;i++) {
				words[i] = sc.nextLine();
				all = all + words[i];
			}		
					
		for(int i=0;i<n;i++) {
			if(words[i].indexOf(ch1)==1) f1 = true;
			if(words[i].indexOf(ch2)==0) f2 = true;
		}
		
		if(all.contains(pass)) {
			System.out.println("YES");
			return;
		}
		
		if(f1 && f2) System.out.println("YES");
		else System.out.println("NO");
				
	}
}