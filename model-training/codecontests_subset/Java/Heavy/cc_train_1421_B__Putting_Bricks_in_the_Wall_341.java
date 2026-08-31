import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
   
	public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt();
            String grid[]=new String[n];
            for(int i=0;i<n;i++)
            {
                grid[i]=sc.next();
            }
            //start is 0,0;
            //end is n-1,n-1;
            
            //I need cells, 10,  01    && n-2n-1  n-1,n-2;
            
            int count=0;
            List<List<Integer>> change=new ArrayList<>();
            if(grid[1].charAt(0)==grid[0].charAt(1))
            {
                //Now these are same, make other opposite of them;
                if(grid[n-2].charAt(n-1)==grid[1].charAt(0))
                {
                    count++;
                    List<Integer> subList=new ArrayList<>();
                    subList.add(n-1);
                    subList.add(n);
                    change.add(subList);
                }
                if(grid[n-1].charAt(n-2)==grid[1].charAt(0))
                {
                    count++;
                    List<Integer> subList=new ArrayList<>();
                    subList.add(n);
                    subList.add(n-1);
                    change.add(subList);
                }
            }
            else
            {
                //Now inme se ek ko change krna pdega;
                //Jo inme se 
                if(grid[n-2].charAt(n-1)==grid[1].charAt(0))
                {
                    //unse diff hona chahiye;
                    count++;
                   // grid[1].charAt(0)=grid[0].charAt(1);
                    List<Integer> subList=new ArrayList<>();
                    subList.add(2);
                    subList.add(1);
                    change.add(subList);
                }
                else
                {
                    count++;
                   // grid[0].charAt(1)=grid[1].charAt(0);
                    List<Integer> subList=new ArrayList<>();
                    subList.add(1);
                    subList.add(2);
                    change.add(subList);
                }
                if(grid[n-2].charAt(n-1)!=grid[n-1].charAt(n-2))
                {
                    count++;
                    List<Integer> subList=new ArrayList<>();
                    subList.add(n);
                    subList.add(n-1);
                    change.add(subList);
                }
            }
            if(count>0)
            {
                System.out.println(count);
                for(List<Integer> li: change)
                {
                    System.out.println(li.get(0)+" "+li.get(1));
                }
            }
            else{
                System.out.println(count);
            }
            
        }	
    }
    public static long count(String a, String b)
    {
        int m=a.length();
        int n=b.length();
        long dp[][]=new long[m+1][n+1];
        for (int i = 0; i <= n; ++i) 
        {
            dp[0][i] = 0; 
        }
        for (int i = 0; i <= m; ++i) 
        {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) 
        { 
            for (int j = 1; j <= n; j++) 
                { 
                    if (a.charAt(i - 1) == b.charAt(j - 1))
                    {
                        dp[i][j] = dp[i - 1][j - 1] +  dp[i - 1][j];
                    }
                    else
                    {
                        dp[i][j] = dp[i - 1][j]; 
                    }
                } 
        } 
  
        return dp[m][n];
    }
    public static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
    public static void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
    static class Pair
    {
        int x;
        int y;
        public Pair(int x, int  y)
        {
            this.x=x;
            this.y=y;
        }
    }
    static class Comp implements Comparator<Pair>
    {
        public int compare(Pair p1, Pair p2)
        {
            return p1.y-p2.y;
        }
    }
    static int gcd(int a,int b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
    }
    static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
    static void sort(long[] a) {
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (final IOException e) {
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
			try {
				str = br.readLine();
			} catch (final IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int[] nextIntArray(final int n) {
			final int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(next());
			}
			return a;
		}

	}	
}


//Templates for Comparator and Classes - @jagrit_07
/*
Arrays.sort(newEmployees, new Comparator<Employee>() {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getName().compareTo(emp2.getName());
    }
});
class Pair
	{
		
		long i; //index;
		long l; //left;
		long c; //cost;
		public Pair(long x,long y,long z)
		{
			this.i=x;
			this.l=y;
			this.c=z;
		}
		public String toString()
		{
			return this.i+" "+this.l+" "+this.c;
		}
	}
class Comp implements Comparator<Pair>
	{
		public int compare(Pair p1, Pair p2)
		{
			if(p1.c!=p2.c)
			{
				return (int)(p1.c-p2.c); //sort acc to cost;
			}
			else{
				return (int)(p1.i-p2.i); //sort acc to index;
			}
			
		}
	}
*/

/*
  HashMap - Put template - d.put(a1,d.getOrDefault(a1,0)+1);
  for (Map.Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }
*/
