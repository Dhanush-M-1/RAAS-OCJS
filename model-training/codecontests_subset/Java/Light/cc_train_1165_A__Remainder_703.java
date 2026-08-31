import java.util.Scanner;
public class Main {

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		String st=sc.next();
		int count=0;
		for(int i=n-x;i<n;i++) {
			if(i==n-y-1) {
				if(st.charAt(i)!='1') {
					count++;
				}
			}
			else if(st.charAt(i)=='1') {
				count++;
			}
		}
		System.out.println(count);
	}
}
