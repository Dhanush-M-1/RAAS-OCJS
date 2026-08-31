import java.io.PrintWriter;
import java.util.Scanner;

public class mineuler {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int t=scan.nextInt();
		for(int tt=0;tt<t;tt++) {
			int n=scan.nextInt();
			long l=scan.nextLong()-1, r=scan.nextLong()-1;
			int startnum1=1;
			long id1=0L, ct=n-1;
			while(id1+ct*2<l) {
				id1+=ct*2;
				ct--;
				startnum1++;
			}
			int printed=0;
			int cur=startnum1, add=1;
			long dif=l-id1;
			while(printed<r-l+1) {
				if(dif<=0) {
					printed++;
					out.print(cur);
					out.print(" ");
				}
				if(cur==startnum1) {
					cur+=add;
					if(cur==n) {
						add=0;
						startnum1++;
						if(startnum1==n) startnum1=1;
					}
				}
				else {
					cur=startnum1;
					add++;
				}
				dif--;
			}
			out.println();
		}
		out.close();
	}
}