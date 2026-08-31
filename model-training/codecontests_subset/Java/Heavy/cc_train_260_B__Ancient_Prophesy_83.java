import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB
{

    public void solve(int testNumber, InputReader in, PrintWriter out)
    {
        String s = in.nextLine();
        final int daysOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
        HashMap<String,Integer> map=new HashMap<String, Integer>();
        for (int idx = 0; idx+9 < s.length(); ++idx)
        {
            if (Character.isDigit(s.charAt(idx)) &&
                    Character.isDigit(s.charAt(idx+1)) &&
                    s.charAt(idx+2)=='-' &&
                    Character.isDigit(s.charAt(idx+3)) &&
                    Character.isDigit(s.charAt(idx+4)) &&
                    s.charAt(idx+5)=='-' &&
                    Character.isDigit(s.charAt(idx+6)) &&
                    Character.isDigit(s.charAt(idx+7)) &&
                    Character.isDigit(s.charAt(idx+8)) &&
                    Character.isDigit(s.charAt(idx+9))) {

                int year=Integer.parseInt(s.substring(idx+6,idx+10));
                int month=Integer.parseInt(s.substring(idx+3,idx+5));
                int day=Integer.parseInt(s.substring(idx,idx+2));
                if(year>=2013 && year<=2015 && month>=1 && month<=12 && day>0 && day<=daysOfMonth[month-1]) {
                    String date=s.substring(idx,idx+10);
                    int oldvalue=0;
                    if(map.containsKey(date)) {
                        oldvalue=map.get(date);
                    }
                    map.put(date,oldvalue+1);
                }
            }

        }
        String curDate="";
        int curValue=0;
        for(String date:map.keySet()) {
            if(map.get(date) >curValue) {
                curValue=map.get(date);
                curDate=date;
            }
        }
        out.println(curDate);
    }
}

class InputReader {
    BufferedReader in;
    public InputReader(InputStream ins)
    {
        in = new BufferedReader(new InputStreamReader(ins));
    }

    public String nextLine()  {
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return "";
    }

}

