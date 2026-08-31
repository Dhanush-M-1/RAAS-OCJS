import java.util.*;

 // Compiler version JDK 11.0.2

 public class Dcoder
 {
   public static void main(String args[])
   { 
    Scanner sc=new Scanner(System.in);
    List<Integer> l=new ArrayList<>();
    List<Integer> l1=new ArrayList<>();
    int n=sc.nextInt();
    int x=n;
    while(n-- > 0){
     int a=sc.nextInt();
     if(a == 100){
       l. add(a);
     }else{
       l1. add(a);
     }
    }
   if(l.size() !=0 && l1. size() !=0){
    
    if(l.size() %2 == 0 && l1. size() % 2 == 0){
      System. out. println("YES");
    }else if(l.size() %2 == 0 && l1. size() % 2 != 0){
      System. out. println("YES");
    }else{
      System. out. println("NO");
    }
    }else if(l.size() ==0 && l1. size() !=0){
    if(l1.size() % 2 == 0){
    System. out. println("YES");
    }else{
      System. out. println("NO");
    }
    }else if(l.size() !=0 && l1. size() ==0){
   
    if( l. size() % 2== 0){
      System. out. println("YES");
    }else{
      System. out. println("NO");
    }
    }
   }
 }
    