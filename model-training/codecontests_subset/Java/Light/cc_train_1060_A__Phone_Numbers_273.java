import java.util.*;

 // Compiler version JDK 11.0.2

 public class Dcoder
 {
   public static void main(String args[])
   { 
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    String s=sc.next();
    int c=0;
    for(int i=0; i<s.length(); i++){
      if(s.charAt(i) == '8'){
        c++;
      }
    }
    if(c == 0){
      System. out. println("0");
    }else if(n < 11){
      System. out. println("0");
    }else if(n>=11 && c!=0){
      int x=n/11;
      int v=(int)Math.min(x, c);
      System. out. println(v);
    }
   }
 }
    