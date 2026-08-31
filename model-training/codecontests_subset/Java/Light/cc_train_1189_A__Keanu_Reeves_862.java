import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			int n=sc.nextInt();
			String s=sc.next();
			int x=0,y=0;
			for(int i=0;i<n;i++) {
				if(s.charAt(i)=='1') {
					x++;
				}
				else {
					y++;
				}
			}
			if(x!=y) {
				System.out.println(1);
				System.out.println(s);
			}
			else {
				int l=0,r=n;
				int mid=(l+r)/2,a=0,b=0;
				for(int i=0;i<mid;i++) {
					if(s.charAt(i)=='1') {
						a++;
					}
					else {
						b++;
					}
				}
				if(a==b) {
					a++;
				}
				System.out.println(2);
				for(int i=0;i<a+b;i++) {
					System.out.print(s.charAt(i));
				}
				System.out.print(" ");
				for(int i=a+b;i<n;i++) {
					System.out.print(s.charAt(i));
				}
			}
		}
	}
}