import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d[] = new int[100];
		int e;
		for(int i = 0; i < n; i++){
			d[i] = in.nextInt();
		}
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				if(d[i] < d[j]){
					e = d[i];
					d[i] = d[j];
					d[j] = e;
				}
			}
		}
		for(int i = 0; i < n; i++){
			if(d[i] / b > c / a){
				c += d[i];
				a += b;
			}
		}
		System.out.println(c / a);
	}
}