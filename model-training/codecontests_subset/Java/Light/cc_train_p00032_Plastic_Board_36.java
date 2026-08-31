import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		String t;
		int c=0,h=0;
		int[] p = new int[5];
		while((t=bf.readLine())!=null){
			String[] d=t.split(",");
			for(int i=0;i<3;i++)p[i]=Integer.parseInt(d[i]);
			p[3]=p[0]*p[0]+p[1]*p[1];p[4]=p[2]*p[2];
			if(p[3]==p[4])c++;
			if(p[0]==p[1])h++;
		}
		System.out.println(c);
		System.out.println(h);
	}
}