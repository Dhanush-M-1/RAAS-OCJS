import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.PrintWriter;
import java.util.TreeSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputStreamReader in = new InputStreamReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB1 solver = new TaskB1();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB1 {
    public void solve(int testNumber, InputStreamReader inSt, PrintWriter out) {
        InputReader in = new InputReader(inSt);

        int num = in.nextInt();
        int place = in.nextInt() - 1;

        int[] order = new int[num];
        for (int i = 0; i < num; i++) {
            order[i] = in.nextInt() - 1;
        }

        int[] chainsLen = new int[num];
        int[] seq = generateConnections(order, chainsLen);
        int placeInChain = 0;
        int numOfChain = place;
        while (seq[numOfChain] != -1) {
            numOfChain = seq[numOfChain];
            placeInChain++;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(placeInChain);
        for (int i = 0; i < chainsLen.length; i++) {
            if (chainsLen[i] > 0 && i != numOfChain) {
                TreeSet<Integer> tmp = new TreeSet<>(treeSet);
                for (Integer element : tmp) {
                    treeSet.add(element + chainsLen[i]);
                }
            }
        }


        for (Integer element : treeSet) {
            out.println(element + 1);
        }

    }


    private int[] generateConnections(int[] order, int[] chainsLen) {
        int[] seq = new int[order.length];
        Arrays.fill(seq, -1);

        Arrays.fill(chainsLen, 1);
        for (int i = 0; i < order.length; i++) {
            if (order[i] != -1) {
                seq[i] = order[i];
                int parent = order[i];
                while (seq[parent] != -1) {
                    parent = seq[parent];
                }

                chainsLen[parent] += chainsLen[i];
                chainsLen[i] = 0;
            }
        }

        return seq;
    }

    class InputReader {
        public BufferedReader reader;
        private String[] currentArray;
        int curPointer;

        public InputReader(InputStreamReader inputStreamReader) {
            reader = new BufferedReader(inputStreamReader);
        }

        public String next() {
            try {
                currentArray = null;
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            if ((currentArray == null) || (curPointer >= currentArray.length)) {
                try {
                    currentArray = reader.readLine().split(" ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                curPointer = 0;
            }
            return Integer.parseInt(currentArray[curPointer++]);
        }

    }
}

