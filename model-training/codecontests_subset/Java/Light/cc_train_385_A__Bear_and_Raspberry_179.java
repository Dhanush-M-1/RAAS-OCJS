
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] data = new int[n+1];
		for(int i = 1 ; i <=n;i++){
			data[i] = sc.nextInt();
		}
		int max = 0;
		for(int i = 1 ; i < n;i++){
			if(data[i]>(data[i+1]+c)){
				int x = data[i]-data[i+1]-c;
				if(x>=max) max = x;
			}
		}
		System.out.println(max);
	}
}
