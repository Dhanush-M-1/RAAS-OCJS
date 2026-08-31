import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M= scan.nextInt();
		int m = 1000000007;
		HashSet<Integer> map = new HashSet<>();
		for (int i=0;i<M;i++) {
			map.add(scan.nextInt());
		}
		int[] grid = new int[N+1];
		grid[0] = 1;
		for (int i=1;i<=N;i++) {
			if (!map.contains(i)) {
				if (i-1>=0 && !map.contains(i-1)) {
					grid[i] = (grid[i]%m+grid[i-1]%m)%m;
				}
				if (i-2>=0 && !map.contains(i-2)) {
					grid[i] = (grid[i]%m+grid[i-2]%m)%m;
				}
			}
		}
		System.out.println(grid[N]);
	}
}