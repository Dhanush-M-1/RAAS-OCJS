import java.io.*;
public class election
{
 public static void main(String args[])throws IOException
 {
  InputStreamReader read=new InputStreamReader(System.in);
  BufferedReader in=new BufferedReader(read);
  int i,l,n,r;
  l=r=0;
  String s;
  n=Integer.parseInt(in.readLine());
  int[] a=new int[n];
  s=in.readLine();
  s+=' ';
  for(i=0;i<s.length();i++)
  {
   if(s.charAt(i)==' ')
   {
    a[r++]=Integer.parseInt(s.substring(0,i));
    s=s.substring(i+1);
    i=-1;
    if(a[r-1]>l)
    l=a[r-1];
   }
  }
  r=l-a[0];;
  for(i=1;i<n;i++)
  {
   r+=(l-a[i]);
   a[i]+=a[i-1];
  }
  while(r<=a[n-1])
  {
   l++;
   r+=n;
  }
  System.out.println(l);
 }
}