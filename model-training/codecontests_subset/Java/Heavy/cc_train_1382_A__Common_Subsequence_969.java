import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;


public class HelloWorld{

     public static void main(String []args)
     {
        Scanner sc=new Scanner(System.in);
        PrintWriter op=new PrintWriter(System.out);
        
        //solve(sc,op);
        
        solvetc(sc,op);
        
        op.flush();
        op.close();
        
     }
     
     public static void solvetc(Scanner sc,PrintWriter op)
     {
         int t=sc.nextInt();
         
         while(t!=0)
         {
             int n=sc.nextInt();
        int m=sc.nextInt();
        
        int[] arr1=new int[n];
        
        int[] arr2=new int[m];
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
         
         arr1[i]=sc.nextInt();
         map.put(arr1[i],1);
        }
        
        int ans=-1;
        for(int i=0;i<m;i++)
        {
         
         arr2[i]=sc.nextInt();
         
         if(map.get(arr2[i])!=null)
         {
             ans=arr2[i];
            
         }
        }
        
        if(ans==-1)
        op.println("NO");
        else
        {
        op.println("YES");
        op.println("1 "+ans);
        }
        
             t--;
         }
     }
     
     public static void solve(Scanner sc,PrintWriter op)
     {
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        int[] arr1=new int[n];
        
        int[] arr2=new int[m];
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
         
         arr1[i]=sc.nextInt();
         map.put(arr1[i],1);
        }
        
        int ans=-1;
        for(int i=0;i<m;i++)
        {
         
         arr2[i]=sc.nextInt();
         
         if(map.get(arr2[i])!=null)
         {
             ans=arr2[i];
             break;
         }
        }
        
        if(ans==-1)
        op.println("NO");
        else
        {
        op.println("YES");
        op.println("1 "+ans);
        }
        
        
     }
     
     
}