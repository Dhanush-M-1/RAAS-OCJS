import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a[] = new int[n];
			int b[] = new int[m];
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			for(int i=0;i<m;i++) {
				b[i] = sc.nextInt();			
			}
		 boolean flag = false;
			for(int i = 0;i<n;i++) {
				for(int j=0;j<m;j++) {
				if(a[i] == b[j] ) {
					System.out.println("YES");
					System.out.println("1 "+a[i]);
                    flag = true;
                    break;
				}
				}
				if(flag) {
					break;
				}
			}
				if(!flag) {
					System.out.println("NO");
				}
				
				}
			}
}