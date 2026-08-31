import java.io.*;
import java.util.Scanner;
public class Main{
    public static void main(String args[]){
      Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int []array=new int[N];
        for(int i=0;i<N;i++)array[i]=sc.nextInt();
        int num=0;
        for(int i=0;i<N;i++){
            int minj=i;
            for(int j=i;j<N;j++){
                if(array[minj]>array[j]){
                    minj=j;
                }
            }
            if(array[minj]!=array[i]){
            int tmp=array[minj];
            array[minj]=array[i];
            array[i]=tmp;
            num++;
           }
        }
        for(int i=0;i<N;i++){
            System.out.print(array[i]);
            if(i<N-1)System.out.print(" ");
        }
        System.out.println();
        System.out.println(num);
    }
}
