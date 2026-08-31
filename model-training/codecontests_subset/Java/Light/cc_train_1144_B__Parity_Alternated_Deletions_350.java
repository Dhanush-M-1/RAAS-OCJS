import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ParityAlternateDeletions {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int size = s.nextInt();
		List<Integer> odd = new ArrayList<Integer>();
		List<Integer> even = new ArrayList<Integer>();
		int num = 0, sum = 0, temp = 0;
		
		for(int i=0; i<size; i++) {
			num = s.nextInt();
			if(num%2==0) {
				even.add(num);
			}else {
				odd.add(num);
			}
		}
		
		Collections.sort(even);
		Collections.sort(odd);
		
		if(even.size()<odd.size()) {
			odd.remove(odd.size() - 1);
			temp = even.size();
			for(int i =0; i<temp; i++) {
				even.remove(even.size() - 1);
				odd.remove(odd.size() - 1);
			}
			
			for(int d : odd) {
			    sum += d;
			}
			System.out.println(sum);
			
		}else if(even.size()>odd.size()) {
			even.remove(even.size() - 1);
			temp = odd.size();
			for(int i =0; i<temp; i++) {
				even.remove(even.size() - 1);
				odd.remove(odd.size() - 1);
			}
			
			for(int d : even) {
			    sum += d;
			}
			System.out.println(sum);
		}else {
			temp = odd.size();
			for(int i =0; i<temp; i++) {
				even.remove(even.size() - 1);
				odd.remove(odd.size() - 1);
			}
			for(int d : even) {
			    sum += d;
			}
			System.out.println(sum);
	
		}

	}

}
