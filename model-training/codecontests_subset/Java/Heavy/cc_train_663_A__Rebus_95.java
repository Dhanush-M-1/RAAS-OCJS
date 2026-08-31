import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Rebus {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> tokens = new ArrayList<String>();
		while (input.hasNext()) {
			tokens.add(input.next());
		}
		int numQuestionMarks = 0;
		
		boolean[] signs = new boolean[1000];
		signs[0] = true;
		for (String s : tokens) {
			if (s.equals("?")) {
				numQuestionMarks++;
			} else {
				signs[numQuestionMarks] = s.equals("+");
			}
		}
		int n = Integer.parseInt(tokens.get(tokens.size()-1));
		int start = 0;
		int end = 0;
		for(int a = 0; a < numQuestionMarks; a++){
			if(signs[a]){
				start+=1;
				end+=n;
			}
			else{
				end-=1;
				start -= n;
			}
		}
		
		if(start <= n && end >= n){
			//find it
			System.out.println("Possible");
			ArrayList<Integer> output = new ArrayList<Integer>();
			//now we have to find it, that's harder.
			int tempN = n;
			for(int a = numQuestionMarks-1; a >= 0; a--){
				if(signs[a]){
					if(tempN <= end-n){
						output.add(1);
						tempN -= 1;
					}
					else{
						output.add(n);
						tempN -= n;
					}
					end -= n;
					start -= 1;
				}
				else{
					if(tempN >= start+n){
						output.add(1);
						tempN += 1;
					}
					else{
						output.add(n);
						tempN += n;
					}
					start += n;
					end += 1;
				}
			}
			Collections.reverse(output);
			int count = 1;
			for(Integer a:output){
				System.out.print((a+tempN) + " ");
				if(count != output.size()){
					if(signs[count]){
						System.out.print("+ ");
					}
					else{
						System.out.print("- ");
					}
				}
				count++;
				tempN = 0;
			}
			System.out.println("= " + n);
		}
		else{
			System.out.println("Impossible");
		}
	}

}
