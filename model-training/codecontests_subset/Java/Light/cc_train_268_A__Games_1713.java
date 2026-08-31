import java.io.*;
import java.util.*;
public class Games{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a,h;
        int v1[] = new int[n];
        int v2[] = new int[n];
        for(int i = 0 ; i < n ; i ++){
            a = sc.nextInt();
            h = sc.nextInt();
            v1[i] = a;
            v2[i] = h;
        }
        /*for(int i = 0 ;i <= 100 ; i ++)
            System.out.print(v1[i] + " ");
        System.out.println();
        for(int i = 0 ; i <= 100 ; i ++)
            System.out.print(v2[i] + " ");
        System.out.println();*/
        int c = 0;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(i != j && v1[i] == v2[j])
                    c ++;
            }
        }
        System.out.println(c);
    }
}
