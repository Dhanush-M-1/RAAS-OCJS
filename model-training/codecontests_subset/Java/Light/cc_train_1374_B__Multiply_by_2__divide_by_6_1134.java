import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
 
/**
 * @author Alice
 */
public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner str = new Scanner(System.in);
		int t = str.nextInt();
		while(t-- > 0) {
			int n = str.nextInt();
			int count1 = 0, count2 = 0, count = 0;
			while(n%6 == 0) {
				n /= 6;
				count++;
			}
			while(n%3 == 0) {
				n /= 3;
				count1++;
			}
			while(n%2 == 0) {
				n /= 2;
				count2++;
			}
			if(n != 1) System.out.println("-1");
			else {
				if(count1 >= count2) System.out.println(count + count1*2);
				else System.out.println("-1");
			}
		}
    }
}
