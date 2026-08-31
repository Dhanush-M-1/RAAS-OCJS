import java.util.Scanner;

public class XORinachi {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t>0) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int n=sc.nextInt();
			int fn=0;
			
			switch(n%3) {
			case 0 : 
				fn=a;
				break;
			case 1 :
				fn=b;
				break;
			case 2 :
				fn= a^b;
				break;
			}
			System.out.println(fn);
			t--;
		}
	}
}