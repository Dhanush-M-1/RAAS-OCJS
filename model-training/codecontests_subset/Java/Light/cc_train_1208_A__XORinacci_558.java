import java.util.*;
import java.io.*;

public class Solution{

	public static Integer INT(String s){
		return Integer.parseInt(s);
	}

	public static Long LONG(String s){
		return Long.parseLong(s);
	}

	//====================================================================================================================




	public static void main(String args[]) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	Scanner in=new Scanner(System.in); StringBuilder out=new StringBuilder();
		
		int t=in.nextInt();

		while(t--!=0) {

			int a=in.nextInt(),
				b=in.nextInt(),
				n=in.nextInt();

			int ans[]={a, b, a^b};
			System.out.println(ans[n%3]);
		}
	}
}