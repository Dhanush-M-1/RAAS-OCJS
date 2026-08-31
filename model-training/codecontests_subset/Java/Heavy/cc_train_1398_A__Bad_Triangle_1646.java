
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;



import java.math.*;
import java.io.*;
import java.text.*;
import java.math.BigInteger;
public class Main {

	static class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
	static class pair{
		int x;
		int y;
		public pair(int a,int b) {
			this.x=a;
			this.y=b;
		}
	}
	 public static boolean[] sieve(long n)
	    {
	        boolean[] prime = new boolean[(int)n+1];
	        Arrays.fill(prime,true);
	        prime[0] = false;
	        prime[1] = false;
	        long m = (long)Math.sqrt(n);
	        for(int i=2;i<=m;i++)
	        {
	            if(prime[i])
	            {
	                for(int k=i*i;k<=n;k+=i)
	                {
	                    prime[k] = false;
	                }
	            }
	        }
	        return prime;
	    } 
	 
	 //sorting
	
	 
	public static void sort(long arr[], int l, int r)
	    {
	        if (l < r)
	        {
	            // Find the middle point
	            int m = (l+r)/2;
	 
	            // Sort first and second halves
	            sort(arr, l, m);
	            sort(arr , m+1, r);
	 
	            // Merge the sorted halves
	            merge(arr, l, m, r);
	        }
	    }
	 
	 
	public static void merge(long arr[], int l, int m, int r)
	    {
	        // Find sizes of two subarrays to be merged
	        int n1 = m - l + 1;
	        int n2 = r - m;
	 
	        /* Create temp arrays */
	        long L[] = new long[n1];
	        long R[] = new long[n2];
	 
	        //Copy data to temp arrays
	        for (int i=0; i<n1; ++i)
	            L[i] = arr[l + i];
	        for (int j=0; j<n2; ++j)
	            R[j] = arr[m + 1+ j];
	 
	 
	        /* Merge the temp arrays */
	 
	        // Initial indexes of first and second subarrays
	        int i = 0, j = 0;
	 
	        // Initial index of merged subarry array
	        int k = l;
	        while (i < n1 && j < n2)
	        {
	            if (L[i] <= R[j])
	            {
	                arr[k] = L[i];
	                i++;
	            }
	            else
	            {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < n1)
	        {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2)
	        {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	 
	 
	 public static boolean[] primeseive(long n) {
		 boolean prime[]=new boolean[(int)n+1];
		 
		 Arrays.fill(prime, true);
		 
		 prime[0]=false;
		 prime[1]=false;
		 
		 int m=(int) Math.sqrt(n);
		 
		 for(int i=2;i<=m;i++) {
			 if(prime[i]) {
				 
				 for(int k=i*i;k<=n;k+=i) {
					 prime[k]=false;
				 }
			 }
		 }
		 
		 return prime;
	 }
	 
	    
	    static int GCD(int a,int b)
	    {
	        if(b==0)
	        {
	            return a;
	        }
	        return GCD(b,a%b);
	    }
	 
	    
	    
	    static long gcdnik(long a,long b)
	    {
	        if(b==0)
	        {
	            return a;
	        }
	        return gcdnik(b,a%b);
	    }
	    
	    
	    static long CountCoPrimes(long n)
	    {
	        long res = n;
	        for(int i=2;i*i<=n;i++)
	        {
	            if(n%i==0)
	            {
	                while(n%i==0)
	                {
	                    n/=i;
	                }
	                res-=res/i;
	            }
	        }
	        if(n>1)
	        {
	            res-=res/n;
	        }
	        return res;
	    }
	 
	 
	    
	 
	    
	 
	    static boolean prime(int n)
	    {
	        for(int i=2;i*i<=n;i++)
	        {
	            if(i%2==0 ||i%3==0)
	            {
	                return false;
	            }
	        }
	        return true;
	    }
   static String userIdGeneration(String input1,String input2,int input3,int input4) {
	    	if(input1.length()==input2.length()) {
	    		String arr[]=new String[2];
	    		
	    		arr[0]=input1;
	    		arr[1]=input2;
	    		
	    		Arrays.sort(arr);
	    	char c=arr[0].charAt(0);
	    	   String output=c+arr[1];
	    		
	    	   String k=Integer.toString(input3);
	    	
	    	char d=k.charAt(input4-1);
	    	
	    	output+=d;
	    		
	    	char e=k.charAt(k.length()-input4);
	    	output+=e;
	    	String res="";
	    	for(int i=0;i<output.length();i++) {
	    		if(Character.isUpperCase(output.charAt(i))){
	    			res+=Character.toLowerCase(output.charAt(i));
	    		}
	    		else {
	    			res+=Character.toUpperCase(output.charAt(i));
	    		}
	      	}
	    	return res;
	    	}
	    	
	    	
	    	else  {
String arr[]=new String[2];
	    		arr[0]=input1.length()>input2.length()?input2:input1;
	    		arr[1]=input1.length()>input2.length()?input1:input2;
	    		
	    		char c=arr[0].charAt(0);
	    		
	    		String output=c+arr[1];
	    		
	    	String k=Integer.toString(input3);
	    	
	    	char d=k.charAt(input4-1);
	    	
	    	output+=d;
	    		
	    	char e=k.charAt(k.length()-input4);
	    	output+=e;
	    	String res="";
	    	for(int i=0;i<output.length();i++) {
	    		if(Character.isUpperCase(output.charAt(i))){
	    			res+=Character.toLowerCase(output.charAt(i));
	    		}
	    		else {
	    			res+=Character.toUpperCase(output.charAt(i));
	    		}
	    	}
	    return res;
	    	}
	    	
	    }
	static int length(int len) {
		
		if(len==1) {
			return 1;
		}
		else if(len==2) {
			return 3;
		}
		else if(len==3) {
			return 6;
		}
		else if(len==4) {
			return 10;
		}
		return 0;
	}
	
	
public static int LargestFour(int arr[]) {
	Arrays.sort(arr);

	int n=arr.length;
	int count=0;
	int sum=0;
	for(int i=n-1;i>=1;i--) {
		sum+=arr[i];
	
			count++;
			if(count==4) {
				break;
			
		}
		
	}
	
	if(count<4) {
		sum+=arr[0];
	}
	
	return sum;
}
//Nikunj Gupta
public static void insertionSort(int array[]) {  
    int n = array.length;  
    for (int j = 1; j < n; j++) {  
        int key = array[j];  
        int i = j-1;  
        while ( (i > -1) && ( array [i] > key ) ) {  
            array [i+1] = array [i];  
            i--;  
        }  
        array[i+1] = key;  
    }  
} 



  static String solve23(int n) {
int k=0;
while(true) {
	if(n-2020*k<0) {
		return "NO";
	}
	if((n-2020*k)%2021==0) {
		return "YES";
	}
	k++;
}
	  
	
	}
  public static String swapString(String a, int i, int j) {  
      char[] b =a.toCharArray();  
      char ch;  
      ch = b[i];  
      b[i] = b[j];  
      b[j] = ch;  
      return String.valueOf(b);  
  }  
	public static void permutation(String str,int start,int end,ArrayList<String> l,Set<String>set) {
		
		if(start==end-1) {
			set.add(str);
		}
		
		for(int i=start;i<end;i++) {
			str=swapString(str,start,i);
		
		permutation(str,start+1,end,l,set);
		
		swapString(str,start,i);
		
		}
		
		
		
	}


public static boolean solution(int j) {
	String str=Integer.toString(j);
	int zero=0;
	int one=0;
	for(int i=0;i<str.length();i++) {
		if(str.charAt(i)=='7') {
			one++;
		}else if(str.charAt(i)=='4') {
			zero++;
		}
	}
	
	
	if(one==zero) {
		return true;
	}
	
	
return false;
}
	
	
	


public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {


ArrayList<Interval>ans=new ArrayList<Interval>();

int min=Math.min(newInterval.start,newInterval.end);
int max=Math.max(newInterval.end,newInterval.start);
int i=0;
boolean flag=false;
boolean place=false;

while(i<intervals.size()){
    int val1=newInterval.start;
    int val2=newInterval.end;
    
    
    if(min<=val1&&max>=val1&&max<=val2){
    Interval p2=	new Interval(min,val2);
    	ans.add(p2);
        
        place=true;
        
    }
    
    else if(min<val1&&max<val1){
        ans.add(new Interval(min,max));
        place=true; 
        ans.add(new Interval(val1,val2));
        i++;
        break;
       
    }
    else if(min>=val1&&max<=val2){
        ans.add(new Interval(val1,val2));
        place=true;
    }
    
    else if(min>val1&&min>val2){
        ans.add(new Interval(val1,val2));
    }
    else if(min>=val1&&max>val2){
        
         min=Math.min(min,val1);
  i++;
  while(i<intervals.size()){
      Interval na=intervals.get(i);
      
      if(max<=na.end&&max>=na.start){
          Interval ni=new Interval(val1,na.end);
      ans.add(ni);
      flag=true;
      place=true;
         // System.out.println("tes");
        break;
      }
      //System.out.println("tes"+"klkl");
      i++;
      
  }
    
        
        
        
    }
    
    
    
}


while(i<intervals.size()){
    Interval df=intervals.get(i);
    Interval g=new Interval(df.start,df.end);
    ans.add(g);
    
    i++;
}
  



    if(place==false){
     Interval ni=new Interval(min,max);
       //  System.out.println("tes");
       ans.add(ni); 
}

return ans;


  }


public static int lower_bound(ArrayList<Long> ar,long k)
{
    int s=0;
    int e=ar.size();
    while (s !=e)
    {
        int mid = s+e>>1;
        if (ar.get(mid) <k)
        {
            s=mid+1;
        }
        else
        {
            e=mid;
        }
    }
    if(s==ar.size())
    {
        return ar.size()-1;
    }
    return s;
}


	
		
		


        
	       
	       
	      
			
	
	
	
	
 


	


 
 
  
    
   
 private static void printsubsequences(String c, String st) {
	// TODO Auto-generated method stub
	
	 
	 if(c.length()==0) {
		 System.out.println(st);
		 return;
	 }
	 
	 
	 printsubsequences(c.substring(1),st+c.charAt(0));
	 printsubsequences(c.substring(1),st);
	 
	 
}

private static boolean compare(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap) {
		// TODO Auto-generated method stub
	 
	 for(char ch:smap.keySet()) {
		 if(smap.get(ch)!=pmap.get(ch)) {
			 return false;
		 }
	 }
		return true;
	}


private static boolean BinarySearch(int search, int[] val, int n)
 {
		// TODO Auto-generated method stub
		
	 int start=0;
	 int end=val.length-1;
	 while(start<=end) {
		 int mid=(start+end)/2;
		 
		 
		 if(val[mid]==search) {
			 return true;
		 }
		 else if(val[mid]<search) {
			 start=mid+1;
		 }
		 else {
			 end=mid-1;
		 }
		 
	 }
	 return false;
	 }


	
 
// 
// 
// static long findGCD(ArrayList<Long> arr,long start, long n) 
//	    { 
//	        long result = arr.get((int)start); 
//	        for (int i = (int)start+1; i < n; i++) 
//	            result = GCD(arr.get(i), result); 
//	  
//	        return result; 
//	    } 
//	 
	   
	 
	   

	    static long re(long n)
	    {
	        n+=1;
	        while(n%10==0)
	        {
	            n/=10;
	        }
	        return n;
	    }
	   
	   


	    
	 
	 
	 
	 
	 
	 
	    
	 
	    //xor range query
	    static long xor(long n)
	    {
	 
	        if(n%4==0)
	        {
	            return n;
	        }
	        if(n%4==1)
	        {
	            return  1;
	        }
	        if(n%4==2)
	        {
	            return n+1;
	        }
	        return 0;
	    }
	 
	    static long xor(long a,long b)
	    {
	        return xor(b)^xor(a-1);
	    }
	 
	 
	    
	 
	  
	   
	    
	 
	    
	       
	    
	 
	    
	   
	  
	 
	 

	   
	   
	    static void swap(char c,char p)
	    {
	        char t = c;
	        c = p;
	        p = t;
	    }
	 
	    static long max(long n,long m)
	    {
	        return Math.max(n,m);
	    }
	    static long min(long n,long m)
	    {
	        return Math.min(n,m);
	    }
	 
//	    double nd() throws IOException
//	    {
//	        return Double.parseDouble(in.next());
//	    }
//	    int ni() throws IOException
//	    {
//	        return Integer.parseInt(in.next());
//	    }
//	 
//	    long nl() throws IOException
//	    {
//	        return Long.parseLong(in.next());
//	    }
//	 
//	    String si() throws IOException
//	    {
//	        return in.next();
//	    }
//	 
//	 
	  
	   
	    static int abs(int n)
	    {
	        return Math.abs(n);
	    }
	 
	    static class Scanner 
	    {
	        StringTokenizer st;
	        BufferedReader br;
	 
	        public Scanner(InputStream s){  br = new BufferedReader(new InputStreamReader(s));}
	 
	        public String next() throws IOException 
	        {
	            while (st == null || !st.hasMoreTokens()) 
	            {
	                st = new StringTokenizer(br.readLine());
	            }
	            return st.nextToken();
	        }
	 
	        public int nextInt() throws IOException {return Integer.parseInt(next());}
	        
	        public long nextLong() throws IOException {return Long.parseLong(next());}
	 
	        public String nextLine() throws IOException {return br.readLine();}
	 
	        public boolean ready() throws IOException {return br.ready();}
	 
	 
	    }
	 
	    
public static char[] solve(char arr[]) {
	int i=0;
	
	char ans[]=new char[arr.length];
while(i<arr.length-1) {
	
		if(arr[i]=='B'&&arr[i+1]=='G') {
			ans[i]='G';
			ans[i+1]='B';
			i=i+2;
		}else {
			ans[i]=arr[i];
		i++;
		}
		
		
	}

if(i==arr.length-1) {
	ans[i]=arr[i];
}

	
	
	return ans;
	
}
public static void pairsort(ArrayList<pair>l){
	
	l.sort(new Comparator<pair>() {
		public int compare(pair o1,pair o2) {
			if(o1.x>o2.x) {
				return 1;
			}else {
				return -1;
			}
		}
	});

}

public static void main(String[] args) throws IOException{
  Scanner s=new Scanner(System.in);

int op=s.nextInt();
while(op>0) {
	
	int n=s.nextInt();
	int arr[]=new int[n];
	for(int i=0;i<n;i++) {
		arr[i]=s.nextInt();
	}
	
	int i=0;
	int j=1;
	int k=arr.length-1;
	boolean flag=false;
	while(j<k) {
		long sum1=arr[i]+arr[j];
		long sum2=arr[k];
		if(sum1<=sum2) {
flag=true;
			break;
		}
		i++;
		j++;
	k--;
		
		
	}
	
	if(flag) {
		i=i+1;
		j++;
		k++;
		System.out.println(i+" "+j+" "+k);
	
	}
	else {
		System.out.println(-1);
	}
	
	op--;
}
  
  
  
}

public static long mod(long x){
    //long M=1000000007;
    
	long M=998244353;
	return (int)((x%M+M)%M);
}

static long add(long a,long b){
    return mod(mod(a)+mod(b));
}


public static  long mul(long a,long b){
    return mod(mod(a)*mod(b));
}

static void printAllKLengthRec(char[] set,
        String prefix,
        int n, int k,ArrayList<String>l)
{

// Base case: k is 0,
// print prefix
if (k == 0)
{
//System.out.println(prefix);
l.add(prefix);
	return;
}

// One by one add all characters
// from set and recursively
// call for k equals to k-1
for (int i = 0; i < n; ++i)
{

// Next character of input added
String newPrefix = prefix + set[i];

// k is decreased, because
// we have added a new character
printAllKLengthRec(set, newPrefix,
         n, k - 1,l);
}
}




	 
	 
	 
	class Pair implements Comparable<Pair>
	{
	   int x,y;
	    public Pair(int x,int y)
	    {
	        this.x = x;
	        this.y = y;
	    }
	    public int compareTo(Pair o)
	    {
	        return this.y-o.y;
	    }
	}
	
	}

