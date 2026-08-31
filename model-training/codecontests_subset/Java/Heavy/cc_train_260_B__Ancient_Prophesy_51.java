import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class AncientProphesy 
{
	public static int count(final String string, final String substring)
	{
	     int count = 0;
	     int idx = 0;
	     while ((idx = string.indexOf(substring, idx)) != -1)
	     {
	        idx++;
	        count++;
	     }

	     return count;
	}
	public static void main(String args[])
	{
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		scn.close();
		PrintWriter pw = new PrintWriter(System.out);
		int c = 0;
		StringBuilder sb = new StringBuilder();
		int max = Integer.MIN_VALUE;
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
	    GregorianCalendar cal=new GregorianCalendar();
	    int year;
	    for(year = 2013;year <= 2015; year++)
	    {
	    	cal.set(Calendar.YEAR, year);
		    for(int d=1; d <= 365; d++) 
		    {
		        cal.set(Calendar.DAY_OF_YEAR, d);
		        Date date = cal.getTime();
		        c = count(s,formatter.format(date));
		        if(c > max)
		        {
		        	max = c;
		        	sb.setLength(0);
		        	sb.append(formatter.format(date));
		        }
		    }
	    }
	    pw.println(sb);
		pw.close();
	}
}