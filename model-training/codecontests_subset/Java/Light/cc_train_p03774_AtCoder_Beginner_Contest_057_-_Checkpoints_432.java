import java.util.*;
 
public class Main {
 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<int[]> Npoint = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int[] n = new int[2];
			n[0] = sc.nextInt();
			n[1] = sc.nextInt();
			Npoint.add(n);
		}
		List<int[]> Mpoint = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int[] m = new int[2];
			m[0] = sc.nextInt();
			m[1] = sc.nextInt();
			Mpoint.add(m);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int[] n = Npoint.get(i);
			int minDis = Integer.MAX_VALUE;
			int point = 0;
			for (int j = 0; j < M; j++) {
				int[] m = Mpoint.get(j);
				int dis = Math.abs(n[0] - m[0]) + Math.abs(n[1] - m[1]);
				if (dis < minDis) {
					minDis = dis;
					point = j+1;
				}
			}
			sb.append(point).append("\n");
		}
		System.out.println(sb);
	}
}