import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyBufferedReader in = new MyBufferedReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        private int n;
        private int m;
        private long L;
        private int s;
        private int t;

        public void solve(int testNumber, MyBufferedReader in, PrintWriter out) {
            int[] data = in.getALineOfInts(5);
            n = data[0];
            m = data[1];
            L = data[2];
            s = data[3];
            t = data[4];

            ArrayList<ArrayList<Integer>> ns = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ns.add(new ArrayList<>());
            }

            long[][] weights = new long[n][n];
            boolean[][] isBlank = new boolean[n][n];

            ArrayList<ArrayList<Integer>> all = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                data = in.getALineOfInts(3);
                int g1 = data[0];
                int g2 = data[1];
                int w = data[2];

                ns.get(g1).add(g2);
                ns.get(g2).add(g1);
                weights[g1][g2] = weights[g2][g1] = (long) Math.max(w, 1);

                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(g1);
                edge.add(g2);
                all.add(edge);

                if (w == 0) {
                    isBlank[g1][g2] = true;
                    isBlank[g2][g1] = true;
                }
            }

            long length;
            int[] edgeOnPath;
            do {
                TaskD.DjikResult djik = djik(s, t, ns, weights);
                long[] ds = djik.dist;
                length = ds[t];
                if (length >= L) {
                    break;
                }

                edgeOnPath = getBlankOnPath(t, djik.parents, isBlank);
                if (edgeOnPath == null) {
                    break;
                }
                int g1 = edgeOnPath[0];
                int g2 = edgeOnPath[1];
                weights[g1][g2] += L - ds[t];
                weights[g2][g1] += L - ds[t];
            } while (true);


            if (length == L) {
                printGraph(out, all, weights);
            } else {
                out.println("NO");
            }

        }

        private int[] getBlankOnPath(int curr, int[] parents, boolean[][] isBlank) {
            int prev = parents[curr];
            int lastBlank1 = -1;
            int lastBlank2 = -1;
            while (prev != -1) {
                if (isBlank[prev][curr]) {
                    lastBlank1 = prev;
                    lastBlank2 = curr;
                }

                curr = prev;
                prev = parents[curr];
            }

            if (lastBlank2 == -1) {
                return null;
            }

            return new int[]{lastBlank1, lastBlank2};
        }

        static TaskD.DjikResult djik(int source, int target, ArrayList<ArrayList<Integer>>
                neighbours,
                                     long[][] weights) {
            long[] dist = new long[neighbours.size()];
            int[] parents = new int[neighbours.size()];
            boolean[] minReached = new boolean[neighbours.size()];
            Arrays.fill(dist, -1);
            Arrays.fill(parents, -1);
            dist[source] = 0;

            TaskD.PrimitiveHeap closest = new TaskD.PrimitiveHeap(neighbours.size(), true, dist);

            closest.add(source);
            while (!closest.isEmpty()) {
                int next = closest.remove();
                if (minReached[next]) {
                    continue;
                }

                minReached[next] = true;
                if (next == target) {
                    break;
                }

                for (int n : neighbours.get(next)) {
                    long w = weights[next][n];
                    if (dist[n] == -1) {
                        dist[n] = dist[next] + w;
                        parents[n] = next;
                        closest.add(n);
                        continue;
                    }

                    if (dist[next] + w < dist[n]) {
                        dist[n] = dist[next] + w;
                        parents[n] = next;
                        closest.update(n);
                    }
                }
            }


            return new TaskD.DjikResult(dist, parents);
        }

        private void printGraph(PrintWriter out, ArrayList<ArrayList<Integer>> all,
                                long[][] weights) {
            out.println("YES");
            for (ArrayList<Integer> e : all) {
                int g1 = e.get(0);
                int g2 = e.get(1);
                out.println(g1 + " " + g2 + " " + weights[g1][g2]);
            }
        }

        public static class DjikResult {
            public long[] dist;
            public int[] parents;

            public DjikResult(long[] dist, int[] parents) {
                this.dist = dist;
                this.parents = parents;
            }

        }

        public static class PrimitiveHeap {
            int[] heap;
            int[] pos;
            private final long[] dist;
            int comparisonSign;
            int size;

            public PrimitiveHeap(int maxSize, boolean min, long[] dist) {
                heap = new int[maxSize];
                pos = new int[maxSize];
                this.dist = dist;
                Arrays.fill(pos, -1);
                if (min) {
                    comparisonSign = 1;
                } else {
                    comparisonSign = -1;
                }
            }

            public void add(int e) {
                heap[size] = e;
                pos[e] = size;
                bubbleUp(size);
                size++;
            }

            public int remove() {
                if (size == 0)
                    return -1;

                int result = heap[0];
                swap(0, size - 1);
                size--;
                pos[result] = -1;
                heapify(0);
                return result;
            }

            public void update(int e) {
                if (pos[e] == -1) {
                    return;
                }

                int epos = pos[e];
                if (epos == 0 || comparisonSign * compare(e, heap[parent(epos)]) >= 0)
                    heapify(epos);
                else
                    bubbleUp(epos);
            }

            private int compare(int e, int i) {
                return (int) (dist[e] - dist[i]);
            }

            void bubbleUp(int child) {
                if (child == 0)
                    return;

                int parent = parent(child);
                if (comparisonSign * compare(heap[child], heap[parent]) < 0) {
                    swap(parent, child);
                    bubbleUp(parent);
                }
            }

            void heapify(int root) {
                if (root >= size)
                    return;

                int extremeChild = left(root);
                if (right(root) < size && comparisonSign * compare(heap[right(root)], heap[left
                        (root)
                        ]) < 0)
                    extremeChild = right(root);

                if (extremeChild < size && comparisonSign * compare(heap[extremeChild],
                                                                    heap[root]) <
                        0) {
                    swap(root, extremeChild);
                    heapify(extremeChild);
                }
            }

            void swap(int idx1, int idx2) {
                pos[heap[idx1]] = idx2;
                pos[heap[idx2]] = idx1;

                MyArrays.swap(heap, idx1, idx2);
            }

            int parent(int i) {
                return (i - 1) / 2;
            }

            int left(int i) {
                return 2 * i + 1;
            }

            int right(int i) {
                return 2 * i + 2;
            }

            public boolean isEmpty() {
                return size == 0;
            }

        }

    }

    static class MyArrays {
        public static void swap(int[] a, int pos1, int pos2) {
            int temp = a[pos1];
            a[pos1] = a[pos2];
            a[pos2] = temp;
        }

    }

    static class MyBufferedReader {
        BufferedReader in;

        public MyBufferedReader(InputStream s) {
            this.in = new BufferedReader(new InputStreamReader(s));
        }

        public int[] getALineOfInts(int numExpected) {
            int[] res = new int[numExpected];
            StringTokenizer st = null;
            try {
                st = new StringTokenizer(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < numExpected; i++)
                res[i] = Integer.parseInt(st.nextToken());
            return res;
        }

    }
}

