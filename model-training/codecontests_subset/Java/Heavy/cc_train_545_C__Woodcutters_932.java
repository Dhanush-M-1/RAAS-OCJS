import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        ArrayList<Integer> pos=new ArrayList<>();
        int count=2;
        ArrayList<Integer> height=new ArrayList<>();
        for(int i=0;i<t;i++)
        {
            String str[]=br.readLine().split(" ");
            pos.add(Integer.parseInt(str[0]));
            height.add(Integer.parseInt(str[1]));
        }
        if(pos.size()==1)
        {

            System.out.println(1);
            return;
        }
        else if(pos.size()==2)
        {
            System.out.println(2);
            return;
        }
        else
        {
            for(int i=1;i<pos.size()-1;i++)
            {
                if(pos.get(i)-height.get(i)>pos.get(i-1))
                {
                    count+=1;
                }
                else if(pos.get(i)+height.get(i)<pos.get(i+1))
                {
                    pos.set(i,(pos.get(i)+height.get(i)));
                    count+=1;
                }

            }
            System.out.println(count);

        }

    }
}
