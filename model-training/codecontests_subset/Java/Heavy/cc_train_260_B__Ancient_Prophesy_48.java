import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws Exception {
		
		
		
		LR in = new LR();
		String s1 = in.nx();
		
		
		CS<ArrayList<Integer>> l1 = new CS();
		
		for (int i=0;i<s1.length()-9;i++){
			if (Character.isDigit(s1.charAt(i) ) )
				if (Character.isDigit(s1.charAt(i+1) ) )
					if (s1.charAt(i+2) == '-' )
						if (Character.isDigit(s1.charAt(i+3) ) )
							if (Character.isDigit(s1.charAt(i+4) ) )
								if (s1.charAt(i+5) == '-' )
									if (Character.isDigit(s1.charAt(i+6) ) )
										if (Character.isDigit(s1.charAt(i+7) ) )
											if (Character.isDigit(s1.charAt(i+8) ) )
												if (Character.isDigit(s1.charAt(i+9) ) ){
													int n1 = Integer.parseInt(s1.substring(i, i+2));
													int n2 = Integer.parseInt(s1.substring(i+3, i+5));
													int n3 = Integer.parseInt(s1.substring(i+6, i+10));
													ArrayList<Integer> temp = new ArrayList();
													temp.add(n1);
													temp.add(n2);
													temp.add(n3);
													//px(n1,n2,n3);
													
													if (valid(temp)){
														l1.add(temp);
													}
												}
		}
		//pn(l1);
		ArrayList<Integer> ans = null;
		int max = Integer.MIN_VALUE;
		for (ArrayList<Integer> e: l1.m1.keySet()){
			if (l1.get(e)>max){
				max = l1.get(e);
				ans = e;
			}
		}
		
		pn(String.format("%2s", ans.get(0)).replace(' ', '0')+"-"+String.format("%2s", ans.get(1)).replace(' ', '0')+"-"+ans.get(2));
	}
	public static int[] month = {100,31,28,31,30,31,30,31,31,30,31,30,31};
	public static boolean valid (ArrayList<Integer> l1){
		int n1 = l1.get(0);
		int n2 = l1.get(1);
		int n3 = l1.get(2);
		if (n1<1) return false;
		if (n2<1) return false;
		if (n3<1) return false;
		if (!(n3<=2015&&n3>=2013)) return false;
		if (!(n2<=12)) return false;
		if (!(n1<=month[n2])) return false;
		
		return true;
	}
	private static BigInteger bi(long n1) {
		return BigInteger.valueOf(n1);
	}

	private static void p(Object o1) {
		System.out.print(o1);
	}

	private static void pn(Object o1) {
		System.out.println(o1);
	}

	private static void px(Object... o1) {
		System.out.println(Arrays.deepToString(o1));
	}

	private static class LR {
		BufferedReader k1 = null;

		public LR() throws Exception {
			k1 = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nx() throws Exception {
			return k1.readLine();
		}
	}

	private static class ST {
		StreamTokenizer k1 = null;

		public ST() throws Exception {
			k1 = new StreamTokenizer(System.in);
		}

		public int ni() throws Exception {
			k1.nextToken();
			return (int) k1.nval;
		}

		public double nd() throws Exception {
			k1.nextToken();
			return (double) k1.nval;
		}

		public long nl() throws Exception {
			k1.nextToken();
			return (long) k1.nval;
		}
	}
	
	
	
	public static class CS<E> {
		public long total = 0;
		public HashMap<E,Integer> m1 = new HashMap();
		public void add(E k1){
			add(k1,1);
		}
		public void remove(E k1){
			add(k1,-1);
		}
		public void add(E k1, int n1){
			int nv = 0;
			if (m1.containsKey(k1)){
				nv = m1.get(k1);
			}
			m1.put(k1, nv+n1);
			total+=n1;
			if (nv+n1==0){
				m1.remove(k1);
			}
		}
		public void set(E k1, int n1){
			int nv = 0;
			if (m1.containsKey(k1)){
				nv = m1.get(k1);
			}
			m1.put(k1, n1);
			total+=n1-nv;
			if (n1==0){
				m1.remove(k1);
			}
		}
		public int get(E k1){
			if (!m1.containsKey(k1)){
				return 0;
			}
			else {
				return m1.get(k1);
			}
		}
		public String toString(){
			return m1.toString();
		}
	}
}
