import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable{
	
	private static String filename;

	public static void main(String[] args){
		if (args.length>0 && args[0].equals("f")) filename = "input.txt";
		else filename = "";
		new Thread(new Main()).start();
	}

    private static void debug(Object ... str){
        for (Object s : str) System.out.print(s + ", ");
        System.out.println();
    }


	public void run(){
		try{
            MyScanner in;
			Locale.setDefault(Locale.US);
			if (filename.length()>0) in = new MyScanner(filename);
			else in = new MyScanner(System.in);
			PrintWriter out = new PrintWriter(System.out);
            long n = in.nextInt();
            long x = in.nextInt();
            long y = in.nextInt();
            long xx = (y*n + 99) / 100 - x;

            if (xx > 0) out.println(xx);
            else out.println(0);
            
            out.close();
			in.close();
			
			
			                                              
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

class MyScanner{
	BufferedReader in;
	StringTokenizer st;

	MyScanner(String file){
	        try{
		in = new BufferedReader(new FileReader(new File(file)));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	MyScanner(InputStream inp){
		try{                                   
                	in = new BufferedReader(new InputStreamReader(inp));
		}catch (Exception e){
			e.printStackTrace();
		}
	}

    void skipLine(){
        st = null;
    }

	boolean hasMoreTokens(){
		String s = null;
		try{
			while ((st==null || !st.hasMoreTokens())&& (s=in.readLine()) != null) st = new StringTokenizer(s);
			if ((st==null || !st.hasMoreTokens())&& s==null) return false;
	        }catch(IOException e){
	        	e.printStackTrace();
	        }
		return true;
	}

	String nextToken(){
		if (hasMoreTokens()){
			return st.nextToken();
		}
		return null;
	}

	int nextInt(){
		return Integer.parseInt(nextToken());
	}

	long nextLong(){
		return Long.parseLong(nextToken());
	}

	double nextDouble(){
		return Double.parseDouble(nextToken());
	}


	String nextString(){
		return nextToken();
	}
	void close(){
		try{
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}





