import java.util.*;
public class Main {
		
	static int same[], N, conti[];
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int p[] = new int[N];
		for(int i=0;i<N;i++)p[i]=sc.nextInt()-1;
		sc.close();
	
		conti = new int[N+1];
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			if(i==p[i]) {
				cnt++;
			}else {
				conti[cnt]++;
				cnt = 0;
			}
		}
		if(cnt!=0)conti[cnt]++;
		
		int ans = 0;
		for(int i=0;i<=N;i++) {
			ans += (i+1) / 2 * conti[i];
		}
		
		System.out.println(ans);
		
	}

	
}