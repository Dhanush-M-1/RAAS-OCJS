//package ABC173;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		HashMap<String,Integer> hm=new HashMap<>();
		hm.put("AC",0);
		hm.put("WA",0);
		hm.put("TLE",0);
		hm.put("RE",0);
		for(int i=0;i<n;i++)
		{
			String s=sc.next();
			hm.put(s,hm.getOrDefault(s,0)+1);
		}
		System.out.println("AC x "+""+hm.get("AC"));
		System.out.println("WA x "+""+hm.get("WA"));
		System.out.println("TLE x "+""+hm.get("TLE"));
		System.out.println("RE x "+""+hm.get("RE"));

	}

}
