import java.util.*;
import java.lang.*;
import java.io.*;

public class Cow_and_poker {

	public static void main(String[] args) throws java.lang.Exception
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine()),c1=0,c2=0,c3=0;
		char c[]=br.readLine().toCharArray();
		for(int i=0; i<t; i++) {
			if(c[i]=='A') ++c1;
			else if(c[i]=='I') ++c2;
		}
		System.out.println(c2==1?1:c2>1?0:c1);
    }

}
