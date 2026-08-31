
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] vals = reader.readLine().split(" ");
            int n = Integer.parseInt(vals[0]);
            int m = Integer.parseInt(vals[1]);
            int h = Integer.parseInt(vals[2]);

            int[] maint = new int[n];
            String[] vals2 = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                maint[i] = Integer.parseInt(vals2[i]);
            }

            int[] d1 = new int[m];
            int[] d2 = new int[m];
            for (int i = 0; i < m; i++) {
                String[] vals3 = reader.readLine().split(" ");
                d1[i] = Integer.parseInt(vals3[0]) - 1;
                d2[i] = Integer.parseInt(vals3[1]) - 1;
            }

            // Stores the lists of data centers that must be shifted if we shift data center i
            ArrayList<HashSet<Integer>> mustShift = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                mustShift.add(new HashSet<>());
            }

            for(int i = 0; i < m; i++) {
                int center1 = d1[i];
                int center2 = d2[i];
                if(maint[center1] == (maint[center2] + 1) % h) {
                    mustShift.get(center2).add(center1);
                }

                if(maint[center2] == (maint[center1] + 1) % h) {
                    mustShift.get(center1).add(center2);
                }
            }

            // If there is a leaf node in the directed graph of data center shifts, just shift that single one.
            // Otherwise, shift all nodes in the smallest leaf node of the condensation of the graph.
            int[] components = stronglyConnectedComponents(mustShift);

            ArrayList<HashSet<Integer>> componentGraph = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                componentGraph.add(new HashSet<>());
            }

            int[] compSizes = new int[n];
            for(int i = 0; i < n; i++) {
                compSizes[components[i]]++;
            }

            for(int i = 0; i < n; i++) {
                for(int v : mustShift.get(i)) {
                    int componentStart = components[i];
                    int componentEnd = components[v];
                    if(componentStart != componentEnd) {
                        componentGraph.get(componentStart).add(componentEnd);
                    }
                }
            }

            int minSize = n + 1;
            int minIndex = -1;
            for(int i = 0; i < n; i++) {
                if(compSizes[i] > 0 && compSizes[i] < minSize && componentGraph.get(i).size() == 0) {
                    minSize = compSizes[i];
                    minIndex = i;
                }
            }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            writer.write(minSize + "\n");
            for(int i = 0; i < n; i++) {
                if(components[i] == minIndex) {
                    writer.write((i + 1) + " ");
                }
            }
            writer.flush();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    // Kosaraju
    public static int[] stronglyConnectedComponents(ArrayList<HashSet<Integer>> mustShift) {
        int n = mustShift.size();
        int[] components = new int[n];
        for(int i = 0; i < n; i++) {
            components[i] = -1;
        }

        ArrayList<HashSet<Integer>> mustShiftRev = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            mustShiftRev.add(new HashSet<>());
        }

        for(int i = 0; i < n; i++) {
            for(int next : mustShift.get(i)) {
                mustShiftRev.get(next).add(i);
            }
        }

        LinkedList<Integer> l = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            visited[i] = false;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visit(i, visited, l, mustShift);
            }
        }

        for(int v : l) {
            if (components[v] == -1) {
                assign(v, v, components, mustShiftRev);
            }
        }

        return components;
    }

    public static void visit(int current, boolean[] visited, LinkedList<Integer> l, ArrayList<HashSet<Integer>> mustShift) {
        // System.out.println("Called visit for vertex: " + current);
        visited[current] = true;
        for(Integer next : mustShift.get(current)) {
            if(!visited[next]) {
                visit(next, visited, l, mustShift);
            }
        }
        l.addFirst(current);
    }

    public static void assign(int current, int root, int[] components, ArrayList<HashSet<Integer>> mustShiftRev) {
        // System.out.println("Called assign of node " + current + " to component: " + root);
        components[current] = root;
        for(int prev : mustShiftRev.get(current)) {
            if(components[prev] == -1) {
                assign(prev, root, components, mustShiftRev);
            }
        }
    }
}
