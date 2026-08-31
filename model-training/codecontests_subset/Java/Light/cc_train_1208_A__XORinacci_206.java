import java.io.*;
import java.util.*;
import java.lang.*;
public class code1{
	public static void main(String args[]){

      Scanner s = new Scanner(System.in);

      int t= s.nextInt();

      while(t-- >0){
      int a = s.nextInt();
      int b= s.nextInt();
      int n= s.nextInt();

        if(n%3==0){
          System.out.println(a);
        }
        else if(n%3==1){
          System.out.println(b);
        }
        else{
          System.out.println(a^b);
        }
    }
	}
}