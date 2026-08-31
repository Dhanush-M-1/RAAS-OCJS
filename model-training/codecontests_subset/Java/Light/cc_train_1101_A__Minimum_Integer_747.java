import java.util.Scanner;

public class Z1101A {
	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int q=inScanner.nextInt();
		for(int i=0;i<q;i++) {
			int l=inScanner.nextInt();
			int r=inScanner.nextInt();
			int d=inScanner.nextInt();
			
			int pom=d;
			
			if(pom<l||pom>r) System.out.println(pom);
			else {
				pom+=(r/d)*d;
				System.out.println(pom);
			}
		}
	}
}
