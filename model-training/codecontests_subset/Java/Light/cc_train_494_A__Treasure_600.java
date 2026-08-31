

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] a= br.readLine().toCharArray();
		int open = 0, close= 0, hash=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]=='#')
				hash++;
			else if(a[i] =='(')
				open++;
			else
				close++;
			if(hash + close >open)
			{
				System.out.println(-1);
				return;
			}
		}
		int diff = open- close;
		int i;
		int lastIndex = -1;
		int v = -1;
		for (i = a.length-1; i >=0; i--) {
			if(a[i] == '#'){
				v = diff - hash+1;
				lastIndex = i;
				break;
			}
		}
		//		i--;
		//		for (; i >=0; i--) {
		//			if(a[i] == '#')
		//				s.push(1);
		//		}
		int valid = 0;
		for (int j = 0; j < a.length; j++) {
			if(a[j]=='#')
			{
				if(j == lastIndex)
					valid -= v;
				else
					valid--;
			}
			else if(a[j] =='(')
				valid++;
			else
				valid--;
			if(valid <0)
			{
				System.out.println(-1);
				return;
			}
		}
		while(hash-->1){
			System.out.println(1);
		}
		System.out.println(v);
	}
}
