import java.util.*;
import java.math.*;
public class G {
	static final int N = 3*3*3*3*3*3;
	static char[] d = {'0', '4', '7'};
	public static void main(String[] args) {
		HashMap<Long,Integer> map = new HashMap<>();
//		ArrayList<Long>[] bydig = new ArrayList[10];
//		for(int d = 0; d < 10; d++){
//			bydig[d] = new ArrayList<>();
//		}
		for(int i = N-1; i >= 0; i--){
			map.put(trad(i), i);
		}
//		for(long ll: map.keySet()){
//			bydig[(int)(ll%10)].add(ll);
//		}
		
		Scanner seer = new Scanner(System.in);
		int T = seer.nextInt();
		for(int test = 1; test <= T; test++){
			long n = seer.nextLong();
			HashMap<Long, Long>[] dp = new HashMap[19];
			dp[0] = new HashMap<>();
			dp[0].put(n, -1L); int last = -1;
			for(int r = 1; r < 19; r++){
				dp[r] = new HashMap<>();
				for(long ll: dp[r-1].keySet()){
					for(long pos: map.keySet()){
						long curr = ll-pos;
						if(curr < 0 || curr % 10 != 0) continue;
						dp[r].put(curr/10, pos);
					}
				}
				if(dp[r].containsKey(0L)){
					last = r; break;
				}
			}
			if(last < 0){
				System.out.println("-1"); continue;
			}
			char[][] res = new char[6][last];
			long rec = 0;
			for(int ind = last; ind >= 1; ind--){
				long p = dp[ind].get(rec);
				int hash = map.get(p);
				rec = rec*10+trad(hash);
				for(int i = 0; i < 6; i++){
					res[i][last-ind] = d[hash%3];
					hash /= 3;
				}
			}
			
			long[] resres = new long[6];
			for(int i = 0; i < 6; i++){
				String num = new String(res[i]);
				resres[i] = Long.parseLong(num);
			}
			System.out.printf("%d %d %d %d %d %d\n",resres[0],resres[1],resres[2],resres[3],resres[4],resres[5]);
		}

	}
	static long trad(int hash){
		long res = 0;
		while(hash > 0){
			if(hash % 3 == 0) res += 0;
			else if(hash % 3 == 1) res += 4;
			else res += 7;
			hash /= 3;
		}
		return res;
	}

}
