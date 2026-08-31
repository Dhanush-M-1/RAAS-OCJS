import java.util.Arrays;
import java.util.Scanner;
public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = 0;
		int p = 0;
		while(sc.hasNextLine()){
			String c = sc.nextLine();
			if(c.charAt(0)=='+') p++;
			else if(c.charAt(0)=='-') p--;
			else t += p * (c.length()-c.indexOf(":")-1);
		}
		System.out.println(t);
    }
}