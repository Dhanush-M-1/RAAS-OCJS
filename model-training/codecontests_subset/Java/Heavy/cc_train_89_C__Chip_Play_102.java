import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class CodeforcesA
{

    /**
     * @param args
     */
    Scanner inp;
    PrintWriter out;

    int n, m;

    int num(int x, int y)
    {
        return m * y + x;
    }

    class Item
    {
        int x, y;
        int u, d, l, r;
        char type;

        public Item(int x, int y, char type)
        {
            this.x = x;
            this.y = y;
            u = -1;
            d = -1;
            l = -1;
            r = -1;
            this.type = type;
        }

        public Item(int x, int y, char type, int u, int d, int l, int r)
        {
            this.x = x;
            this.y = y;
            this.type = type;
            this.u = u;
            this.d = d;
            this.l = l;
            this.r = r;
        }

        int next()
        {
            if (type == 'U')
                return u;
            if (type == 'D')
                return d;
            if (type == 'L')
                return l;
            return r;
        }

        Item me()
        {
            return new Item(x, y, type, u, d, l, r);
        }
    }

    void run() throws Exception
    {
        inp = new Scanner(System.in);
        out = new PrintWriter(System.out);

        n = inp.nextInt();
        m = inp.nextInt();
        String[] area = new String[n];
        for (int i = 0; i < n; i++)
            area[i] = inp.next();

        Item[] all = new Item[n * m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (area[i].charAt(j) != '.')
                {
                    all[num(j, i)] = new Item(j, i, area[i].charAt(j));
                    for (int k = i - 1; k >= 0; k--)
                        if (area[k].charAt(j) != '.')
                        {
                            all[num(j, i)].u = num(j, k);
                            break;
                        }
                    for (int k = i + 1; k < n; k++)
                        if (area[k].charAt(j) != '.')
                        {
                            all[num(j, i)].d = num(j, k);
                            break;
                        }

                    for (int k = j - 1; k >= 0; k--)
                        if (area[i].charAt(k) != '.')
                        {
                            all[num(j, i)].l = num(k, i);
                            break;
                        }
                    for (int k = j + 1; k < m; k++)
                        if (area[i].charAt(k) != '.')
                        {
                            all[num(j, i)].r = num(k, i);
                            break;
                        }

                }

        Item[] tmp = new Item[n * m];
        int max = 0;
        int count = 0;
        for (int i = 0; i < n * m; i++)
            if (all[i] != null)
            {
                for (int j = 0; j < n*m; j++)
                    if (all[j] != null) tmp[j] = all[j].me();
                    else tmp[j] = null;
                

                int now = i;
                int ansfor = 0;

                while (now != -1)
                {
                    ansfor++;
                    if (tmp[now].u != -1)
                        tmp[tmp[now].u].d = tmp[now].d;
                    if (tmp[now].d != -1)
                        tmp[tmp[now].d].u = tmp[now].u;
                    if (tmp[now].l != -1)
                        tmp[tmp[now].l].r = tmp[now].r;
                    if (tmp[now].r != -1)
                        tmp[tmp[now].r].l = tmp[now].l;
                    now = tmp[now].next();
                }

                if (ansfor > max)
                {
                    max = ansfor;
                    count = 1;
                } else if (ansfor == max)
                    count++;

            }

        out.print(max + " " + count);

        out.close();
        inp.close();

    }

    public static void main(String[] args) throws Exception
    {
        // TODO Auto-generated method stub
        new CodeforcesA().run();

    }

}
