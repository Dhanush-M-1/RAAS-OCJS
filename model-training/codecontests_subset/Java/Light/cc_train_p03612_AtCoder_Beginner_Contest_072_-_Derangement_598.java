import java.util.Scanner;


	public class Main {
		
		

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
	        
			int n = sc.nextInt();
			int[] p = new int[n];
			int num = 0;
			int ren = 0;
			int zenkai = -1;
			
			for(int i=0;i<n;i++) {
				p[i] = sc.nextInt();
				if(p[i]==i+1) {
					num++;
					if(zenkai==i) {
						ren++;
						zenkai = -1;
						continue;
					}
					zenkai = i+1;
				}
			}
			
			System.out.println(num-ren);
			
			
			
		}
		
	}
