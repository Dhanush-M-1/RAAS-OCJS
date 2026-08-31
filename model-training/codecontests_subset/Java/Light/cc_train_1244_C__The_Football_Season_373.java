
import java.util.Scanner;

public class FootballSeason {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		long n=scn.nextLong();
		long p=scn.nextLong();
		long w=scn.nextLong();
		long d=scn.nextLong();
		for(int i=0;i<w;i++) {
			if(i*d<=p&&(p-i*d)%w==0&&(n-i-(p-i*d)/w)>=0) {
				System.out.println((p-i*d)/w+" "+i+" "+(n-i-(p-i*d)/w));
				return;
			}
		}
		System.out.println(-1);
	}

}
