
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReadingBooksE {
	@SuppressWarnings("resource")
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int output = 0;
		ArrayList<Integer> Alice = new ArrayList<Integer>();
		ArrayList<Integer> Bob = new ArrayList<Integer>();
		ArrayList<Integer> intersect = new ArrayList<Integer>();
		int sumIntersect = 0;
		
		for (int i = 0 ; i< n ; i++) {
			int time = s.nextInt();
			int alice = s.nextInt();
			int bob = s.nextInt();
			if(alice == 1 && bob == 1) {
				intersect.add(time);
				sumIntersect += time;
			}
			else if(alice == 1 && bob == 0) {
				Alice.add(time);
			}
			else if(alice == 0 && bob == 1) {
				Bob.add(time);
			}
		}
		s.close();
		
		if (Bob.size() + intersect.size() < k || Alice.size() + intersect.size() < k) {
			System.out.println(-1);
			return;
		}
		
		if (k > n/2) {
			k -= intersect.size();
			output+=sumIntersect;
			intersect.clear();
		}
		
		Collections.sort(intersect);		
		Collections.sort(Alice);
		Collections.sort(Bob);
		
		for (int i =0 ; i<k ;i++) {
			if(!intersect.isEmpty() && !Alice.isEmpty() && !Bob.isEmpty()) {
				if (Alice.get(0)+Bob.get(0) > intersect.get(0)) 
					output += intersect.remove(0);
				else {
					output+= Alice.remove(0);
					output+= Bob.remove(0);
				}
			}
			else if (!intersect.isEmpty() && (Alice.isEmpty() || Bob.isEmpty())) {
				if (intersect.size() >= (k-i) && Alice.isEmpty() && Bob.isEmpty()) {
					int gap = intersect.size() - k;
					for (int j = 0 ; j < gap ;j++) {
						sumIntersect -= intersect.remove(intersect.size()-1);
					}
					System.out.println(output + sumIntersect);
					return;
				}
				output += intersect.remove(0);
			}
			else if (intersect.isEmpty()) {
				output+= Alice.remove(0);
				output+= Bob.remove(0);
			}
		}
		System.out.println(output);
	}
}
