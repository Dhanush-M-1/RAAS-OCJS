import java.io.*;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    boolean a[];
    a=new boolean[52];
    for(boolean b:a) b=false;
    for(int i=0;i<n;i++){
      String m=sc.next();
      char[] mark=m.toCharArray();
      int num=sc.nextInt();
      switch(mark[0]){
        case 'H':
          num+=13;
          break;
        case 'C':
          num+=26;
          break;
        case 'D':
          num+=39;
          break;
      }
      a[num-1]=true;
    }
    for(int i=0;i<52;i++){
      if(!a[i]){
        if(i<13) System.out.println("S "+(i+1));
        else if(i<26) System.out.println("H "+(i-12));
        else if(i<39) System.out.println("C "+(i-25));
        else System.out.println("D "+(i-38));
      }
    }
  }
}
