import java.util.Scanner;

public class Main{
	static int n;
	static int[] w;
	static int[] s= {5, 7, 5, 7, 7};
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n=sc.nextInt();
				if(n==0) break;
				w=new int[n+1];
				for(int i=1; i<=n; i++) {
					String str=sc.next();
					w[i]=str.length();
				}
				for(int k=1; k<=n; k++) {
					int c=0; 
					int j=0;
					int check=0;
					for(int i=k; i<=n; i++) {
						c+=w[i];
						if(c==s[j]) {
							j++;
							c=0;
							if(j==5) {
								System.out.println(k);
								check=1;
								break;
							}
						}
						else if(c>s[j]) {
							break;
						}
					}
					if(check==1) break;
				}
			}
		}
	}
}
