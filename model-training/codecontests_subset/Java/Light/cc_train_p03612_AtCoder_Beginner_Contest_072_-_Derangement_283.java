
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}



	public void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i]=sc.nextInt();
		}
		int cnt=0;
		for(int i=0; i<n-1; i++) {
			if(a[i] == i+1) {
				int tmp = a[i+1];
				a[i+1]=a[i];
				a[i]=tmp;
				cnt++;
			}
		}
		if(a[n-1]==n) {
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}

}
