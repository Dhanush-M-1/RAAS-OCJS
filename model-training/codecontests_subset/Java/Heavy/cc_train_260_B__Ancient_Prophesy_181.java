  import java.io.*;
  import java.util.*;
 public class time1{
  static boolean valid(String s)
  {
    if(!s.substring(3,5).contains("-")&&!s.substring(0,2).contains("-")&&!s.substring(6,10).contains("-")&&s.charAt(2)=='-'&&s.charAt(5)=='-')
    {
      int a=Integer.parseInt(s.substring(0,2));
      int b=Integer.parseInt(s.substring(3,5));
      int c=Integer.parseInt(s.substring(6,10));
      int[] days={0,31,28,31,30,31,30,31,31,30,31,30,31};
      if(1<=b&&b<=12&&a>=1&&days[b]>=a&&c>=2013&&c<=2015)
        return true;
      else
        return false;
    }
    return false;
  }
      
  
  public static void main(String[] args) throws IOException
  {
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    HashMap<String,Long> map=new HashMap<String,Long>();
    for(int i=0;i<=(s.length()-10);i++)
    {
      String t=s.substring(i,i+10);
      if(valid(t))
      {
        if(map.containsKey(t))
          map.put(t,map.get(t)+1);
        else
          map.put(t,(long)1);
      }
    }
    long max=-1;
    String maxVal="";
    for(String key:map.keySet())
    {
      
      if(map.get(key)>max)
      {
        max=map.get(key);
        maxVal=key;
      }
    }
      
    System.out.println(maxVal);
  }
}