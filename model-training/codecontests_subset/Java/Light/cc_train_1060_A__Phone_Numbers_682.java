import java.io.PrintWriter;
import java.util.*;
import java.util.Formatter;
public class Main {
	
	public static int gcd(int a,int b)
	{
		int r;
		
		while(b>0)
		{
			r=a%b;
			a=b;
			b=r;
		}
		
		return a;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int i,j,b,c,k,n,d,m,l,max_=-1,cnt=0,ans=0;
	

		
		n=sc.nextInt();
		
		sc.nextLine();
		String s=sc.nextLine();
		
		for(i=0;i<s.length();i++) if(s.charAt(i)=='8') cnt++;
		
		
		for(i=1;i<=cnt;i++) ans=Math.max(ans, Math.min(i, (s.length()-i)/10));
		System.out.println(ans);
		
	} 

}


