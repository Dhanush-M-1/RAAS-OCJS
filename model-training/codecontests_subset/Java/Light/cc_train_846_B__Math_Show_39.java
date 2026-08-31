 
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

 public class TheLotteryBothDivs {
 
	 
	 public static void main(String[] args) {
 
		 Scanner in = new Scanner(System.in);

		 int n = in.nextInt();
		 int sub = in.nextInt();
	 
		 long time = in.nextLong();
		 
		 List<Integer> times = new ArrayList<>(sub);
		 long tot = 0;
		 
		 for(int i=0; i<sub; i++) {
			 int t = in.nextInt();
			 tot += t;
			 times.add(t);
		 }
		 
		 Collections.sort(times);
		 
		 int best = 0;
			
		 for(int i=0; i<=n; i++) {
			 
			 long left = time - tot*i;
			 if(left < 0) {
				 break;
			 }
			 
			 int points = (i * sub) + i;
			 
			 for(int j=0; j<sub; j++) {
				 if(times.get(j) * (long)(n - i) >= left) {
					 points += (left / times.get(j));
					 break;
				 }
				 else {
					 points += n-i;
					 left -= times.get(j) * (long)(n - i);
				 }
			 }
			 
			 best = Math.max(best, points);
			 
		 }
		 
		 System.out.println(best);
	 }


}
 
 
 
