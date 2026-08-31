import java.util.Scanner;


public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        int x1 = 1;
        int x2 = 1;
        int x3 = 1;
        int x4 = 1;
        boolean flag = false;
        m:
        if (!flag)
        for (x1=1; x1<10; x1++)
            for(x2=1; x2<10; x2++)
                for(x3=1; x3<10; x3++)
                    for (x4=1; x4<10; x4++) {
                        if  (x1==x2||x1==x3||x1==x4||x2==x3||x2==x4||x3==x4)
                            continue;
                        else
                            if (x1+x2==r1 && x3+x4==r2 && x1+x3==c1 && x2+x4==c2 && x1+x4==d1 && x2+x3==d2) {
                                flag = true;
                                break m;
                            }
                    }
        if (!flag) System.out.println(-1);
        else System.out.println(x1+" "+x2+"\n"+x3+" "+x4);
            

    }

}
