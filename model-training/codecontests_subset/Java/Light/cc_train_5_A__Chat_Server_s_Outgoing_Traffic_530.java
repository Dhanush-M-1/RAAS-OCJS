import java.util.*;
public class RoundN111 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int ans = 0;
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			if(s.charAt(0) == '+')
				count++;
			else if(s.charAt(0) == '-')
				count--;
			else{
				String[] p = s.split(":");
				if(p.length >= 2)
					ans += count*p[1].length();
			}
		}
		System.out.println(ans);
	}}