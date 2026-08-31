
//tanku short phrase
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		int phrase_counter = 0;
//		int temp=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		int word_num = Integer.parseInt(br.readLine());
		if(word_num == 0) {return;}
		int[] sec = new int[word_num];

//		int flag = 0;
//		int setlength;
//		int count = 0;
//		int loc = 0;

		for(int i=0;i<word_num;i++) {
			sec[i] = br.readLine().length();
		}

		int set=0;

		int rui =0;
		for(int j=0;j<word_num;j++) {
//		count = j;
			if(set != 5) {
				set = 0;
				rui=0;
			}else {
				break;
			}
		for(int i=j;i<word_num;i++) {
			rui += sec[i];
			if(rui < 5) {
				continue;
			}
			if(set==0&&rui > 5) {
				break;
			}
			if(rui == 5) { set++; }
			if(rui < 12) {
				continue;
			}
			if(set==1&&rui > 12) {
				break;
			}
			if(rui == 12) { set++; }
			if(rui < 17) {
				continue;
			}
			if(set==2&&rui > 17) {
				break;
			}
			if(rui == 17) { set++; }
			if(rui < 24) {
				continue;
			}
			if(set==3&&rui > 24) {
				break;
			}
			if(rui == 24) { set++; }
			if(rui < 31) {
				continue;
			}
			if(set==4&&rui > 31) {
				break;
			}
			if(rui == 31) {
				set++;
			System.out.println(j+1);
			break;
			}
		}





		}

		}

	}

}

