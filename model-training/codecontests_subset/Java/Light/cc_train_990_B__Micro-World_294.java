import java.io.*;
import java.util.*;

public class MicroWorld {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int k = in.nextInt();
		Integer a[] = new Integer[n];
		for(int i=0;i<n;i++) a[i] = in.nextInt();
		Arrays.parallelSort(a);
		int cnt = 1;
		for(int i=n-1;i>0;i--) {
			if(a[i]>a[i-1]&&a[i]-a[i-1]<=k) {
				int j=i-1;
				while(j>=0&&a[i]-a[j]<=k) {
					j--;
				}
				i = j+2;
			}
			else cnt++;
		}
		out.println(cnt);
		out.close();in.close();
	}
}







