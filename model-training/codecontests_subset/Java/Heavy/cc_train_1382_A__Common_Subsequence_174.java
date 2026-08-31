// import static java.lang.System.out;
import java.io.*; 
import java.util.*; 
public class Main{
	static PrintWriter pp = new PrintWriter((System.out));
	public static void main(String[] args) throws IOException {
		in sc = new in();  
		int t = sc.iin(); 
		// for single output use out
		while(t-- > 0){
			int n1 = sc.iin();
			int n2 = sc.iin(); 
			int a[] = sc.iin(n1);
			int b[] = sc.iin(n2);
			int count = 0; 
// 			ArrayList<Integer> c = new ArrayList<>();
            int c= 0; 
			Arrays.sort(a); 
			Arrays.sort(b);
			int i = 0, j = 0;  
		    while(i < n1 && j < n2){
		        if(a[i] == b[j]){
		            count++; 
		           c= a[i];
		            break; 
		            
		        }
		        else if(a[i] > b[j])
		            j++; 
		        else
		            i++; 
		    }
		    if(count == 0){
		        pp.println("NO"); 
		    }
		    else{
		        pp.println("YES");
		        pp.println(count+" "+c); 
		    }
		}
		pp.close(); 
	}
	public static int find() throws IOException {
		return 0; 
	}
	public static String index(String s, int i){
		return Character.toString(s.charAt(i)); 
	}
}
class in{
	ReaderClass sc = new ReaderClass(System.in);
	public int iin() throws IOException{
		int a = sc.nextInt(); 
		return a; 
	}
	public long lin() throws IOException{
		long a = sc.nextLong(); 
		return a; 
	}
	public double din() throws IOException{
		double a = sc.nextDouble(); 
		return a; 
	}
	public String sin() throws IOException{
		String a = sc.next(); 
		return a; 
	}

	public int[] iin(int n) throws IOException{
		int a[] = new int[n]; 
		for(int i = 0; i< n; i++){
			a[i] = sc.nextInt(); 
		}
		return a; 
	}
	public long[] lin(int n) throws IOException{
		long a[] = new long[n]; 
		for(int i = 0; i< n; i++){
			a[i] = sc.nextLong(); 
		}
		return a;
	}
	public char[] scin() throws IOException{
		String s = sc.next(); 
		char[] a = s.toCharArray(); 
		return a; 
	}
	public double[] din(int n) throws IOException{
		double a[] = new double[n]; 
		for(int i = 0; i< n; i++){
			a[i] = sc.nextDouble(); 
		}
		return a; 
	}
	public String[] sin(int n) throws IOException{
		String a[] = new String[n]; 
		for(int i = 0; i< n; i++){
			a[i] = sc.next(); 
		}
		return a; 
	}
	public ArrayList<Integer>  iinlist(int n) throws IOException{
		ArrayList<Integer> a = new ArrayList<>(); 
		for(int i = 0; i < n; i++){
			a.add(sc.nextInt()); 
		}
		return a; 
	}
	public ArrayList<Long>  linlist(int n) throws IOException{
		ArrayList<Long> a = new ArrayList<>(); 
		for(int i = 0; i < n; i++){
			a.add(sc.nextLong()); 
		}
		return a; 
	}
	public ArrayList<String>  sinlist(int n) throws IOException{
		ArrayList<String> a = new ArrayList<>(); 
		for(int i = 0; i < n; i++){
			a.add(sc.next()); 
		}
		return a; 
	}
	public ArrayList<Character> cinnlist(int n) throws IOException{
		ArrayList<Character> a = new ArrayList<>(); 
		String s = sc.next();
		for(int i = 0; i < n; i++){
			a.add(s.charAt(i)); 
		} 
		return a; 
	}
	public ArrayList<Double> dinlist(int n) throws IOException{
		ArrayList<Double> a = new ArrayList<>(); 
		for(int i = 0; i < n; i++){
			a.add(sc.nextDouble()); 
		}
		return a; 
	}
}
class out{
	public static void println(String [] s) throws IOException{
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]); 
		}
	}
	public static void print(String [] s) throws IOException{
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " "); 
		}
	}
	public static void print(int [] a) throws IOException {
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " "); 
		}
	}
	public static void println(int [] a) throws IOException {
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i] + " "); 
		}
	}

	public static  void print(long [] a) throws IOException {
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " "); 
		}
	}
	public static  void print(double [] a) throws IOException {
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " "); 
		}
	}
	public static void print(char [] a) throws IOException {
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " "); 
		}
	}
	public static  void println(long [] a) throws IOException {
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i] + " "); 
		}
	}
	public static  void println(double [] a) throws IOException {
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i] + " "); 
		}
	}
	public static void println(char [] a) throws IOException {
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i] + " "); 
		}
	}
	public static <E> void print(ArrayList<E> a){
		for(int i = 0; i<a.size(); i++){
			System.out.print(a.get(i)+" "); 
		}
	}
	public static <E> void println(ArrayList<E> a){
		for(int i = 0; i<a.size(); i++){
			System.out.println(a.get(i)+" "); 
		}
	}
}
class ReaderClass {
	    static BufferedReader reader;
	    static StringTokenizer tokenizer;

	    /** call this method to initialize reader for InputStream */
	   public ReaderClass(InputStream input) {
	        reader = new BufferedReader(
	                     new InputStreamReader(input) );
	        tokenizer = new StringTokenizer("");
	    }

	    /** get next word */
	    public String next() throws IOException {
	        while ( ! tokenizer.hasMoreTokens() ) {
	            tokenizer = new StringTokenizer(
	                   reader.readLine() );
	        }
	        return tokenizer.nextToken();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt( next() );
	    }
		
	    public double nextDouble() throws IOException {
	        return Double.parseDouble( next() );
	    }
	    public long nextLong() throws IOException{
	    	return Long.parseLong(next());
	    }
	    public String nextLine() throws IOException{
	    	return reader.readLine();
	    }
}
class str{
	
}
// class graphs{
// 	in sc = new in(); 
// 	public static ArrayList[] dir(int n, int m){
// 		ArrayList<Integer> al[] = new ArrayList[n]; 
// 		for(int i = 0; i < n; i++)
// 			al[i] = new ArrayList<>(); 
// 		while(m-- >0){
// 			int a = sc.iin(); 
// 			int b = sc.iin(); 
// 			al[a].add(b);
// 		}
// 		return al; 
// 	}
// 	public static ArrayList<Node>[] dir(int n, int m){
// 		ArrayList<Node> al[] = new ArrayList[n]; 
// 		for(int i = 0; i < n; i++)
// 			al[i] = new ArrayList<>(); 
// 		while(m-- >0){
// 			Node a = new Node(sc.iin(), sc.iin());
// 			Node b = new Node(sc.iin(), sc.iin());
// 			al[a].add(b);
// 		}
// 		return al; 
// 	}
// }
class Node{
	int x, y = 0; 
	public Node(int x, int y){
		this.x = x; this.y = y; 
	}
}