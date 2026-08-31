import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n  = sc.nextInt();
		List<Integer> even = new ArrayList();
		List<Integer> odd = new ArrayList();
		for(int i=0;i<n;i++) {
			int t = sc.nextInt();
			if(t%2==0)
				even.add(t);
			else
				odd.add(t);
		}
		Collections.sort(even);
		Collections.sort(odd);
		int have = Math.abs(even.size()-odd.size());
		if(have<=1)
			System.out.println(0);
		else {
			long sum = 0;
			have--;
			if(even.size()>odd.size()) {
				for(int i=0;have>0;i++,have--) {
					sum+=even.get(i);
				}
			}else {
				for(int i=0;have>0;i++,have--) {
					sum+=odd.get(i);
				}
			}
			System.out.println(sum);
		}
	}
}
