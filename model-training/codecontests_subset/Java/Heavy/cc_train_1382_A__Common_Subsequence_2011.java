import java.util.*;
public class JavaApplication185 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[m];
            HashSet<Integer> map=new HashSet<>();
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                map.add(a[i]);
            }
            int ans=0;
            boolean f=false;
             for(int i=0;i<m;i++)
            {
                b[i]=sc.nextInt();
                if(map.contains(b[i]))
                    
                        {
                            f=true;
                            ans=b[i];
                        }
                
            }
             if(f)
             {
                 System.out.println("YES");
                 System.out.println(1+" "+ans);
             }
             else
                 System.out.println("NO");
        }
    }
    
}
