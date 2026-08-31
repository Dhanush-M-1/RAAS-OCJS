import java.util.Scanner;

public class A385 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int c=sc.nextInt();
		int a=0, d=0, max=0;
		for(int i=0;i<n;i++, d=a) {
			a=sc.nextInt();
			max= Math.max(d-a-c, max);
		}
		System.out.println(max);
	}

}
