import java.io.*;
import java.util.StringTokenizer;

public class D {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tok;

    public static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public static String nextToken() throws IOException {
        if (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) throws IOException {
        double x = nextDouble();
        double y = nextDouble();
        double z = nextDouble();

        if (x > 1.0 || y > 1.0 || z > 1.0) {
            double maximum = Double.NEGATIVE_INFINITY;
            String result = "";
            if (x > 1.0) {
                double value = z * Math.log(y) + Math.log(Math.log(x));
                if (value > maximum) {
                    maximum = value;
                    result = "x^y^z";
                }
                value = y * Math.log(z) + Math.log(Math.log(x));
                if (value > maximum) {
                    maximum = value;
                    result = "x^z^y";
                }
                value = Math.log(z) + Math.log(y) + Math.log(Math.log(x));
                if (value > maximum) {
                    maximum = value;
                    result = "(x^y)^z";
                }
            }
            if (y > 1.0) {
                double value = z * Math.log(x) + Math.log(Math.log(y));
                if (value > maximum) {
                    maximum = value;
                    result = "y^x^z";
                }
                value = x * Math.log(z) + Math.log(Math.log(y));
                if (value > maximum) {
                    maximum = value;
                    result = "y^z^x";
                }
                value = Math.log(z) + Math.log(x) + Math.log(Math.log(y));
                if (value > maximum) {
                    maximum = value;
                    result = "(y^x)^z";
                }
            }
            if (z > 1.0) {
                double value = y * Math.log(x) + Math.log(Math.log(z));
                if (value > maximum) {
                    maximum = value;
                    result = "z^x^y";
                }
                value = x * Math.log(y) + Math.log(Math.log(z));
                if (value > maximum) {
                    maximum = value;
                    result = "z^y^x";
                }
                value = Math.log(y) + Math.log(x) + Math.log(Math.log(z));
                if (value > maximum) {
                    maximum = value;
                    result = "(z^x)^y";
                }
            }
            System.out.println(result);
            return;
        }

        if (x == 1.0) {
            System.out.println("x^y^z");
            return;
        }

        if (y == 1.0) {
            System.out.println("y^x^z");
            return;
        }

        if (z == 1.0) {
            System.out.println("z^x^y");
            return;
        }

        double minimum = Double.POSITIVE_INFINITY;
        String result = "";
        double value = z * Math.log(y) + Math.log(-Math.log(x));
        if (value < minimum) {
            minimum = value;
            result = "x^y^z";
        }
        value = y * Math.log(z) + Math.log(-Math.log(x));
        if (value < minimum) {
            minimum = value;
            result = "x^z^y";
        }
        value = Math.log(z) + Math.log(y) + Math.log(-Math.log(x));
        if (value < minimum) {
            minimum = value;
            result = "(x^y)^z";
        }
        value = z * Math.log(x) + Math.log(-Math.log(y));
        if (value < minimum) {
            minimum = value;
            result = "y^x^z";
        }
        value = x * Math.log(z) + Math.log(-Math.log(y));
        if (value < minimum) {
            minimum = value;
            result = "y^z^x";
        }
        value = Math.log(z) + Math.log(x) + Math.log(-Math.log(y));
        if (value < minimum) {
            minimum = value;
            result = "(y^x)^z";
        }
        value = y * Math.log(x) + Math.log(-Math.log(z));
        if (value < minimum) {
            minimum = value;
            result = "z^x^y";
        }
        value = x * Math.log(y) + Math.log(-Math.log(z));
        if (value < minimum) {
            minimum = value;
            result = "z^y^x";
        }
        value = Math.log(y) + Math.log(x) + Math.log(-Math.log(z));
        if (value < minimum) {
            minimum = value;
            result = "(z^x)^y";
        }
        System.out.println(result);
    }
}