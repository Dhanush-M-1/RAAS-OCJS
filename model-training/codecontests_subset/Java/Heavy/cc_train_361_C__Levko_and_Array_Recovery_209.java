import java.util.*;

public class C {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	long[] array = new long[n+1];
	long[] array2 = new long[n+1];
	long[][] input = new long[m][4];
	long min = -1000000000;
	long max = 1000000000;	
	
	for (int i = 1; i <= n; i++) {
	    array[i] = max;
	}
	// creating
	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < 4; j++) {
		input[i][j] = (long) sc.nextInt();
	    }
	    if(input[i][0] == 1) {
		for (long k = input[i][1]; k <=  input[i][2]; k++) {
		    array[(int) k] += input[i][3];
		}
	    } else {
		for (long k = input[i][1]; k <=  input[i][2]; k++) {
		    array[(int) k] = (array[(int) k] > input[i][3]) ? input[i][3] : array[(int) k];
		}
	    }
	}
	// reversing
	for (int i = m-1; i >=  0; i--) {
	    if(input[i][0] == 1) {
		for (long k = input[i][1]; k <=  input[i][2]; k++) {
		    array[(int) k] -= input[i][3];
		}
	    } 
	}
	
	// trimming
	for (int i = 1; i <= n; i++) {
	    if (array[i] > max) {
		array[i] = max;
	    } else if (array[i] < min){
		array[i] = min;
	    }
	    array2[i] = array[i]; //cloning
	}

	
	// checking if correct
	boolean isCorrect = true;
	for (int i = 0; i < m; i++) {
	    if(input[i][0] == 1) {
		for (long k = input[i][1]; k <=  input[i][2]; k++) {
		    array[(int) k] += input[i][3];
		}
	    } else {
		long maxim = array[(int) input[i][1]];
		for (long k = input[i][1]; k <=  input[i][2]; k++) {
		    maxim = (array[(int) k] > maxim) ? array[(int) k] : maxim;
		}
		if (maxim != input[i][3]){ 
		    isCorrect = false;
		    break;
		}
	    }
	}
	
	if (!isCorrect){
	    System.out.println("NO");
	} else {
	    System.out.println("YES");
	    for (int i = 1; i <= n; i++) {
		if (i == n) {
		    System.out.println("" + array2[i]);
		} else {
		    System.out.print("" + array2[i] + " ");
		}
	    }
	}
    }
}