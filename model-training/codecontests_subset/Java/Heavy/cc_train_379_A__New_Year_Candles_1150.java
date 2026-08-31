/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * @author Rohini Chandra
 */
import java.util.*;
import java.io.*;
public class EX{
    public static void main(String args[]) throws IOException{
       //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       //PrintWriter pw = new PrintWriter(System.out);
       //List<Integer> list = new ArrayList<>();
       //Map<Integer,Integer> map = new HashMap<>();
       //Set<Integer> set = new HashSet<>();
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();
       int rev=b,rem=0,sum=a;
       while(rev>=b){
          rev = a/b;
          rem = a%b;
          sum += rev;
          rev += rem; 
          a = rev;
       }
       prtl(sum);
    }
                                       //******** PRINTLN ********//
    static void prtl(long b){
       System.out.println(b); 
    }         
                                       //******** FACTORIAL ********//
    static int fact(int n){
       if(n==1)
          return 1;
       else
          return n*fact(n-1);
    }
                                       //******** OCCURRENCE ********//
    static Map<String,Integer> ocr(String str[]){
           Map<String,Integer> map = new HashMap<>();
           for(int i=0; i<str.length; i++){
           if(!map.containsKey(str[i]))
              map.put(str[i], 1);
           else
              map.put(str[i], map.get(str[i])+1);
           }
           return map;
    }
                                        //******** PRIME OR NOT ********//
    static boolean isprime(long num){
        if(num<=1)
            return false;
        else if(num<=3)
            return true;
        else if(num%2==0 || num%3==0)
            return false;
        else{
            for(int i=5; i*i<=num; i+=6){
                if(num%i==0 || num%(i+2)==0)
                   return false; 
            }
            return true;
        }
    }
                                       //******** GCD ************//
    static int gcd(int a,int b){
         if(b==0)
            return a;
         else if(a==0)
            return b;  
         else if(a>b)
            return gcd(a%b,b);
         else if(a<b)
            return gcd(a,b%a);
         else if(a==b)
            return a;
         return 0;
    }
}
