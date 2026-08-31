import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AandBandCompilationErrors {
    int n;
    int[] a, b, c;
    public static void main(final String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        AandBandCompilationErrors aandBandCompilationErrors = new AandBandCompilationErrors(bufferedReader);
        aandBandCompilationErrors.print(aandBandCompilationErrors.errorsCorrected());
    }
    AandBandCompilationErrors(BufferedReader bufferedReader) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        String[] errors;
        a = new int[n];
        errors = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; ++i) a[i] = Integer.parseInt(errors[i]);
        b = new int[n-1];
        errors = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n-1; i++)   b[i] = Integer.parseInt(errors[i]);
        c = new int[n-2];
        errors = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n-2; i++)   c[i] = Integer.parseInt(errors[i]);
    }
    void print(int[] errorsCorrected) {
        for (int error : errorsCorrected)   System.out.println(error);
    }
    int[] errorsCorrected() {
        int sum_a, sum_b, sum_c;
        sum_a = sum_b = sum_c = 0;
        for (int i : a) sum_a += i;
        for (int i : b)   sum_b += i;
        for (int i : c) sum_c += i;   
        return new int[]{sum_a-sum_b,sum_b-sum_c};
    }
}   