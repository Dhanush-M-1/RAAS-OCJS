import java.util.*;
import static java.lang.Math.*;
public class Demo{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();	
		while(t-->0){
			int n = in.nextInt();
			long[] a = new long[n];
			for (int i = 0; i < n; i++){
				a[i] = in.nextInt();
			}
			for (int i = 2; i < n; i++){
				if (a[0]+a[1]<=a[i]){
					System.out.println("1 2 "+(i+1));
					break;
				} else if(i==n-1){
					System.out.println(-1);
				}
				
			}
			
		}
	}	
}
