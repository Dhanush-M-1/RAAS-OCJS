import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main (String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int a = Integer.parseInt(sc.nextLine());
        //String x =sc.nextLine();
        ArrayList<String> array = new ArrayList<String>();
        String[] str ={"S","H","C","D"};

        for(int i=0;i<str.length;i++){
        	for(int b=1;b<=13;b++){
        	array.add(str[i]+" "+ b);
        	}
        }
        for(int i=0;i<a;i++){
        	String x =sc.nextLine();
            array.remove(x);
        }

        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i));
        }
        }


    }