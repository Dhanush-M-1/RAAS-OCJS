import java.util.*;
public class asd
{
         public static void main(String args[])
         {
             Scanner s=new Scanner(System.in);
             int t=s.nextInt();
             while(t-->0)
            {
               int n=s.nextInt();
               String str[]=new String[n];
               for(int i=0;i<n;i++)
                   
                       str[i]=s.next();
               
               
               char x1=str[0].charAt(1);char x2=str[1].charAt(0);
               char y2=str[n-1].charAt(n-2);char y1=str[n-2].charAt(n-1);
               
               if(x1==x2&&y2==y1&&x1!=y2)
                   System.out.println("0");
               else if(x1==x2&&y2==y1&&x1==y2)
               {
                   System.out.println("2");
                                      System.out.println("1 2\n2 1");

               }
               else if(x1!=x2&&y2!=y1)
               {
                   System.out.println("2");
                   if(x1=='1')
                                          System.out.println("1 2");
                 else if(x2=='1')
                                          System.out.println("2 1");
                   if(y2=='0')
                                          System.out.println((n-1+1)+" "+(n-2+1));
                 else if(y1=='0')
                                          System.out.println((n-2+1)+" "+(n-1+1));

               }
               else if((x1==x2&&y1!=y2)||y1==y2&&x1!=x2)
               {
                   System.out.println("1");
                   if(y1!=y2)
                   {
                       if(x1=='0')
                       {
                           if(y1=='0')
                                          System.out.println((n-2+1)+" "+(n-1+1));
                           else if(y2=='0')
                                          System.out.println((n-1+1)+" "+(n-2+1));
                       }
                       else
                       {
                           if(y1=='1')
                                          System.out.println((n-2+1)+" "+(n-1+1));
                           else if(y2=='1')
                                          System.out.println((n-1+1)+" "+(n-2+1));
                       }
                   }
                   else if(x1!=x2)
                   {
                       if(y1=='0')
                       {
                           if(x1=='0')
                                          System.out.println("1 2");
                           else if(x2=='0')
                                          System.out.println("2 1");
                       }
                       else
                       {
                           if(x1=='1')
                                          System.out.println("1 2");
                           else if(x2=='1')
                                          System.out.println("2 1");
                       }
                   }
               }
            }
        }
             
}
        


         
         
