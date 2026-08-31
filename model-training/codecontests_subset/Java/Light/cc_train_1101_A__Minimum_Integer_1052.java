import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int q=input.nextInt();
		for (int i=0;i<q;++i) {
			int l=input.nextInt();
			int r=input.nextInt();
			int d=input.nextInt();
			if (l>d) System.out.println(d);
			else System.out.println((r/d+1)*d);
		}
	}
}