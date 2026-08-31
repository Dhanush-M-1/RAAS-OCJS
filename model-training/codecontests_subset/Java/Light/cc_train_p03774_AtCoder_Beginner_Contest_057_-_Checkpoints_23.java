import java.util.Scanner;

	public class Main {

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			long[] a = new long[n];
			long[] b = new long[n];
			long[] c = new long[m];
			long[] d = new long[m];
			
			long[] ret = new long[n];
			
			for(int i=0;i<n;i++) {
				a[i] = sc.nextLong();
				b[i] = sc.nextLong();
			}
			
			for(int i=0;i<m;i++) {
				c[i] = sc.nextLong();
				d[i] = sc.nextLong();
			}
			
			long dis = 0;
			long reti = 0;
			long man = 0;
			
			for(int i=0;i<n;i++) {
				 dis = 0;
				 reti = 0;
				
				 for(int j=0;j<m;j++) {
					if(j==0) {
						dis = (Math.abs((a[i]-c[j])))+(Math.abs((b[i]-d[j])));
					}else {
						man = (Math.abs((a[i]-c[j])))+(Math.abs((b[i]-d[j])));
						if(man<dis) {
							reti=j;
						}
						dis = Math.min(dis, man);
					}
				}
				
				ret[i]=reti+1;
			}
			
			for(int i=0;i<n;i++) {
				System.out.println(ret[i]);
			}
		}	
	}