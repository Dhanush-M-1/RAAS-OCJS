import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a= in.nextInt();
		int b= in.nextInt();
		int cura= a;
		int curb= 0;
		int res= 0;
		while(cura>0){
			res+=cura;
			curb+=cura;
			cura= curb/b;
			curb= curb%b;
		}
		System.out.println(res);
	}
}
