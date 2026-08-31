import java.util.*;
public class Main {
public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
	int n=scan.nextInt();
	int k=scan.nextInt();
	int m=scan.nextInt();
	int tot=0;
	int[] t=new int[k];
	for(int i=0;i<k;i++){
		t[i]=scan.nextInt();
	}int allT = 0;
    for (int tt : t) allT += tt;
    Arrays.sort(t);

    int best = 0;
    for (int ceil = 0; ceil <= n; ceil++) {
        if (allT * ceil > m) break;
        int curAns = ceil * (k + 1);
        int ost = m - allT * ceil;

        int maxCan = n - ceil;
        for (int x : t) {
            int allowed = Math.min(maxCan, ost / x);
            curAns += allowed;
            ost -= allowed * x;
        }
        best = Math.max(best, curAns);
    }
    System.out.println(best);
	
	
}
}
