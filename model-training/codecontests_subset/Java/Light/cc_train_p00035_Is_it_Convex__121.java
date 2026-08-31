import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		String t;
		double[] p = new double[12];
		double s,r;
		while((t=bf.readLine())!=null){
			String[] d=t.split(",");
			for(int i=0;i<8;i++)p[i]=Double.parseDouble(d[i]);
			for(int i=0;i<4;i++)p[i+8]=p[i];
			s=((p[3]-p[1])*(p[2]-p[4])-(p[2]-p[0])*(p[3]-p[5]));
			for(int i=4;i<=8;i+=2){
				r=((p[i+1]-p[i-1])*(p[i]-p[i+2])-(p[i]-p[i-2])*(p[i+1]-p[i+3]));
				if(s*r<0){System.out.println("NO");break;}
				if(i==8)System.out.println("YES");
			}
		}
	}
}