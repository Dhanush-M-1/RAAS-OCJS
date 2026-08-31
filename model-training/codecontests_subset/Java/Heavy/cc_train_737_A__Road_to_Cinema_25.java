import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.io.InputStream;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Alex
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }
    static class TaskA {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt(); // cars
            int k = in.readInt(); // gas stations
            int s = in.readInt(); // length of road
            int t = in.readInt(); // max time
            Car[] cars = new Car[n];
            for (int i = 0; i < cars.length; i++) cars[i] = new Car(in.readInt(), in.readInt());
            int[] gas = IOUtils.readIntArray(in, k);
            Arrays.sort(gas);
            Arrays.sort(cars, new Comparator<Car>() {
                public int compare(Car a, Car b) {
                    if (a.price != b.price) return Integer.compare(a.price, b.price);
                    return -Integer.compare(a.capacity, b.capacity);
                }
            });
            ArrayList<Car> goodCars = new ArrayList<>();
            for (Car c : cars) {
                if (goodCars.isEmpty() || c.capacity > goodCars.get(goodCars.size() - 1).capacity) {
                    goodCars.add(c);
                }
            }
            int low = 0, high = goodCars.size() - 1;
            while (low < high) {
                int mid = (low + high) / 2;
                if (canReach(mid, goodCars, gas, s, t)) high = mid;
                else low = mid + 1;
            }
            if (canReach(low, goodCars, gas, s, t)) out.printLine(goodCars.get(low).price);
            else out.printLine(-1);
        }
        private boolean canReach(int carIdx, ArrayList<Car> cars, int[] gas, int s, int t) {
            if (carIdx < 0 || carIdx >= cars.size()) return false;
            Car c = cars.get(carIdx);
            int curLoc = 0;
            for (int idx = 0; idx <= gas.length; idx++) {
                int loc = idx < gas.length ? gas[idx] : s;
                int dist = loc - curLoc;
                int time = getTime(dist, c.capacity);
                if (time == -1) return false;
                t -= time;
                if (t < 0) return false;
                curLoc = loc;
            }
            return true;
        }
        private int getTime(int dist, int capacity) {
            // slow + fast = dist
            // slow = dist - fast
            // slow + fast * 2 <= capacity
            // (dist - fast) + fast * 2 <= capacity
            // dist + fast <= capacity
            int fast = capacity - dist;
            if (fast < 0) return -1;
            if (fast >= dist) return dist;
            int slow = dist - fast;
            return slow * 2 + fast;
        }
        class Car {
            int price;
            int capacity;
            public Car(int price, int capacity) {
                this.price = price;
                this.capacity = capacity;
            }
        }
    }
    static class IOUtils {
        public static int[] readIntArray(InputReader in, int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.readInt();
            }
            return array;
        }
    }
    static class OutputWriter {
        private final PrintWriter writer;
        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }
        public void close() {
            writer.close();
        }
        public void printLine(int i) {
            writer.println(i);
        }
    }
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }
        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}

