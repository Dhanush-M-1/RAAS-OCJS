import java.util.*;

public class Solution1{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<n;i++){
			int xi = scan.nextInt();
			for(int j=0;j<xi;j++){
				set.add(scan.nextInt());
			}
			if(set.size() == m) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
}