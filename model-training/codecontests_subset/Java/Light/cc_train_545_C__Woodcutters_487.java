import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x[]=new int[n];
        int h[]=new int[n];
        for (int i=0;i<n;i++){
            x[i]=sc.nextInt();
            h[i]=sc.nextInt();
        }
        int s=2;
        if (n==1)s--;
        for (int i=1;i<n-1;i++){
            if (x[i]-h[i]>x[i-1])s++;
            else if (x[i]+h[i]<x[i+1]){
                s++;
                x[i]+=h[i];
            }
        }
        System.out.println(s);
    }
}
