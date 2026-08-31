import java.util.*;
import java.io.*;
public class Main{
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    String temp=s.next();
    int arr[]=new int[n];
    int i,j;
    int eight=0;
    for(i=0;i<n;i++){
      arr[i]=(int)(temp.charAt(i)-'0');
      if(arr[i]==8)
        eight++;
    }
    int ans=0;
    int total=n/11;
    ans=Math.min(eight,total);
    System.out.println(ans);
  }
}
