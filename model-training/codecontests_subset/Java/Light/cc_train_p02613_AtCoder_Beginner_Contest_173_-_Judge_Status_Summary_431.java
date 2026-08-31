import java.util.Scanner;

public class Main{
 public static void main(String[] args) {
   Scanner kbd =new Scanner(System.in);
   int n=kbd.nextInt();
   int x=0;
   String a="";
   int[] A= new int[4];
   for(int i=0;i<n;i++){
     a=kbd.next();
     if(a.equals("AC")){
       x=0;
     }
     if(a.equals("WA")){
       x=1;
     }
     if(a.equals("TLE")){
       x=2;
     }
     if(a.equals("RE")){
       x=3;
     }
     A[x]++;
   }
   System.out.println("AC x "+A[0]);
   System.out.println("WA x "+A[1]);
   System.out.println("TLE x "+A[2]);
   System.out.println("RE x "+A[3]);
}
}