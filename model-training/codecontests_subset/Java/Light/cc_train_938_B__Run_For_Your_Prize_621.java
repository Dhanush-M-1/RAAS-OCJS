import java.util.*;

public class B {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++){
			ans = Math.min(ans, Math.max(a[i]-1 ,1000000 - a[i+1])); 
		}
		
		ans = Math.min(ans, 1000000-a[0]);
		ans = Math.min(ans, a[n-1]-1);
		System.out.println(ans);
	}
}
