import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	static Main main;

	public static void main(String[] args) {
		main = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		String eol = System.getProperty("line.separator");
		byte[] eolb = eol.getBytes();
		byte[] spaceb = " ".getBytes();
		try {
			String str = br.readLine();
			int n = Integer.parseInt(str);
			int n1 = 0;
			int n2 = 0;
			str = br.readLine();
			int j=0;
			int s=0;
			int k =0;
			int length = str.length();
			while(j<length) {
				while(j<length) {
					if(str.charAt(j) == ' ') {
						break;
					}else {
						j++;
					}
				}
				int x = Integer.parseInt(str.substring(s,j)) ;	
				if(x==100) {
					n1++;
				}else {
					n2++;
				}
				k++;
				j++;
				s=j;			
			}
			boolean pos = false;
			if((n2%2)==0) {
				if((n1%2)==0) {
					pos = true;
				}
			} else if(n1>=2){
				if((n1%2)==0) {
					pos = true;
				}
			}
			if(pos) {
				bos.write("YES".getBytes());
			} else {
				bos.write("NO".getBytes());
			}
			bos.write(eolb);
			bos.flush();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
