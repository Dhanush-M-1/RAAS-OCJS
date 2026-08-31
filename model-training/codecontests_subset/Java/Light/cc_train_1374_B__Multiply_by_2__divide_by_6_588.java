import java.util.Scanner;

public class probB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {int c=0,c2=0;
            int x=sc.nextInt();
            if(x<=6)
            {if(x==1)
                System.out.println(0);
                else if(x==3)
                    System.out.println(2);
                else if(x==6)
                    System.out.println(1);
                else
                    System.out.println(-1);

            }
            else {
                while (true) {
                    if(x==1)
                    {
                        System.out.println(c2);
                        break;
                    }
                    else if(c==2)
                    {
                        System.out.println(-1);
                        break;
                    }
                    else if (x % 6 == 0) {

                        c2++;
                        x /= 6;
                        if(c==1)
                            c--;


                    }
                    else {
                        x*=2;
                        c2++;
                        c++;
                    }
                }
            }

            t--;
        }

    }
}