import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class A {
        
        final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE")!=null;
        BufferedReader in;
        PrintWriter out;
        StringTokenizer tok = new StringTokenizer("");
        
        void init() throws FileNotFoundException{
                if (ONLINE_JUDGE){
                        in = new BufferedReader(new InputStreamReader(System.in));
                        out = new PrintWriter(System.out);
                }else{
                        in = new BufferedReader(new FileReader("input.txt"));
                        out = new PrintWriter("output.txt");
                }
        }
        
        String readString() throws IOException{
                while(!tok.hasMoreTokens()){
                        tok = new StringTokenizer(in.readLine());
                }
                return tok.nextToken();
        }
        
        int readInt() throws IOException{
                return Integer.parseInt(readString());
        }
        
        long readLong() throws IOException{
                return Long.parseLong(readString());
        }
        
        double readDouble() throws IOException{
                return Double.parseDouble(readString());
        }
        
        int[] readArr(int n) throws IOException{
        	int[] res = new int[n];
        	for(int i = 0; i < n; i++){
        		res[i] = readInt();
        	}
        	return res;
        }
        
        long[] readArrL(int n) throws IOException{
        	long[] res = new long[n];
        	for(int i = 0; i < n; i++){
        		res[i] = readLong();
        	}
        	return res;
        }
        
        public static void main(String[] args){
                new A().run();
        }
        
        public void run(){
                try{
                        long t1 = System.currentTimeMillis();
                        init();
                        solve();
                        out.close();
                        long t2 = System.currentTimeMillis();
                        System.err.println("Time = "+(t2-t1));
                }catch (Exception e){
                        e.printStackTrace(System.err);
                        System.exit(-1);
                }
        }
        long q;
        
        void solve() throws IOException{
        	q = readLong();
        	factor = new ArrayList<Long>();
        	factorization(q);
        	if(factor.size() == 0){
        		out.println("1");
        		out.println("0");
        		return;
        	}
        	if(factor.size() <= 2){
        		out.println(2);
        		return;
        	}
        	out.println(1);
        	out.println((factor.get(0)*factor.get(1)));
        }
        
        void maxHepify(int[] a, int i, int length){
        	int l = (i<<1) + 1;
        	int r = (i<<1) + 2;
        	int largest = i;
        	if(l < length && a[l] > a[largest])
        		largest = l;
        	if(r < length && a[r] > a[largest])
        		largest = r;
        	if(largest != i){
        		a[largest] += a[i];
        		a[i] = a[largest] - a[i];
        		a[largest] -= a[i];
        		maxHepify(a, largest, length);
        	}
        }
        
        ArrayList<Long> factor;
        
        void factorization(long x){
        	long root = (long)sqrt(x)+1;
        	for(long i = 2; i <= root; i++){
        		if(x%i == 0 && x != i){
        			factor.add(i);
        			factorization(x/i);
        			break;
        		}
        	}
        	if(x != q)factor.add(x);
        }
        
        void buildMaxHeap(int[] a){
        	for(int i = a.length/2 - 1; i >= 0; i--){
        		maxHepify(a, i, a.length);
        	}
        }
        
        void heapSort(int[] a){
        	buildMaxHeap(a);
        	for(int i = a.length - 1; i > 0; i--){
        		a[i] += a[0];
        		a[0] = a[i] - a[0];
        		a[i] -= a[0];
        		maxHepify(a, 0, i);
        	}
        }

        
        int[] zFunction(char[] s){
        	int[] z = new int[s.length];
        	z[0] = 0;
        	for (int i=1, l=0, r=0; i<s.length; ++i) {
        		if (i <= r)
        			z[i] = min (r-i+1, z[i-l]);
        		while (i+z[i] < s.length && s[z[i]] == s[i+z[i]])
        			++z[i];
        		if (i+z[i]-1 > r){
        			l = i; 
        			r = i+z[i]-1;
        		}
        	}	
        	return z;
        }
        
        int[] prefixFunction(char[] s){
        	int[] pr = new int[s.length];
        	for (int i = 1; i< s.length; ++i) {
        		int j = pr[i-1];
        		while (j > 0 && s[i] != s[j])
        			j = pr[j-1];
        		if (s[i] == s[j])  ++j;
        		pr[i] = j;
        	}
        	return pr;
        }
        
        int ModExp(int a, int n, int mod){
        	int res = 1;
        	while (n!=0)
        		if ((n & 1) != 0) {
        			res = (res*a)%mod;
        			--n;
        		}
        		else {
        			a = (a*a)%mod;
        			n >>= 1;
        		}
        	return res;
        }
        
        
        public static class Utils {       	
 
        	private Utils() {}

        	public static void mergeSort(int[] a) {
                    mergeSort(a, 0, a.length - 1);
            }
             
        	private static void mergeSort(int[] a, int leftIndex, int rightIndex) {
                    final int MAGIC_VALUE = 50;
                    if (leftIndex < rightIndex) {
                            if (rightIndex - leftIndex <= MAGIC_VALUE) {
                                    insertionSort(a, leftIndex, rightIndex);
                            } else {
                                    int middleIndex = (leftIndex + rightIndex) / 2;
                                    mergeSort(a, leftIndex, middleIndex);
                                    mergeSort(a, middleIndex + 1, rightIndex);
                                    merge(a, leftIndex, middleIndex, rightIndex);
                            }
                    }
            }
 
            private static void merge(int[] a, int leftIndex, int middleIndex, int rightIndex) {
            	int length1 = middleIndex - leftIndex + 1;
            	int length2 = rightIndex - middleIndex;
                int[] leftArray = new int[length1];
                int[] rightArray = new int[length2];
                System.arraycopy(a, leftIndex, leftArray, 0, length1);
                System.arraycopy(a, middleIndex + 1, rightArray, 0, length2);
                for (int k = leftIndex, i = 0, j = 0; k <= rightIndex; k++) {
                    if (i == length1) {
                            a[k] = rightArray[j++];
                    } else if (j == length2) {
                            a[k] = leftArray[i++];
                    } else {
                            a[k] = leftArray[i] <= rightArray[j] ? leftArray[i++] : rightArray[j++];
                    }
                }
            }
 
            private static void insertionSort(int[] a, int leftIndex, int rightIndex) {
                for (int i = leftIndex + 1; i <= rightIndex; i++) {
            		int current = a[i];
                    int j = i - 1;
                	while (j >= leftIndex && a[j] > current) {
                        a[j + 1] = a[j];
                        j--;
                        }
                    a[j + 1] = current;
                }
            }
        }
        
         
       
        
        boolean isPrime(int a){
        	for(int i = 2; i <= sqrt(a); i++)
        		if(a % i == 0) return false;
        	return true;
        }
        
        static double distance(long x1, long y1, long x2, long y2){
        	return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        }
        
        static long gcd(long a, long b){
        	if(min(a,b) == 0) return max(a,b);
        	return gcd(max(a, b) % min(a,b), min(a,b));
        }
        
        static long lcm(long a, long b){
        	return a * b /gcd(a, b);
        }
}

