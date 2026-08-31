import java.util.*;
import java.io.*;
public class Games{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ar1[]=new int[n];
        int ar2[]=new int[n];
        int j=0,k=0,cnt=0;
        for(int i=0;i<n*2;i++){
            if(i%2==0){
                ar1[j]=sc.nextInt();
                j++;
            }
            else{
                ar2[k]=sc.nextInt();
                k++;
            }
        }
        for(int i=0;i<n;i++){
            for(int l=0;l<n;l++){
                if(ar1[i]==ar2[l])
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}