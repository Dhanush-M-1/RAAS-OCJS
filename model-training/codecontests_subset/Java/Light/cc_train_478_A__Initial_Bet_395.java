import java.util.Scanner;


public class C_478A {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt(); 
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();
		int e=sc.nextInt();
		int f=a+b+c+d+e;
		if (f%5!=0 || f/5==0) 
			System.out.println(-1);
		else
			System.out.println(f/5);
	}

}
