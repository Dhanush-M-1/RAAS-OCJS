import java.util.Scanner;

 public class JavaApplication119 {
 
      public static void main(String[] args) {
 
		Scanner  in = new Scanner(System.in);
		int n =  in.nextInt();
                int a = in.nextInt() ;
                int i  = 1  ; 
                int sum = 0 ; 
                if (n<a){
                while (n<a){
                 if (a-n==1){
                     sum+=i ; 
                     break ; 
                 }
                     a-=1 ;
                     sum+=i ; 
                 n+=1 ; 
                 sum+=i ; 
                i++ ;}}
                 else {
                      while (n>a){
                 if (n-a==1){
                     sum+=i ; 
                     break ; 
                 }
                     a+=1 ;
                     sum+=i ; 
                 n-=1 ; 
                 sum+=i ; 
                i++ ;}}
                System.out.println(sum);
                    
      }}