/*class Treap<K extends Comparable<K>>{
	
	public K x;
	public double y;
	public Treap<K> left;
	public Treap<K> right;
	
	public Treap(K x, double y, Treap<K> left, Treap<K> right) {
		this.x = x;
		this.y = y;
		this.left = left;
		this.right = right;
	}
	
	public static <K extends Comparable<K>> Treap<K> merge(Treap<K> l, Treap<K> r){
		if(l == null) return r;
		if(r == null) return l;
		if(l.y > r.y){
			return new Treap<K>(l.x, l.y, l.left, merge(l.right, r));
		}
		else{
			return new Treap<K>(r.x, r.y, merge(l, r.left), r.right);
		}
	}
	
	public void split(K x, Treap<K> left, Treap<K> right){
		Treap<K> newTreap = null;
		if(this.x.compareTo(x) <= 0){
			if(this.right == null){
				right = null;
			}
			else{
				right.split(x, newTreap, right);
			}
			left = new Treap<K>(this.x, this.y, left, newTreap);
		}
		else{
			if(this.left == null){
				left = null;
			}
			else{
				left.split(x, left, newTreap);
			}
			right = new Treap<K>(x, y, newTreap, right);
		}
	}
	
	public Treap<K> add(K x){
		Treap<K> left = null, right = null;
		this.split(x, left, right);
		Treap<K> temp = new Treap<K>(x, random(), null, null);
		return merge(merge(left, temp), right);
	}
	
	@SuppressWarnings("null")
	public Treap<K> remove(K x){
		Treap<K> left = null, temp = null, right = null;
		this.split(x, left, right);
		right.split(x, temp, right);
		return merge(left, right);
	}
	
	public static <K extends Comparable<K>> Treap<K> build(K[] a){
		Treap<K> temp = new Treap<K>(a[0], random(), null, null);
		for(int i = 1; i < a.length; i++){
			temp = temp.add(a[i]);
		}
		return temp;
	}
}*/