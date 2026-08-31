
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner s=new Scanner (System.in);
		int peopleinchat=0;
		long totaltraffic=0;
		HashMap<String ,Integer> db=new HashMap<>();
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String str=reader.readLine();
		
		while(str!=null)
		{
			if(str.charAt(0)=='+') {
				String tempname=str.substring(1, str.length());
				db.put(tempname, 0);
				peopleinchat++;
			}
			else if(str.charAt(0)=='-') {
				String tempname =str.substring(1,str.length());
				if(db.containsKey(tempname)){
					db.remove(tempname);
					peopleinchat--;
				}
			}
			else
			{
				String tempname="";
				for(int i=0;i<str.length();i++)
				{
					if(str.charAt(i)!=':')
					{
						tempname+=str.charAt(i);
					}
					else 
					{
						break;
					}
				}
				totaltraffic+=((str.length()-tempname.length()-1)*peopleinchat);
			}
			str="";
			str=reader.readLine();
		}
		System.out.println(totaltraffic);
	}

}
