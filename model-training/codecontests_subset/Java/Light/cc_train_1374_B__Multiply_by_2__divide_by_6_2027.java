import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner in=new Scanner(System.in);
int t=in.nextInt();
while(t-->0)
{
    int j=in.nextInt();
    int n=j;
    int a=0;
    int b=0;
    int k=0;
    while(j!=1)
    {
        if(j%2==0)
        {
            j=j/2;
            a++;
        }
        else if(j%3==0)
        {
            j=j/3;
            b++;
        }
        else{
            k=-1;
            break;
        }
        }
     if(a>b)
     System.out.println(-1);
      else if(k==-1)
       System.out.println(-1);
       else if(n==1)
       System.out.println(0);
       else{
            System.out.println((b-a)*2+a);
       }



    }

}	}

