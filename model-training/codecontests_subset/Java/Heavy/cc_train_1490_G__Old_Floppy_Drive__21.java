import java.util.*;
import java.io.*;
public class EdB {
	static long[] mods = {1000000007, 998244353, 1000000009};
	static long mod = mods[0];
	public static MyScanner sc;
    public static PrintWriter out;
	public static void main(String[] omkar) throws Exception{
		// TODO Auto-generated method stub
 		sc = new MyScanner();
 		out = new PrintWriter(System.out);
 		int t = sc.nextInt();
 		for(int i = 0;i<t;i++){
//	 		String input1 = bf.readLine().trim();
//	 		String input2 = bf.readLine().trim();
//			COMPARING INTEGER OBJECTS U DO DOT EQUALS NOT ==
 			int n = sc.nextInt();
 			int m = sc.nextInt();
 			long[] a = readArrayLong(n);
 			long[] x = readArrayLong(m);
 			long[] prefixsums = new long[n];
 			prefixsums[0] = a[0];
 			for(int j = 1;j<n;j++){
 				prefixsums[j] = prefixsums[j-1]+a[j];
 			}
 			ArrayList<Pair> arr = new ArrayList<>();
 			long max = 0;
 			for(int j = 0;j<n;j++){
 				if (prefixsums[j] > max){
 					max = prefixsums[j];
 					arr.add(new Pair(j, prefixsums[j]));
 				}
 			}
 			Collections.sort(arr);
 			for(int j = 0;j<m;j++){
 				if (max < x[j] && prefixsums[n-1] <=0){
 					out.print(-1 + " ");
 					continue;
 				}
 				long sum = x[j];
 				long count = 0;
 				long currsum = 0;
 				if (prefixsums[n-1] > 0){
	 				count+=Math.max(0, n*((x[j]-max+prefixsums[n-1]-1)/prefixsums[n-1]));
	 				currsum = Math.max(0, (x[j]-max+prefixsums[n-1]-1)/prefixsums[n-1]*prefixsums[n-1]);
 				}
 				long left = sum-currsum;
 				
 				int l = 0;
 				int r = arr.size();
 				while(l < r){
 					int mid = (l+r)/2;
 					if (arr.get(mid).val >= left){
 						r = mid;
 					}
 					else{
 						l = mid+1;
 					}
 				}
 				count+=arr.get(l).index;
 				out.print(count + " ");
 			}
 			out.println();
 			
 			
//	 		for(int j = 0;j<array.length;j++){
//	 			out.print(array[j] + " ");
//	 		}
//	 		out.println();
 		}
	 		
 		out.close();
 	}
	static class Pair implements Comparable<Pair>{
		private int index;
		private long val;
		public Pair(int index, long val){
			this.index = index;
			this.val = val;
		}
		public int compareTo(Pair other){
			return Long.compare(val,  other.val);
		}
	}
	public static void sort(int[] array){
		ArrayList<Integer> copy = new ArrayList<>();
		for (int i : array)
			copy.add(i);
		Collections.sort(copy);
		for(int i = 0;i<array.length;i++)
			array[i] = copy.get(i);
	}
	static String[] readArrayString(int n){
		String[] array = new String[n];
		for(int j =0 ;j<n;j++)
			array[j] = sc.next();
		return array;
	}
	static int[] readArrayInt(int n){
    	int[] array = new int[n];
    	for(int j = 0;j<n;j++)
    		array[j] = sc.nextInt();
    	return array;
    }
	static int[] readArrayInt1(int n){
		int[] array = new int[n+1];
		for(int j = 1;j<=n;j++){
			array[j] = sc.nextInt();
		}
		return array;
	}
	static long[] readArrayLong(int n){
		long[] array = new long[n];
		for(int j =0 ;j<n;j++)
			array[j] = sc.nextLong();
		return array;
	}
	static double[] readArrayDouble(int n){
		double[] array = new double[n];
		for(int j =0 ;j<n;j++)
			array[j] = sc.nextDouble();
		return array;
	}
	static int minIndex(int[] array){
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int j = 0;j<array.length;j++){
			if (array[j] < minValue){
				minValue = array[j];
				minIndex = j;
			}
		}
		return minIndex;
	}
	static int minIndex(long[] array){
		long minValue = Long.MAX_VALUE;
		int minIndex = -1;
		for(int j = 0;j<array.length;j++){
			if (array[j] < minValue){
				minValue = array[j];
				minIndex = j;
			}
		}
		return minIndex;
	}
	static int minIndex(double[] array){
		double minValue = Double.MAX_VALUE;
		int minIndex = -1;
		for(int j = 0;j<array.length;j++){
			if (array[j] < minValue){
				minValue = array[j];
				minIndex = j;
			}
		}
		return minIndex;
	}
	static long power(long x, long y){
		if (y == 0)
			return 1;
		if (y%2 == 1)
			return (x*power(x, y-1))%mod;
		return power((x*x)%mod, y/2)%mod;
	}
	static void verdict(boolean a){
        out.println(a ? "YES" : "NO");
    }
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try{
                str = br.readLine();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        
    }	
}

//StringJoiner sj = new StringJoiner(" "); 
//sj.add(strings)
//sj.toString() gives string of those stuff w spaces or whatever that sequence is