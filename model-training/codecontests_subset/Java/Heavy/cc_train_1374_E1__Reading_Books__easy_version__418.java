import java.util.*;

public class Question5Alternative {
static Scanner sc = new Scanner(System.in);
		
	public static void  main(String[] args) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		ArrayList<Integer> list[] = new ArrayList[4];
		for(int i = 0;i < 4;i++)list[i] = new ArrayList<Integer>();
		
		for(int i = 0;i < n;i++) {
			int t = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[2 * a + b].add(t);
		}
		
		Collections.sort(list[1]);
		Collections.sort(list[2]);
		
		
		for(int i = 0;i < Math.min(list[1].size(),list[2].size());i++){
			list[3].add(list[1].get(i) + list[2].get(i));
		}
		
		if(list[3].size() < k) {
			System.out.println(-1);
			return;
		}
		
		Collections.sort(list[3]);
		long sum = 0;
		
		for(int i = 0;i < k;i++)
			sum += list[3].get(i);
		
		System.out.println(sum);
	}
}
