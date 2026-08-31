import java.util.Scanner;

public class Games {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=0;
		int a [] = new int[10000];
		int b [] = new int[10000];
		
		int result = 0;
		
		n = sc.nextInt();
		
		for (int i = 0;i < n;i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		
		for (int i =0;i<n;i++) {
			for(int j =0;j<n;j++) {
				if(i!=j && a[i]==b[j])
					result++;
			}
		}
		
		System.out.println(result);

	}

}
