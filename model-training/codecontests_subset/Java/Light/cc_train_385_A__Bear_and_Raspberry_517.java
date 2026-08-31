import java.util.*;
import java.io.*;
public class Main{
  static char arr[][];
  public static void main(String[] args) throws IOException {
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    int c=s.nextInt();
    int arr[]=new int[n];
    int i,j;
    for(i=0;i<n;i++){
      arr[i]=s.nextInt();
    }
    int temp=arr[0]-arr[1];
    for(i=1;i<n;i++){
      temp=Math.max(temp,arr[i-1]-arr[i]);
    }
    temp -= c;
    if(temp>0){
      System.out.println(temp);
    }
    else{
      System.out.println(0);
    }
  }
}
