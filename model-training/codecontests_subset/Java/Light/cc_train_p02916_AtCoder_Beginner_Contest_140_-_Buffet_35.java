import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = s.nextInt()-1;
		
		int b[] = new int[n];
		int c[] = new int[n-1];
		
		for(int i=0;i<n;i++)
			b[i] = s.nextInt();
		
		for(int j=0;j<n-1;j++)
			c[j] = s.nextInt();
		
		int sum = 0;
		sum+=b[a[0]];
		
		int prev = a[0];
		for(int i=1;i<n;i++) {
			if(a[i]==prev+1) {
				sum+=b[a[i]]+c[prev];
			}
			else {
				sum+=b[a[i]];
			}
			prev=a[i];
		}
		System.out.println(sum);
		
	}
}