import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main implements Runnable {
    
    private String s;

    public static void main(String[] args) throws IOException {
        Main m = new Main();
	m.run();
    }

    private void set() {
	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	    s = br.readLine();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void run() {
	set();
	if (s.contains("keyence")) {
	    System.out.println("YES");
	    System.exit(0);
	}
	int len = s.length();
	for (int i=1;i<=6;i++) {
	    String t = s.substring(0,i) + s.substring(len-7+i,len);
	    if (t.equals("keyence")) {
		System.out.println("YES");
		System.exit(0);
	    }
	}
	System.out.println("NO");
    }

}