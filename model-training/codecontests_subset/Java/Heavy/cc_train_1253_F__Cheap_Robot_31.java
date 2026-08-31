import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MSTFromSubgraph {
    static class DJStruct {
        final int vertice;
        final int head;
        final long length;

        DJStruct(int v, int h, long p) {
            vertice = v;
            head = h;
            length = p;
        }

    }
    static class Edge {
        final int f;
        final int t;
        final long w;
        Edge(int f, int t, long w){
            this.f = f;
            this.t = t;
            this.w = w;
        }
    }

    static List<Map<Integer, Integer>> firstGraph = new ArrayList<>();

    static int n;
    static int k;
    static int q;
    static boolean[] used;
    static int[] head;
    static long[] length;


    static List<Edge> mstCandidates = new ArrayList<>();
    static void createMst() throws Exception{
        n = nextInt();
        int m = nextInt();
        k = nextInt();
        q = nextInt();
        used = new boolean[n];
        head = new int[n];
        length = new long[n];
        for(int i = 0; i<n; ++i) firstGraph.add(new HashMap<>());
        for(int i = 0; i<m; ++i) {
            int f = nextInt() - 1;
            int t = nextInt() - 1;
            int w = nextInt();
            firstGraph.get(f).put(t, w);
            firstGraph.get(t).put(f, w);
        }

        PriorityQueue<DJStruct> djr = new PriorityQueue<>(new Comparator<DJStruct>() {
            @Override
            public int compare(DJStruct o1, DJStruct o2) {
                 return Long.compare(o1.length, o2.length);

            }
        });
        for(int i = 0; i<k; ++i) djr.add(new DJStruct(i,i,0));
        while (!djr.isEmpty()){
            DJStruct next = djr.poll();
            if(used[next.vertice]) {
                mstCandidates.add(new Edge(next.head, head[next.vertice], next.length +length[next.vertice]));
                continue;
            }
            used[next.vertice] = true;
            length[next.vertice] = next.length;
            head[next.vertice] = next.head;
            for(Map.Entry<Integer, Integer> e: firstGraph.get(next.vertice).entrySet()){
                djr.add(new DJStruct(e.getKey(), next.head, next.length + e.getValue()));
            }
        }

        mstCandidates.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Long.compare(o1.w, o2.w);
            }
        });

        int[] snm = new int[k];
        for(int i = 0; i<k; ++i) {
            snm[i] = i;
            tree.add(new HashMap<>());
        }


        for(Edge e: mstCandidates) {
            int p1 = parent(e.f, snm);
            int p2 = parent(e.t, snm);
            if(p1!=p2) {
                snm[p1] = p2;
                addToTree(e);
            }
        }
    }

    private static int parent(int f, int[] snm) {
        return snm[f] == f?f:(snm[f] = parent(snm[f], snm));
    }



    static List<Map<Integer, Long> > tree = new ArrayList<>();
    static void addToTree(Edge e) {
        tree.get(e.f).put(e.t, e.w);
        tree.get(e.t).put(e.f, e.w);

    }



    static int[] parent;
    static int[] subTreeSize;
    static int[] subTreeMarker;
    static long[] maxPathFromCenter;

    static int[][] tasks;
    static long[] answer;

    static void solve() throws Exception{
       parent = new int[k];
       subTreeSize = new int[k];
       subTreeMarker = new int[k];
       maxPathFromCenter = new long[k];
       goRoot(0, 0);

       tasks = new int[q][2];
       answer = new long[q];
       for(int i = 0; i<q; ++i) {
           tasks[i][0] = nextInt() - 1;
           tasks[i][1] = nextInt() - 1;
       }

       goDecompose(0, IntStream.range(0, q).boxed().collect(Collectors.toList()));
       StringBuilder sb = new StringBuilder();
       for(long l: answer) {
           sb.append(l); sb.append('\n');
       };
       System.out.print(sb.toString());
    }

    private static void goDecompose(int root, List<Integer> tasksList) {
        if(tasksList.isEmpty()) return;
        //subTreeSize[root] >=2;
        int center = root;
        while (true) {
            int c = maxChild(center);
            if(2*subTreeSize[c]>subTreeSize[root]) center = c;
            else break;
        }
        Map<Integer, List<Integer> > subTreeTasks = new HashMap<>();
        for(Map.Entry<Integer, Long> entry: tree.get(center).entrySet()) {
            int v = entry.getKey();
            int treeMarker = v==parent[center]?root:v;
            subTreeTasks.put(treeMarker, new ArrayList<>());
            goMark(v, center, treeMarker, entry.getValue());
        }
        for(int i: tasksList) {
            if(tasks[i][0] == center) {
                answer[i] = maxPathFromCenter[tasks[i][1]];
                continue;
            }
            if(tasks[i][1] == center) {
                answer[i] = maxPathFromCenter[tasks[i][0]];
                continue;
            }
            if(subTreeMarker[tasks[i][0]] == subTreeMarker[tasks[i][1]]) {
                subTreeTasks.get(subTreeMarker[tasks[i][0]]).add(i);
            } else {
                answer[i] = Math.max(maxPathFromCenter[tasks[i][1]], maxPathFromCenter[tasks[i][0]]);
            }
        }

        for(int i: tree.get(center).keySet()) tree.get(i).remove(center);
        if(center != root) {
            int diff = subTreeSize[center];
            int p = parent[center];
            while (true) {
                subTreeSize[p]-=diff;
                if(p==root) break;
                p = parent[p];
            }
        }
        for(Map.Entry<Integer, List<Integer>> entry: subTreeTasks.entrySet()) {
            goDecompose(entry.getKey(), entry.getValue());
        }

    }

    private static void goMark(int vert, int prev, int treeMarker, long maxRun) {
        subTreeMarker[vert] = treeMarker;
        maxPathFromCenter[vert] = maxRun;
        for(Map.Entry<Integer, Long> entry: tree.get(vert).entrySet()) {
            int v = entry.getKey();if(v==prev) continue;
            goMark(v, vert, treeMarker, Math.max(maxRun, entry.getValue()));
        }
    }

    private static int maxChild(int center) {
        return tree.get(center).keySet().stream()
                .mapToInt(i->i)
                .filter(i->i!=parent[center])
                .reduce((i,j)->subTreeSize[i]>subTreeSize[j]?i:j)
                .getAsInt();
    }


    private static void goRoot(int vert, int prev) {
        parent[vert] = prev;
        subTreeSize[vert] = 1;
        for(int i: tree.get(vert).keySet())
            if(i!=prev) {
                goRoot(i, vert);
                subTreeSize[vert]+=subTreeSize[i];
            }
    }


    static BufferedReader input;
    static StringTokenizer stoken = new StringTokenizer("");
    static String nextString() throws IOException {
        while (!stoken.hasMoreTokens()) {
            String st = input.readLine();
            stoken = new StringTokenizer(st);
        }
        return stoken.nextToken();
    }

    static int nextInt() throws Exception {
        return Integer.parseInt(nextString());
    }
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(
                new InputStreamReader(System.in)
        );
        createMst();
        solve();
    }

}
