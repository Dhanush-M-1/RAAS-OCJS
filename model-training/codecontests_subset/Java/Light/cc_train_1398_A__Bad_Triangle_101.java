import java.util.*;

public class Main{

public static void main(String[] args) {

  Scanner scn=new Scanner(System.in);
  int t=scn.nextInt();
  while(t-->0){
      int n=scn.nextInt();
      long [] arr=new long[n];
      for(int i=0;i<arr.length;i++){
          arr[i]=scn.nextLong();
      }
      if(arr[0] + arr[1] <=arr[arr.length-1]){
          System.out.println(1 + " " + 2 + " " + arr.length);
      }
      else{
          System.out.println(-1);
      }
  }

 }
}