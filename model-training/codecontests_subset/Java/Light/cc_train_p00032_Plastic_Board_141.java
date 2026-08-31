import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		int hishi = 0;
		int chouhou = 0;
		while((str = br.readLine()) != null) {
			int cPos = str.indexOf(",");
			int prevPos = cPos;

			int width = Integer.parseInt(str.substring(0, cPos));
			
			cPos = str.indexOf(",", cPos+1);
			int height = Integer.parseInt(str.substring(prevPos+1, cPos));
			if(width == height) {
				hishi++; continue;
			}
			int diagonal = Integer.parseInt(str.substring(cPos+1));
			
			if(width*width + height*height == diagonal*diagonal) chouhou++;
		}
		System.out.println(chouhou);
		System.out.println(hishi);
	}
}