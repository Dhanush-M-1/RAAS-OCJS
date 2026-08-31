import java.util.Scanner;

public class BearAndRaspberry {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		int b[] = new int[n];
		for (int i = 0; i < n; i++) {
			b[i]=in.nextInt();
		}
		int max=0, temp;
		for (int i = 0; i < n-1; i++) {
			temp=b[i]-b[i+1]-c;
			if(max<temp) max=temp;
		}
		System.out.println(max);
	}

}
