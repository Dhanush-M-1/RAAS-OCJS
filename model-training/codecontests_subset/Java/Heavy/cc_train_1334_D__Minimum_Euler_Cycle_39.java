import java.io.*;
import java.util.*;
public class Sol4{
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			long n = sc.nextInt();
			long l = Long.parseLong(sc.next());
			long r = Long.parseLong(sc.next());
			long idx = 1;
			long cnt = 2*(n-idx);
			while(cnt+1<l) {
				idx++;
				cnt +=(long)2*(n-idx);
			}
			cnt-=2*(n-idx)-1;
			long ix = idx+1;
			while(cnt<r) {
				if(ix == n+1) {
					idx++;
					ix = idx+1;
				}
				if(cnt%2==0) {
					if(cnt>=l)System.out.print(ix + " ");
					ix++;
				}else {
					if(cnt>=l)System.out.print(idx + " ");
				}
				cnt++;
			}
			if(r == ((n)*(n-1)+1))System.out.println(1);
			else {
				if(ix == n+1) {
					idx++;
					ix = idx+1;
				}
				if(cnt%2==0) {
					if(cnt>=l)System.out.println(ix);
				}else {
					if(cnt>=l)System.out.println(idx);
				}
			}
			
			
		}
		sc.close();
	}
}
