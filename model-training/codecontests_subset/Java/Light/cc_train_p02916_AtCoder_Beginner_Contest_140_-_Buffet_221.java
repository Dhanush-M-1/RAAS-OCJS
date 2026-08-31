import java.util.*;

public class Main{

	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		int b[]=new int[n];
		for(int i=0;i<n;i++){
			b[i]=sc.nextInt();
		}
		int c[]=new int[n-1];
		for(int i=0;i<n-1;i++){
			c[i]=sc.nextInt();
		}
		int total=0;
		for(int i=0;i<n;i++){
			total+=b[i];
		}


		for(int i=1;i<n;i++){
			if(a[i]-a[i-1]==1){
				total+=c[a[i-1]-1];
			}
		}

		System.out.println(total);


	}
}
