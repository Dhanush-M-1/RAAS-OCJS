import java.util.*;
public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
     short t=sc.nextShort();
     while(t-->0)
     {
         short n=sc.nextShort();
         short m=sc.nextShort();
         short A[]= new short[n];
         short B[]=new short[m];
         short count=0;
         for(short i=0;i<n;i++)
         {
             A[i]=sc.nextShort();
         }
         for(short j=0;j<m;j++)
         {
             B[j]=sc.nextShort();
         }
         for(int j=0;j<m;j++){
         for(int i=0;i<n;i++)
         {
             if(B[j]==A[i])
             {   count++;
                 System.out.println("YES");
                 System.out.println(count +" "+A[i]);
                 break;
             }
         }
         if(count>0)
         { break;}
         }
         if(count==0)
         {
             System.out.println("NO");
         }

     }
    }
}
