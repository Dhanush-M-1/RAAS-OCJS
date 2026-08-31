import java.io.*;
import java.util.*;
public class A{
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int v0 = sc.nextInt();
		int v1 = sc.nextInt();
		int a = sc.nextInt();
		int l = sc.nextInt();
		
		int days = 0;		// Pages Read.
		//Day 1.
		days++;
		int rs = v0;	//Reading speed
		c=c-v0;
		rs+= a;
		while(c>0){
			if(rs>v1){
				rs=v1;
			}
			if((rs-l)>=c){
				days++;
				break;
			}else{
				c = c - rs + l;
				rs += a;
				days++;
			}
		}
		System.out.println(days);
	}
}