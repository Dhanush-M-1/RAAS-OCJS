import java.util.*;
public class Test
{
    public static void main(String[] args)
    {
        int temp;
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        ArrayList<Integer> a=new ArrayList<Integer>();
        StringTokenizer st=new StringTokenizer(s,"+");
        while(st.hasMoreTokens())
        {
            String k=st.nextToken();
            a.add(Integer.parseInt(k));
       
        for(int i=0;i<a.size();i++)
        {
            for(int j=0;j<a.size();j++)
            {
                if(a.get(i)<a.get(j))
                {
                    temp=a.get(i);
                    a.set(i,a.get(j));
                    a.set(j,temp);
                }
            }
        }
        }
        for(int i=0;i<a.size()-1;i++)
        {
            System.out.print(a.get(i)+"+");
        }
        System.out.print(a.get(a.size()-1));
    }
}