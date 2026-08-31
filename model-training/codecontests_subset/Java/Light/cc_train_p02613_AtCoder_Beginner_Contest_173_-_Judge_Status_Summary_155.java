import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    int N =sc.nextInt();
    String A[] =new String[N];
    int x=0;int y=0;int z =0; int w=0;
    for(int i=0;i<N;i++){
      A[i]=sc.next();
      if(A[i].equals("AC")){x=x+1;}
      else if(A[i].equals("WA")){y=y+1;}
      else if(A[i].equals("TLE")){z=z+1;}
      else{w=w+1;}}
    System.out.println("AC"+" "+"x"+" "+x);
    System.out.println("WA"+" "+"x"+" "+y);
    System.out.println("TLE"+" "+"x"+" "+z);
    System.out.println("RE"+" "+"x"+" "+w);
  }
}