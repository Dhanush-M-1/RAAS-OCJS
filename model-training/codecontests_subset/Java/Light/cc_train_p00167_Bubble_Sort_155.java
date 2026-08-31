import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		while(true){
			int n = stdIn.nextInt();
			if(n==0){
				return;
			}
			int[] a = new int[n];
			for(int i=0;i<n;i++){
				a[i] = stdIn.nextInt();
			}
			int cnt = 0;
			for(int i=0;i<n;i++){
				for(int j=n-1;j>i;j--){
					if(a[j]<a[j-1]){
						cnt++;
						int tmp = a[j];
						a[j] = a[j-1];
						a[j-1] = tmp;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}