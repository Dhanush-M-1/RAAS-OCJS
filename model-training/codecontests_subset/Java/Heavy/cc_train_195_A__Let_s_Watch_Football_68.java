import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

public class A extends Template {

    public void run() {
        double a = d(), b = d(), c=d();
        int t = (int) Math.ceil((c*(a-b))/b);
        System.out.println(t < 0 ? 0 : t );
    }

}




















class Template {

    public static void main(String[] args) {
        A a = new A();
        a.run();
    }

    private Scanner sc = new Scanner(System.in);

    public int toi(String s) {
        return Integer.parseInt(s);
    }

    public double tod(String s) {
        return Double.parseDouble(s);
    }

    public long tol(String s) {
        return Long.parseLong(s);
    }

    public int i() {
        return sc.nextInt();
    }

    public double d() {
        return sc.nextDouble();
    }

    public String s() {
        return sc.next();
    }

    public String l() {
        return sc.nextLine();
    }

    public int[] ai() {
        String[] line = as();
        int[] ints = new int[line.length];
        for (int i = 0; i < ints.length; i++)
            ints[i] = toi(line[i]);
        return ints;
    }

    public double[] ad() {
        String[] line = as();
        double[] doubles = new double[line.length];
        for (int i = 0; i < doubles.length; i++)
            doubles[i] = tod(line[i]);
        return doubles;
    }

    public int[] al() {
        String[] line = as();
        int[] ints = new int[line.length];
        for (int i = 0; i < ints.length; i++)
            ints[i] = toi(line[i]);
        return ints;
    }

    public String[] as() {
        return l().split("[ ]+");
    }

    public int[] aof(int n, int i) {
        int a[] = new int[n];
        Arrays.fill(a, i);
        return a;
    }

}
