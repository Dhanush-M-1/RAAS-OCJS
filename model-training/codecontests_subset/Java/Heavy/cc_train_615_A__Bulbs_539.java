import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
//import java.util.Arrays;
import java.util.Collections;
public class BCF615A {
    public static void main(String[]rags)throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
            String s[]=br.readLine().split(" ");
            int b=Integer.parseInt(s[0]);
            int a=Integer.parseInt(s[1]);
           LinkedList arr=new LinkedList();
            int t=0;
            int k=1;
            for(int j=0;j<b;j++)
            {
                String s1[]=br.readLine().split(" ");
                int ar[]=new int[s1.length];
                for(int i=1;i<s1.length;i++)
                arr.add(Integer.parseInt(s1[i]));
            }
            //System.out.println(arr);
           Collections.sort(arr);
           //System.out.println(arr);
          for(int i=0;i<arr.size()-1;i++)
            {  //System.out.println(arr);
               Integer a1 = (int)arr.get(i+1);
            Integer a2 = (int) arr.get(i);
            if (a1.equals(a2)) {
                arr.remove(i);i--;
            }
            }
          //System.out.println(arr);
          //System.out.println(arr.size());
             if(arr.size()!=a)   
            System.out.println("NO");
             else
                 System.out.println("YES");
        }  
}
