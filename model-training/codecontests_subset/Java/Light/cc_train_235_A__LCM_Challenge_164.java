import java.util.*;
public class LCMChallenge146{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    if(n==1 || n==2)
      System.out.println(n);
    else if(n == 3)
      System.out.println("6");       
    else{
      long l1=1;
      if(n%2 == 0){
        if(n%3 == 0){
          l1 = (n-1)*(n-2);
          l1 = l1*(n-3);
        }  
        else
          l1 = n*(n-1)*(n-3); 
      }
      else l1 = n * (n-1) * (n-2); 
      System.out.println(l1); 
    }
  }
  static int gcd(int a, int b){ 
    if (a == 0 || b == 0)
        return 0;
    if (a == b)
      return a;
    if (a > b)
      return gcd(a-b, b);
    return gcd(a, b-a);
  }    
}
    
