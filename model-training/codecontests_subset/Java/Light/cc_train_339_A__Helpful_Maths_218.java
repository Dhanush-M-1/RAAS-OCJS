import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HelpfulMaths {

	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String numsString = br.readLine();
		String [] numsSeparateString = numsString.split("\\+");
		bw.write(borbujaToString(burbuja(numsSeparateToInt(numsSeparateString))));

		br.close();
		bw.close();
	}

	public static int [] numsSeparateToInt (String [] numsSeparateString) {
		int size = numsSeparateString.length;
		int [] numsSeparate = new int [size];
		for (int i = 0; i<size; i++) {
			numsSeparate[i] = Integer.parseInt(numsSeparateString[i]);
		}
		return numsSeparate;
	}

	public static int [] burbuja(int[] numsSeparate) {
		int aux;
		int [] nums = numsSeparate;
		for(int i = 0; i<nums.length-1; i++) {
			for(int j = 0; j<nums.length-i-1; j++) {
				if(nums[j+1] <nums[j]) {
					aux = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = aux;
				}
			}
		}
		return nums;
	}

	public static String borbujaToString (int [] nums) {
		String numToString = "";
		boolean out = false;
		for(int i = 0; i<nums.length; i++) {
			if(out) {
				numToString += "+";
			}
			numToString += nums[i];
			out = true;
		}
		numToString += "\n";
		return numToString;
	}
}
