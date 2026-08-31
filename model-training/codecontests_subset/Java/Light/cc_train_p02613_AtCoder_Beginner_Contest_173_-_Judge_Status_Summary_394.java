import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		LinkedHashMap<String,Integer> hm=new LinkedHashMap<String,Integer>();
		hm.put("AC",0);
		hm.put("WA",0);
		hm.put("TLE",0);
		hm.put("RE",0);
		for(int i=0;i<N;i++)
		{
			String s=br.readLine().trim();
			hm.put(s,hm.get(s)+1);
		}
		for(String s:hm.keySet())
			System.out.println(s+" x "+hm.get(s));
	}
}
