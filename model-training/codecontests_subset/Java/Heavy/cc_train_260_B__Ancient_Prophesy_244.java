//    A Computer is Like a mischievous genie.
//    It will give you exactly what you ask for,
//    but not always what you want
//    A code by Rahul Verma


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;

import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;



public class Main {



  public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

  static class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new
          InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
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

    String[] nextSArray() {
      String sr[] = null;
      try {
        sr = br.readLine().trim().split(" ");
      } catch (IOException e) {
        e.printStackTrace();
      }
      return sr;
    }

    String nextLine() {
      String str = null;
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }

      return str;
    }
  }


//  static long powmodulo(long a, long p) {
//    if (p == 0)
//      return 1 % mod;
//    if (p == 1)
//      return a % mod;
//    long ans = 1;
//    while (p > 0) {
//      if ((p & 1) > 0) {
//        ans = (ans * a) % mod;
//      }
//      a = (a * a) % mod;
//      p = p >> 1;
//    }
//    return ans % mod;
//  }



//
//  static long mod = 1000000007;
//
//  static long gcd(long a,long b)
//  {
//    if(a==0)
//      return b;
//    return  gcd(b%a,a);
//  }
//
//  static long fast_powerNumbers(long a,long n)
//  {
//    if(n==1)
//      return a;
//    long ans=fast_powerNumbers(a,n/2);
//    if(n%2==0)
//      return (ans*ans);
//    else
//      return ((ans*ans)*(a));
//  }


//
//  static void dfs_helper(int [][] arr,int i,int j,int team,int n,int m)
//  {
//    arr[i][j]=team;
//    if(i-1>=0 && arr[i-1][j]==1)
//      dfs(arr,i-1,j,team,n,m);
//    if(j-1>=0 && arr[i][j-1]==1)
//      dfs(arr,i,j-1,team,n,m);
//    if(i+1< n && arr[i+1][j]==1)
//      dfs(arr,i+1,j,team,n,m);
//    if(j+1<m && arr[i][j+1]==1)
//      dfs(arr,i,j+1,team,n,m);
//
//  }
//
//
//  static int visited[];
//  static HashMap<Integer,ArrayList<Integer>>hm;
//
//
//  static void dfs(int [][] arr,int i,int j,int team,int n,int m)
//  {
//    dfs_helper(arr,i,j,team,n,m);
//
//  }

  static int day[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
  static boolean validDay(String s,int m)
  {
    if(Character.isDigit(s.charAt(0))&&Character.isDigit(s.charAt(1)))
    {
      int d=Integer.parseInt(s);
      if(d>0&&d<=day[m])
        return true;
    }
    return false;
  }

  static boolean validMonth(String s,String dd)
  {

    if(Character.isDigit(s.charAt(0))&&Character.isDigit(s.charAt(1)))
    {
      int m=Integer.parseInt(s);
      if(m>=1&&m<=12)
      {
        return validDay(dd,m);
      }

    }
    return false;
  }

  static boolean validYear(String s)
  {
   // System.out.println(s+" "+"y");
    if(Character.isDigit(s.charAt(0))&&Character.isDigit(s.charAt(1))&&Character.isDigit(s.charAt(2))&&Character.isDigit(s.charAt(3)))
    {
      int y=Integer.parseInt(s);
      if(y>=2013&&y<=2015)
      {
        return true;
      }

    }
    return false;

  }




  public static void main(String[] args) throws Exception {
    FastReader sc = new FastReader();

//    int t1 = sc.nextInt();
//
//    for (int t = 0; t < t1 ; t++) {
   String s=sc.nextLine();
   int n=s.length();

   HashMap<String ,Integer>hm=new HashMap<>();
    for (int i = 2; i < n-7; i++) {
     if(s.charAt(i)=='-')
     {
       String d=s.substring(i-2,i);
       String m=s.substring(i+1,i+3);
       String y=s.substring(i+4,i+8);
      // System.out.println(d+" "+m+" "+y+" "+validMonth(m,d)+" "+validYear(s));

       if(validMonth(m,d)&&validYear(y))
       {
         String date =d+'-'+m+'-'+y;
         if(hm.containsKey(date))
           hm.put(date,hm.get(date)+1);
         else
           hm.put(date,1);
       }
     }

    }
      String maxdate=" ";
   // System.out.println(hm);
    int max=0;
    for (String date: hm.keySet()
    ) {
      if(max<hm.get(date))
      {
        maxdate=date;
        max=hm.get(date);
      }
    }
    System.out.println(maxdate);
  }

}

class Pair
{
  int a; int b;
  Pair(int a,int b)
  {
    this.a=a;
    this.b=b;
  }
}


class Graph
{
  HashMap<Integer,ArrayList<Integer>>hm;
  Graph()
  {
    hm=new HashMap<>();
  }
  Graph(int n){

    hm=new HashMap<>();
    for (int i = 1; i <=n ; i++) {
      hm.put(i,new ArrayList<Integer>());
    }
  }
  // function for adding an edge.................................................
  public void addEdge(int a,int b,boolean isDir)
  {
    if(isDir)
    {
      if(hm.containsKey(a))
      {
        hm.get(a).add(b);
      }
      else
      {
        hm.put(a,new ArrayList<>(Arrays.asList(b)));
      }
    }
    else
    {
      if(hm.containsKey(a))
      {
        hm.get(a).add(b);
      }
      else if(!hm.containsKey(a))
      {
        hm.put(a,new ArrayList<>(Arrays.asList(b)));
      }

      if(hm.containsKey(b))
      {
        hm.get(b).add(a);
      }
      else if(!hm.containsKey(b))
      {
        hm.put(b,new ArrayList<>(Arrays.asList(a)));
      }
    }
  }

  public void addWeightededge(){

  }



}

// out.println(al.toString().replaceAll("[\\[|\\]|,]",""));
