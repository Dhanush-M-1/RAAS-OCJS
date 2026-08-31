/*Shabeg Singh Gill*/
//code 
import java .util.Scanner ;
import java.util.*;
import java.io.*;
import java.nio.IntBuffer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
//import java.io.OutputStreamReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.awt.Point; 
import java.util.HashMap;
import java.util.Collections;
import java.util.Arrays;
//import  java.util.Collections.reverseOrder()
 
public class cf2{
 
    public static int binarysearch(int[] arr,int num){
        int n;
        n=arr.length;
        int ans;
        ans=0;
        int start;
        start=0;
        int end ;
        end=n-1;
        while(start<=end){
            int mid;
            mid=(start+end)/2;
            if (arr[mid]>num){
                end=mid-1;
            } 
            else{
                ans=mid+1;
                start=mid+1;
            }
        }
        return ans;
    }

    public static void merger(int startind,int midind,int endind, ArrayList<Integer> arr){
        ArrayList<Integer> mergedSortedArray;
         mergedSortedArray= new ArrayList<Integer>();
		
		 int rightIndex ;
        rightIndex= midind+1;
        
        int leftIndex ;
        leftIndex= startind;
        
        
        while(midind>=leftIndex && endind>=rightIndex){
            if(arr.get(leftIndex)<=arr.get(rightIndex)){
                mergedSortedArray.add(arr.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(arr.get(rightIndex));
                rightIndex++;
            }
        }       
        while(midind>=leftIndex){
            mergedSortedArray.add(arr.get(leftIndex));
            leftIndex++;
        }
        
        while(endind>=rightIndex){
            mergedSortedArray.add(arr.get(rightIndex));
            rightIndex++;
        }
        
        int i ;
        i= 0;
        int j ;
        j= startind;
        while(i<mergedSortedArray.size()){
            arr.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }
    public static void divide(int startIndex,int endIndex, ArrayList<Integer> arr){
        if(endIndex >startIndex&& (endIndex-startIndex)>=1){
            int mid;
            mid = (endIndex + startIndex)/2;
            divide(startIndex, mid, arr);
            divide(mid+1, endIndex, arr);        
            merger(startIndex,mid,endIndex,arr);            
        }       
    } 

    public static int gcd1(int a, int b){
        return fact(Math.min(a, b));
    } 

    public static long gcd2(long a, long b ){
        if(b==0){
            return a ;
        }
        else {
            return gcd2(b, a%b);
        }
    }

    public static int fact(int n){
        int ans =1;
        for(int i =1; i<=n; i++){
            ans=ans*i;
        }
        return ans ; 
    } 
    public static long lcm(long a, long b){
        return (a*b)/gcd2(a, b); 
    } 

    public static long arraysum(int[] arr, int n ){
        long sum=0;
        for(int x=0; x<n; x++){
            sum=sum+arr[x];
        }
        return sum ;
    }
    public static long max(long n, long k){
        long max=Integer.MIN_VALUE;
        for(long j=1; j<=k; j++){
            if(n%j==0 && max<j){
                max=j;
            }
        }
        return max;
    }
    public static long max2(long n, long k ){
        long myans=n;
        for(int x=1; x*x<=n; x++){
            if(n%x==0){
                if(x<=k){
                    myans=Math.min(myans, (n/x));
                }
                if((n/x)<=k){
                    myans=Math.min(myans, x);
                }
            }
        }
        return myans;
    }

    public static void main(final String[] args) throws IOException { 
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
        Scanner s =new Scanner(System.in);

        int n =in.nextInt(); //no of teams 
        ArrayList<Integer>list1=new ArrayList<Integer>();
        ArrayList<Integer> list2=new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            int a =in.nextInt();
            int b =in.nextInt();
            list1.add(a);
            list2.add(b);
        }
        int count=0;
        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                if(list1.get(x)==list2.get(y)){
                    count++;
                }
            }
        }
        System.out.println(count);

        
             
    }
}


class InputReader {
    private final InputStream stream;
    private final byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public InputReader(final InputStream stream) {
        this.stream = stream;
    }
 
    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
 
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (final IOException e) {
                throw new InputMismatchException();
            }
 
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
 
    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return str;
    }
 
    public int nextInt() {
        int c = read();
 
        while (isSpaceChar(c))
            c = read();
 
        int sgn = 1;
 
        if (c == '-') {
            sgn = -1;
            c = read();
        }
 
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
 
        return res * sgn;
    }
 
    public long nextLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
 
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E')
                return res * Math.pow(10, nextInt());
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }
 
    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        final StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
 
        return res.toString();
    }
 
    public boolean isSpaceChar(final int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public String next() {
        return readString();
    }
 
    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}