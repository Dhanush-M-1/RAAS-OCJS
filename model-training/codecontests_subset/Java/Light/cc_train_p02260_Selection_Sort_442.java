import java.io.*;
import java.util.*;

class Main{
  public static void main(String[] args) throws IOException{
    Scanner scan=new Scanner(System.in);
    int n=Integer.parseInt(scan.next());
    int[] array=new int[n];
    for(int i=0;i<array.length;i++){
      array[i]=Integer.parseInt(scan.next());
    }

    //選択ソート
    int count=0;
    for(int i=0;i<array.length-1;i++){
      int min=i;
      for(int j=i+1;j<array.length;j++){
        if(array[j]<array[min]){
          min=j;
        }
      }
      if(i==min){
        continue;
      }
      int tmp=array[i];
      array[i]=array[min];
      array[min]=tmp;
      count++;
    }
    for(int i=0;i<array.length;i++){
      System.out.print(array[i]);
      if(i<array.length-1){
        System.out.print(" ");
      }else {
        System.out.println();
      }
    }
    System.out.println(count);
  }
}
