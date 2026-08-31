import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
		public class Solution123{
			public static void main(String[] args) throws IOException{
				FastReader sc = new FastReader();
				int n = sc.nextInt();
				int k = sc.nextInt();
				int[] arr = new int[n];
				for(int i = 0;i < n;i++){
					arr[i] = sc.nextInt();
				}
				//int cycle = 0;
				long rem = 0;
				for(long i = 1;i <= n;i++){
					if(i * (i + 1)/2 < k){
						//cycle = i;
						rem = (i * (i + 1)/2);
					}else if(i * (i + 1)/2 > k){
						break;
					}
				}
				long ans = k - rem;
				System.out.println(arr[(int)ans - 1]);
			}
			static class Pair{
				int a;
				int b;
				@Override
				public boolean equals(Object obj){
					Pair p = (Pair)obj;
					if(p.a != this.a || p.b != this.b){
						return false;
					}
					return true;
				}
				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + a;
					result = prime * result + b;
					return result;
				}
			}
			static class MyDs{
				ArrayList<Integer> arr;
				HashMap<Integer,LinkedList<Integer>> hmap;
				public MyDs(){
					arr = new ArrayList<Integer>();
					hmap = new HashMap<Integer,LinkedList<Integer>>();
				}
				void add(int x){
					if(!hmap.containsKey(x)){
						hmap.put(x,new LinkedList());
					}
					int s = arr.size();
					arr.add(x);
					hmap.get(x).add(s);
				}
				void remove(int x){
					if(!hmap.containsKey(x)){
						return;
					}
					Integer index = hmap.get(x).get(0);
					hmap.get(x).poll();
					int size = arr.size();
					Integer last = arr.get(arr.size() - 1);
					Collections.swap(arr,index,arr.size() - 1);
					arr.remove(size - 1);
					hmap.get(last).set(hmap.get(last).indexOf(size),index);
				}
				LinkedList<Integer> search(int x){
					return hmap.get(x);
				}
			}
			public static boolean compare(int[] arr,int[] arr2){
				boolean ans = true;
				for(int i = 0;i < 26;i++){
					if(arr[i] < arr2[i]){
						ans = false;
						break;
					}
				}
				return ans;
			}
			int gcd(int a, int b)
			{
			    if (b==0)
			        return a;
			    return gcd(b, a%b);
			}
			 
			 // Returns LCM of array elements
			static long findlcm(int arr[], int n)
			{
			    // Initialize result
			    long ans = arr[0];
			 
			    // ans contains LCM of arr[0],..arr[i]
			    // after i'th iteration,
			    for (int i=1; i<n; i++)
			        ans = ( ((arr[i]*ans)) /
			                (gcd(arr[i], ans)) );
			 
			    return ans;
			}
			public static boolean isPalindrome(String s){
				StringBuilder st = new StringBuilder(s);
				if(st.reverse().toString().equals(s)){
					return true;
				}
				return false;
			}
			public static int digits(int a){
				int count = 0;
				while(a != 0){
					count++;
					a = a/10;
				}
				return count;
			}
			public static long min(long n,long k){
				long ans = 0;
				long calc = n/k;
				long calc2 = n % k;
				long recalc = k - calc2;
				ans += calc * (calc - 1)/2 * recalc;
				ans += (calc + 1) * calc/2 * calc2;
				return ans;
			}
			public static long max(long n,long k){
				long ans = 0;
				long calc = n - k + 1;
				ans += calc * (calc - 1)/2;
				return ans;
			}
			public static boolean isOk(int[] arr,int size){
				if(size % 2 == 0){
					for(int i = 0;i < arr.length;i++){
						if(arr[i] % 2 != 0){
							return false;
						}
					}
					return true;
				}else{
					int count = 0;
					for(int i = 0;i < arr.length;i++){
						if(arr[i] % 2 != 0){
							count++;
						}
					}
					if(count > 1){
						return false;
					}
					return true;
				}
			}
			public static int complement(int index){
				if(index == 0){
					return 1;
				}
				return 0;
			}
			private static long gcd(long a, long b)
			{
			    while (b > 0)
			    {
			        long temp = b;
			        b = a % b; // % is remainder
			        a = temp;
			    }
			    return a;
			}
			void convertDegree(){
				
			}
			private static long gcd(long[] input)
			{
			    long result = input[0];
			    for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
			    return result;
			}
			private static long lcm(long a, long b)
			{
			    return a * (b / gcd(a, b));
			}
		
			private static long lcm(long[] input)
			{
			    long result = input[0];
			    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
			    return result;
			}
			public static boolean[] sieveAlgo(int n){
				boolean isPrime[] = new boolean[n + 1];
				for (int i = 2; i <= n; i++) {
		            isPrime[i] = true;
		        }
		
		        // mark non-primes <= n using Sieve of Eratosthenes
		        for (int factor = 2; factor*factor <= n; factor++) {
		
		            // if factor is prime, then mark multiples of factor as nonprime
		            // suffices to consider mutiples factor, factor+1, ...,  n/factor
		            if (isPrime[factor]) {
		                for (int j = factor; factor*j <= n; j++) {
		                    isPrime[factor*j] = false;
		                }
		            }
		        }
		        return isPrime;
			}
			public static int binarySearch(int[] arr,int low,int high,int key){
				while(low <= high){
					int mid = (low + high)/2;
					if(arr[mid] == key){
						return mid;
					}else if(arr[mid] < key){
						low = mid + 1;
					}else{
						high = mid - 1;
					}
				}
				return -1;
			}
			public static int ternarySearch(int[] arr,int l,int r,int key){
				if(r >= l){
					int mid1 = l + (r-1)/3;
					int mid2 = r - (r-1)/3;
					if(arr[mid1] == key){
						return mid1;
					}else if(arr[mid2] == key){
						return mid2;
					}
					if(key < arr[mid1]){
						return ternarySearch(arr,l,mid1-1,key);
					}else if(key > arr[mid2]){
						return ternarySearch(arr,mid2 + 1,r,key);
					}else{
						return ternarySearch(arr,mid1 + 1,mid2 - 1,key);
					}
				}
				return -1;
			}
			public static double fun(double x){
				return 2 * x * x - 12 * x + 7;
			}
			
			public static double tsModified(double start,double end){
				double l = start;
				double r = end;
				for(int i = 0;i < 200;i++){
					double mid1 = (l * 2 + r)/3;
					double mid2 = (l + 2 * r)/3;
					if(fun(mid1) < fun(mid2)){
						r = mid2;
					}else{
						l = mid1;
					}
				}
				double x = l;
				return fun(x);
			}
			public static String fmt(double d)
			{
			    if(d == (long) d)
			        return String.format("%d",(long)d);
			    else
			        return String.format("%s",d);
			}
			public static int[][] comparator(int[][] arr){
				Arrays.sort(arr, new Comparator<int[]>() {
		            @Override
		            public int compare(int[] a,int[] b) {
		                Integer a1 = a[0];
		                Integer b1 = b[0];
		            	return a1.compareTo(b1);
		            }
		        });
				return arr;
			}
			public static StringBuilder[][] comparator2(StringBuilder[][] arr){
				Arrays.sort(arr, new Comparator<StringBuilder[]>() {
		            @Override
		            public int compare(StringBuilder[] a,StringBuilder[] b) {
		                StringBuilder a1 = a[0];
		                StringBuilder b1 = b[0];
		            	return a1.toString().compareTo(b1.toString());
		            }
		        });
				return arr;
			}
			public static int[][] comparator2(int[][] arr){
				Arrays.sort(arr, new Comparator<int[]>() {
		            @Override
		            public int compare(int[] a,int[] b) {
		                Integer a1 = a[0];
		                Integer b1 = b[0];
		            	return b1.compareTo(a1);
		            }
		        });
				return arr;
			}
			static class FastReader
		    {
		        BufferedReader br;
		        StringTokenizer st;
		 
		        public FastReader()
		        {
		            br = new BufferedReader(new
		                     InputStreamReader(System.in));
		        }
		 
		        String next()
		        {
		            while (st == null || !st.hasMoreElements())
		            {
		                try
		                {
		                    st = new StringTokenizer(br.readLine());
		                }
		                catch (IOException  e)
		                {
		                    e.printStackTrace();
		                }
		            }
		            return st.nextToken();
		        }
		 
		        int nextInt()
		        {
		            return Integer.parseInt(next());
		        }
		 
		        long nextLong()
		        {
		            return Long.parseLong(next());
		        }
		 
		        double nextDouble()
		        {
		            return Double.parseDouble(next());
		        }
		 
		        String nextLine()
		        {
		            String str = "";
		            try
		            {
		                str = br.readLine();
		            }
		            catch (IOException e)
		            {
		                e.printStackTrace();
		            }
		            return str;
		        }
		    }
			public static String min(int m,int n){
				int[] arr = new int[m];
				arr[0] = 1;
				int sum = 1;
				int j = m - 1;
				for(int i = 1;i <= 18* m + 10;i++){
					if(sum != n){
						if(arr[j] == 9){
							j--;
						}else{
							arr[j]++;
							sum++;
						}
					}
					else{
						break;
					}
				}
				StringBuilder min = new StringBuilder("");
				for(int i = 0;i < arr.length;i++){
					min.append(arr[i]);
				}
				return min.toString();
			}
			
			public static String max(int m,int n){
				int[] arr = new int[m];
				arr[0] = 1;
				int sum = 1;
				int j = 0;
				for(int i = 1;i <= 9 * m + 10;i++){
					if(sum != n){
						if(arr[j] == 9){
							j++;
						}else{
							arr[j]++;
							sum++;
						}
					}
					else{
						break;
					}
				}
				StringBuilder min = new StringBuilder("");
				for(int i = 0;i < arr.length;i++){
					min.append(arr[i]);
				}
				return min.toString();
			}
		    public static int KMPSearch(String txt,String pat){
				int m = pat.length();
				int n = txt.length();
				int lps[] = new int[m];
				int j = 0;
				int count = 0;
				PrefixTable(pat,m,lps);
				int i = 0;
				while (i < n)
			        {
			            if (pat.charAt(j) == txt.charAt(i))
			            {
			                j++;
			                i++;
			            }
			            if (j == m)
			            {
			            	count++;
			                j = lps[j-1];
			            }
			            else if (i < n && pat.charAt(j) != txt.charAt(i))
			            {
			                if (j != 0)
			                    j = lps[j-1];
			                else
			                    i = i+1;
			            }
			        }
				return count;
			}
			public static void PrefixTable(String pat,int m,int[] lps){
				int len = 0;
				int i = 1;
				lps[0] = 0;
				while(i < m){
					if(pat.charAt(i) == pat.charAt(len)){
						lps[i] = len + 1;
						i++;
						len++;
					}else if(len > 0){
						len = lps[len - 1];
					}else{
						lps[i] = 0;
						i++;
					}
				}
			}
		    public int digit(int x){
		    	int temp = x;
		    	int count = 0;
		    	while(temp != 0){
		    		count++;
		    		temp = temp/10;
		    	}
		    	return count;
		    }
		    public int sum(int x){
		    	int temp = x;
		    	int count = 0;
		    	while(temp != 0){
		    		count += temp % 10;
		    		temp = temp/10;
		    	}
		    	return count;
		    }
		    public int product(int x){
		    	int temp = x;
		    	int count = 1;
		    	while(temp != 0){
		    		count*=temp % 10;
		    		temp = temp/10;
		    	}
		    	return count;
		    }
		    public boolean isValid2(int x){
		    	int temp = x;
		    	while(temp != 0){
		    		if(temp % 10 == 0){
		    			return false;
		    		}
		    		temp = temp/10;
		    	}
		    	return true;
		    }
		    public boolean isValid(int x){
		    	if(!isValid2(x)){
		    		return false;
		    	}else{
		    		if(product(x) <= sum(x)){
		    			return true;
		    		}
		    		return false; 
		    	}
		    }
		}