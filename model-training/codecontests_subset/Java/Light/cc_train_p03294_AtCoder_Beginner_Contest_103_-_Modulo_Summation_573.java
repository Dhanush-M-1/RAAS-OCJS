import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long wa=0;
		int kosu=sc.nextInt();
		for(int i=0; i<kosu; i++) {
			wa+=sc.nextInt()-1;
		}
		System.out.println(wa);
	}
}