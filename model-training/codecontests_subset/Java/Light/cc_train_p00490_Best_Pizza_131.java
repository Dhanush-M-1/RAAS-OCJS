import java.util.Scanner;
import java.util.*;

class Main{
    public static void main(String args[]){
	int n;
	Scanner in = new Scanner(System.in);
	n = in.nextInt();
	int[] all = new int[n];
	int u,each,cost;
	cost = in.nextInt();
	each = in.nextInt();
	u = in.nextInt();

	for(int i=0;i<n;i++){
	    all[i] = in.nextInt();
	}
	Arrays.sort(all);

	int ans=0;
	for(int i=n-1;i>=0;i--){
	    u += all[i];
	    cost += each;
	    if (u/cost > ans)ans = u/cost;
	}
	System.out.println(ans);
    }
}