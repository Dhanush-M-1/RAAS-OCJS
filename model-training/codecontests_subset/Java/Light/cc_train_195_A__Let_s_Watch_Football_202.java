public class A {
    public static final java.util.Scanner in = new java.util.Scanner(System.in);
    public static final java.io.PrintStream out = new java.io.PrintStream(System.out);

    public static void main(String[] args) {
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();

    out.println((c * (a - b) - 1) / b + 1);
    }
}
