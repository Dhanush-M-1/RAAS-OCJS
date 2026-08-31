/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int w[] = new int[n];
        int b[] = new int[m];
        for(int i = 0;i<n;i++){
            w[i]=sc.nextInt();
        }
        for(int i = 0;i<m;i++){
            b[i]=sc.nextInt()-1;
        }
        ArrayList<Integer> sa = new ArrayList<Integer>();
        boolean taken[] = new boolean[n];
        for(int i = 0;i<n;i++){
            taken[i]=false;
        }
        for(int i = 0;i<m;i++){
            if(!taken[b[i]]){
                taken[b[i]]=true;
                sa.add(b[i]);
            }
        }
        int answer = 0;
        for(int i = 0;i<m;i++){
            int x = -1;
            for(int j=0;j<sa.size();j++){
                if(sa.get(j)!=b[i]){
                    answer+=w[sa.get(j)];
                }
                else{
                    x=j;
                    break;
                }
            }
            sa.remove(x);
            sa.add(0,b[i]);
        }
        System.out.println(answer);
    }
}