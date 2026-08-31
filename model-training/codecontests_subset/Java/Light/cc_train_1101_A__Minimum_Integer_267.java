import java.util.*; 
public class tht
{
    
    public static void main(String args[])
    { 
        Scanner in=new Scanner(System.in);
        int t=in.nextInt(); 
        for(int i=0;i<t;i++) 
        {
            int l=in.nextInt(); 
            int r=in.nextInt(); 
            int d=in.nextInt(); 
            long ans=(r+d-r%d); 
              if(d<l)
              ans=d;
            System.out.println(ans);
        }
    }
}