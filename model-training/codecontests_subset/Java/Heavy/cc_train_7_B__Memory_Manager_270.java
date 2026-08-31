import java.util.*;
public class Main
{
  public static void main(String[] args) 
  {
    int i,j,k,z,s,w,sum,num,sumx,h;String str;
    Scanner reader = new Scanner(System.in);
    while(reader.hasNextInt())
    {
      int n = reader.nextInt();
      int t = reader.nextInt();
      int []list = new int [1000];
      for(i=0,w=0,s=1,sum=0;i<n;i++)
      {
        str=reader.next();
        if(str.equals("alloc"))
        {
          num=reader.nextInt();
          for(j=0,sum=0;j<t;j++)
          {
            if(list[j]==0)
              sum++;
            else if(sum>=num)
              break;
            else
              sum=0;
          }
          if(num<=sum)
          {
            for(j=w;j<w+num;j++)
              list[j]=s;
            System.out.println(s);
            s++;
            w=j;
          }
          else
            System.out.println("NULL");
        }
        else if(str.equals("erase"))
        {
          num=reader.nextInt();
          for(j=0,z=0,sumx=0,h=0;j<t;j++)
          {
            if(list[j]==num)
            {
              list[j]=0;
              z=1;
              if(sumx==0)
                h=j;
              sumx++;
            }
          }
          if(z==0||num==0)
            System.out.println("ILLEGAL_ERASE_ARGUMENT");
          else
            w=h;
        }
        else if(str.equals("defragment"))
        {
          int []test = new int [1000];
          for(j=0,k=0;j<t;j++)
          {
            if(list[j]!=0)
            {
              test[k]=list[j];
              k++;
              list[j]=0;
            }
          }
          for(j=0;j<=k;j++)
            list[j]=test[j];
          w=k;
        }
      }
    }
  }
}
 	 		 	  	   	 	 		   		 	