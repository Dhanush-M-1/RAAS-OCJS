import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    
    public static void main(String[] args) throws NumberFormatException, IOException {
        

        
                
    BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pr=new PrintWriter(System.out);


   

String s;
int count=0;
int bytes=0;
while(true)
{
	 s=r.readLine();
	 
	if(s==null)
		break;
	
	if(s.charAt(0)=='+')
	{
		count++;
	}
	else
		if(s.charAt(0)=='-')
		{
			count--;
		}
		else
		{
			String st[]=s.split(":");
			if(st.length==2)
			bytes+=s.split(":")[1].length()*count;
			
		}
}
pr.println(bytes);

pr.flush();
pr.close();

    }
}