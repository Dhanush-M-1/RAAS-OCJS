import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt(), k=scan.nextInt();
		TreeSet<Integer> set=new TreeSet<>();
		int[] c=new int[n];
		for(int i=0;i<n;i++) {
			c[i]=scan.nextInt();
			set.add(c[i]);
		}
		int res=0;
		for(int i=0;i<n;i++) {
			int x=c[i];
			Integer next=set.higher(x);
			if(next==null||next-k>x) res++;
		}
		System.out.println(res);
	}
}