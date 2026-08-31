import java.io.*;

public class Chat {
	public static void main(String args[])  {
		int usrCount=0;
		String input;
		int traffic=0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try{
			input=in.readLine();
			while(input!=null){
				//System.out.println("*"+input.indexOf(0));
				
				if(input.charAt(0)=='+') {
					usrCount=usrCount+1;
				}
				else if(input.charAt(0)=='-') {
					usrCount=usrCount-1;
				}
				else {
					String a[]=input.split(":");
					if(input.indexOf(":")!=input.length()-1)
					{
					   // System.out.println(a[0]+" "+a[1]);
					    //if(a[1].isEmpty())
					    traffic=traffic+(a[1].length())*usrCount;
					}
				}
				input=in.readLine();
				//System.out.println("***"+input);
			
		    }
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}
		System.out.println(traffic);
	}
}
