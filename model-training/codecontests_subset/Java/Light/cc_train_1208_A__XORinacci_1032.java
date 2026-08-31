import java.util.*;
import java.lang.*;
public class A{
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
         if(sc.hasNext()){
             int t = sc.nextInt();
             while(t-->0){
                 long a = sc.nextLong();
             long b = sc.nextLong();
             long n = sc.nextLong();
             if(n%3==0){
                 System.out.println(a);
             }else if(n%3==1){
                 System.out.println(b);
             }else{
                 System.out.println(a^b);
             }
            }
         }
	}
}