import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.omg.Messaging.SyncScopeHelper;
public class A {

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		long a=0;
		long b=0;
		boolean A; //true if a is bigger
		System.out.println("? 0 0");
		A=sc.nextInt()==1;
		for(int i=29;i>=0;i--) {
			System.out.println("? "+(a|(1<<i))+" "+b);
			int f=sc.nextInt();
			System.out.println("? "+a+" "+(b|(1<<i)));
			int s=sc.nextInt();
			if(f!=s) {
				if(f==-1) {
					a|=1<<i;
					b|=1<<i;
				}
			}else {
				
				if(A) {
					a|=1<<i;
				}else {
					b|=1<<i;
				}
				A=f==1;
			}
		}
		System.out.println("! "+a+" "+b);
	
	}
}
class Scanner{
	StringTokenizer st;
	BufferedReader br;
	public Scanner(InputStream system) { br = new BufferedReader(new InputStreamReader(system));}
	public Scanner(String file) throws Exception{br = new BufferedReader(new FileReader (file));}
	public String next() throws IOException{
		while (st==null|| !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	public int nextInt() throws IOException{
		return Integer.parseInt(next());
	}
	public long nextLong() throws IOException{
		return Long.parseLong(next());
	}
	public String nextLine() throws IOException{
		return br.readLine();
	}
	public Double nextDouble() throws IOException{
		return Double.parseDouble(next());
	}

}
