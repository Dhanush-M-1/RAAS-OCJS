import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MostMinimalNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfRequests = Integer.parseInt(reader.readLine());
        String[] array=new String[numberOfRequests];
        for (int i = 0; i <numberOfRequests ; i++) {
            array[i]=reader.readLine();
        }
        for (int i = 0; i <numberOfRequests ; i++) {
            int[] mas=new int[3];
            String[] stringsNumbers = array[i].split(" ");
            for (int j = 0; j < stringsNumbers.length; j++) {
                mas[j]=Integer.parseInt(stringsNumbers[j]);
            }
            System.out.println(outPut(mas));
        }
    }

    private static int outPut(int[] mas) {
        if(mas[2]<mas[0] && mas[2]<mas[1] || mas[2]>mas[0] && mas[2]>mas[1]) return mas[2];
        int multiplier = mas[1]/mas[2]+1;
        return mas[2]*multiplier;


        }
    }

