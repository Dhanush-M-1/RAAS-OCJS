import java.util.*;
public class CodeForces 
{ 
    public static void main(String[] args)
    {
       
       Scanner sc = new Scanner(System.in);
       int a[]=new int [5];
       int b[]={0,0,0,0,0};        
       int suma=0,sumb=0;
       for(int i=0;i<5;i++)
       { 
           a[i]=sc.nextInt();
           suma+=a[i];
       }
        while(suma>sumb)
        {
            if(suma==sumb)
            {
                
                break;
            }
            else
            {
                sumb=0;
                for(int i=0;i<5;i++)
                {
                    b[i]+=1;
                    sumb+=b[i]; 
                } 
            }
        }
       
           
         if (sumb>suma||suma==0)
             System.out.println("-1");
         else
             System.out.println(b[0]);
    } 
}
