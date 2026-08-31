
import java.util.*;
import java.io.*; 
import java.util.*;
import java.io.*; 
public class MM {
	static Scanner scanner=new Scanner(System.in);
	static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	static long a[][]=new long [200010][10];
	static long mod=1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Node[]nodes=new Node[10];
		for(int i=0;i<10;i++) {
			nodes[i]=new Node(1);
			nodes[i].a[i]++;
		}
		for(int i=0;i<10;i++)a[0][i]=1;
		for(int i=1;i<10;i++) {
			for(int j=0;j<10;j++) {
				long x=0,y=0;
				long s=0;
				for(int k=0;k<10;k++) {
					y=nodes[j].a[k];
					nodes[j].a[k]=x;
					x=y;
					s+=x;
					s%=mod;
				}
				nodes[j].a[0]+=x;nodes[j].a[1]+=x;
				nodes[9].a[0]%=mod;nodes[9].a[1]%=mod;
				s+=x;
				s%=mod;
				a[i][j]=s;
			}
		}
		for(int i=10;i<200001;i++) {
			long x=0,y=0;
			long s=0;
			for(int k=0;k<10;k++) {
				y=nodes[9].a[k];
				nodes[9].a[k]=x;
				x=y;
				s+=x;
				s%=mod;
			}
			nodes[9].a[0]+=x;nodes[9].a[1]+=x;
			nodes[9].a[0]%=mod;nodes[9].a[1]%=mod;
			s+=x;
			s%=mod;
			a[i][9]=s;
		}
		for(int i=10;i<200001;i++) {
			for(int j=8;j>=0;j--) {
				a[i][j]=a[i-1][j+1];
				
			}
		}
		int q=Integer.parseInt(bf.readLine());
		StringBuilder sb=new StringBuilder();
		while(q-->0) {
			String s[]=bf.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			long ss=0;
			while(x>0) {
				ss+=a[y][x%10];
				x/=10;
				ss%=mod;
			}
			if(q!=0)sb.append(ss+"\n");
			else sb.append(ss);
		}
		System.out.println(sb);
	}
	static class Node{
		long s;
		long a[];
		public Node(int s) {
			this.s = s;
			a=new long [10];
		}
		public Node(int s, long[] a) {
			this.s = s;
			this.a = a;
		}
		@Override
		public String toString() {
			return s+" "+Arrays.toString(a);
		}
		
	}
}
