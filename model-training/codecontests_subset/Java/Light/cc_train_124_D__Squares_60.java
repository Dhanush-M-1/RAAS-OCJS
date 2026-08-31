import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int LocPar1, LocPar2;

        a *= 2;
        b *= 2;

        LocPar1 = x1;
        LocPar2 = y1;
        x1 = LocPar1 + LocPar2;
        y1 = LocPar2 - LocPar1;

        LocPar1 = x2;
        LocPar2 = y2;
        x2 = LocPar1 + LocPar2;
        y2 = LocPar2 - LocPar1;

        if (x1>0)
            x1 = x1/a+1;
        else
            x1 = x1/a;
        if (x2>0)
            x2 = x2/a+1;
        else
            x2 = x2/a;
        if (y1>0)
            y1 = y1/b+1;
        else
            y1 = y1/b;
        if (y2>0)
            y2 = y2/b+1;
        else
            y2 = y2/b;
        System.out.println(Math.max(Math.abs((x2-x1)),Math.abs((y2-y1))));
    }
}