import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class _0309PhoneNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		String input=sc.nextLine();
		if(input.indexOf('8')==-1) {
			System.out.println(0);
			return;
		}
		int count=0;
		for(int i=0;i<n;i++) {
			if(input.charAt(i)=='8'){
				count++;
			}
		}
		System.out.println(Math.min(count, n/11));
	}

}
