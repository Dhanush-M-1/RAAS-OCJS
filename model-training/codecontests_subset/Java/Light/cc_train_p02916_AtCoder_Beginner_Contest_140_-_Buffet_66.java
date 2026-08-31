import java.util.*;

class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n-1];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++){
			b[i] = sc.nextInt();
		}
		for(int i = 0; i < n-1; i++){
			c[i] = sc.nextInt();
		}
		int sum = 0;
		int hoz = -1;
		for(int i = 0; i < n; i++){
			sum+=b[a[i]-1];
			if(a[i]==hoz+1){
				sum+=c[a[i]-2];
			}
			hoz = a[i];
		}
		System.out.print(sum);
	}
}
