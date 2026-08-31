import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        //--------Solution-------------------------------------------------------//
        int n=sc.nextInt();
        int[] a=readIntArray(sc,n);
        int ans=Math.min(a[n-1]-1,1000000-a[0]);

        for(int i=0;i<n-1;i++){
            int c=Math.max(a[i]-1 , 1000000 - a[i+1]);
            if(c<ans) ans=c;
        }

        out.println(ans);
        //-----------------------------------------------------------------------//

        out.close();
    }

    static boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='y';
    }

    //-----------Helper Functions------------------------------------------------//
    static int[] readIntArray(MyScanner sc,int n){
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i]= sc.nextInt();
        return a;
    }

    static long[] readLongArray(MyScanner sc,int n){
        long[] a = new long[n];
        for(int i=0;i<n;i++) a[i]=sc.nextLong();
        return a;
    }

    static int[] toIntArray(String s){
        int[] a = new int[s.length()];
        for(int i=0;i<s.length();i++) a[i]=s.charAt(i)-'0';
        return a;
    }

    static long mod(long a){
        long M=(long)1e9+7;
        return (a%M + M) % M;
    }

    static int gcd(int a,int b){
        while(b!=0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }

    static long exp(long base,int exp){
        long M=(long)1e9+7;
        long res=1L;

        while(exp>0){
            if(exp%2==1) res = (res*base)%M;
            base = (base*base)%M;
            exp /= 2;
        }

        return res;
    }

    static int floor(int[] a,int i){
        int lo=0,hi=a.length-1;
        int ans=-1;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(a[mid]==i){ans=mid; break;}
            else if(a[mid]<i){ans=mid; lo=mid+1;}
            else{hi=mid-1;}
        }

        return ans;
    }

    static boolean nextPermutation(int[] a){
        int i = a.length - 1;
        while(i>0 && a[i-1]>=a[i]) i--;

        if(i==0) return false;

        int j = a.length - 1;
        while(a[j]<=a[i-1]) j--;

        int temp = a[i-1];
        a[i-1]=a[j];
        a[j]=temp;

        j = a.length - 1;
        while(i<j){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++; j--;
        }
        return true;
    }

    static boolean nextPermutation(char[] a){
        int i = a.length - 1;
        while(i>0 && a[i-1]>=a[i]) i--;

        if(i==0) return false;

        int j = a.length - 1;
        while(a[j]<=a[i-1]) j--;

        char temp = a[i-1];
        a[i-1]=a[j];
        a[j]=temp;

        j = a.length - 1;
        while(i<j){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++; j--;
        }
        return true;
    }

    static long max_subarray(long[] a){
        long lmax = a[0], gmax=a[0];

        for(int i=1; i<a.length; i++){
            lmax = Math.max(a[i],lmax+a[i]);
            gmax = Math.max(lmax,gmax);
        }
        return gmax;
    }

    //-----------PrintWriter for faster output-----------------------------------//
    public static PrintWriter out;

    //-----------MyScanner class for faster input--------------------------------//
    public static class MyScanner
    {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}


//-----------------------Helper Classes------------------------------------------//
class Pair<A extends Comparable<A>,B> implements Comparable<Pair<A,B>>
{
    A first;
    B second;

    Pair(A f,B s){
        first=f;
        second=s;
    }

    public int compareTo(Pair<A,B> p){
        return this.first.compareTo(p.first);
    }
}