import java.util.Scanner;

public class Sample{
	final static int N = 100005;
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int[] x = new int[N];
		int[] h = new int[N];
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++){
			x[i] = scanner.nextInt();
			h[i] = scanner.nextInt();
		}
		
		x[n] = Integer.MAX_VALUE;
		int bound = Integer.MIN_VALUE;
		int ans = 0;
		for(int i=0; i<n; i++){
			if(x[i]-h[i] > bound){
				bound = x[i];
				ans++;
			}else if(x[i]+h[i] < x[i+1]){
				bound = x[i]+h[i];
				ans++;
			}else{
				bound = x[i];
			}
		}
		System.out.println(ans);
	}

}