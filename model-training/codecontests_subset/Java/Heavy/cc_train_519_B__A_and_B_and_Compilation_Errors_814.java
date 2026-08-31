/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int n1=n;
        int n2=n-1;
        int n3=n-2;
        int[] a=new int[n1];
        int[] b=new int[n2];
        int[] c=new int[n3];
        for(int i=0;i<n1;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        for(int j=0;j<n2;j++){
            b[j]=sc.nextInt();
        }
        Arrays.sort(b);
        for(int k=0;k<n3;k++){
            c[k]=sc.nextInt();
        }
        Arrays.sort(c);
        int q=0;
        for(int l=0;l<n2;l++){
            if(b[l]==a[l]){
                continue;
            }
            else{
                q=a[l];
                break;
            }
        }
        if(q==0){
            q=a[n1-1];
            System.out.println(q);
        }
        else{
            System.out.println(q);
        }
        
        int p=0;
        for(int m=0;m<n3;m++){
            if(c[m]==b[m]){
                continue;
            }
            else{
                p=b[m];
                break;
            }
        }
        if(p==0){
            p=b[n1-2];
            System.out.println(p);
        }
        else{
            System.out.println(p);
        }
        
    }
}