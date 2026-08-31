import java.util.Arrays;
import java.util.Scanner;

public class ProblemSolvingMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while(t!=0) {
			int a = s.nextInt();
			int b = s.nextInt();
			int c = s.nextInt();
			
			int aa = a, bb = b, cc = c;
			int sum = 0;
			int sum2 = 0;
			
			while(a>0 && b>1) {
				sum++;
				a--;
				sum += 2;
				b-=2;
			}
			
			while(b>0 && c>1) {
				sum++;
				b--;
				sum+=2;
				c-=2;
			}
			
			while(bb>0 && cc>1) {
				sum2++;
				bb--;
				sum2 += 2;
				cc-=2;
			}
			
			while(aa>0 && bb>1) {
				sum2++;
				aa--;
				sum2+=2;
				bb-=2;
			}
			System.out.println(Math.max(sum, sum2));
			t--;
		}
	}
	
}

