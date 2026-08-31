import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    int n = sc.nextInt();
		    int ans = 0;
		    int[] a = new int[n];
		    for(int i=0;i<n;i++) {
		    	a[i] = sc.nextInt();
		    }
		    for(int i=0;i<n;i++) {
		    	ans += sc.nextInt();
		    }
		    int[] c = new int[n-1];
		    for(int i=0;i<n-1;i++) {
		    	c[i] = sc.nextInt();
		    }
		    for(int i=1;i<n;i++) {
		    	if(a[i]-a[i-1] == 1) {
		    		ans += c[a[i-1]-1];
		    	}
		    }
		    System.out.println(ans);

		    sc.close();
	}
}
