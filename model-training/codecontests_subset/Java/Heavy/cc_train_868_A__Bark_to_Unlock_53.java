import java.util.*;
/**
 * Created by CUONG on 10/7/2017.
 */
public class PS868A {
    public static void main(String[] args)
    {
        Scanner s= new Scanner(System.in);
        String pass= s.nextLine(); boolean poss=false;
        int n= Integer.parseInt(s.nextLine());
        String[] arr= new String[n];
        StringBuilder sb= new StringBuilder();
        for (int i=0; i<n; i++)
        {
            sb.delete(0,sb.length());
           arr[i]= s.nextLine();
           sb.append(arr[i]);
           if (sb.reverse().toString().equals(pass)) poss=true;
        }


        for (int i=0; i<n; i++)
        {
            if (poss) break;

            for (int j=0; j<n; j++)
            {
                String temp="";
                temp+=arr[i];

                if (i!=j) temp+=arr[j];
                if (temp.indexOf(pass)!=-1) {poss=true; break;}
            }

        }
        if (poss) System.out.println("YES");
        else System.out.println("NO");
    }
}
