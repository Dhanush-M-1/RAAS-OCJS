
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;



public class A {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int f=sc.nextInt();
		int s=sc.nextInt();
		int diff=Math.abs(f-s);
		int ft=diff/2;
		long sum=0;
		int i=1;
		for( i=1;i<=ft;i++) {
			sum+=i;
		}
		sum*=2;
		if(diff%2!=0) {
			sum+=i;
		}
		System.out.println(sum);
		
		
		}
}
