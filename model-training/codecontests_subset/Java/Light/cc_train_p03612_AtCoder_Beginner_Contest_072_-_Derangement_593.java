import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Main {
	public static int AMAX = 100000;
	public static void main(String[] args) {
		int i=0,j=0,k=0;
		Scanner sc = new Scanner(in);
		int n = parseInt(sc.next());
		int[] p = new int[n];
		int cnt=0;
		int cnt2=0;
		for(i=0;i<n;i++) {
			p[i] = parseInt(sc.next());
			if(p[i]==i+1) {
				cnt++;
			} else {
				cnt2+=(int)ceil((double)cnt/2);
				cnt=0;
			}
		}
		sc.close();
		cnt2+=(int)ceil((double)cnt/2);
		out.println(cnt2);
	}
}
