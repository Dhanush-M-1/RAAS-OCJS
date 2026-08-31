
import java.util.*;

public class ReverseASubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.nextLine();
		s=sc.nextLine();
		int minI=0;
		int max=0;
		int maxI=0;
		int p=0;
		for(int i=0;i<s.length();i++) {
			if((int)s.charAt(i)<max) {
				minI=i;
				p=1;
				break;
			}
			if((int)s.charAt(i)>max) {
				max=s.charAt(i);
				maxI=i;
//				System.out.println(maxI);
			}
			
		}
		maxI=maxI+1;
		minI=minI+1;
		if(p==0)
			System.out.println("NO");
		else {
			System.out.println("YES");
			System.out.println(maxI+" "+minI );
		}
	}
}
