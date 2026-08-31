import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n  = sc.nextInt();
			if(n==0)break;
			int[] uta = new int[n];
			for(int i=0;i<n;i++) {
				uta[i] = sc.next().length();
			}
			
			int[] k = {5,7,5,7,7};
			boolean fin = false;
			int ans = 0;
			for(int l=0;l<=n-4;l++) {
				if(5-uta[l] < 0)
						continue;
				int[] kk = Arrays.copyOf(k,5);
				boolean doing = true;
				for(int i=l;i<n;i++) {
					for(int j=0;j<5;j++) {
						if(kk[j]==0)
							continue;
						if(kk[j]-uta[i] < 0 ) {
							doing = false;
							break;
						}
						else {
							kk[j] -= uta[i];
							if(kk[4]==0) {
								fin = true;
								ans = l+1;
							}
							break;
						}
					}
					if(!doing || fin)
						break;
				}
				if(fin)
					break;
			}
			System.out.println(ans);
		}
	}
}
