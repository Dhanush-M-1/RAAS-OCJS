import java.io.*;
import java.util.*;
import java.math.*;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class SubmarineInTheRybinskSea {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }
    static class TaskA {
        long mod = (998244353l);
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
        	while(testNumber-->0){
        		int n = in.nextInt();
        		long a[] = new long[n];
        		int length[] = new int[n];
        		HashMap<Integer , Integer> m = new HashMap<>();
        		for(int i=0;i<n;i++){
        			a[i] = in.nextLong();
        			int sum = 0;
        			long y = a[i];
        			while(y>0){
        				sum++;
        				y/=10;
        			}
        			length[i] = sum;
        			if(!m.containsKey(sum))
        				m.put(sum , 1);
        			else
        				m.replace(sum , m.get(sum)+1);
        		}
        		long ans = 0;
        		for(int i=0;i<n;i++){
        			// int l = length[i];
        			for(int j:m.keySet()){
        				long x = a[i];
        				int k = j;
        				int count = 0;
        				long ans1 = 0;
        				while(k>0 && x>0){
        					long w = x%10;
        					x/=10;
        					ans1 = (ans1 + (w*pow(10 , count , 1 , mod))%mod)%mod;
        					count+=2;
        					k--;
        				}
        				ans1 = (ans1 + (x*pow(10 , count , 1 , mod))%mod)%mod;
        				ans1 = (ans1*m.get(j))%mod;
        				ans = (ans+ans1)%mod;
        			}
        		}
        		// out.println(ans);
        		for(int i=0;i<n;i++){
        			for(int j:m.keySet()){
        				long x = a[i];
        				int k = j;
        				int count = 0;
        				long ans1 = 0;
        				while(k>0 && x>0){
        					k--;
        					count++;
        					long w = x%10;
        					x/=10;
        					ans1 = (ans1 + (w*pow(10 , count , 1 , mod))%mod)%mod;
        					count++;
        				}
        				ans1 = (ans1 + (x*pow(10 , count , 1 , mod))%mod)%mod;
        				ans1 = (ans1*m.get(j))%mod;
        				ans = (ans + ans1)%mod;
        			}
        		}
        		out.println(ans);
            }
        }
        public void dfs(ArrayList<ArrayList<Integer>> a , int index , int visited[] , int distance[] , int parent[]){
        	if(visited[index] == 1)
        		return;
        	visited[index] = 1;
        	int l = a.get(index).size();
        	for(int i=0;i<l;i++){
        		if(visited[a.get(index).get(i)] == 1)
        			continue;
        		parent[a.get(index).get(i)] = index;
        		distance[a.get(index).get(i)] = 1 + distance[index];
        		dfs(a , a.get(index).get(i) , visited , distance , parent);
        	}
        }
        public void sieve(int a[]){
            a[0] = a[1] = 1;
            int i;
            for(i=2;i*i<=a.length;i++){
                if(a[i] != 0)
                    continue;
                a[i] = i;
                for(int k = (i)*(i);k<a.length;k+=i){
                    if(a[k] != 0)
                        continue;
                    a[k] = i;
                }
            }
        }
        public int [][] matrixExpo(int c[][] , int n){
            int a[][] = new int[c.length][c[0].length];
            int b[][] = new int[a.length][a[0].length];
            for(int i=0;i<c.length;i++)
                for(int j=0;j<c[0].length;j++)
                    a[i][j] = c[i][j];
            for(int i=0;i<a.length;i++)
                b[i][i] = 1;
            while(n!=1){
                if(n%2 == 1){
                    b = matrixMultiply(a , a);
                    n--;
                }
                a = matrixMultiply(a , a);
                n/=2;
            }
            return matrixMultiply(a , b);
        }
        public int [][] matrixMultiply(int a[][] , int b[][]){
            int r1 = a.length;
            int c1 = a[0].length;
            int c2 = b[0].length;
            int c[][] = new int[r1][c2];
            for(int i=0;i<r1;i++){
                for(int j=0;j<c2;j++){
                    for(int k=0;k<c1;k++)
                        c[i][j] += a[i][k]*b[k][j];
                }
            }
            return c;
        }
        public long nCrPFermet(int n , int r , long p){
            if(r==0)
                return 1l;
            long fact[] = new long[n+1];
            fact[0] = 1;
            for(int i=1;i<=n;i++)
                fact[i] = (i*fact[i-1])%p;
            long modInverseR = pow(fact[r] , p-2 , 1l , p);
            long modInverseNR = pow(fact[n-r] , p-2 , 1l , p);
            long w = (((fact[n]*modInverseR)%p)*modInverseNR)%p;
            return w;
        }
        public long pow(long a , long b , long res , long mod){
            if(b==0)
                return res;
            if(b==1)
                return (res*a)%mod;
            if(b%2==1){
                res *= a;
                res %= mod;
                b--;
            }
            // System.out.println(a + " " + b + " " + res);
            return pow((a*a)%mod , b/2 , res , mod);
        }
        public long pow(long a , long b , long res){
            if(b == 0)
                return res;
            if(b==1)
                return res*a;
            if(b%2==1){
                res *= a;
                b--;
            }
            return pow(a*a , b/2 , res);
        }
        public void swap(int a[] , int p1 , int p2){
            int x = a[p1];
            a[p1] = a[p2];
            a[p2] = x;
        }
        public void sortedArrayToBST(TreeSet<Integer> a , int start, int end) { 
            if (start > end) {
                return;
            }
            int mid = (start + end) / 2;
            a.add(mid);
            sortedArrayToBST(a, start, mid - 1);
            sortedArrayToBST(a, mid + 1, end); 
        }
        class Combine{
            long value;
            long delete;
            Combine(long val , long delete){
                this.value = val;
                this.delete = delete;
            }
        }
        class Sort2 implements Comparator<Combine>{
            public int compare(Combine a , Combine b){
                if(a.value > b.value)
                    return 1;
                else if(a.value == b.value && a.delete>b.delete)
                    return 1;
                else if(a.value == b.value && a.delete == b.delete)
                    return 0;
                return -1;
            }
        }
        public int lowerLastBound(ArrayList<Integer> a , int x){
            int l = 0;
            int r = a.size()-1;
            if(a.get(l)>=x)
                return -1;
            if(a.get(r)<x)
                return r;
            int mid = -1;
            while(l<=r){
                mid = (l+r)/2;
                if(a.get(mid) == x && a.get(mid-1)<x)
                    return mid-1;
                else if(a.get(mid)>=x)
                    r = mid-1;
                else if(a.get(mid)<x && a.get(mid+1)>=x)
                    return mid;
                else if(a.get(mid)<x && a.get(mid+1)<x)
                    l = mid+1;
            }
            return mid;
        }
        public int upperFirstBound(ArrayList<Integer> a , Integer x){
            int l = 0;
            int r = a.size()-1;
            if(a.get(l)>x)
                return l;
            if(a.get(r)<=x)
                return r+1;
            int mid = -1;
            while(l<=r){
                mid = (l+r)/2;
                if(a.get(mid) == x && a.get(mid+1)>x)
                    return mid+1;
                else if(a.get(mid)<=x)
                    l = mid+1;
                else if(a.get(mid)>x && a.get(mid-1)<=x)
                    return mid;
                else if(a.get(mid)>x && a.get(mid-1)>x)
                    r = mid-1;
            }
            return mid;
        }
        public int lowerLastBound(int a[] , int x){
            int l = 0;
            int r = a.length-1;
            if(a[l]>=x)
                return -1;
            if(a[r]<x)
                return r;
            int mid = -1;
            while(l<=r){
                mid = (l+r)/2;
                if(a[mid] == x && a[mid-1]<x)
                    return mid-1;
                else if(a[mid]>=x)
                    r = mid-1;
                else if(a[mid]<x && a[mid+1]>=x)
                    return mid;
                else if(a[mid]<x && a[mid+1]<x)
                    l = mid+1;
            }
            return mid;
        }
        public int upperFirstBound(long a[] , long x){
            int l = 0;
            int r = a.length-1;
            if(a[l]>x)
                return l;
            if(a[r]<=x)
                return r+1;
            int mid = -1;
            while(l<=r){
                mid = (l+r)/2;
                if(a[mid] == x && a[mid+1]>x)
                    return mid+1;
                else if(a[mid]<=x)
                    l = mid+1;
                else if(a[mid]>x && a[mid-1]<=x)
                    return mid;
                else if(a[mid]>x && a[mid-1]>x)
                    r = mid-1;
            }
            return mid;
        }
        public long log(float number , int base){
            return (long) Math.floor((Math.log(number) / Math.log(base)));
        }
        public long gcd(long a , long b){
            if(a<b){
                long c = b;
                b = a;
                a = c;
            }
            if(b == 0)
            	return 0;
            if(a%b==0)
                return b;
            return gcd(b , a%b);
        }
        public void print2d(long a[][] , PrintWriter out){
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a[i].length;j++)
                    out.print(a[i][j] + " ");
                out.println();
            }
            out.println();
        }
        public void print1d(int a[] , PrintWriter out){
            for(int i=0;i<a.length;i++)
                out.print(a[i] + " ");
            out.println();
            out.println();
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
