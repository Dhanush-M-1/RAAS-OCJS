import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
 
public class BarktoUnlock
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String password = st.nextToken(); 
		int n = Integer.parseInt(br.readLine());
		
	      boolean ContainFirstLetter = false, ContainSecondLetter = false;	
            for(int i=0; i<n; i++)
            {
                  st = new StringTokenizer(br.readLine());
                  String bark = st.nextToken(); 
                  
                  if(bark.charAt(0) == password.charAt(1))
                        ContainSecondLetter = true;
                  if(bark.charAt(bark.length()-1) == password.charAt(0))
                        ContainFirstLetter = true;
                  if(ContainSecondLetter == true && ContainFirstLetter == true || bark.equals(password))
                  {
                        ContainSecondLetter = true;
                        ContainFirstLetter = true;
                        System.out.println("YES");
                        break;
                  }
            }
            if(ContainSecondLetter == false || ContainFirstLetter == false)
                  System.out.println("NO");
            
	}
}