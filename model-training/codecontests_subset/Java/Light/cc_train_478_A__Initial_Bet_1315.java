

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InitialBet {
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int sum=0;
		for (int i = 0; i <5; i++) {
			sum+=Integer.parseInt(st.nextToken());
		}
		if(sum%5==0 && sum!=0)
			System.out.println(sum/5);
		else
			System.out.println(-1);
	}
	
	
}
