import java.io.*;
import java.util.*;
public class MainClass {
    public static void main(String[] args) throws IOException {
        int t,s,x ,temp,count=0,test=0;

       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        //t = Integer.parseInt(str);

        Scanner input = new Scanner(System.in);
        t = input.nextInt();
        s = input.nextInt();
        //String[] arr;
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[t];
        for(int i=0 ; i < t ; i++)
        {
            x = input.nextInt();
            arr[i] = x;
            for(int j=0 ; j < x; j++)
            {
                temp =input.nextInt();
                list.add(temp);
            }
        }
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=0 ; i < list.size() ; i++)
        {
            x = list.get(i);
            if(list2.isEmpty())
            {
                list2.add(x);
                count++;
            }
            else
            {
                for(int j=0 ; j < list2.size() ; j++)
                {
                    if(list2.get(j) == x)
                        test++;
                }
                if(test == 0)
                {
                    list2.add(x);
                    count++;

                }
                test=0;
            }



        }

        if(count == s)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
