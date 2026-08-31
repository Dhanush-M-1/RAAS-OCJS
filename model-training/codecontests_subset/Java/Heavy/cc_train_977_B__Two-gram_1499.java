import java.io.*;
public class Twogram {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String S = br.readLine();
        String [] arr = new String[n-1];
        int count = 0, max = 0, index = -1;
        for(int i=0;i<n-1;i++)
        {
            arr[i] = S.substring(i,i+2);
        }
       /* for (String string : arr) {
            System.out.print(string + " ");
        }*/
        for(int i=0;i<arr.length;i++)
        {
            count = count_oc(arr[i],arr);
            //System.out.println(count);
            if (count > max)
            {
                max = count;
                index = i;
            }
        }
        System.out.println(arr[index]);
    }
    static int count_oc(String s,String [] a)
    {
       /* for (String string : a) {
            System.out.print(string + "   ");
        }
        System.out.println(" ");
        System.out.println(s);*/
        int cont = 0;
        for (String string : a) {
            if(string.equals(s))
                cont = cont + 1;
        }
        return cont;
    }
}