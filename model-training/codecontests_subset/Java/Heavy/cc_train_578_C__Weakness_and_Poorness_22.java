import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

public class WeaknessAndPoorness {

    
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.in);
        int n = ir.nextInt();
        int a[] = new int[n];
        int maxA = 0, minA = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = ir.nextInt();
            maxA = i == 0 ? a[0] : Math.max (maxA, a[i]);
            minA = i == 0 ? a[0] : Math.min (minA, a[i]);
        }
        
        Solution solution = new Solution(n, a);
        double x = solution.getMin(minA, maxA);
        OutputWriter ow = new OutputWriter(System.out);
        ow.printLine(x);
        ow.close();
    }

}

class Solution {
    private int n, a[];
    private static double EPS = 1e-6;
    public static int MAXA = 10000;
    Solution(int n, int a[]) {
        this.n = n;
        this.a = a;
    }
    double function1(double x) {
        double result = 0.0, current = 0.0;
        for (int i = 0; i < n; ++i) {
        	current += a[i] - x;
        	if (current < 0.0) {
        		current = 0.0;
        	} else if (current > result){
        		result = current;
        	}
        }
        return result;
    }

    double function2(double x) {
        double result = 0.0, current = 0.0;
        for (int i = 0; i < n; ++i) {
        	current += -a[i] + x;
        	if (current < 0.0) {
        		current = 0.0;
        	} else if (current > result){
        		result = current;
        	}
        }
        return result;
    }
    
    double getMin(double left, double right) {
    	for (int i = 0; i < 100; ++i) {
    		double middle = (left+right)/2;
    		double function1Value = function1(middle);
    		double function2Value = function2(middle); 
    		if (function1Value > function2Value) {
    			left = middle;
    		} else {
    			right = middle;
    		}
    	}
    	return Math.max(function1((left+right)/2), function2((left+right)/2));
    }
}

class InputReader {
    private InputStream stream;
    private byte[] buffer = new byte[10000];
    private int cur;
    private int count;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public static boolean isSpace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public int read() {
        if (count == -1) {
            throw new InputMismatchException();
        }
        try {
            if (cur >= count) {
                cur = 0;
                count = stream.read(buffer);
                if (count <= 0)
                    return -1;
            }
        } catch (IOException e) {
            throw new InputMismatchException();
        }
        return buffer[cur++];
    }

    public int readSkipSpace() {
        int c;
        do {
            c = read();
        } while (isSpace(c));
        return c;
    }

    public int nextInt() {
        int sgn = 1;
        int c = readSkipSpace();
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res = res * 10 + c - '0';
            c = read();
        } while (!isSpace(c));
        res *= sgn;
        return res;
    }

}


class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

}