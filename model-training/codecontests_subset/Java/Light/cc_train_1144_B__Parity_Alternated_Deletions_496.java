import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class partialalternatedelete {

	public static void main(String[] args) {
		Scanner nik = new Scanner(System.in);
		int n = nik.nextInt();
		ArrayList<Integer> odd = new ArrayList<>();
		ArrayList<Integer> even = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int temp = nik.nextInt();
			if (temp % 2 == 0) {
				even.add(temp);
			} else {
				odd.add(temp);
			}
		}
		int oidx = 0;
		int eidx = 0;
		Collections.sort(odd);
		Collections.sort(even);
		if (odd.size() > even.size()) {
			oidx = even.size() + 1;
			eidx = even.size();
		} else if (even.size() > odd.size()) {
			eidx = odd.size() + 1;
			oidx = odd.size();
		}else {
			oidx=odd.size();
			eidx=even.size();
		}
		
		long sum=0;
		for(int i=odd.size()-oidx-1;i>=0;i--) {
			sum+=odd.get(i);
		}
		for(int i=even.size()-eidx-1;i>=0;i--) {
			sum+=even.get(i);
		}
		System.out.println(sum);
		
	}
	

}
