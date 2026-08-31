import java.util.Scanner;

	public class Main {

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			
			String S = sc.next();
			
			int L = S.length();
			String Sx;
			
			if("keyence".equals(S)) {
				System.out.println("YES");
				return;
			}
			
			for(int i=0;i<L;i++) {
				for(int j=i+1;j<L;j++) {
					StringBuilder s = new StringBuilder(S);
					s.delete(i, j);
					
						if("keyence".equals(s.toString())){
							System.out.println("YES");
							return;
						}
				}
			}
			
			System.out.println("NO");
			
		}
	}