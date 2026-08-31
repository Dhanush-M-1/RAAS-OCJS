import java.io.*;
import java.util.Scanner;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	static PrintWriter cout = new PrintWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		String s = br.readLine();
		int len = s.length();
		int num = 0,plus = 0,minus = 0,n = 0;
		for(int i = 0;i < len;i++){
			if(s.charAt(i) == '?') num++;
			if(s.charAt(i) == '+') plus++;
			if(s.charAt(i) == '-') minus++;
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') n = n * 10 + (s.charAt(i) - '0');
		}
		plus++;
		//System.out.println(num+" "+plus + " " + minus);
		if(plus * n - minus < n || plus - minus * n > n){
			cout.println("Impossible");
			cout.flush();
		}
		else{
			cout.println("Possible");
			int t = 1,tag = 1;
			while(n + minus * t < plus)
				t++;
			int x = (n + minus * t) / plus;
			int cnt = (n + minus * t) % plus;
			for(int i = 0;i < len;i++){
				if(s.charAt(i) == '?'){
					if(tag == 1){
						int tmp = cnt > 0 ? x + 1 : x ;
						cnt--;
						cout.print(tmp);
					}
					else
						cout.print(t);
				}
				else{
					cout.print(s.charAt(i));
					if(s.charAt(i) == '-')
						tag = -1;
					if(s.charAt(i) == '+')
						tag = 1;
				}
			}
			cout.println();
			cout.flush();
		}
	}
}
