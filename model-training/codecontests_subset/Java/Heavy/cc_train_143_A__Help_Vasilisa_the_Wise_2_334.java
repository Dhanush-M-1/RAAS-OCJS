import java.util.*;
public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1=sc.nextInt();
        int r2= sc.nextInt();
        int c1= sc.nextInt();
        int c2= sc.nextInt();
        int d1= sc.nextInt();
        int d2= sc.nextInt();
        for(int a=1;a<=9;a++){
            for(int b=1;b<=9;b++){
                if(a==b)continue;
                for(int c=1;c<=9;c++){
                    if(c==a)continue;
                    if(c==b)continue;
                    for(int d=1;d<=9;d++){
                        if(d==a)continue;
                        if(d==b)continue;
                        if(d==c)continue;
                        if(
                            r1==a+b&&
                            r2==c+d&&
                            c1==a+c&&
                            c2==b+d&&
                            d1==a+d&&
                            d2==b+c
                                
                                )
                        {
                            System.out.println(a+" "+b);
                            System.out.println(c+" "+d);
                            System.exit(0);
                            
                        }
                            
                    }
                }
            }
        }
        System.out.println("-1");
        System.exit(0);

    }

}
