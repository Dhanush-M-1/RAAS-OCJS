import java.util.*;

class Main {


	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		for(;;){
			int n = in.nextInt();
			if(n==0) return ;
			int a[] = new int[n];
			for(int i=0; i<n; i++) a[i] = in.nextInt();
			System.out.println(solve(a));
		}
	}
	
	static int solve(int[] a){
		int cnt=0;
		
		for(int i=a.length-1; i>0; i--)
			for(int j=0; j<i; j++){
				if(a[j] > a[j+1]){
					cnt++;
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		
		return cnt;
	}
}