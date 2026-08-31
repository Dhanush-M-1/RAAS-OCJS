import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author bd340
 */
public class Mon {
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       
       for(int i=0;i<n;i++)
       {
           int[] a=new int[1001];
           int z=sc.nextInt();
           int x=sc.nextInt();
           int w=0;
           int[] b=new int[z];
           int[] v=new int[x];
           
           for(int j=0;j<z;j++)
           {
               int y=sc.nextInt();
              // b[i]=y;
               a[y]=1;
           }
           
           for(int k=0;k<x;k++)
           {
               int u=sc.nextInt();
               v[k]=u;
               
               if(a[u]==1)
               {
                   w=v[k];
               }
           }
           
           if(w>0)
           {
               System.out.println("YES");
           
               System.out.println(1+" "+w);
           }
           else
               System.out.println("NO");
           
           
       }
       
       
       
       
       
       
             }
} 
           
      
     
    