import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class D_372_div2
{
    public static final Random RANDOM = new Random(System.currentTimeMillis());
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer = null;
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    private static String next() throws IOException
    {
        while ((stringTokenizer == null) || (!stringTokenizer.hasMoreTokens()))
        {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    public static int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }

    public static double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }

    public static long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    public static String nextLine() throws IOException
    {
        return bufferedReader.readLine();
    }

    public static void close()
    {
        out.close();
    }

    public static void main(String[] args)
    {
        try
        {
            solve();
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
        close();
    }

    public static final long INFINITE = 2000000000L;

    public static class Node<TypeNode extends Node<TypeNode, TypeEdge>, TypeEdge extends Edge<TypeNode, TypeEdge>> implements Comparable<Node<TypeNode, TypeEdge>>
    {
        public final int number;
        public final Map<TypeNode, TypeEdge> edges;

        public Node(int number)
        {
            this.number = number;
            this.edges = new TreeMap<>();
        }

        public void addEdge(TypeEdge edge)
        {
            if (edge.nodeFrom == this)
            {
                this.edges.put(edge.nodeTo, edge);
            }
            else
            {
                this.edges.put(edge.nodeFrom, edge);
            }
        }

        public TypeEdge getEdge(Node<TypeNode, TypeEdge> node)
        {
            return edges.get(node);
        }

        @Override
        public int compareTo(Node<TypeNode, TypeEdge> that)
        {
            int result;
            if (this.number == that.number)
            {
                result = 0;
            }
            else
            {
                if (this.number < that.number)
                {
                    result = -1;
                }
                else
                {
                    result = 1;
                }
            }
            return result;
        }

        private static <TypeNode> void add(Map<TypeNode, Long> node2Distance, Map<Long, TreeSet<TypeNode>> distance2Node, TypeNode node, long distance)
        {
            node2Distance.put(node, distance);
            TreeSet<TypeNode> set = distance2Node.get(distance);
            if (set == null)
            {
                set = new TreeSet<>();
                distance2Node.put(distance, set);
            }
            set.add(node);
        }

        private static <TypeNode> void remove(Map<TypeNode, Long> node2Distance, Map<Long, TreeSet<TypeNode>> distance2Node, TypeNode node)
        {
            Long distance = node2Distance.remove(node);
            if (distance != null)
            {
                TreeSet<TypeNode> set = distance2Node.get(distance);
                set.remove(node);
                if (set.isEmpty())
                {
                    distance2Node.remove(distance);
                }
            }
        }

        public static <TypeNode extends Node<TypeNode, TypeEdge>, TypeEdge extends Edge<TypeNode, TypeEdge>> Map<TypeNode, Long> distanceMinimum(Function<TypeEdge, Long> functionDistance, TypeNode nodeStart)
        {
            Map<TypeNode, Long> result = new TreeMap<>();
            TreeMap<Long, TreeSet<TypeNode>> distance2Node = new TreeMap<>();
            Map<TypeNode, Long> node2Distance = new TreeMap<>();
            add(node2Distance, distance2Node, nodeStart, 0L);
            while (!distance2Node.isEmpty())
            {
                long distance = distance2Node.firstKey();
                TypeNode node = distance2Node.get(distance).first();
                remove(node2Distance, distance2Node, node);
                result.put(node, distance);
                for (Map.Entry<TypeNode, TypeEdge> entry : node.edges.entrySet())
                {
                    Node nodeProcessing = entry.getKey();
                    long distanceProcessing = distance + functionDistance.apply(entry.getValue());
                    if (!result.containsKey(entry.getKey()))
                    {
                        Long distanceCurrent = node2Distance.get(nodeProcessing);
                        if (distanceCurrent == null)
                        {
                            add(node2Distance, distance2Node, entry.getKey(), distanceProcessing);
                        }
                        else
                        {
                            if (distanceProcessing < distanceCurrent)
                            {
                                remove(node2Distance, distance2Node, entry.getKey());
                                add(node2Distance, distance2Node, entry.getKey(), distanceProcessing);
                            }
                        }
                    }
                }
            }
            return result;
        }

        public static <TypeNode extends Node<TypeNode, TypeEdge>, TypeEdge extends Edge<TypeNode, TypeEdge>> List<TypeEdge> shortestPath(Function<TypeEdge, Long> functionDistance, TypeNode nodeStart, TypeNode nodeEnd)
        {
            Stack<TypeEdge> result;
            Map<TypeNode, Long> node2DistanceMinimum = distanceMinimum(functionDistance, nodeEnd);
            if (node2DistanceMinimum.get(nodeStart) == null)
            {
                result = null;
            }
            else
            {
                result = new Stack<>();
                while (nodeEnd != nodeStart)
                {
                    Map.Entry<TypeNode, TypeEdge> entryNext = null;
                    for (Map.Entry<TypeNode, TypeEdge> entry : nodeStart.edges.entrySet())
                    {
                        if (entryNext == null || node2DistanceMinimum.get(entry.getKey()) + functionDistance.apply(entry.getValue()) < node2DistanceMinimum.get(entryNext.getKey()) + functionDistance.apply(entryNext.getValue()))
                        {
                            entryNext = entry;
                        }
                    }
                    result.push(entryNext.getValue());
                    nodeStart = entryNext.getKey();
                }
            }
            return result;
        }
    }

    public static abstract class Edge<TypeNode extends Node<TypeNode, TypeEdge>, TypeEdge extends Edge<TypeNode, TypeEdge>> implements Comparable<Edge<TypeNode, TypeEdge>>
    {
        public final TypeNode nodeFrom;
        public final TypeNode nodeTo;

        public Edge(TypeNode nodeFrom, TypeNode nodeTo)
        {
            this.nodeFrom = nodeFrom;
            this.nodeTo = nodeTo;
        }

        public abstract TypeEdge getThis();

        @Override
        public int compareTo(Edge<TypeNode, TypeEdge> that)
        {
            int result = this.nodeFrom.compareTo(that.nodeFrom);
            if (result == 0)
            {
                result = this.nodeTo.compareTo(that.nodeTo);
            }
            return result;
        }
    }

    public static abstract class EdgeDirected<TypeNode extends Node<TypeNode, TypeEdge>, TypeEdge extends EdgeDirected<TypeNode, TypeEdge>> extends Edge<TypeNode, TypeEdge>
    {
        public EdgeDirected(TypeNode nodeFrom, TypeNode nodeTo)
        {
            super(nodeFrom, nodeTo);
            nodeFrom.addEdge(getThis());
        }
    }

    public static abstract class EdgeUndirected<TypeNode extends Node<TypeNode, TypeEdge>, TypeEdge extends EdgeUndirected<TypeNode, TypeEdge>> extends Edge<TypeNode, TypeEdge>
    {
        public EdgeUndirected(TypeNode nodeFrom, TypeNode nodeTo)
        {
            super(nodeFrom, nodeTo);
            nodeFrom.addEdge(getThis());
            nodeTo.addEdge(getThis());
        }
    }

    public static class NodeUndirectedDefault extends Node<NodeUndirectedDefault, EdgeUndirectedDefault>
    {
        public NodeUndirectedDefault(int number)
        {
            super(number);
        }
    }

    public static class EdgeUndirectedDefault extends EdgeUndirected<NodeUndirectedDefault, EdgeUndirectedDefault>
    {
        public long weight;

        public EdgeUndirectedDefault(NodeUndirectedDefault nodeFrom, NodeUndirectedDefault nodeTo, long weight)
        {
            super(nodeFrom, nodeTo);
            this.weight = weight;
        }

        @Override
        public EdgeUndirectedDefault getThis()
        {
            return this;
        }
    }

    public static void solve() throws IOException
    {
        int n = nextInt();
        int m = nextInt();
        int L = nextInt();
        int s = nextInt();
        int t = nextInt();
        NodeUndirectedDefault[] nodes = new NodeUndirectedDefault[n];
        for (int index = 0; index < n; index++)
        {
            nodes[index] = new NodeUndirectedDefault(index);
        }
        EdgeUndirectedDefault[] edges = new EdgeUndirectedDefault[m];
        for (int index = 0; index < m; index++)
        {
            int u = nextInt();
            int v = nextInt();
            int w = nextInt();

            NodeUndirectedDefault nodeU = nodes[u];
            NodeUndirectedDefault nodeV = nodes[v];
            EdgeUndirectedDefault edge = new EdgeUndirectedDefault(nodeU, nodeV, w);
            edges[index] = edge;
        }
        NodeUndirectedDefault nodeS = nodes[s];
        NodeUndirectedDefault nodeT = nodes[t];
        Map<NodeUndirectedDefault, Long> node2DistanceMinimum = Node.distanceMinimum(edge -> edge.weight == 0 ? 1 : edge.weight, nodeT);
        Map<NodeUndirectedDefault, Long> node2DistanceMaximum = Node.distanceMinimum(edge -> edge.weight == 0 ? INFINITE : edge.weight, nodeT);
        if (node2DistanceMinimum.get(nodeS) != null && node2DistanceMinimum.get(nodeS) <= L && L <= node2DistanceMaximum.get(nodeS))
        {
            List<EdgeUndirectedDefault> path = Node.shortestPath(edge -> edge.weight == 0 ? 1 : edge.weight, nodeS, nodeT);
            TreeSet<EdgeUndirectedDefault> edgesZeroOnPath = new TreeSet<>();
            for (EdgeUndirectedDefault edge : path)
            {
                if (edge.weight == 0)
                {
                    edgesZeroOnPath.add(edge);
                }
            }
            for (EdgeUndirectedDefault edge : edges)
            {
                if (edge.weight == 0 && !edgesZeroOnPath.contains(edge))
                {
                    edge.weight = INFINITE;
                }
            }
            while (node2DistanceMinimum.get(nodeS) - edgesZeroOnPath.size() < L)
            {
                EdgeUndirectedDefault edgeZero = edgesZeroOnPath.first();
                edgeZero.weight = 1 + L - node2DistanceMinimum.get(nodeS);
                node2DistanceMinimum = Node.distanceMinimum(edge -> edge.weight == 0 ? 1 : edge.weight, nodeT);
                path = Node.shortestPath(edge -> edge.weight == 0 ? 1 : edge.weight, nodeS, nodeT);
                edgesZeroOnPath = new TreeSet<>();
                for (EdgeUndirectedDefault edge : path)
                {
                    if (edge.weight == 0)
                    {
                        edgesZeroOnPath.add(edge);
                    }
                }
                for (EdgeUndirectedDefault edge : edges)
                {
                    if (edge.weight == 0 && !edgesZeroOnPath.contains(edge))
                    {
                        edge.weight = INFINITE;
                    }
                }
            }
            out.println("YES");
            for (int index = 0; index < m; index++)
            {
                EdgeUndirectedDefault edge = edges[index];
                out.print(edge.nodeFrom.number);
                out.print(" ");
                out.print(edge.nodeTo.number);
                out.print(" ");
                out.print(edge.weight == 0 ? INFINITE : edge.weight);
                out.println();
            }
        }
        else
        {
            out.println("NO");
        }
    }
}