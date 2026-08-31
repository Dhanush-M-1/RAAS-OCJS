import java.util.Scanner;

public class CR303C {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int h[]=new int[n];
		int x[] =new int[n];
		
		for(int i=0;i<n;i++) {
			x[i]=s.nextInt();
			h[i]=s.nextInt();
		}
			int sc=Math.min(2,n);
			
			for(int i=1;i<n-1;i++) {
				if(x[i]-x[i-1]>h[i]) {
					sc++;
				}
				else if(x[i+1]-x[i]>h[i]) {
					sc++;
					x[i]=x[i]+h[i];
				}
		}
			System.out.println(sc);
	}

}
