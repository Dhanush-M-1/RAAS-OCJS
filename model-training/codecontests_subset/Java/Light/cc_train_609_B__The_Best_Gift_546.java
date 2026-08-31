import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n =cin.nextInt();
			int m = cin.nextInt();
			int a[] = new int[n];
			for (int i=0; i<n; i++){
				a[i] = 0;
			}
			for (int i=0; i<n; i++){
				int index = cin.nextInt();
				a[index-1]++;
			}
			int count = 0;
			for (int i=0; i<m-1; i++){
				for (int j=i+1; j<m; j++){
					count += a[i]*a[j];
				}
			}
			System.out.println(count);
		}
		cin.close();
	}
}
