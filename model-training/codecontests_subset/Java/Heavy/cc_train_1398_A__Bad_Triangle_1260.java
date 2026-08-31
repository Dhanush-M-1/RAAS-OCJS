
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
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
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
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }

      return str;
    }
  }

//  static long mod = 1000000007;
//
//  static ArrayList<String> al=new ArrayList<>();
//  public static int n;
//
//  static  long inversion=0;
//
//  // static long arr[];
//static long tree[] = new long[100000];
//static void MakeTree(long arr[],int s,int e,int i)
//{
//  if(s==e)
//  {
//    tree[i] = arr[s];
//    return;
//  }
//  if(s<e)
//  {
//    int mid = (s+e)/2;
//    MakeTree(arr,s,mid,2*i);
//    MakeTree(arr,mid+1,e,2*i+1);
//    tree[i] = Math.min(tree[2*i],tree[2*i+1]);
//  }
//  return;
//}

//static long MinQuery(int s,int e,int qs,int qe,int i)
//{
//  long t=0;
//
//  if(qe<s || qs>e)
//  { t= Long.MAX_VALUE;}
//  else if(s==e)
//  {
//    t = tree[i];
//  }
//  else if(qs==s&&qe==e)
//  {
//    t = tree[i];
//
//  }
//  else {
//    int mid = (s + e) / 2;
//    t= Math.min(MinQuery(s, mid, qs, qe, 2 * i), MinQuery(mid + 1, e, qs, qe, 2 * i + 1));
//
//  }
//
//  return t;
//}
//
//public static void  UpdateQuery(int s,int e,int i,int qi,long val)
//{
//  if(qi<s||qi>e)
//    return;
//  if(s==e)
//  {
//    if(s==qi)
//      tree[i]=val;
//    return;
//  }
//  int mid = (s+e)/2;
//  UpdateQuery(s,mid,2*i,qi,val);
//  UpdateQuery(mid+1,e,2*i+1,qi,val);
//
//
//
//}

  //public static int QueryTime(int s,int e,int qs,int qe,long k,int i)
//{
//
//  if(qe<s || qs>e)
//  {
//
//    return 0;}
//  if(s>=qs && e<=qe)
//  {
//    int index = Collections.binarySearch(tree[i].al , k);
//    if(index<0)
//      index = Math.abs(index)-1;
//    //System.out.println(tree[i].al.size()-index);
//    return tree[i].al.size()-index;
//  }
//  int mid = (s+e)/2;
//  int m1 = QueryTime(s,mid,qs,qe,k,2*i);
//  int m2 = QueryTime(mid+1,e,qs,qe,k,2*i+1);
//
// // System.out.println((m1+m2) +" "+m1+" "+m2);
//  return m1+m2;
//}
//  public static ArrayList<Long> MakeTree(int s,int e,long arr[],int i)
//  {
//    if(s==e)
//    {
//      ArrayList<Long>al=new ArrayList<>();
//      al.add(arr[s]);
//      Node n = new Node(al);
//      tree[i]=n;
//      return al;
//    }
//    int mid = (s+e)/2;
//    ArrayList<Long> al1=MakeTree(s,mid,arr,2*i);
//    ArrayList<Long> al2=MakeTree(mid+1,e,arr,2*i+1);
//    ArrayList<Long>al=new ArrayList<>();
////    System.out.println("al1" +al1.toString());
////    System.out.println("al2" +al2.toString());
//
//    int ai=0,bi=0;
//    while(ai<al1.size() && bi<al2.size())
//    {
//      if(al1.get(ai)<al2.get(bi))
//      {
//        al.add(al1.get(ai));
//        ++ai;
//      }
//      else
//      {
//        al.add(al2.get(bi));
//        ++bi;
//      }
//    }
//    while(ai<al1.size())
//    {
//      al.add(al1.get(ai++));
//    }
//    while(bi<al2.size())
//    {
//      al.add(al2.get(bi++));
//    }
////    System.out.println("al"+al.toString());
//
//    Node n=new Node(al);
//    tree[i]=n;
//    return al;
//  }
//
//
//  static  int arr[][];
//  static Node tree[]=new Node[400070];
  static long powmodulo(long a, long p) {
    if (p == 0)
      return 1 % mod;
    if (p == 1)
      return a % mod;
    long ans = 1;
    while (p > 0) {
      if ((p & 1) > 0) {
        ans = (ans * a) % mod;
      }
      a = (a * a) % mod;
      p = p >> 1;
    }
    return ans % mod;
  }

  static long mod = 1000000007;

  public static void main(String[] args) throws Exception {
    FastReader sc = new FastReader();
    int t = sc.nextInt();
    for (int t1 = 0; t1 < t; ++t1) {

      int n=sc.nextInt();
      SortedSet<Long>set=new TreeSet<>();
      long arr[]=new long[n];
      for(int i=0;i<n;++i)
      {
        arr[i]=sc.nextLong();
      }
     // System.out.println(set);
      long a,b,c=-1;
      a=arr[0];
      b=arr[1];
        for(int i=2;i<n;++i)
        {
          if(a+b<=arr[i])
          {c=i;
          break;
          }
        }
      if (c == -1) {
        System.out.println(-1);
      } else {
        System.out.println(1+" "+2+" "+(c+1));
      }

      }
    out.close();


  }
}

// out.println(al.toString().replaceAll("[\\[|\\]|,]",""));