//https://codeforces.com/contest/1466/problem/C
//C. Canine poetry
import java.util.*;
import java.io.*;
public class CF_1466_C{
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		while(t-->0){
			String s = br.readLine().trim();
			int l = s.length();

			int count = 0;

			for(int i=0;i<l-1;){
				if(s.charAt(i)==s.charAt(i+1)){
					count++;
					if(i+2<l && s.charAt(i)==s.charAt(i+2)){
						count++;
						i+=3;
					}
					else
						i+=2;
				}
				else if(i+2<l && s.charAt(i)==s.charAt(i+2)){
					count++;
					if(i+3<l && s.charAt(i+1)==s.charAt(i+3)){
						count++;
						i+=4;
					}
					else
						i+=3;
				}
				else
					i++;
			}

			sb.append(count).append("\n");
		}

		pw.print(sb);
		pw.flush();
		pw.close();
	}
}