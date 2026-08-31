import java.io.*;
public class CF174B{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s  = br.readLine();
        int a = 0, f = 0, i = 0;
        for(int x = 0; x < n; x++){
            char c = s.charAt(x);
            switch(c){
              case 'A':
                a++;
                break;
              case 'F':
                f++;
                break;
              case 'I':
                i++;
                break;
            }
        }
        int result = 0;
        if(i == 1) result = 1;
        else if (i > 1) result = 0;
        else result = a;
        System.out.println(result);
    }
}

