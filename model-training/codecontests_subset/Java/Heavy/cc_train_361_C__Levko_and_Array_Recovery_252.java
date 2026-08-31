import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt();
        int m=in.nextInt();
        int upperBounds[]=new int[n];
        Arrays.fill(upperBounds,1000000000);
        int currentAdditions[] = new int[n];
        int operationsType[]=new int[m];
        int operationsLeft[]=new int[m];
        int operationsRight[]=new int[m];
        int operationsD[]=new int[m];
        for(int i=0;i<m;i++) {
              operationsType[i]=in.nextInt();
              operationsLeft[i]=in.nextInt()-1;
              operationsRight[i]=in.nextInt()-1;
              operationsD[i]=in.nextInt();
              if(operationsType[i]==1) {
                  for(int j=operationsLeft[i];j<=operationsRight[i];j++) {
                      currentAdditions[j]+=operationsD[i];
                  }
              } else {
                  for(int j=operationsLeft[i];j<=operationsRight[i];j++) {
                      upperBounds[j]=Math.min(upperBounds[j],operationsD[i]-currentAdditions[j]);
                  }
              }

        }

        // validate
        Arrays.fill(currentAdditions,0);
        for(int i=0;i<m;i++) {
            if(operationsType[i]==1) {
                for(int j=operationsLeft[i];j<=operationsRight[i];j++) {
                    currentAdditions[j]+=operationsD[i];
                }
            }
            else
            if(operationsType[i]==2) {
                int max=-1000000000;
                for(int j=operationsLeft[i];j<=operationsRight[i];j++) {
                    max=Math.max(max,upperBounds[j]+currentAdditions[j]);
                }
                if(max!=operationsD[i]) {
                    out.println("NO");
                    return;
                }

            }
        }
        out.println("YES");
        for(int i=0;i<n;i++) {
            if(i!=0)
                out.print(" ");
            out.print(upperBounds[i]);
        }
    }
}

class InputReader {
    StringTokenizer st;
    BufferedReader in;
    public InputReader(InputStream ins)
    {
        in = new BufferedReader(new InputStreamReader(ins));
    }

    public String nextToken()
    {
        while(st==null || !st.hasMoreTokens())
        {
            try {
                st=new StringTokenizer(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return st.nextToken();
    }
    public int nextInt()
    {

        return Integer.parseInt(nextToken());
    }

    }

