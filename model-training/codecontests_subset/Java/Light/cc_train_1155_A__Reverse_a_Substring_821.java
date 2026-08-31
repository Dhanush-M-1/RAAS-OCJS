import java.util.*;

//Mann Shah [ DAIICT ].[ Mann_27__ ] :) 


public class Main { 
	
	

	public static void main(String[] Args) {
		Scanner in = new Scanner(System.in);
		int mod = 1000000007;
		int n = in.nextInt();
		in.nextLine();
		String s = in.next();
		int f=0;
		for(int i=1;i<n;i++) {
			if(s.charAt(i)<s.charAt(i-1)) {
				f=1;
				System.out.println("YES");
				System.out.println(i+" "+(i+1));
				break;
			}
		}
		if(f==0) {
			System.out.println("NO");
		}
		in.close();
	}
}