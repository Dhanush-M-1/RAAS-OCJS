
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Test {

	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int length=Integer.parseInt(st.nextToken());
		int div=Integer.parseInt(st.nextToken());
		int rem=Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		String num=st2.nextToken();
		int result=0;
		for(int i=length-div;i<length;i++) {
			if(num.charAt(i)=='1'&&i!=length-rem-1) {
				result++;
			}
			if(num.charAt(i)=='0'&&i==length-rem-1) {
				result++;
			}
		}
		System.out.println(result);

		}
	}
