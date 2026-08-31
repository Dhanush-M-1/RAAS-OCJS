import java.util.*;
import java.io.*;
public class ReadingBooksEasy {
    public static void main(String agrs[]) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int k = in.nextInt();
        int numa = 0;
        int numb = 0;
        ArrayList<Integer> aO = new ArrayList<Integer>();
        int indexA = 0;
        ArrayList<Integer> bO = new ArrayList<Integer>();
        int indexB = 0;
        ArrayList<Integer> both = new ArrayList<Integer>();
        int indexBoth = 0;
        int totalTime = 0;
        for(int i = 0; i < n; i++)
        {
            int t = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if(a == 1)
            {
                numa++;
                if(b == 1)
                {
                    both.add(t);
                    numb++;
                }
                else
                {
                    aO.add(t);
                }
            }
            else if(b == 1)
            {
                numb++;
                bO.add(t);
            }
        }
        if(numa < k || numb < k)
        {
            out.println(-1);
        }
        else
        {
            Collections.sort(aO);
            Collections.sort(bO);
            Collections.sort(both);
            numa = 0;
            numb = 0;
            while(numa < k || numb < k)
            {
                if(numa >= k)
                {
                    if(bO.size() > 0 && indexB < bO.size())
                    {
                        totalTime += bO.get(indexB);
                        indexB++;
                    }
                    else
                    {
                        totalTime += both.get(indexBoth);
                        indexBoth++;
                        numa++;
                    }
                    numb++;
                }
                else if(numb >= k)
                {
                    if(indexA < aO.size() && aO.size() > 0)
                    {
                        totalTime += aO.get(indexA);
                        indexA++;
                    }
                    else
                    {
                        totalTime += both.get(indexBoth);
                        indexBoth++;
                        numb++;
                    }
                    numa++;
                }
                else
                {
                    if(aO.size() > 0 && bO.size() > 0 && indexA < aO.size() && indexBoth < both.size() && (aO.get(indexA) + bO.get(indexB) < both.get(indexBoth)))
                    {
                        totalTime += aO.get(indexA) + bO.get(indexB);
                        indexA++;
                        indexB++;
                    }
                    else if(indexBoth >= both.size())
                    {
                        totalTime += aO.get(indexA) + bO.get(indexB);
                        indexA++;
                        indexB++;
                    }
                    else
                    {
                        totalTime += both.get(indexBoth);
                        indexBoth++;
                    }
                    numa++;
                    numb++;
                }
            }
            out.println(totalTime);
        }
        out.close();
    }
}
