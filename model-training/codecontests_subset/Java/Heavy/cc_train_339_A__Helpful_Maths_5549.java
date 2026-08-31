import java.util.*;

 public class vaccine
{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

          String str=sc.next();

          int a=0;
          int b=0;
          int c=0;


            for(int i=0;i<str.length();i++)
            {
              if(str.charAt(i)=='1')
              {
                  a++;
              }
              else if(str.charAt(i)=='2')
              {
                  b++;

              }
              else if(str.charAt(i)=='3')
              {
                  c++;
              }
            }

            String res="";

              for(int i=0;i<a;i++)
              {
                  res+="1+";
              }
        for(int i=0;i<b;i++)
        {
            res+="2+";
        }
        for(int i=0;i<c;i++)
        {
            res+="3+";
        }

        res=res.substring(0,res.length()-1);

        System.out.println(res);

        }
}