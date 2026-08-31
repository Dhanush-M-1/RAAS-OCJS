import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;



public class Main {

	
	private static Scanner in = new Scanner(System.in);
	 	
	public static void main(String[] args) {
		
	
/*	int n = in.nextInt();
		int k = in.nextInt();
		
		for (int i = 0; i < k; i++) {
			n = decrease(n);
		}
		
		System.out.println(n);
		*/
		
		int  p = in.nextInt();
		String S = in.next();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int max = Integer.MIN_VALUE;
		String ans = S.substring(0,2);
		
		for (int i = 0; i <= S.length()- 2; i++) {
			
			String ss = S.substring(i, i+2);
		//	System.out.println("ss = " + ss);
			
			if(map.containsKey(ss)) {
				
				int count = map.get(ss) + 1;
				
				if(count>=max) {
					max = count;
					ans = ss;
				}
				
				map.put(ss, count);
			}
			else {
				map.put(ss,1);
			}			
		}
		
		System.out.println(ans);
	//	System.out.println(max);
	
	} static int decrease (int n) {
		if(n%10!=0) n--;
		else n/=10;
		return n;
	}
	
	static int [] iterateAnArray (int j, int [] a) {
		
		int c = j;
		
		int [] b = Arrays.copyOf(a, a.length);
		
		while(b[c]>0) {
			j++;
			if(j>=b.length) {
				j=0;
			}
			if(j==c) continue;
			b[c]--;
			b[j]+=1;
		}
		
		System.out.println(Arrays.toString(b));
		return b;
	}
	static long sum (int [] a) {
		long summa = 0;
		for (int i : a) {
			if(i%2==0) summa+=i;
		}
		
		return summa;
	}
	
	static String changeLetters (String S) {
		
		StringBuilder sb = new StringBuilder();
		
		char [] c = S.toCharArray();
		
		for (int i = 0; i < c.length; i++) {			
			if(i!=0 && i!=c.length - 1) {
				int random = (int) (1 + Math.random()* (c.length - 2));
				char temp = c[i];
				c[i]=c[random];
				c[random] = temp;
			}		
		}
	
		for (char d : c) {
			sb.append(d);
		}
		
		return sb.toString();
	}
	
	static int [] solve (int n) {
		
		int [] a = new int[n];

		int  t = 1;
		
		a[0] = 1;
		
		for (int i = t; i < a.length; i++) {	
			if(t>=a.length) break;
			fillAnArray(a,i,t++);			
		}
		
		return a;
	}
	static void fillAnArray (int[] a,int p,int t) {
		
		for(int i = p; i< p+t;i++) {
			//System.out.println(a[i-1]);
			if(i==p) a[i]=a[i-1]+1;
			else a[i]=a[i-1]+2;
		}
	}
	static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

