import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MainB {

    public static void main(String[] args) throws Exception {
    	String pattern = "\\d{2}-\\d{2}-\\d{4}";
    	BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    	String line = buffer.readLine();
    	Pattern p = Pattern.compile(pattern);
    	Matcher m = p.matcher(line);
    	TreeMap<String, Integer> map = new TreeMap<String, Integer>();
    	Vector<String> list = new Vector<String>();
    	int index = 0;
    	while(m.find()) {
    		String temp = m.group();
    		line = line.substring(m.end()-8);
    		m = p.matcher(line);
    		int year = Integer.parseInt(temp.substring(6));
    		if(year < 2013 || year > 2015)
    			continue;
    		int month = Integer.parseInt(temp.substring(3, 5));
    		int day = Integer.parseInt(temp.substring(0, 2));
    		if(month == 2)
    			if(day <= 0 || day > 28)
    				continue;
    		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
    			if(day <= 0 || day > 31)
    				continue;
    		if(month == 4 || month == 6 || month == 9 || month == 11)
    			if(day <= 0 || day > 30)
    				continue;
    		Calendar c = Calendar.getInstance();
    		c.setLenient(false);
    		try {
    			c.set(year, month, day);
	    		if(map.containsKey(temp)) {
	    			map.put(temp, map.get(temp)+1);
	    		}
	    		else {
	    			list.addElement(temp);
	    			map.put(temp, 1);
	    		}
    		}
    		catch(Exception e) {
    			continue;
    		}
    	}
    	int high = map.get(list.elementAt(0));
    	String ans = list.elementAt(0);
    	for(int i=1; i<list.size(); i++) {
    		if(map.get(list.elementAt(i)) > high) {
    			ans = list.elementAt(i);
    			high = map.get(list.elementAt(i));
    		}
    	}
    	System.out.println(ans);
    }
}
