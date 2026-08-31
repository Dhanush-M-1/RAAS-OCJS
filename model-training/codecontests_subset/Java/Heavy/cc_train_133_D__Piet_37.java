import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class D {
        
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
        
        public static void main(String[] args){
                new D().run();
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
        
        
       
        void solve() throws IOException{
        	int m = readInt();
        	int n = readInt();
        	char[] a = readString().toCharArray();
        	int[][] map = new int[m][a.length];
        	for(int j = 0; j < a.length; j++){
    			map[0][j] = a[j] - '0';
    		}
        	for(int i = 1; i < m; i++){
        		a = readString().toCharArray();
        		for(int j = 0; j < a.length; j++){
        			map[i][j] = a[j] - '0';
        		}
        	}
        	
        	int[][][][] nextI = new int[m][a.length][4][2];
        	int[][][][] nextJ = new int[m][a.length][4][2];
        	int[][][][] nextDP = new int[m][a.length][4][2];
        	int[][][][] nextCP = new int[m][a.length][4][2];
        	int r = a.length;
        	for(int i = 0; i < m; i++){
        		for(int j = 0; j < r; j++){
        			int curL = 0;
    				int curR = 0;
    				int curD = 0;
    				int curU = 0;
        			for(int i1 = j; i1 < r; i1++){
        				if(i1 == r-1 || map[i][i1+1] != map[i][j]){
        					curR = i1;
        					break;
        				}
        			}
        			for(int i1 = j; i1 >= 0; i1--){
        				if(i1 == 0 || map[i][i1-1] != map[i][j]){
        					curL = i1;
        					break;
        				}
        			}
        			for(int i1 = i; i1 < m; i1++){
        				if(i1 == m-1 || map[i1+1][j] != map[i][j]){
        					curD = i1;
        					break;
        				}
        			}
        			for(int i1 = i; i1 >= 0; i1--){
        				if(i1 == 0 || map[i1-1][j] != map[i][j]){
        					curU = i1;
        					break;
        				}
        			}
        			
        			if(curR != r-1 && map[curU][curR+1] != 0){
        				nextI[i][j][1][0] = curU;
        				nextJ[i][j][1][0] = curR+1;
        				nextDP[i][j][1][0] = 1;
        				nextCP[i][j][1][0] = 0;
        			}
        			else{
        				nextI[i][j][1][0] = i;
        				nextJ[i][j][1][0] = j;
        				nextDP[i][j][1][0] = 1;
        				nextCP[i][j][1][0] = 1;
        			}
        			
        			if(curR != r-1 && map[curD][curR+1] != 0){
        				nextI[i][j][1][1] = curD;
        				nextJ[i][j][1][1] = curR+1;
        				nextDP[i][j][1][1] = 1;
        				nextCP[i][j][1][1] = 1;
        			}
        			else{
        				nextI[i][j][1][1] = i;
        				nextJ[i][j][1][1] = j;
        				nextDP[i][j][1][1] = 2;
        				nextCP[i][j][1][1] = 0;
        			}
        			
        			if(curD != m-1 && map[curD+1][curR] != 0){
        				nextI[i][j][2][0] = curD+1;
        				nextJ[i][j][2][0] = curR;
        				nextDP[i][j][2][0] = 2;
        				nextCP[i][j][2][0] = 0;
        			}
        			else{
        				nextI[i][j][2][0] = i;
        				nextJ[i][j][2][0] = j;
        				nextDP[i][j][2][0] = 2;
        				nextCP[i][j][2][0] = 1;
        			}
        			
        			if(curD != m-1 && map[curD+1][curL] != 0){
        				nextI[i][j][2][1] = curD+1;
        				nextJ[i][j][2][1] = curL;
        				nextDP[i][j][2][1] = 2;
        				nextCP[i][j][2][1] = 1;
        			}
        			else{
        				nextI[i][j][2][1] = i;
        				nextJ[i][j][2][1] = j;
        				nextDP[i][j][2][1] = 3;
        				nextCP[i][j][2][1] = 0;
        			}
        			
        			if(curL != 0 && map[curD][curL-1] != 0){
        				nextI[i][j][3][0] = curD;
        				nextJ[i][j][3][0] = curL-1;
        				nextDP[i][j][3][0] = 3;
        				nextCP[i][j][3][0] = 0;
        			}
        			else{
        				nextI[i][j][3][0] = i;
        				nextJ[i][j][3][0] = j;
        				nextDP[i][j][3][0] = 3;
        				nextCP[i][j][3][0] = 1;
        			}
        			
        			if(curL != 0 && map[curU][curL-1] != 0){
        				nextI[i][j][3][1] = curU;
        				nextJ[i][j][3][1] = curL-1;
        				nextDP[i][j][3][1] = 3;
        				nextCP[i][j][3][1] = 1;
        			}
        			else{
        				nextI[i][j][3][1] = i;
        				nextJ[i][j][3][1] = j;
        				nextDP[i][j][3][1] = 0;
        				nextCP[i][j][3][1] = 0;
        			}
        			
        			if(curU != 0 && map[curU-1][curL] != 0){
        				nextI[i][j][0][0] = curU-1;
        				nextJ[i][j][0][0] = curL;
        				nextDP[i][j][0][0] = 0;
        				nextCP[i][j][0][0] = 0;
        			}
        			else{
        				nextI[i][j][0][0] = i;
        				nextJ[i][j][0][0] = j;
        				nextDP[i][j][0][0] = 0;
        				nextCP[i][j][0][0] = 1;
        			}
        			
        			if(curU != 0 && map[curU-1][curR] != 0){
        				nextI[i][j][0][1] = curU-1;
        				nextJ[i][j][0][1] = curR;
        				nextDP[i][j][0][1] = 0;
        				nextCP[i][j][0][1] = 1;
        			}
        			else{
        				nextI[i][j][0][1] = i;
        				nextJ[i][j][0][1] = j;
        				nextDP[i][j][0][1] = 1;
        				nextCP[i][j][0][1] = 0;
        			}
        			
        		}
        	}
        	int curI =0;
        	int curJ = 0;
        	int curDP = 1;
        	int curCP = 0;
            for(int i = 0; i < n; i++){
            	int nI = nextI[curI][curJ][curDP][curCP];
            	int nJ = nextJ[curI][curJ][curDP][curCP];
            	int nD = nextDP[curI][curJ][curDP][curCP];
            	int nC = nextCP[curI][curJ][curDP][curCP];
            	curI = nI;
            	curJ = nJ;
            	curDP = nD;
            	curCP = nC;
            }
            out.println(map[curI][curJ]);
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
        
        
        static class Utils {
 
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