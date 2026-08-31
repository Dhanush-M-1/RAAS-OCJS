import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	final static String[] C = {"a","b","c","d","e","f","g","h","i","j"};
	static BufferedReader reader;
	final static boolean MODE_DEBUG = true;
	//static field here
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reader = new BufferedReader(new InputStreamReader(System.in));
		//code here
		int N = readLineInt()[0];
		
		String[] ss = get(N,N,1);
		
		for(String s : ss) {
			print(s);
		}
		
		//String[] s = readLine();
		//print(num);
	}
	
	public static String[] get(int N, int left, int max) {
		if(left==1) {
			String[] ss = new String[max];
			for(int i=0;i<max;i++) {
				ss[i] = C[i];
			}
			return ss;
		}else {
			String[][] sss = new String[max][];
			int rsl = 0;
			for(int j=0;j<max-1&&j<N-left+1;j++) {
				sss[j] = get(N,left-1,max);
				rsl+=sss[j].length;
			}
			sss[max-1] = get(N,left-1,max+1);
			rsl+=sss[max-1].length;
			String[] rs = new String[rsl];
			int rsi = 0;
			for(int j=0;j<max-1&&j<N-left+1;j++) {
				for(int i=0;i<sss[j].length;i++) {
					rs[rsi] = C[j]+sss[j][i];
					rsi++;
				}
			}
			for(int i=0;i<sss[max-1].length;i++) {
				rs[rsi] = C[max-1]+sss[max-1][i];
				rsi++;
			}
			return rs;
		}
	}
	
	//functions here
	//note that all methods should be STATIC

	private static <T> int arraySearch(T needle, T[] heystack) {
		for(int i=0;i<heystack.length;i++) {
			if(needle.equals(heystack[i])) {
				return i;
			}
		}
		return -1;
	}
	private static String[] readLine(){
		try{
			return reader.readLine().split(" ");
		}catch(Exception e){
			e.printStackTrace();
			return new String[]{e.getMessage()};
		}
	}
	private static int[] readLineInt(){
		try{
			String[] s = readLine();
			int[] ints = new int[s.length];
			for(int i=0;i<ints.length;i++) {
				ints[i] = Integer.parseInt(s[i]);
			}
			return ints;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	private static byte[] readLineByte(){
		try{
			String[] s = readLine();
			byte[] bytes = new byte[s.length];
			for(int i=0;i<bytes.length;i++) {
				bytes[i] = Byte.parseByte(s[i]);
			}
			return bytes;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	private static char[] readLineChar(){
		try{
			String[] s = readLine();
			char[] chars = new char[s.length];
			for(int i=0;i<chars.length;i++) {
				chars[i] = (char)Integer.parseInt(s[i]);
			}
			return chars;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	private static void print(Object o){
		System.out.println(o);
	}
	private static void print(){
		System.out.println();
	}
	private static void printd(Object o){
		if(MODE_DEBUG)System.err.println(o);
	}
	private static void printd(){
		if(MODE_DEBUG)System.err.println();
	}
}
