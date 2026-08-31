import java.util.Scanner;
public class A {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int r1=sc.nextInt();
      int r2=sc.nextInt();
      int c1=sc.nextInt();
      int c2=sc.nextInt();
      int d1=sc.nextInt();
      int d2=sc.nextInt();
      if((r1+r2)!=(c1+c2) || (r1+r2)!=d1+d2 || (c1+c2)!=(d1+d2)) System.out.println(-1);
      else {  int x1=(d1+(r1-c2))/2;
      int x2=r1-x1;
      int x3=c1-x1;
      int x4=d1-x1;
      if(x1!=x2 && x1!=x3 && x1!=x4 && x2!=x3 && x2!=x4 && x3!=x4 && x1>0 && x1<10 && x2>0 && x2<10 && x3>0 && x3<10 && x4>0 && x4<10){
    	  System.out.println(x1+" "+x2+"\n"+x3+" "+x4);
      }
      else System.out.println(-1);
      }
 
    }
}