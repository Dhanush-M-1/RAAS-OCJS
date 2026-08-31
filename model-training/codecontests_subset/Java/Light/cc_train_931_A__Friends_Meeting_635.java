import java.util.*;
import java.io.*;
public class A{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int dif = Math.abs(a-b);
		if(dif%2==0){
			int count = 0;
			for(int i = 1;i<=dif/2;i++){
				count += i;
			}
			System.out.println(2*count);
		}
		else{
			int count = 0;
			int left = dif/2;
			int right = (dif+1)/2;
			for(int i = 1;i<=left;i++){
				count += i;
			}
			for(int i = 1;i<=right;i++){
				count += i;
			}
			System.out.println(count);
		}
	}
}