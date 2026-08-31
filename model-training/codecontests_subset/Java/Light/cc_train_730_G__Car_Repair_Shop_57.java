import java.util.Scanner;
import java.util.TreeSet;

public class G {
	static long inf = (long)1e12;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		starts = new TreeSet<>();
		ends = new TreeSet<>();
		
		starts.add(0L);
		ends.add(0L);
		
		
		for(int i=0;i<n;i++) {
			long s = in.nextLong(), d = in.nextLong();
			long idx = add(s,d);
			System.out.println(idx + " " + (idx+d-1));
		}
	}

	static TreeSet<Long> starts, ends;
	public static long add(long s, long d) {
		if (canInsert(s, d)) {
			starts.add(s);
			ends.add(s + d - 1);
			return s;
		}
		for (long v : ends) {
			if(v+1 < 1) continue;
			if(!canInsert(v+1, d)) continue;
			starts.add(v+1);
			ends.add((v+1)+d-1);
			return v+1;
		}
		return -1;
	}

	public static boolean canInsert(long s, long d) {
		if (ends.lower(s) < starts.lower(s) || starts.lower(s + d) >= s)
			return false;
		return true;
	}
}
