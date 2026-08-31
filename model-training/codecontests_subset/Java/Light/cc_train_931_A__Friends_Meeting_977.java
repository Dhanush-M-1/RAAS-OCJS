import java.util.*;
public class Main2{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    
    int a = sc.nextInt();
    int b = sc.nextInt();
    
    if(a>b){
     int temp = b;
     b = a;
     a = temp;
    }
    
    int mid = 0;
    
    int ans = 0;
    
    if((a+b)%2==0){
    mid = (b-a)/2;
    ans = (mid*(mid+1))/2;
    ans = ans*2;
    }else{
     mid = (b-a)/2;
    ans = (mid*(mid+1))/2;
    ans = ans*2;
    ans = ans + mid+1;
    }
    
    System.out.println(ans);
    
    
  }
}
		      	  	  				 			 	 				 	