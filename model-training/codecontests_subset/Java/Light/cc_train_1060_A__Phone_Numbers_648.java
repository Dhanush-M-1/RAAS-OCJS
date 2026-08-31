import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String s = sc.next();
		
		int count=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='8')
				count++;
		}
		
		System.out.println(Math.min(n/11, count));
		
	}
}
/*
22
0011223344556677889988
*/