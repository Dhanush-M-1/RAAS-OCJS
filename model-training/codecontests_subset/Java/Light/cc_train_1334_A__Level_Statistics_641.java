import java.util.*;
import java.io.*;

public final class Solution {
	public static void main(String[] args) throws IOException  {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			ArrayList<Long> p=new ArrayList<Long>();
			ArrayList<Long> c=new ArrayList<Long>();
			long ps=0, cs=0;
			String ans="YES";
			for(int i=0;i<n;i++) {
				p.add(sc.nextLong());
				c.add(sc.nextLong());
			}
			ps=p.get(0);
			cs=c.get(0);
			if(c.get(0)>p.get(0)) ans="NO";
			for(int i=1;i<n;i++) {
				ps+=p.get(i);
				cs+=c.get(i); 
				if(p.get(i)<p.get(i-1) || c.get(i)<c.get(i-1) || cs>ps || c.get(i)-c.get(i-1)>p.get(i)-p.get(i-1)) ans="NO";
			}
			if(cs>ps) ans="NO";
			System.out.println(ans);
			
			
		}
	}
}
