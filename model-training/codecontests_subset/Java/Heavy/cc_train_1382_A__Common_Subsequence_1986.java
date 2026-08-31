import java.util.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class Chef_and_Proportion
{
          static Scanner sc=new Scanner(System.in);
          static PrintWriter out=new PrintWriter(System.out);
          static void pn(Object o)
          {
              out.println(o);
              out.flush();
              
          }
          static void p(Object o)
           {
             out.print(o);
             out.flush();
             }
          static void pni(Object o)
          {
              out.println(o);System.out.flush();
          }
          
          static int I() throws IOException
          {
              return sc.nextInt();
          }
          static long L()throws IOException
          {
              return sc.nextLong();
          }
          static double D()throws IOException
          {
              return sc.nextDouble();
          }
          static String S()throws IOException
           {
              return sc.nextLine();
           }
          
          static void process()throws IOException
           {
               try
               {
                   int n=I();
                   int m=I();
                  int a[]=new int[n];
                  int b[]=new int[m];
                      for(int i=0;i<n;i++)
                     {
                        a[i]=I();
                     }
                    for(int i=0;i<m;i++)
                    {
                      b[i]=I();
                    }  
                    int p=0; int z=0;
                    for(int i=0;i<n;i++)
                      {
                          for(int j=0;j<m;j++)
                          {
                          if(a[i]==b[j])
                          {
                             p++;
                             z=a[i];
                             break;
                            }
                            }
                        }
                  if(p==0)
                  {
                      pn("NO");
                    }
                  else
                  if(p>=1)
                  {
                     pn("YES");
                     pn(1+" "+z);
                    }
                }
                catch(Exception e)
                {
                    return;
                }
            }
            public static void main(String[] args)throws IOException
            {
              try
             {
               long t=L();
               while(t-->0)
              {
                 process();
                }
             }
             catch(Exception e)
             {
                return;
              }
               }    
                    

      }