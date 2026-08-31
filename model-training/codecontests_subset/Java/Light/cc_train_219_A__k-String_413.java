import java.util.*;
public class dubstep
{
public static void main(String args[])
{
Scanner in = new Scanner(System.in);
int k = in.nextInt();
String s = in.next();
if(k==1)
System.out.println(s);
else
{
int f[] = new int[26];
for(int i=0 ; i<s.length() ; i++)
 f[s.charAt(i)-97]++;
 
 int flag=0;
 for(int i=0 ; i<26 ; i++)
 {
     if(f[i]%k==0)
      continue;
      else
       {
           flag=1;
           break;
       }
 }
 if(flag==1)
System.out.println("-1");
else
{
    String str="";
    for(int i=0 ; i<26 ; i++)
    {
        if(f[i]!=0)
        {
            for(int j=0 ; j<f[i]/k ; j++)
            str=str+String.valueOf((char)(i+97));
        }
    }
    for(int i=0 ; i<k ;i++)
     System.out.print(str);
}
}
}
}