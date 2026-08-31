import java.util.*;
class Main{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int []po=new int[4];
  for(int i=0;i<n;i++){
    String p=sc.next();
  po[p.equals("AC")?0:p.equals("WA")?1:p.equals("TLE")?2:3]++;
  }
  System.out.println("AC x "+po[0]);
  System.out.println("WA x "+po[1]);
  System.out.println("TLE x "+po[2]);
  System.out.println("RE x "+po[3]);
}
}
