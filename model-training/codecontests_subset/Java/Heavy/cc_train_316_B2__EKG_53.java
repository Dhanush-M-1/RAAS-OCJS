import java.io.*;
import java.lang.*;
import java.util.*;
import java.text.*;


public class Main {
	
	static boolean[][] look;
	public static void main(String[] args) throws IOException {

		//BufferedReader cin = new BufferedReader(new FileReader("te.txt"));
		 BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	
		
		String line;
		StringTokenizer st;
		
		line = cin.readLine();
		st = new StringTokenizer(line);
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		//int b = Integer.parseInt(st.nextToken());
		
		int[] before = new int[n];
		boolean[] end = new boolean[n];
		Arrays.fill(end, true);
		line = cin.readLine();
		st = new StringTokenizer(line);
		int t;
		for(int i=0;i<n;i++){
			t=Integer.parseInt(st.nextToken());
			before[i]=t;
			if(t>0)end[t-1]=false;
		}
		int count;
		ArrayList<Integer> chains = new ArrayList<Integer>();
		int xpos = 0;
		boolean good;
		for(int i=0;i<n;i++){
			good=true;
			count=0;
			if(i==x-1){//count pos of x
				count++;
				t=i;
				while(before[t]!=0){
					count++;
					t=before[t]-1;
				}
				xpos=count;
			}
			else if(end[i]){//get the count for this chain
				count++;
				t=i;
				while(before[t]!=0){
					count++;
					t=before[t]-1;
					if(t==x-1){
						good=false;
						break;
					}
				}
				if(good)chains.add(count);
			}
		}
		int s = chains.size();
		look=new boolean[n+1][s+1];
		psum(n,chains,s);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			if(look[i][s]){//partial sum i is possible
				sb.append(i+xpos);
				sb.append('\n');
			}
		}
		System.out.println(sb);

		cin.close();
	}
	
	public static void psum(int n,ArrayList<Integer>l,int s){//So many mistakes! <=,>= margin condition!
		for(int i=0;i<=s;i++) look[0][i]=true;
		for(int j=1;j<=n;j++) look[j][0]=false;
		for(int i=1;i<=n;i++)
			for(int j=1;j<=s;j++){
				look[i][j]=look[i][j-1];
				if(i>=l.get(j-1)){//Mistake!! get(i-1) not get(s-1)
					look[i][j]=look[i][j]||look[i-l.get(j-1)][j-1];
				}
			}
	}

}