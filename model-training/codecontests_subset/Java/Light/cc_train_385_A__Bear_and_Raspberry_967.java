import java.util.*;
public class Main {
	@SuppressWarnings({"resource"})
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			arr.add(sc.nextInt());
		}
		int max_diff = 0;
		for(int i=1;i<n;i++) {
			if(arr.get(i-1)<arr.get(i))
				continue;
			else {
				int diff = arr.get(i-1)-arr.get(i);
				max_diff = Math.max(max_diff, diff);
			}
		}
		if(max_diff==0) {
			System.out.println(0);
		}else {
			System.out.println((max_diff>=c)?(max_diff-c):0);
		}
	}
}
