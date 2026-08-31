import java.util.*;

public class Main{
	public static String[] solve(int h, int m, int s){
		int hour = 2-h;
		int minute = -m;
		if( minute < 0 ){
			minute += 60;
			hour--;
		}
		int second = -s;
		if( second < 0 ){
			second += 60;
			minute--;
			if( minute < 0 ){
				minute += 60;
				hour--;
			}
		}
		String H = "0"+Integer.toString(hour);
		String M = ( minute < 10 ) ? "0"+Integer.toString(minute) : Integer.toString(minute);
		String S = ( second < 10 ) ? "0"+Integer.toString(second) : Integer.toString(second);
		
		int hour3 = 3*hour;
		int minute3 = 3*minute;
		while( minute3 >= 60 ){
			minute3 -= 60;
			hour3++;
		}
		int second3 = 3*second;
		while( second3 >= 60 ){
			second3 -= 60;
			minute3++;
		}
		while( minute3 >= 60 ){
			minute3 -= 60;
			hour3++;
		}
		String H3 = "0"+Integer.toString(hour3);
		String M3 = ( minute3 < 10 ) ? "0"+Integer.toString(minute3) : Integer.toString(minute3);
		String S3 = ( second3 < 10 ) ? "0"+Integer.toString(second3) : Integer.toString(second3);
		String ans1 = H + ":" + M + ":" + S;
		String ans2 = H3 + ":" + M3 + ":" + S3;
		String[] ans = new String[2];
		ans[0] = ans1; ans[1] = ans2;
		return ans;
	}
		
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		List<String[]> result = new ArrayList<String[]>();
		
		int h = stdIn.nextInt(), m = stdIn.nextInt(), s = stdIn.nextInt();
		while( h != -1 || m != -1 || s != -1 ){
			result.add(solve(h,m,s));
			h = stdIn.nextInt();
			m = stdIn.nextInt();
			s = stdIn.nextInt();
		}
		
		for(String[] ans : result){
			for(String str : ans){
				System.out.println(str);
			}
		}
	}
}