import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Mikle
 * Date: 04.04.15
 * Time: 23:36
 * To change this template use File | Settings | File Templates.
 */
public class ZeptoA {
    public static void main(String[] args) {
        int i, d=1, j, sum, k=0, flag=0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();
        str = sc.nextLine();

        int a[] =new int[n];
        for (i=0;i<n;i++)
        {
            if (str.charAt(i)=='*')
            a[i]=1;
            else
                a[i]=0;

        }
        while (true)
        {sum=0;
          for (i=0;i<4;i++)
              sum+=d;
          if(n-sum<0)
              break;
          else d++;
        }
        d=d-1;
        int count =0;
      //  System.out.println(d);
        for (i=1;i<=d;i++)
        {

            for (j=0;j<n;j++)
            {
                if(a[j]==1)
                {
                    count=0;
                    sum=j;
                    for (k=0;k<4;k++)
                    {
                      sum+=i;
                        count++;
                     // System.out.println(sum+" "+count+" "+i);

                      if(sum>=n)
                          break;
                        else
                      if(a[sum]==0)
                          break;
                    }
                }

                if(k==4)
                {
                    flag=1;
                    System.out.print("yes");
                    break;
                }
            }
            if(flag==1)
                break;

        }
        if (flag==0)
            System.out.print("no");
    }
}
