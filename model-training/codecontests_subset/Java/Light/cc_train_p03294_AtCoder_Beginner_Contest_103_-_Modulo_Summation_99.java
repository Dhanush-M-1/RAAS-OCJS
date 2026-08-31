import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner stdIn=new Scanner(System.in);
		int n=stdIn.nextInt(),a,i;
		long s=-n;
		for(i=0;i<n;i++) {
			a=stdIn.nextInt();
			s+=a;
		}
		System.out.print(s);
	}
}