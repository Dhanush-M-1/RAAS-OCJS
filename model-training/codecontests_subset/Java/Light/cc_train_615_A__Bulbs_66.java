import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
 

public class hef {
 
	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int k = s.nextInt();
		HashSet<Integer> h = new HashSet<>();
		for(int i=0;i<n;i++) {
			int n1 = s.nextInt();
			while(n1--!=0) {
				h.add(s.nextInt());
			}
		}
		if(h.size()>=k) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
	}
}