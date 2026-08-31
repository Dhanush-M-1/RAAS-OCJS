import java.io.*;
public class b {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String l = br.readLine();
        int b = Integer.parseInt(l.split(" ")[0]);
        int bulb = Integer.parseInt(l.split(" ")[1]);
        int [] arr = new int [bulb];
        while(b>0){
            b--;
            String h = br.readLine();
            String [] arr2 = h.split(" ");
            for(int i =1; i <arr2.length;i++ ){
                int x = Integer.parseInt(arr2[i]);
                arr[x-1] = 1;
            }
        }
        boolean flag = true;
        for(int i = 0; i < arr.length;i++ ){
            if(arr[i] == 0){
                flag = false;
                break;
            }
        }
        if(!flag){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
        
    }

}
