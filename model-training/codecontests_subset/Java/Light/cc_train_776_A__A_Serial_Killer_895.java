import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
			String v[]= new String[2];
			v[0]=in.next();
			v[1]=in.next();
			int day = in.nextInt();
			String t;
			System.out.println(v[0]+" "+v[1]);
			for(int i=0;i<day;i++)
			{
				t=in.next();
				if(t.equals(v[0]))
					v[0]=in.next();
				else v[1]=in.next();
				System.out.println(v[0]+" "+v[1]);
			}
		}
	}

}
	 		 		    	  			    	 	   	 		