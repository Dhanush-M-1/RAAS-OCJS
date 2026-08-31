import java.util.*;
 
public class Hello {
	
	@SuppressWarnings("resource")
	
	static void reverse(int []A) {
		int l = A.length;
		int temp;
		for(int i = 0;i < l/2 ;i++) {
			temp = A[i];
			A[i] = A[l-1-i];
			A[l-i-1] = temp;
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int faq=1; 
		while(faq-->0)
		{
			 int n=in.nextInt();
			 int h[]=new int[n];
			 int g[]=new int[n];
			 for(int i=0;i<n;i++)
			 {
				 h[i]=in.nextInt();
				 g[i]=in.nextInt();
			 }
			 
			 int count=0;
			 for(int i=0;i<n;i++)
			 {
				 for(int j=0;j<n;j++)
				 {
					if(h[i]==g[j])
						count++;
				 } 
			 }
			 
			 System.out.println(count);
		}
	}
}