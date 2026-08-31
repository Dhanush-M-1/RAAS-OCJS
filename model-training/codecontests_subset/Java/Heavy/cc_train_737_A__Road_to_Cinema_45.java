import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        int  k = sc.nextInt();
        long s = sc.nextLong();
        long t = sc.nextLong();
//        long[] prices = new long[n];
//        long[] fuelCapacities = new long[n];
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            long c = sc.nextLong();
            long v = sc.nextLong();
            cars[i] = new Car(c, v);
        }

//        long[] gasStationPositions = sc.readLongArray(k);
        long[] gasStationPositions = new long[k + 1];
        for (int i = 0; i < k; i++) {
            gasStationPositions[i] = sc.nextLong();
        }
        gasStationPositions[k] = s;
        shuffle(gasStationPositions);
        Arrays.sort(gasStationPositions);

        long low = 0;
        long high = 2L * Integer.MAX_VALUE;
        while (low < high) {
            long mid = (low + high) / 2;

            boolean ok = canReach(gasStationPositions, s, t, mid);
//            System.err.println(mid + ": " + ok);
            if (ok) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

//        System.out.println(canReach(gasStationPositions, s, t, 7));

        long minCapacity = high;
//        System.err.println(minCapacity);
        long minCost = Integer.MAX_VALUE;
        for (Car car : cars) {
            if (car.fuelCapacity >= minCapacity) {
                minCost = Math.min(minCost, car.cost);
            }
        }

        if (minCost >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCost);
        }
    }

    static boolean canReach(long[] gasStationPositions, long end, long timeLimit, long fuelCapacity) {
        long curPos = 0;
        long curTime = 0;
//        long curFuel = fuelCapacity;
        int gasStationIdx = 0;
        while (curPos < end) {
            // Greedily use all fuel to next gas station
            long dist = gasStationPositions[gasStationIdx] - curPos;
            if (dist > fuelCapacity) {
                return false;
            }

            long fastTime = fuelCapacity - dist;
            fastTime = Math.min(fastTime, dist);
            long slowTime = dist - fastTime;
            curTime += 2 * slowTime + fastTime;

            curPos = gasStationPositions[gasStationIdx];
            gasStationIdx++;
        }

        return curPos >= end && curTime <= timeLimit;
    }

    static class Car implements Comparable<Car> {
        final long cost, fuelCapacity;

        public Car(long cost, long fuelCapacity) {
            this.cost = cost;
            this.fuelCapacity = fuelCapacity;
        }

        @Override
        public int compareTo(Car o) {
            return Long.compare(cost, o.cost);
        }
    }

    static void shuffle(long[] arr) {
        Random rng = new Random();
        int length = arr.length;
        for (int idx = 0; idx < arr.length; idx++) {
            int toSwap = idx + rng.nextInt(length-idx);
            long tmp = arr[idx];
            arr[idx] = arr[toSwap];
            arr[toSwap] = tmp;
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }
        public FastScanner() {
            this(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}
