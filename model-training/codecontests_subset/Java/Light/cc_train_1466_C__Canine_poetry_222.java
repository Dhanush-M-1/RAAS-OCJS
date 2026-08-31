//package codeforces;
import java.util.*;
public class solution {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int tt=0;tt<t;tt++) {
			char a[]=s.next().toCharArray();
			long ans=0;
			//boolean c[]=new boolean[a.length()],e=false;
			for(int i=1;i<a.length;i++) {
				if(a[i]==a[i-1]) {
					a[i]='0';
					ans++;
				}else if(i>1 && a[i]==a[i-2]) {
					ans++;
					a[i]='1';
				}
			}
			System.out.println(ans);
		}
		s.close();
	}
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
}