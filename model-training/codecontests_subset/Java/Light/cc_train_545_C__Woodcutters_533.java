import java.lang.*;
import java.util.*;

public class woodcutters{

	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long x[] =new long[n];
		long h[] =new long[n];
		int c=0;

		for(int i=0;i<n;i++){
			x[i]=sc.nextLong();
			h[i]=sc.nextLong();
		}
		if(n!=1){
		for(int j=1;j<n-1;j++){
			if((x[j]-h[j])>x[j-1])
				c++;
			else if( (x[j]+h[j])<x[j+1]){
				x[j]=x[j]+h[j];
				c++;
			}
		}
		System.out.print((c+2));
		}
		else if(n==1)
			System.out.print(1);
			
		
	}
}