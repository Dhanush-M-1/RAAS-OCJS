
import java.util.*;
public class soonu {

	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			int t=sc.nextInt();
			while(t-->0)
			{
				long n=sc.nextLong();
				long[]a=new long[(int) n];
				for(long i=0;i<n;i++) {
					a[(int) i]=sc.nextLong();
				}
				if(a[0]+a[1]>a[(int) (n-1)]) {
					System.out.println("-1");
				}
				else {
					System.out.println("1 2 "+n);
				}
			}
			
		}catch(Exception e) {
			
		}

	}

}
