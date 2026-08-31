import java.io.*;
import java.util.*;
import java.util.regex.*;
public class vk18
{
    public static void main(String[]stp) throws Exception
    {
    	Scanner scan=new Scanner(System.in);
    	PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long ax=Long.parseLong(st.nextToken()),ay=Long.parseLong(st.nextToken()),bx=Long.parseLong(st.nextToken()),by=Long.parseLong(st.nextToken()),cx=Long.parseLong(st.nextToken()),cy=Long.parseLong(st.nextToken());
        //pw.println(ax+" "+ay+" "+bx+" "+by+" "+cx+" "+cy);
        if(ax-bx == bx-cx && ay-by == by-cy) pw.write("No");
        else 
        {
        	if(   (ax-bx)*(ax-bx)  +  (ay-by)*(ay-by) == (bx-cx)*(bx-cx) + (by-cy)*(by-cy)  ) pw.write("Yes");
        	else pw.write("No");
        }
    	pw.flush();

    }

    
}