import java.io.*;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int count=0;
    int n=sc.nextInt();
    int[] a;
    a=new int[n];
    for(int i=0;i<n;i++){
      a[i]=sc.nextInt();
    }
    for(int i=0;i<n-1;i++){
      int min=i;
      for(int j=i+1;j<n;j++){
        if(a[min]>a[j]) min=j;
      }
      if(min!=i){
        int c=a[i];
        a[i]=a[min];
        a[min]=c;
        count++;
      }
    }
    for(int i=0;i<n;i++){
      System.out.print(a[i]);
      if(i!=n-1) System.out.print(" ");
      else System.out.println();
    }
    System.out.println(count);
  }
}

