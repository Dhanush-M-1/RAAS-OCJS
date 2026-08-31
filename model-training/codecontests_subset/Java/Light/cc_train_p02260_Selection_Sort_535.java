import java.util.Scanner;
import java.lang.Math;
class Main{

  public static int selectionSort(long a[], int x){
    int sw=0;
    long minv;
    int mini;
    for(int i=0;i<x-1;i++){
      minv=a[i]; mini=i;
      for(int j=i+1;j<x;j++){
        if(a[j]<minv){
          minv=a[j];
          mini=j;
        }
      }
      if(mini!=i){
      a[mini]=a[i];
      a[i]=minv;
      sw++;
    }
    }
    return sw;
  }
  public static void main(String args[]){
    Scanner stdIn=new Scanner(System.in);
    int x=stdIn.nextInt();
    long[] a=new long[x];
    //input
    for(int i=0;i<x;i++){
        a[i]=stdIn.nextLong();
    }

    int sw=selectionSort(a,x);

    for(int i=0;i<x;i++){
      System.out.print(a[i]);
      if(i<x-1){
        System.out.print(" ");
      }
    }
    System.out.println();
    System.out.println(sw);
  }
}

