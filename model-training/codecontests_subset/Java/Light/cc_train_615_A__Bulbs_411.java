	import java.util.Scanner;
	
	public class Training {
		
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int m = in.nextInt();
			int arr[];
			int x;
			int cnt = 0;
			String s = "";
			for(int i = 0; i < n; i++) {
				x = in.nextInt();
				arr = new int[x];
				for(int j = 0; j < x; j++) {
					arr[j] = in.nextInt();
					s = s + arr[j] + " ";
				}
			}
			String s1;
			for(int i = 1; i <= m; i++) {
				s1 = Integer.toString(i);
				if(s.contains(s1))
					cnt++;
			}
			if(cnt == m)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
