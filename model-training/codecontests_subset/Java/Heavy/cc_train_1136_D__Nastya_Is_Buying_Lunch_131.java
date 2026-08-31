/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author arvin
 */
public class Nastya_buying_lunch {
     public static void main(String args[]) throws Exception
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String abcde[]=br.readLine().split(" ");
    int n=Integer.parseInt(abcde[0]);
    int m=Integer.parseInt(abcde[1]);
    String abc[]=br.readLine().split(" ");
    int a[]=new int[n];
    for(int i=0;i<n;i++)
        a[i]=Integer.parseInt(abc[i]);
    HashSet<Integer> hp[]=new HashSet[n+1];
    for(int i=0;i<=n;i++)
        hp[i]=new HashSet<>();
    HashSet<Integer> b=new HashSet<>();
    b.add(a[n-1]);
    for(int i=0;i<m;i++)
    {
        String vbn[]=br.readLine().split(" ");
        hp[Integer.parseInt(vbn[0])].add(Integer.parseInt(vbn[1]));
    }
        
    int flag=0,ans=0;
    for(int i=n-1;i>=0;i--)
    {
        if(hp[a[i]].size()<b.size())
            b.add(a[i]);
        else
        {
            Iterator it=b.iterator();
            while(it.hasNext())
            {
                if(!hp[a[i]].contains(it.next()))
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
                b.add(a[i]);
            else
                ans++;
            flag=0;
        }
        
    }
    System.out.println(ans);
    
  } 
} 
