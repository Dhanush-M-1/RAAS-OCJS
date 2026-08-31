import java.util.Scanner;
public class JavaApplication4 {
    static boolean position(int i,int j)
    {
        boolean test;
        if((i+j)%2==0)
        {
            return(false);
        }
        return(true);
    }


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] T =new int[n*2];
        int i;
        int j;
        for(i=0;i<n*2;i=i+2)
        {
            for (j=0;j<2;j++)
            {
                T[i+j]=in.nextInt();
            }   
        }
        int s1=0;
        for(i=(n*2)-1;i>=0;i--)
        {
            int s2=0;
            for (j=i-1;j>=0;j--)
            {
                if (T[i]==T[j] && JavaApplication4.position(i, j))
                {
                    s2++;
                }
            }
            s1+=s2;
            
        }
        System.out.println(s1);
    }
    
}
