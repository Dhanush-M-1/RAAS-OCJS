import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main{
	static final Scanner s=new Scanner(System.in);
	static int getInt(){
		return Integer.parseInt(s.next());
	}
	public static void main(String[] __){
		cases:
		for(int q=getInt();q>0;q--) {
			int t=getInt();
			final int bufd=t;
			int digit=IntStream.iterate(1,i->i*10).limit(8).filter(i->i<=bufd).max().orElse(0);
			
			TreeSet<Integer>log=new TreeSet<>();
			int c=0;
			for(;t>9;c++) {
				int l=0,r=t,max=Integer.MIN_VALUE,d=digit;
				while(d!=1) {
					l*=10;
					l+=r/d;
					r%=d;
					d/=10;
					max=Math.max(l*r,max);
				}
				if(!log.add(t=max)) {
					System.out.println(-1);
					continue cases;
				}
			}
			System.out.println(c);
		}
	}
}