import java.util.Scanner;
import java.util.ArrayList;

public class AandBandCompilationError {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),s1=0,s2=0,s3=0;
		for (int i=0;i<n;i++) {
			s1+=sc.nextInt();
		}
		for (int i=0;i<n-1;i++) {
			s2+=sc.nextInt();
		}
		for (int i=0;i<n-2;i++) {
			s3+=sc.nextInt();
		}
		System.out.println(s1-s2);
		System.out.println(s2-s3);
	}
}
