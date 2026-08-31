//package c615A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class c615A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nosbuttons = Integer.parseInt(st.nextToken());
			int nosbulbs = Integer.parseInt(st.nextToken());			
			HashMap<Integer, Boolean> isbulbturnedon = new HashMap<Integer, Boolean>();
			for(int i=0; i<nosbulbs; i++)
				isbulbturnedon.put(i, false);			
			for(int i=0; i<nosbuttons; i++){
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				for(int j=0; j<n; j++){
					int bulbindex = Integer.parseInt(st.nextToken());
					isbulbturnedon.put(bulbindex-1, true);
				}				
			}
			String output = (isbulbturnedon.containsValue(false))?"NO":"YES";
			System.out.println(output);
		}catch(IOException e){
			System.out.println(e);
		}
	}

}
