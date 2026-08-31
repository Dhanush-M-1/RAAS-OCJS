import java.util.*;

public class Question5 {
static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] arr = new int[n][3];
		ArrayList<Integer> list[] = new ArrayList[4];
		for(int i = 0;i < 4;i++)list[i] = new ArrayList<Integer>();
		int sumb = 0, sumc = 0;
		for(int i = 0;i < n;i++) {
			int t = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			sumb += b;
			sumc += c;
			
			list[2 * b + c].add(t);
		}
		
		if(sumb < k || sumc < k) {
			System.out.println(-1);
			return;
		}
		Collections.sort(list[1]);
		Collections.sort(list[2]);
		Collections.sort(list[3]);
		
		long ans = 0;
		sumb = 0;
		sumc = 0;
		ArrayList<Integer> ansList = new ArrayList<Integer>();
		int ini = Math.min(k, list[3].size());
		for(int i = 0;i < ini;i++) {
			int x = list[3].get(i);
			ans += x;
			ansList.add(x);
			sumb += 1;
			sumc += 1;
		}
		
		Collections.sort(ansList, Collections.reverseOrder());
		int i = 0;
		while(sumb < k) {
			
			ansList.add(list[1].get(i));
			ansList.add(list[2].get(i));
			ans += list[1].get(i) + list[2].get(i);
			sumb++;
			i++;
		}
		
		int j = i;
		int l = 0;
		int ax = list[1].size();
		int bx = list[2].size();
		while(i < list[1].size() && j < list[2].size() && l < ini) {
			
			if(list[1].get(i) + list[2].get(j) <  ansList.get(0)) {
				ans -= ansList.get(0);
				ansList.remove(0);
				ans += list[1].get(i);
				ans += list[2].get(j);
				ansList.add(list[1].get(i));
				ansList.add(list[2].get(j));
				i++;
				j++;
				l++;
			}
			else break;
			
			if(i >= ax || j >= bx || l >= ini) {
				break;
			}
			
		}
		System.out.println(ans);
		
	}
}
