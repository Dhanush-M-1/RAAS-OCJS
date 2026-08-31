import java.util.*;
public class Main {
    public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      //String a="abcdefghijklmnopqrstuvwxyz";
      while(t--!=0)
      {
          int k,n,m;
          k=sc.nextInt();
          n=sc.nextInt();
          m=sc.nextInt();
          int a[]=new int[n];
          int b[]=new int[m];
          for(int i=0;i<n;i++)
           a[i]=sc.nextInt();
          for(int i=0;i<m;i++)
           b[i]=sc.nextInt();
          int i=0,j=0,flag=1,idx=0;
          int ans[]=new int[n+m];
          while(i<n && j<m)
          {
              if(a[i]==0)
              {
                  k++;
                  ans[idx++]=a[i];
                  i++;
              }
              else
              {
                  if(a[i]<=k)
                  {
                      ans[idx++]=a[i];
                      i++;
                  }
                  else
                  {
                      if(b[j]==0)
                      {
                          k++;
                          ans[idx++]=b[j];
                          j++;
                      }
                      else
                      {
                          if(b[j]<=k)
                          {
                              ans[idx++]=b[j];
                              j++;
                          }
                          else
                          {
                              flag=0;
                              break;
                          }
                      }
                  }
              }
          }
          if(flag==1)
          {
              while(i<n)
              {
                  if(a[i]==0)
                  {
                      k++;
                      ans[idx++]=a[i];
                      i++;
                  }
                  else if(a[i]<=k)
                  {
                      ans[idx++]=a[i];
                      i++;
                  }
                  else
                  {
                      flag=0;
                      break;
                  }
              }
              while(j<m)
              {
                  if(b[j]==0)
                  {
                      k++;
                      ans[idx++]=b[j];
                      j++;
                  }
                  else if(b[j]<=k)
                  {
                      ans[idx++]=b[j];
                      j++;
                  }
                  else
                  {
                      flag=0;
                      break;
                  }
              }
          }
          if(flag==0)
            System.out.println(-1);
            else
            {
                for(i=0;i<n+m;i++)
                {
                    System.out.print(ans[i]+" ");
                }
                System.out.println();
            }
      }
    }
}