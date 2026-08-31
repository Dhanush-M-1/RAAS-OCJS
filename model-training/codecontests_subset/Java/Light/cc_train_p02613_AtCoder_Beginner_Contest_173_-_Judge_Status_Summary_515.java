import java.util.*;

class Main{
  public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   int c0 = 0;
   int c1 = 0;
   int c2 = 0;
   int c3 = 0;
   for(int i = 0; i < n+1; i++){
     String s = sc.nextLine();
     if(s.equals("AC")){
      ++c0; 
     }else if(s.equals("WA")){
      ++c1;
     }else if(s.equals("TLE")){
      ++c2;
     }else if(s.equals("RE")){
      ++c3;
     }
   }
   System.out.println("AC x " + c0);
   System.out.println("WA x " + c1);
   System.out.println("TLE x " + c2);
   System.out.println("RE x " + c3);
  }
}

