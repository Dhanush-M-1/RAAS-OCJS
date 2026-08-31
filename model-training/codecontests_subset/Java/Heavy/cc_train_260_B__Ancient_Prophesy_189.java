import java.io.*;
import java.util.*;
import java.lang.Math.*;
public class cf158B
{
     public static void main(String args[])throws Exception
     {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         String s=br.readLine();
         
         int rec[][][]=new int[3][13][32];
         
         int final_date[]=new int[3];
         
         int day[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
         
         String possible[]=s.split("-");
         int i,j,k,l;
         l=possible.length;
         
         /*for(i=0;i<l;i++)
         System.out.print(possible[i]+" ,");
         System.out.println();*/
         
         int d,m,y;
         
         for(i=0;i<l-2;i++)
         {
             if(possible[i].length()>=2 && possible[i+1].length()==2 && possible[i+2].length()>=4)
             {
                 d=Integer.parseInt(possible[i].substring(possible[i].length()-2));
                 m=Integer.parseInt(possible[i+1]);
                 y=Integer.parseInt(possible[i+2].substring(0,4));
                 
                 if(y>=2013 && y<=2015 && m>=1 && m<=12)
                 {
                     if(day[m]>=d && d>0)
                     {
                         rec[y-2013][m][d]++;
                        }
                    }
                }
            }
         int max=0;
         
         for(i=0;i<3;i++)
         {
             for(j=0;j<13;j++)
             {
                 for(k=0;k<32;k++)
                 {
                     if(max<rec[i][j][k])
                     {
                         max=rec[i][j][k];
                         final_date[0]=k;
                         final_date[1]=j;
                         final_date[2]=i+2013;
                        }
                    }
                }
            }
            
         print_date(final_date);
     }
     
     public static void print_date(int a[])throws Exception
     {
         PrintWriter pw=new PrintWriter(System.out);
         
         if((a[0]+"").length()<2)
         pw.print("0");
         
         pw.print(a[0]+"-");
         
         if((a[1]+"").length()<2)
         pw.print("0");
         
         pw.print(a[1]+"-"+a[2]);
         pw.flush();
     }
}
