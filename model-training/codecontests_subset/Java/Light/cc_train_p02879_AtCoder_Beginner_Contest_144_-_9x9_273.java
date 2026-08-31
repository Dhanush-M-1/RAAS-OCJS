import java.util.*;

public class Main { 
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int a=sc.nextInt();
      int b=sc.nextInt();
      int o=0;
      if(a>9 || b>9){
        o=-1;
      }else{
      	o=a*b;
      }
      System.out.println(o);
    }
}