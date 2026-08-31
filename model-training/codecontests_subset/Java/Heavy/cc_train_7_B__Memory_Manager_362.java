import java.io.*;

public class Task_7B {
    
    int t = 0, m = 0;
    int count = 0;
    int[] mem;
    
    class Scanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        public String readString(){
              try{
                return br.readLine(); 
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return null;          
        }
    }
    
    void run(){
        Scanner scan = new Scanner();
        String[] str = scan.readString().split(" ");
        t = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        
        String[] task = new String[t];
        mem = new int[m];
        
        for (int i = 0; i < m; i++)
            mem[i] = 0;
        
        for (int i = 0; i < t; i++){
            task[i] = scan.readString();
            str = task[i].split(" ");
            int temp;
            switch (str[0]){
                case "alloc":
                    temp = alloc(Integer.parseInt(str[1]));
                    if (temp > 0) System.out.println(temp);
                    else System.out.println("NULL");
                break;
                case "erase":
                    temp = erase(Integer.parseInt(str[1]));
                    if (temp < 0) System.out.println("ILLEGAL_ERASE_ARGUMENT");
                break;
                case "defragment":
                    defrag();
                break;
            }
        }
    }
    
    int alloc(int bytes){
        int cnt = 0;
        for (int i = 0; i < m; i++){
            if (mem[i] == 0) cnt++;
            else cnt = 0;
            if (cnt == bytes){
                count++;
                for (int j = i - bytes + 1; j <= i; j++)
                    mem[j] = count;
                return count;
            }
        }
        return -1;
    }
    
    int erase(int adr){
        int temp = -1;
        if (adr > 0 && adr <= count){
            for (int i = 0; i < m; i++)
                if (mem[i]==adr){
                    mem[i] = 0;
                    temp = 0;
                }
        }
        return temp;
    }
    
    void defrag(){
        int cnt = 0;
        for(int i = 0; i < m; i++){
            if (mem[i]==0) cnt++;
            else if (cnt > 0){
                mem[i - cnt] = mem[i];
                mem[i] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        new Task_7B().run();
    }
    
}
