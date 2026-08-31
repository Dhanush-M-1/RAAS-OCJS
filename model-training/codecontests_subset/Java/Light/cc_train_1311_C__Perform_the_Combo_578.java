//package Atcoder;
import java.io.*;
import java.util.*;
 
 
public class wtf {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			String inp[]=br.readLine().split(" ");
			int n=Integer.parseInt(inp[0]);
			int m=Integer.parseInt(inp[1]);
			String s=br.readLine();
			HashMap<Integer,long[]> dp=new HashMap<Integer,long[]>();
			long[] toadd=new long[26];
			toadd[s.charAt(0)-'a']++;
			dp.put(0,toadd);
			for(int i=1;i<n;i++) {
				long[] temp=Arrays.copyOf(dp.get(i-1), 26);
				temp[s.charAt(i)-'a']++;
				dp.put(i,temp);
			}
			inp=br.readLine().split(" ");
			long []answer=dp.get(n-1);
			for(int i=0;i<m;i++) {
				long add[]=dp.get(Integer.parseInt(inp[i])-1);
				for(int j=0;j<26;j++) {
					answer[j]+=add[j];
				}
			}
			StringBuilder print=new StringBuilder();
			for(int i=0;i<26;i++) {
				print.append(answer[i]+" ");
			}
			System.out.println(print.toString());
		}
	}
		
}
