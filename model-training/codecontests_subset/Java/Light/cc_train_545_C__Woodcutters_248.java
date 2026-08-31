import java.util.*;
public class Tree {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arxl[] = new int[n];
		int arxr[] = new int[n];
		int arh[] = new int[n];
		int i;
		for(i = 0; i < n; i++) {
			arxl[i] = sc.nextInt();
			arxr[i] = arxl[i];
			arh[i] = sc.nextInt();
		}
		
		if(n < 3)
			System.out.println(n);
		else{
		int cnt = 2;
		for(i = 1; i < n-1; i++) {
			if(arxr[i-1] < arxl[i]-arh[i]) {
				arxl[i] = arxl[i]-arh[i];
				cnt++;
			}
			else if(arxl[i+1] > arxr[i]+arh[i]) {
				arxr[i] = arxr[i]+arh[i];
				cnt++;
			}
		}
		System.out.println(cnt);
		}
	}
}