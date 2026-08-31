 //   package com.company;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.math.BigInteger;
    //import java.nio.file.Paths;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            // write your code here
            // BufferedReader s=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader s=new BufferedReader(new InputStreamReader(System.in));    StringBuilder sb = new StringBuilder();
      //   Scanner s=new Scanner(System.in);
         int t=Integer.parseInt(s.readLine());

         while(t-->0){
             String[] str=s.readLine().trim().split("\\s+");
             int l=Integer.parseInt(str[0]);int r=Integer.parseInt(str[1]);int x=Integer.parseInt(str[2]);
             long a=x;
         if(a>=l){
             a=(r/x+1)*x;
         }
             System.out.println(a);
         }
        }static int[] vis;
static int count;
static int[] flag;
static int another;
static int connected;static int huf=0;
static void dfs(int i,LinkedList<Integer> [] adj){
    connected++;
vis[i]=1;if(flag[i]==1) count++;
if(adj[i]!=null){
    for(int j:adj[i]){
        if(vis[j]==0){
            if(flag[i]==0) flag[j]=1; else flag[j]=0;

            dfs(j,adj);
    } else{
            if(flag[i]==flag[j]){
                huf=1;
            }
        }


    }}else{another++;}//return count;
}






      static  Boolean isCyclicUtil(int v, Boolean visited[], int parent,LinkedList[] adj)
        {
            // Mark the current node as visited
            visited[v] = true;
            Integer i;

            // Recur for all the vertices adjacent to this vertex
           if(adj[v]!=null){
            Iterator<Integer> it = adj[v].iterator();
            while (it.hasNext())
            {
                i = it.next();

                // If an adjacent is not visited, then recur for that
                // adjacent
                if (!visited[i])
                {
                    if (isCyclicUtil(i, visited, v,adj))
                        return true;
                }

                // If an adjacent is visited and not parent of current
                // vertex, then there is a cycle.
                else if (i != parent)
                    return true;
            }}
            return false;
        }

        // Returns true if the graph contains a cycle, else false.
        static Boolean isCyclic(int V,LinkedList<Integer>[] adj)
        {
            // Mark all the vertices as not visited and not part of
            // recursion stack
            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper function to detect cycle in
            // different DFS trees
            for (int u = 0; u < V; u++)
                if (!visited[u]) // Don't recur for u if already visited
                    if (isCyclicUtil(u, visited, -1,adj))
                        return true;

            return false;
        }

    }

    class Student
    {
        int rollno;
        int color;

        // Constructor
        public Student(int rollno, int color)
        {
            this.rollno = rollno;

            this.color=color;}
        // Used to print student details in main()
        public String toString()
        {
            return this.rollno + " " ;
        }
    }

    class Sortbyroll implements Comparator<Student>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Student a, Student b)
        {
            return a.color - b.color;
        }
    }

