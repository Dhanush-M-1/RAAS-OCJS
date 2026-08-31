import java.util.*;

public class CodeForces50A {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		while(x-->0) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			int third = sc.nextInt();
			int stones = 0;
			al.add(get(first,second,third,stones));
			
		}
		for(int e : al) {
			System.out.println(e);
		}
		
	}

	private static int get(int first, int second, int third, int stones) {
		if(second == 0) {
			return 0;
		}
		
		while(second >= 1 && third >= 2) {
			stones += 3;
			second--;
			third -= 2;
		}
			
		while(first >= 1 && second >= 2) {
			stones += 3;
			first--;
			second -= 2;
		}
		
		
		return stones;
		
	}
	
	
}
