//created by Whiplash99
import java.io.*;
import java.util.*;
public class E
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i,N;

        String s[]=br.readLine().trim().split(" ");
        N=Integer.parseInt(s[0]);
        int K=Integer.parseInt(s[1]);

        int a=0,b=0;
        PriorityQueue<Integer> both=new PriorityQueue<>();
        PriorityQueue<Integer> alice=new PriorityQueue<>();
        PriorityQueue<Integer> bob=new PriorityQueue<>();

        for(i=0;i<N;i++)
        {
            s=br.readLine().trim().split(" ");
            int t=Integer.parseInt(s[0]);
            int u=Integer.parseInt(s[1]);
            int v=Integer.parseInt(s[2]);

            if(u+v==0) continue;
            if(u+v==2)
            {
                a++;
                b++;
                both.add(t);
            }
            else if(u==1)
            {
                a++;
                alice.add(t);
            }
            else
            {
                b++;
                bob.add(t);
            }
        }

        if(a<K||b<K)
        {
            System.out.println(-1);
            System.exit(0);
        }

        i=K; int j=K;
        long ans=0;
        while (i>0&&j>0&&!both.isEmpty())
        {
            if(alice.size()<i||bob.size()<j)
            {
                ans+=both.poll();
                i--;
                j--;
                continue;
            }
            int tmp=both.peek();
            int tmp2=alice.peek();
            int tmp3=bob.peek();

            if(tmp2+tmp3<tmp) ans+=alice.poll()+bob.poll();
            else ans+=both.poll();
            i--;
            j--;
        }
        while (i>0)
        {
            if(both.isEmpty()) ans+=alice.poll();
            else if(alice.isEmpty())
            {
                ans += both.poll();
                j--;
            }
            else if(alice.peek()<both.peek()) ans+=alice.poll();
            else
            {
                ans += both.poll();
                j--;
            }
            i--;
        }
        while (j>0)
        {
            if(both.isEmpty()) ans+=bob.poll();
            else if(bob.isEmpty()) ans+=both.poll();
            else if(bob.peek()<both.peek()) ans+=bob.poll();
            else ans+=both.poll();
            j--;
        }
        System.out.println(ans);
    }
}