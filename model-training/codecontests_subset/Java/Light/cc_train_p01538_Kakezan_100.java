
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	Scanner sc = new Scanner(System.in);

	void run() {

		int Q = sc.nextInt();
		
		
		for(int i = 0 ; i < Q ; i++){
			int ni = sc.nextInt();
			
			int r = solve(ni);
			
			System.out.println(r);
		}
		
	}
	
	
	int solve(int ni){
		
		Set<Integer> visited = new TreeSet<Integer>();
		int count = 0;
		for(;;){
			if(ni < 10){
				return count;
			}

			ni = nextNum(ni);
			if(visited.contains(ni)){
				return -1;
			}
			visited.add(ni);
			
			count++;
		}
		
	}
	
	
	int nextNum(int a){
		int[] div = {10,100,1000,10000,100000};
		int max = 0;
		for(int d : div){
			int x = a/d;
			int y = a%d;
			max = Math.max(max, x*y);
		}
		return max;
	}
}

