import java.util.*;
public class Garden{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		Arrays.sort(a);
		for(int i=a.length-1; i>=0; i--){
			if(k % a[i] == 0){
				System.out.print(k / a[i]);
				break;
			}
		}
	} 
} 