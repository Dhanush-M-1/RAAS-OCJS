import java.util.*;

public class dddd
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] m=new int[n];
		int sum=0;
		for(int i=0;i<n;i++) {
			m[i]=in.nextInt();
			if(m[i]==100) sum+=1;
		}
		if(sum%2==0&&sum!=0) System.out.println("YES");
		else if(sum==0) 
			if(n%2==0) System.out.println("YES");
			else System.out.println("NO");
		else System.out.println("NO");
	}
}