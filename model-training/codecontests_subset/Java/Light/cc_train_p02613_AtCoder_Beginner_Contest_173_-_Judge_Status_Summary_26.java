import java.util.*;
public class Main{
	public static void main(String args[]){
		
		Scanner sc=new Scanner(System.in);
		int te=sc.nextInt();
		Map <String,Integer> mp=new HashMap<>();
		String s=new String();
		mp.put("AC",0);
		mp.put("WA",0);
		mp.put("TLE",0);
		mp.put("RE",0);
		while(te-->0){
			s=sc.next();
			Integer val=mp.get(s);
			mp.put(s,val+1);
		}
		System.out.println("AC x "+mp.get("AC"));
		System.out.println("WA x "+mp.get("WA"));
		System.out.println("TLE x "+mp.get("TLE"));
		System.out.println("RE x "+mp.get("RE"));
	}
};