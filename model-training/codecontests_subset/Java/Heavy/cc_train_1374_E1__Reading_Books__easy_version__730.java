import java.io.*;
import java.util.*;

public class ReadingBooks {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt(); int k = in.nextInt();
		ArrayList<Long> oneone = new ArrayList<>();
		ArrayList<Long> onezero = new ArrayList<>();
		ArrayList<Long> zeroone = new ArrayList<>();
		for(int i=0;i<n;i++) {
			long a = in.nextInt(); long b = in.nextInt(); long c = in.nextInt();
			if(b==1&&c==1) 
				oneone.add(a);
			else if(b==1&&c==0)
				onezero.add(a);
			else if(b==0&&c==1)
				zeroone.add(a);
		}
		Collections.sort(oneone);
		Collections.sort(onezero);
		Collections.sort(zeroone);
		int a = oneone.size(), b = onezero.size(), c = zeroone.size();
		int i,j,l; i=j=l=0;
		int cnt = 0;
		long ans = 0;
		boolean verdict = Boolean.FALSE;
		while(i<a||(j<b&&l<c)) {
			long s1 = -1,s2 = -1;
			if(i<a) s1 = oneone.get(i);
			if(j<b&&l<c) s2 = onezero.get(j) + zeroone.get(l);
			if(s1==-1&&s2==-1) {
				verdict = Boolean.TRUE;break;
			}
			if(s1==-1) s1 = Long.MAX_VALUE;
			if(s2==-1) s2 = Long.MAX_VALUE;
			if(s1<s2) {
				ans += s1;i++;
				cnt++;
			}
			else {
				ans += s2;j++;l++;
				cnt++;
			}
			if(cnt>=k) break;
		}
		if(verdict||cnt<k) out.println("-1");
		else out.println(ans);
		out.close();
	}
}





