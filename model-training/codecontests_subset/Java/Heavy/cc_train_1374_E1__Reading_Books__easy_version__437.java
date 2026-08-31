
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class D {

	static int mod = (int) 1e9 + 7;
	static ArrayList<Integer> gr[];
	static int ar[];
	static Scanner sc = new Scanner(System.in);
	static StringBuilder out = new StringBuilder();
	
	static class pair implements Comparable<pair>{
		int val;
		int id;
		
		
		pair(int a, int b){
			id=a;
			val=b;
		}


		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if(this.val==o.val)return this.id-o.id;
			return this.val-o.val;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		int t = 1;//sc.nextInt();
		while (t-- > 0) {
			

			int n=sc.nextInt();
			int k=sc.nextInt();
			ArrayList<Integer>alice=new ArrayList<>();
			ArrayList<Integer>bob=new ArrayList<>();
			ArrayList<Integer>both=new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				int ti=sc.nextInt();
				int ai=sc.nextInt();
				int bi=sc.nextInt();
				if(ai==1 && bi==1) {
					both.add(ti);
				}
				else if(ai==1)alice.add(ti);
				else if(bi==1)bob.add(ti);
			}
			
			Collections.sort(alice);
			Collections.sort(bob);
			Collections.sort(both);
			if(alice.size()+both.size()<k || bob.size()+both.size()<k) {
				out.append(-1+"\n");continue;
			}
			int x=0;
			int i=0,j=0,l=0;
			
			int a=0,b=0;
			int ans=0;
			while(a<k && i<alice.size() && j<bob.size() && l<both.size()) {
				
				if(alice.get(i)+bob.get(j)<=both.get(l)) {
					ans+=alice.get(i)+bob.get(j);
					i++;
					j++;
					
				}
				else {
					ans+=both.get(l);
					l++;
					
					
				}
				
				a++;
				b++;
				
				
				
			}
			
			if(a<k) {
				
				if(i==alice.size() || j==bob.size()) {
					
					while(a<k) {
						ans+=both.get(l);
						l++;
						a++;
					}
				}
				else if(l==both.size()) {
					
					while(a<k) {
						ans+=alice.get(i)+bob.get(j);
						i++;
						j++;
						a++;
					}
					
				}
				
			}
			
			out.append(ans+"\n");
			
			
			
			
		}
		System.out.println(out);
	}

}
