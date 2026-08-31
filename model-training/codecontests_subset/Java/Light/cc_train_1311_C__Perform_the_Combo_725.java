import java.util.*;
public class c9{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        

        int t=sc.nextInt();
        for(int j=0;j<t;j++){
            int n=sc.nextInt();
            int m= sc.nextInt();
            int p[]=new int[m];
            char ch[]=sc.next().toCharArray();
            int a[]=new int[26];

            

            HashMap<Integer,Integer> h=new HashMap<>();
            for(int i=0;i<m;i++)
            {
                p[i]=sc.nextInt();
                if(h.containsKey(p[i]))
                h.put(p[i],h.get(p[i])+1);
                else
                h.put(p[i],1);
            }

            // for(int i=0;i<m;i++){
            //     for(int k=0;k<p[i];k++)
            //     a[ch[k]-'a']+=1;
                //System.out.println(a[0]);
                int k=m;
                for(int i=0;i<n&&k>0;i++)
                {
                    if(h.containsKey(i+1))
                    {
                        a[ch[i]-'a']+=k;
                        k-=h.get(i+1);
                    }
                    else
                    a[ch[i]-'a']+=k;
                    
                }
            
            
            for(int i=0;i<n;i++)
            a[ch[i]-'a']+=1;
            for(int i=0;i<26;i++)
            System.out.print(a[i]+" ");
            System.out.println();
            

            



        }
    }
    
}