import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException,
	IOException {Main solve = new Main();solve.solve();}
	void dump(int[]a){for(int i=0;i<a.length;i++)System.out.print(a[i]+" ");System.out.println();}
	void dump(int[]a,int n){for(int i=0;i<a.length;i++)System.out.printf("%"+n+"d",a[i]);System.out.println();}
	void dump(long[]a){for(int i=0;i<a.length;i++)System.out.print(a[i]+" ");System.out.println();}
	void dump(char[]a){for(int i=0;i<a.length;i++)System.out.print(a[i]);System.out.println();}
	long pow(long a,int n){long r=1;while(n>0){if((n&1)==1)r*=a;a*=a;n>>=1;}return r;}
	String itob(int a,int l){return String.format("%"+l+"s",Integer.toBinaryString(a)).replace(' ','0');}
	int binarySearchSmallerMax(int[]a,int v) // get maximum index which a[idx]<=v
	{int l=0,r=a.length-1,s=0;while(l<=r){int m=(l+r)/2;if(a[m]>v)r=m-1;else{l=m+1;s=m;}}return a[s]>v?-1:s;}
	void solve() throws NumberFormatException, IOException{
		final ContestScanner in = new ContestScanner();
		Writer out = new Writer();
		List<String> str = new ArrayList<>();
		String token;
		int plus = 0;
		int minus = 0;
		while(!(token = in.nextToken()).matches("\\d+")){
			if(token.equals("-")) minus++;
			else if(token.equals("+")) plus++;
			str.add(token);
		}
		int n = Integer.parseInt(token);
//		if(minus>plus*n || (plus+1)>minus*n+n){
//			System.out.println("Impossible");
//			return;
//		}
		plus++;
		int[] resPlus = new int[plus];
		int[] resMinus = new int[minus];
		for(int i=0; i<plus; i++) resPlus[i] = n;
		for(int i=0; i<minus; i++) resMinus[i] = n;
		if(plus>minus){
			int dist = (plus - minus)*n-n;
			for(int i=0; i<plus && dist>0; i++){
				int sub = Math.min(n-1, dist);
				dist -= sub;
				resPlus[i] -= sub;
			}
			if(dist>0){
				System.out.println("Impossible");
				return;
			}
		}else if(plus<=minus){
			int dist = (minus - plus)*n+n;
			for(int i=0; i<minus && dist>0; i++){
				int sub = Math.min(n-1, dist);
				dist -= sub;
				resMinus[i] -= sub;
			}
			if(dist>0){
				System.out.println("Impossible");
				return;
			}
		}
		String bf = "+";
		int size = str.size();
		for(int i=0; i<size-1; i++){
			if(i%2==1){
				bf = str.get(i);
				continue;
			}
			if(bf.equals("+")){
				str.set(i, String.valueOf(resPlus[--plus]));
			}else{
				str.set(i, String.valueOf(resMinus[--minus]));
			}
		}
		String res = "";
		for(int i=0; i<size; i++){
			res += str.get(i)+" ";
		}
		System.out.println("Possible");
		System.out.println(res+n);
	}
}

class MultiSet<T> extends HashMap<T, Integer>{
	@Override
	public Integer get(Object key){return containsKey(key)?super.get(key):0;}
	public void add(T key,int v){put(key,get(key)+v);}
	public void add(T key){put(key,get(key)+1);}
	public void sub(T key)
	{final int v=get(key);if(v==1)remove(key);else put(key,v-1);}
}
class Timer{
	long time;
	public void set(){time=System.currentTimeMillis();}
	public long stop(){return time=System.currentTimeMillis()-time;}
	public void print()
	{System.out.println("Time: "+(System.currentTimeMillis()-time)+"ms");}
	@Override public String toString(){return"Time: "+time+"ms";}
}
class Writer extends PrintWriter{
	public Writer(String filename)throws IOException
	{super(new BufferedWriter(new FileWriter(filename)));}
	public Writer()throws IOException{super(System.out);}
}
class ContestScanner {
	private InputStreamReader in;private int c=-2;
	public ContestScanner()throws IOException 
	{in=new InputStreamReader(System.in);}
	public ContestScanner(String filename)throws IOException
	{in=new InputStreamReader(new FileInputStream(filename));}
	public String nextToken()throws IOException {
		StringBuilder sb=new StringBuilder();
		while((c=in.read())!=-1&&Character.isWhitespace(c));
		while(c!=-1&&!Character.isWhitespace(c)){sb.append((char)c);c=in.read();}
		return sb.toString();
	}
	public String readLine()throws IOException{
		StringBuilder sb=new StringBuilder();if(c==-2)c=in.read();
		while(c!=-1&&c!='\n'&&c!='\r'){sb.append((char)c);c=in.read();}
		return sb.toString();
	}
	public long nextLong()throws IOException,NumberFormatException
	{return Long.parseLong(nextToken());}
	public int nextInt()throws NumberFormatException,IOException
	{return(int)nextLong();}
	public double nextDouble()throws NumberFormatException,IOException 
	{return Double.parseDouble(nextToken());}
}