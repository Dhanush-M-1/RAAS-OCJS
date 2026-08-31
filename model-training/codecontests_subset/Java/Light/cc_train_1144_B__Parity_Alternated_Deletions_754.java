// No sorceries shall prevail. //           
import java.util.Scanner; 
import java.io.PrintWriter;
import java.util.Arrays;

public class InVoker {	
	
	public static void main(String args[]) {
		
		Scanner inp=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		
		int n=inp.nextInt();
		long a[]=new long[n];
		int odd=0;
		long sum=0;
		for(int i=0;i<n;i++) {
			a[i]=inp.nextLong();
			sum+=a[i];
			if(a[i]%2==1)
				odd++;
		}
		int even=n-odd;
		Arrays.sort(a);
		long s1=0,s2=0;
		int z=Math.min(odd, even);
		for(int i=n-1,c=0;i>=0 && c<z+1;i--) {
			if(a[i]%2==1) {
				s1+=a[i];
				c++;
			}
		}
		for(int i=n-1,c=0;i>=0 && c<z;i--) {
			if(a[i]%2==0) {
				s1+=a[i];
				c++;
			}
		}
		for(int i=n-1,c=0;i>=0 && c<z+1;i--) {
			if(a[i]%2==0) {
				s2+=a[i];
				c++;
			}
		}
		for(int i=n-1,c=0;i>=0 && c<z;i--) {
			if(a[i]%2==1) {
				s2+=a[i];
				c++;
			}
		}
		out.println(sum-Math.max(s1, s2));
		out.close();
		inp.close();
	}

}