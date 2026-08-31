import java.util.*;
public class Gym {	
	public static void main(String []args ) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		int k=0;
		int q=k+2;
		int count = 0;
		String sub = s.substring(k, q);
		for(int i = q;i<s.length()-2;i++) {
			if(s.substring(i,i+2).equals(sub))
				count++;
		}
		int max = count;
		while(k<n-2) {
			k++;
			q=k+2;
			count = 0;
			String ssub = s.substring(k, q);
			for(int i = 0;i<s.length()-2;i++) {
				if(s.substring(i,i+2).equals(ssub) && i!=k)
					count++;
			}
			if(count>max) {
				max=count;
				sub=ssub;
			}
		}
		System.out.println(sub);
	}
}