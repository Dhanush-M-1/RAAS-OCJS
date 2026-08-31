import java.util.Scanner;

public class _0795CowsandPokerGame {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		String s=sc.nextLine();
		int acount=0;
		int icount=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='A') {
				acount++;
			}
			else if(s.charAt(i)=='I') {
				icount++;
			}
		}
		if(icount==0) {
			System.out.println(acount);
		}
		else if(icount==1) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	
	
	}

}
