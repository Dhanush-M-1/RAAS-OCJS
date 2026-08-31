import java.io.*;
public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		int lectcnt=0;
		int diacnt=0;
		while(str!=null){
			String[] lengthstr=str.split(",");
			int[] length=new int[3];
			for(int i=0;i<3;i++)
				length[i]=Integer.parseInt(lengthstr[i]);
			if(Math.pow(length[0], 2)+Math.pow(length[1],2)==Math.pow(length[2],2))
				lectcnt++;
			if(length[0]==length[1])
				diacnt++;
			str=br.readLine();
		}
		System.out.println(lectcnt);
		System.out.println(diacnt);
	}

}