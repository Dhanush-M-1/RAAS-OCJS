import java.util.*;
import java.io.*;

public class ProbD {
	public static void main(String[] args) {
		ProbD sol = new ProbD();
		sol.start();
	}

	StringBuffer printstr;
	String _readerstr;
	BufferedReader rdr;
	HashSet<Integer> debug_number_set;
	int[] debug_code;

	public void print(Object o){ print(o, 0); }
	public void print(Object o, int debug_number){
		if(debug_number_set.contains(debug_number)) System.out.print(o);
	}
	public void println() { print("\n", 0); }
	public void println(Object o) { println(o, 0); }
	public void println(Object o, int debug_number){ print(o+"\n", debug_number); }

	public void bufp(Object o){ printstr.append(o); }
	public void bufpl(Object o){ printstr.append(o).append('\n'); }
	public void bufpl() { printstr.append('\n'); }
	public void bufp(char[] c, int offset, int len){ printstr.append(c, offset, len); }
	public void bufpl(char[] c, int offset, int len){ printstr.append(c, offset, len).append('\n'); }
	
	public Integer readInt(){
		try{
			if(_readerstr==null) _readerstr = rdr.readLine();
		}
		catch(Exception e){ return null; }
		String[] s = _readerstr.split(" ", 2);
		if(s.length==1) _readerstr = null;
		else _readerstr = s[1];
		try{
			return Integer.parseInt(s[0]);
		}
		catch(Exception e){}
		return readInt();
	}
	
	public Long readLong(){
		try{
			if(_readerstr==null) _readerstr = rdr.readLine();
		}
		catch(Exception e){ return null; }
		String[] s = _readerstr.split(" ", 2);
		if(s.length==1) _readerstr = null;
		else _readerstr = s[1];
		try{
			return Long.parseLong(s[0]);
		}
		catch(Exception e){}
		return readLong();
	}
	
	public Double readDouble(){
		try{
			if(_readerstr==null) _readerstr = rdr.readLine();
		}
		catch(Exception e){ return null; }
		String[] s = _readerstr.split(" ", 2);
		if(s.length==1) _readerstr = null;
		else _readerstr = s[1];
		try{
			return Double.parseDouble(s[0]);
		}
		catch(Exception e){}
		return readDouble();
	}
	
	public String readStr(){
		try{
			if(_readerstr==null) _readerstr = rdr.readLine();
		}
		catch(Exception e){ return null; }
		String[] s = _readerstr.split(" ", 2);
		if(s.length==1) _readerstr = null;
		else _readerstr = s[1];
		return s[0];
	}
	
	public String readLine(){
		try{
			if(_readerstr==null) _readerstr = rdr.readLine();
		}
		catch(Exception e){ return null; }
		String ret = _readerstr;
		_readerstr = null;
		return ret;
	}
	
	public void initiate_the_entire_program(){
		printstr = new StringBuffer();
		_readerstr = null;
		try{
			rdr = new BufferedReader(new InputStreamReader(System.in));
		}
		catch(Exception e){ println(e); }
		debug_number_set = new HashSet();
		for(int i : debug_code) debug_number_set.add(i);
	}

	public void start(){
		debug_code = new int[] {0,1,2,3,4,5};
		initiate_the_entire_program();
		
		submit();
		
		System.out.println(printstr);
		System.out.flush();
	}
	
	public void submit(){
		int n = readInt(), k = readInt(), p = readInt();
		int[] a = new int[n], b = new int[k];
		for(int i=0;i<n;i++) a[i] = readInt();
		for(int i=0;i<k;i++) b[i] = readInt();
		Arrays.sort(a);
		Arrays.sort(b);
		bufpl(minTime(n, k, p, a, b));
//		if(canDoInTime(n, k, p, a, b, (long)(9))) println("OK");
//		else println("Not OK");
	}
	
	public long minTime(int n, int k, int p, int[] persons, int[] keys){
		long left = (long) 0;
		long right = (long) 1000;
		right = right * right * right * 20;
		while(right>left+1){
			long middle = left + (right - left) / 2;
			if(canDoInTime(n, k, p, persons, keys, middle)) right = middle;
			else left = middle;
//			if(canDoInTime(n, k, p, persons, keys, middle)) println("can do: "+middle);
//			else println("cannot do: "+middle);
		}
		if(canDoInTime(n, k, p, persons, keys, left)) return left;
		else return right;
	}
	
	public boolean canDoInTime(int n, int k, int p, int[] persons, int[] keys, long time){
		int j = 0;
		for(int i=0;i<n;i++){
			if(j==k) return false;
//			println("Matching: persons["+i+"]="+persons[i]+" with keys["+j+"]="+keys[j]);
			long t = Math.abs(persons[i] - keys[j]) + (long)(Math.abs(keys[j]-p));
			j++;
			if(t>time){
//				println("does not work.");
				i--;
			}
//			else println("does work");
		}
		return true;
	}
}