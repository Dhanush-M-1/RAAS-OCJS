import java.util.Scanner;
import java.util.Arrays;

public class A{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = 0;
		StringBuilder str = new StringBuilder().append(in.next());
		for(int i = 0;i<n;++i){
			if(str.charAt(i) == '1') count++;
		}
		if(count * 2 == n){
			System.out.println(2 + "\n" + str.charAt(0)+ " " + str.substring(1));
		} else System.out.println(1 + "\n" + str);
	}
}
