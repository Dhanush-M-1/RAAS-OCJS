import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class k{
	
	
	public static void main(String[] args)  {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=0;i<n;i++) {
			int a=s.nextInt();
			int b=s.nextInt();
			int c=s.nextInt();
			int count=0;
			if(c>=2&&b>=1) {
			int sh=c/2;
			if(b>=sh&&b!=0) {
			count=sh*2;
			count=count+sh;
			b=b-sh;
			}else {
				count=count+b;
				count=count+(2*b);
				b=0;
			}
			}
			int gh=b/2;
			if(b>=2&&a>=1) {
			if(a>=gh&&a!=0) {
			count=count+gh*2;
			count=count+gh;
			a=a-gh;
			}else {
				count=count+a;
				count=count+(2*a);
			}
			}
			System.out.println(count);
		}
		
	}
}