import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int[] p = new int[n];
			int[] c = new int[n];
			
			boolean flag = false;
			
			for(int i = 0; i < n; i++) {
				p[i] = sc.nextInt();
				c[i] = sc.nextInt();
			}
			
			for(int i = 0; i < n; i++) {
				// 플레이보다 클리어가 큰 경우
				if(p[i] < c[i]) {
					sb.append("NO\n");
					flag = true;
					break;
				}
//				플레이 감소
				if(i > 0 && p[i] < p[i-1]) {
					sb.append("NO\n");
					flag = true;
					break;
				}
//				클리어 감소
				if(i > 0 && c[i] < c[i - 1]) {
					sb.append("NO\n");
					flag = true;
					break;					
				}
//				클리어 증가 플레이 감소
				if(i > 0 && c[i] > c[i - 1] && p[i] <= p[i - 1]) {
					sb.append("NO\n");
					flag = true;
					break;	
				}
				
				if(i > 0 && c[i] > c[i - 1] && p[i] > p[i-1]) {
					int t1 = c[i] - c[i - 1];
					int t2 = p[i] - p[i - 1];
					if(t1 > t2) {
						sb.append("NO\n");
						flag = true;
						break;
					}
				}
							
			}
			if(flag == false) {
				sb.append("YES\n");				
			}
		}
		
		System.out.print(sb.toString());
	}
	
}
