import java.util.Scanner;



public class Games {

    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][]a=new int[n][2];
        
        for(int i=0;i<n;i++)
        {
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
            
            
        }
        int indicator=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
            if((a[i][0]==a[j][1]))
                indicator++;
            if((a[i][1]==a[j][0]))
                indicator++;
                    
                
            }
                
                
        }
        
        System.out.println(indicator);
        
      
    }
}
