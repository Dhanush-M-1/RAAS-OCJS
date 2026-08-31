import java.util.*;
public class Main {
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int q = stdIn.nextInt();
		for(int i = 0; i < q; i++) {
			int n = stdIn.nextInt();
			int ans = solv((long)n);
			System.out.println(ans);
		}
	}
	
	public static int solv(Long n) {
		HashMap<Long,Boolean> map = new HashMap<Long,Boolean>();
		Long tmp = n;
		String tmpS = String.valueOf(tmp);
		int count = 0;
		while(true) {
			Long max = 0L;
			if(tmpS.length() == 1) {
				return count;
			}
			for(int i = 1; i < tmpS.length(); i++) {
				String sbt1 = tmpS.substring(0, i);
				String sbt2 = tmpS.substring(i, tmpS.length());
				
				Long sbi1 = Long.parseLong(sbt1);
				Long sbi2 = Long.parseLong(sbt2);
				
				if(sbi1 * sbi2 > max) {
					max = sbi1 * sbi2;
				}
			}
			if(map.containsKey(max)) {
				return -1;
			}
			tmpS = String.valueOf(max);
			count++;
		}
		
	}
}