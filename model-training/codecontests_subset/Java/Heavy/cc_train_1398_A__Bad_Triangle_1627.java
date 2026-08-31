//Written by Shagoto
import java.util.*;
public class Main
{
// -------- Generating Prime Numbers Using Bit-wise sieve --------
//  static HashSet<Integer> primes = new HashSet<Integer>();
//  static BitSet bs = new BitSet(10000001);
//  static void sieve()
//  {
//    primes.add(2);
//    for(int i = 4; i<=10000000; i+=2)
//    {
//      bs.set(i,true);
//    }
//    
//    for(int i = 3; i<=10000000; i+=2)
//    {
//      if(!bs.get(i))
//      {
//        primes.add(i);
//        for(int j = 3; i*j<=10000000; j+=2)
//        {
//          bs.set(i*j,true);
//        }
//      }
//    }
//  }

// -------- Phi Function --------
//  static int phi(int n) 
//  { 
//    int ret = n;  
//    for(int i = 2; i*i <= n; i++) 
//    { 
//      if(n % i == 0)  
//      { 
//        while(n % i == 0) 
//        {
//          n /= i; 
//        }
//        ret -= ret / i; 
//      } 
//    } 
//    
//    if(n > 1) 
//    {
//      ret -= ret / n; 
//    }
//    return ret; 
//  }

// -------- GCD of Two Numbers --------  
//  static int gcd(int a, int b)
//  {
//    if(b == 0)
//    {
//      return a;
//    }
//    return gcd(b, a % b);  
//  }
  
//  -------- Binary Search --------
//  static int binarySearch(int [] arr, x)
//  {
//    int low = 0;
//    int high = arr.length - 1;
//    
//    while(low <= high)
//    {
//      int mid = (low + high) / 2;
//      
//      if(arr[mid] == x)
//      {
//        return mid;
//      }
//      else if(arr[mid] > x)
//      {
//        high = mid - 1;
//      }
//      else
//      {
//        low = mid + 1;
//      }
//    }
//    return -1;
//  }
  
  public static void main(String[]args)
  {
/*
*  InputStreamReader isr = new InputStreamReader(System.in);
*  BufferedReader read = new BufferedReader(isr);
*/
    Scanner read = new Scanner(System.in); 
    
    int t = read.nextInt();
    for(int x = 1; x<=t; x++)
    {
      int n = read.nextInt();
      int [] arr = new int[n];
      for(int i = 0; i<n; i++)
      {
        arr[i] = read.nextInt();
      }
   
      if(arr[0] + arr[1] > arr[n-1])
      {
        System.out.println(-1);
      }
      else
      {
        System.out.println("1 2 "+n);
      }
    }
  }
}

// -------- Creating own Class --------
//class className
//{
//  int v1;
//  int v2;
//  public className(int x, int y)
//  {
//    v1 = x;
//    v2 = y;
//  }
// 
//  public String toString()
//  {
//    return v1+" "+v2;
//  }
//}

// -------- For Comparision or Sorting --------
// *Paste it in the main class*
//Collections.sort(arr, new Comparator<className>(){
//      public int compare(className a, className b)
//      {
//        if(a.v1 == b.v1)
//        {
//          return b.v2 - a.v2;
//        }
//        else
//        {
//          return a.v1 - b.v1;
//        }
//      }
//    });