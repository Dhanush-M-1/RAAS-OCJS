import  java.util.*;
public class b_25_3{
    private static long gcd(long a,long b){
        if(b==0)
        return a;
        return gcd(b,a%b);
    }
public static void main(String args[]){
Scanner s=new Scanner(System.in);

// int t=s.nextInt();
// while(t-->0){
long n=s.nextLong();
long a=1,b=n;
 for(long i=1;i<=Math.sqrt(n);i++){
     if(n%i==0){
         if(gcd(i,n/i)==1){
             a=i;b=n/i;
         }
     }
 }
 System.out.println(Math.min(a,b)+" "+Math.max(a,b));
//}
    
}
}