	static void bubbleSortMyVersion(int [] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i+1; j < a.length ; j++) {
				if(a[i]>a[j]) {
					int temp = a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			//	System.out.println(Arrays.toString(a));

			}
		}
	}

	static int sum(int [] f, int n) {
		
		int result = 0;
		
		for (; n>=0; n= (n & (n + 1)) - 1) {
			result+=f[n];
		}
		return result;
	}
	//сумма элементов от l до r
	static int summa(int [] f, int l, int r) {
	    if (l>0) {
	        return sum(f,r) - sum(f,l - 1);
	    } else {
	        return sum(f,r);
	    }
	}
	
	static void increase(long [] a, long []f ,int idx, long delta) {
	    a[idx] += delta;
	 
	    for (; idx < a.length; idx |= idx + 1) {
	        f[idx] += delta;
	    }
	}
	
	static boolean isSquare(int n) {
		return (int)Math.sqrt(n)==Math.sqrt(n);
	}
	static int sumOfNumbers(int n) {
		int sum = 0;
		while(n>0) {
			sum+=n%10;
			n/=10;
		}
		return sum;
	}
	static int [] fibonacci(int n) {
		int [] f = new int[n];
		f[0]=1;
		f[1]=1;
		
		for (int i = 2; i < f.length; i++) {
			f[i]=f[i-1]+f[i-2];
		}
		
		return f;
	}
	static long fact(long n) {
		if(n<=1) return 1;
		else return n*fact(n-1);
	}
	static void closeLeft(int [] a , int l) {
		for (int i = 0; i < l; i++) {
			a[i]=1;
		}
	}
	static void closeRight (int [] a, int r) {
		for (int i = r+1; i < a.length; i++) {
			a[i]=1;
		}
	}
	static boolean isFinish(int [] a) {
		
		int num = 0;
		
		for (int i = 0; i < a.length; i++) {
			if(a[i]==-1 || a[i]==1) num++;
		}

		return num==a.length;
	}
	
	static int findAPeak(int [] a) {
		
		int n = a.length;
		
		int lo = 0;
		int hi = n-1;
		
		while(lo<=hi) {
			
			int mid = lo+(hi-lo)/2;
			if(a[mid]<a[mid-1]) hi = mid-1;
			else if(a[mid]<a[mid+1]) lo=mid+1;
			else return mid;
			
		}	
		
		
		return -1;
	}
	 
	
	static void fillAnArray(long [] a) {
		for (int i = 0; i < a.length - 1; i++) {
			a[i]=in.nextLong();
		}
	}
	static int []  shuffleAnArray(int [] a) {
		
		for (int i = 0; i < a.length; i++) {
			int index = (int)(Math.random()*a.length);
			int temp = a[i];
			a[i]=a[index];
			a[index]=temp;			
		}
				
		return a;
		
	}
	static int gcd(int a,int b) {
		return a==0 ? b : gcd(b%a,a);
	}
	
	static boolean eulerFunction(int n, int k) {
		return gcd(n,k)==1;
	}
	
	static int sumOfArray(int [] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) 
			if(a[i]>0)sum+=a[i];			
		return sum;
	}
	
	private static long convert(int i) {
		long res = i;
		while(i>0){
			int lastNum = i % 10;
			res = res * 10 + lastNum;
			i /=10;
		}
		
		return res;
	}

	static int numberOfElementsAboveZero(int [] a) {
		int num = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]>0) num++;
		}		
		return num;
	}
	static int min(int [] a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(a[i]>0 && a[i]<min) {
				min=a[i];
			}
		}
		return min;
	}
	static void dis(int [] a ,int min) {
		for (int i = 0; i < a.length; i++) {
			a[i]-=min;
		}
	}
	static boolean isPrime(int n) {
		
		if(n < 2) return false;
		
		for (int i = 2; i <= (int)Math.sqrt(n); i++) 
			if(n%i==0) return false;
			return true;
		
	}

}
class Fenwick2 {
static int sum(int [] f, int n) {
		
		int result = 0;
		
		for (; n>=0; n= (n & (n + 1)) - 1) {
			result+=f[n];
		}
		return result;
	}
	//сумма элементов от l до r
	static int summa(int [] f, int l, int r) {
	    if (l>0) {
	        return sum(f,r) - sum(f,l - 1);
	    } else {
	        return sum(f,r);
	    }
	}
	
	static void increase(long [] a, long []f ,int idx, long delta) {
	    a[idx] += delta;
	 
	    for (; idx < a.length; idx |= idx + 1) {
	        f[idx] += delta;
	    }
	}
	
	static long getMin(long [] f, int x) {
		
	    long result = Long.MAX_VALUE ;
	 
	    for (; x >= 0; x = (x & (x + 1)) - 1) {
	        result = Math.min(result, f[x]);
	    }
	 
	    return result;
	}
	
	static long getMax(long [] f, int x) {
		
	    long result = Long.MIN_VALUE ;
	 
	    for (; x >= 0; x = (x & (x + 1)) - 1) {
	        result = Math.max(result, f[x]);
	    }
	 
	    return result;
	}
	
	 static void assignMin(long [] a, long [] f, int idx, long val) {
	    a[idx] = val;
	 
	    for (; idx < a.length; idx |= idx + 1) {
	        f[idx] = Math.min(f[idx], val);
	    }
	}
	 
	 static void assignMax(long [] a, long [] f, int idx, long val) {
		    a[idx] = val;
		 
		    for (; idx < a.length; idx |= idx + 1) {
		        f[idx] = Math.max(f[idx], val);
		    }
		}
	
}
