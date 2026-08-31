

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


@SuppressWarnings("unused")
public class A {
	public  static  Scanner scan = new Scanner(System.in);
	
	public static void solve () {
		int n=scan.nextInt();
		String s=scan.next();
		//System.out.println(s);
		HashMap<String, Integer> h=new HashMap<String, Integer>();
		for(int i=0;i<n-1;i++) {
			String t=""+s.charAt(i)+s.charAt(i+1);
			if(h.containsKey(t)==false) {
				h.put(t ,1);
			}
			else {
				int old=h.get(t);
				h.put(t, ++old);
			}
		}
		Set<Entry<String,Integer>> obj=h.entrySet();
		int max=0;String ans="";;
		for (Entry<String, Integer> p : obj) {
			if(p.getValue()>max) {
				max=p.getValue();
				ans=""+p.getKey();
			}
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
	
		solve();
		scan.close();
	}

}

