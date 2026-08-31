import java.io.*;
import java.util.*;


public class E1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer("");
		String[] str;
		int n, k;
		str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		k = Integer.parseInt(str[1]);
		List<Integer> ab = new ArrayList<>();
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		for(int i=0; i<n; i++) {
			str = br.readLine().split(" ");
			int t1 = Integer.parseInt(str[0]);
			int t2 = Integer.parseInt(str[1]);
			int t3 = Integer.parseInt(str[2]);
			if(t2 == 1 && t3 == 1) ab.add(t1);
			else if(t2 == 1) a.add(t1);
			else if(t3 == 1) b.add(t1);
		}
		Collections.sort(a);
		Collections.sort(b);
		int tmp = Math.min(a.size(), b.size());
		for(int i=0; i<tmp; i++) ab.add(a.get(i)+b.get(i));
		Collections.sort(ab);
		for(int i=1; i<ab.size(); i++) ab.set(i, ab.get(i)+ab.get(i-1));
		int l = 0, r = 0, ans = Integer.MAX_VALUE;
		while(r < ab.size()) {
			if(r-l+1 < k) r++;
			else {
				ans = Math.min(ans, ab.get(r)-(l>0?ab.get(l-1):0));
				l++;
			}
		}
		if(ans == Integer.MAX_VALUE) ans = -1;
		sb.append(ans);
		System.out.println(sb.toString());
		br.close();
	}
}
