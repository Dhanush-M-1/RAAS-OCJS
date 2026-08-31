import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long a=scan.nextLong();
		long ans=0;
		long b=scan.nextLong();
		long jn=(long) Math.sqrt(b);
		if(a==1) {ans=b;}
		else {
		for(;;) {
			long waru=(long) Math.pow(jn,a);
			if(jn==1) {ans=1;break;}
			if(waru<=b&&b%waru==0) {ans=jn;break;}
			jn--;
		}
		}
		
		System.out.println(ans);
    }
}