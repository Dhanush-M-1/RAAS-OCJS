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
        int n=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken()),p=0,i=0;
        ArrayList<Integer> []al=new ArrayList[200001];
        int count=0;
        for(i=0;i<=200000;i++) { al[i]=new ArrayList<Integer>(); }
        st=new StringTokenizer(br.readLine());
        for(i=0;i<n;i++)
        {
        	p=Integer.parseInt(st.nextToken());
        	count=0; 
        	while(p != 0)
        	{
        		al[p].add(count);
        		count++;
        		p/=2;
        	}
        }
       	int min=Integer.MAX_VALUE;
        for(i=0;i<200001;i++)
        {
        	Collections.sort(al[i]);
        	if(al[i].size() < k) continue;
        	int j=0; count=0;
        	while(j < k){ count+=al[i].get(j); j++; }
        	min=Math.min(min,count);
        }
        pw.print(min);
        pw.flush();
   	}

}