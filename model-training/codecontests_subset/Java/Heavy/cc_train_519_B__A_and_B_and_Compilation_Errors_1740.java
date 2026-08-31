import java.util.Arrays;
import java.util.Scanner;


public class B294 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n=sc.nextInt();
		
		int[]a= new int[n];
		int[]b= new int[n-1];
		int[]c= new int[n-2];
		
		
		
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		for(int i=0;i<n-1;i++)
			b[i]=sc.nextInt();
		
		
		for(int i=0;i<n-2;i++)
			c[i]=sc.nextInt();
		
		
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		boolean donea=false;
		boolean doneb=false;
		for(int i=0;i<n-1;i++){
			if(a[i]!=b[i]){
				System.out.println(a[i]);
		        donea=true;
		        break;
			}
			}
		if(!donea){
			System.out.println(a[n-1]);
		}
		
		for(int i=0;i<n-2;i++){
			if(b[i]!=c[i]){
				System.out.println(b[i]);
		        doneb=true;
		        break;
			 }
			}
		
		if(!doneb)
		System.out.println(b[n-2]);
		
		
		
		
		
		
		
		
		
		

	}

}
