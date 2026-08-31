import java.util.Scanner;
public class Demo
 { public static void main(String args[])
    { Scanner sc=new Scanner(System.in);
         int n;
         n=sc.nextInt();
          int f[]=new int[26];
          String s=sc.next();
          char arr[];
         arr=s.toCharArray();
          for(int i=0;i<arr.length;i++)
              { f[arr[i]-97]++;
              }
          for(int i=0;i<26;i++)
              { if(f[i]!=0 && f[i]%n!=0)
                   { System.out.print("-1");
                      System.exit(0);
                   }
              }
        String s1="";
        for(int i=0;i<26;i++) 
          { if(f[i]!=0)
               for(int j=0;j<f[i]/n;j++)
                 s1=s1+(char)(i+97);
          }
        for(int i=0;i<n;i++)
          System.out.print(s1);
   }                  
}