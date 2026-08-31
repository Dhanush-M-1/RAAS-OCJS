import java.util.*;
 
public class Main {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		while(t-->0) {
		    int n = in.nextInt();
		    int a[] = new int[n];
		    for(int i=0;i<n;i++) {
		        a[i] = in.nextInt();
		    }
		    if(n<=5) System.out.println("0 0 0");
		    else {
		        int mid = n/2;
		        int rem = -1;
		        if(a[mid-1] == a[mid]) rem = a[mid];
		        int cnt[] = new int[mid+1];
		        cnt[0] = 1;
		        int curr = 0;
	            for(int i=1; i<mid; i++) {
	                if(rem != -1 && a[i] <= rem) break;
	                if(a[i] == a[i-1]) cnt[curr]++;
	                else cnt[++curr]++;
	            }
	            int g=cnt[0], s=0, b=0;
	            for(int i=1; i<mid+1; i++) {
	                if(cnt[i] == 0) break;
	                if(s <= g) s += cnt[i];
	                else b += cnt[i];
	            }
	            if(g < s && g < b && g > 0 && s > 0 && b > 0) System.out.println(g+" "+s+" "+b);
	            else System.out.println("0 0 0");
		    }
		}
		
	}
}