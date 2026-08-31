import java.util.*;

public class Main {
    public static int bubble_sort(int[] dat) {
	int num = 0;
	for(int i = 0; i < dat.length; ++i) {
	    for(int j = 1; j < dat.length-i; ++j) {
		if(dat[j-1] > dat[j]) {
		    ++num;
		    int t = dat[j-1];
		    dat[j-1] = dat[j];
		    dat[j] = t;
		}
	    }
	}
	return num;
    }

    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	while(s.hasNext()) {
	    int n = s.nextInt();
	    if(n == 0) break;
	    int[] dat = new int[n];
	    for(int i = 0; i < n; ++i) {
		dat[i] = s.nextInt();
	    }
	    System.out.println(bubble_sort(dat));
	}
    }
}