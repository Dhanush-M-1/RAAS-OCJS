

import java.io.PrintWriter;

import java.util.*;
import java.util.Arrays ; 


public class Test{
    static int pos = 0 ; 
    static int  arr[] ; 
  static LinkedList l1 = new  LinkedList() ; 
static void find(int p ,char[]x,int put[],String s){
    int c= 0 ; 
    for (int i = 0; i < s.length(); i++) {
        if(x[p]==s.charAt(i)){
        c++ ; }
    }
    put[p] = c ;  
}
static int mode(int m ,int[]x ){
    int temp = 0 ; 
    for (int i = x.length-1; i >=0; i--) {
        if(x[i]<=m){
            temp= x[i] ; 
           /// break ; 
             return m-temp ; 
             
        }
    }
     return m-temp ; 
}
static int mode2(int m ,int[]x ){
    int temp = 0 ; 
    
    for (int i = x.length-1; i >=0; i--) {
        if(x[i]<=m){
            temp= x[i] ; 
           /// break ; 
             return x[i] ; 
             
        }
    }
     return 0 ; 
}
static int find(int x[],int temp){
    int j = 0 ; 
    for (int i = x.length-1; i >=0; i--) {
        if(x[i]==temp) return j+1 ; 
        j++ ; 
    }
    return -1 ; 
}
static String ch(long[]x,long b){
    for (int i = 0; i < x.length; i++) {
        if(x[i]==b)return "YES" ;
    }
    return "NO" ; 
}
static int pis(String s,char k ){
  
    for (int i = 0; i < s.length(); i++) {
        if(k==s.charAt(i) ) {
            return i ;
        } 
    }
   
    return -1 ; 
    
}
static  int fin(String s){
   int count = 0 ; 
    for (int i = 0; i < s.length(); i++) {
       if(s.charAt(i)>=65&&s.charAt(i)<=90) count++ ; 
    }
   return count ; 
}
static boolean config(int[]x ){
    for (int i = 0; i < x.length; i++) {
        if(x[i]==0) return false ;
    }
    return true  ; 
}
static long count(long i ){
    if(i%2==0){
        return i ; 
    }else return i+count(i-1) ;  
}
static boolean ce(int [][]x){
    for (int i = 0; i < x.length; i++) {
        if(x[i][0]!=x[i][1]) return true ; 
    }
    
    return false ;
}
static boolean c(int[][]x,int[]y){
    int j=y.length-1 ; 
    for (int i = 0; i < x.length; i++) {
        if(x[i][1]!=y[j]) return true;
        j-- ;
    }
    return false  ; 
}
static long gcd(long a , long b){
    if(b==0) return a ; 
    else return gcd(b,a%b) ; 
    
}
    public static void main(String[] args)  {

        Scanner in = new Scanner(System.in) ;
        PrintWriter pw = new PrintWriter(System.out);   
        
        
    //   String s = in.next(); 
    String []x =new String[2] ;
     x[0] =in.next() ;
     x[1] =in.next() ;
  int n = in.nextInt() ; 
        System.out.println(x[0]+" "+x[1]);
        for (int i = 0; i < n; i++) {
            String temp1=in.next() ;
            String temp2=in.next() ;
            if(x[0].equals(temp1)){
                x[0]=temp2 ;
            }else x[1] =temp2 ; 
            System.out.println(x[0]+" "+x[1]);
        }
                 pw.close();
    }
}

