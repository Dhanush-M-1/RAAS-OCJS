import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int hour = 0, min = 0, sec = 0;
		while(true){
			String[] input = br.readLine().split(" ");
			hour = Integer.parseInt(input[0]);
			min = Integer.parseInt(input[1]);
			sec = Integer.parseInt(input[2]);
			if( hour == -1 && min == -1 && sec == -1)	break;
			Tape t = new Tape(hour, min, sec);
			System.out.println(t.toString());
		}
	}

}

class Tape{
	static final int maxRecordtime = 120 * 60;
	int recordTime;
	public Tape(int recordTime) {
		this.recordTime = recordTime;
	}
	public Tape(int recordHour, int recordMin, int recordSec){
		this.recordTime = recordHour * 3600 + recordMin * 60 + recordSec;
	}
	public int getRestTime(){
		return maxRecordtime - this.recordTime;
	}
	public int getRestTime3Speed(){
		return getRestTime() * 3;
	}
	private static String translate(int restTime){
		int hour = restTime / 3600;
		int min = (restTime % 3600) / 60;
		int sec = restTime % 60;
		return String.format("%02d:%02d:%02d", hour, min, sec);
	}
	@Override
	public String toString() {
		return translate(getRestTime()) + "\n" + translate(getRestTime3Speed());
	}
}