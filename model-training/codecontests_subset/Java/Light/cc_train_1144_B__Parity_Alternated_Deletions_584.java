import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Integer> odd = new ArrayList<Integer>();
		ArrayList<Integer> even = new ArrayList<Integer>();
		
		for (int i =0;i<n;i++) {
			int a = sc.nextInt();
			if (a%2==0) {
				even.add(a);
			}
			else
				odd.add(a);
		}
		int ans =0;
		
		if (odd.size()==even.size() || Math.abs(odd.size()-even.size())==1) {
			ans =0;
		}
		else {
			if (even.size()>odd.size()) {
				Collections.sort(even);
				
				for (int i =0;i<even.size()-odd.size()-1;i++) {
					ans+=even.get(i);
				}
			}
			else {
				Collections.sort(odd);
				
				for (int i =0;i<odd.size()-even.size()-1;i++) {
					ans+=odd.get(i);
				}
			}
		}
		System.out.println(ans);
		
		sc.close();

	}

}
