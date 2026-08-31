import java.util.*;
//import java.Collection.*;

public class Solution{
    static int min(int a,int b, int c){
        if(a>b && a>c)  return a;
        if(b>c)   return b;
        return c;
    }
    public static void main(String[] args){
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       Scanner sc=new Scanner(System.in);
           int n=sc.nextInt();
           int k=sc.nextInt();
        ArrayList <Integer> a=new ArrayList<Integer>();
        ArrayList <Integer> b=new ArrayList<Integer>();
        ArrayList <Integer> hs=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int p=sc.nextInt();
            int q=sc.nextInt();
            int r=sc.nextInt();
            if(q==1 && r==1)    hs.add(p);
            else if(q==1)   a.add(p);
            else if(r==1)   b.add(p);
        }
        if(a.size()+hs.size()<k || b.size()+hs.size()<k)   System.out.println(-1);
        else{
            Collections.sort(hs);
            Collections.sort(a);
            Collections.sort(b);
            //System.out.println(a+""+b+""+hs);
            int sum=0,i=0,p=0,j=0;
            while(i<a.size()&& i<b.size() && p<hs.size()&& j<k){
                if(a.get(i)+b.get(i)<hs.get(p)){
                    //System.out.println("from if"+a.get(i)+" "+b.get(i));
                    sum+=a.get(i)+b.get(i);
                    j++;
                    i++;
                }
                else{
                    //System.out.println("from if "+hs.get(i));
                    sum+=hs.get(p);p++;
                    j++;
                }
            }
            while(j<k && i<a.size() && i<b.size()){
                //System.out.println(a.get(i)+" "+b.get(i));
                j++;
                sum+=a.get(i)+b.get(i);i++;
            }
            while(j<k && p<hs.size()){
                j++;
                sum+=hs.get(p);
                p++;
            }
            System.out.println(sum);
        }
    }
}