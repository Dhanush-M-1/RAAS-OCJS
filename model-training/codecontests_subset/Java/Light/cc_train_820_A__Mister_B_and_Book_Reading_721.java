import java.util.Scanner;

public class _0552MisterBandBookReading {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int c=sc.nextInt();
		int v0=sc.nextInt();
		int v1=sc.nextInt();
		int a=sc.nextInt();
		int l=sc.nextInt();
		int days=0;
		
		while(c>0) {
			if(c>0 && days!=0 ) {
				c+=l;
			}
			int read=v0+(days*a);
			if(read>v1) {
				c-=v1;
			}
			else {
				c-=read;
			}
		//	System.out.println(c);
			
			days++;
		}
		System.out.println(days);
	}

}
