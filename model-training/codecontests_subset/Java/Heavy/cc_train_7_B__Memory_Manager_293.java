import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Num[] = new int[10000+1109];
        int a[] = new int[10000+1109];
        int T = s.nextInt(), m = s.nextInt(),Cnt = 0;
        for(;T > 0;T--){
            String ch = s.next();
            if(ch.charAt(0) == 'd'){
                int Now = 1;
                for(int i = 1;i <= m;i++)
                    if(a[i] > 0){
                        a[Now] = a[i];
                        Num[Now] = Num[i];
                        if(i != Now) a[i] = Num[i] = 0;
                        Now += a[Now];
                    }
            }
            else if(ch.charAt(0) == 'a'){
                int x = s.nextInt(),y;
                boolean flag = false;
                for(int i = 1;i <= m;i++){
                    if(a[i] > 0) i = i + a[i] - 1;
                    else{
                        int j = i;
                        while(a[j] == 0 && j <=m) j++;
                        if(j - i >= x){
                            System.out.println(++Cnt);
                            a[i] = x;
                            Num[i] = Cnt;
                            flag = true;
                            break;
                        }
                        else i = j - 1;
                    }
                }
                if(!flag) System.out.println("NULL");
            }
            else{
                int x = s.nextInt();
                if(x <= 0){
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    continue;
                }
                boolean flag = false;
                for(int i = 1;i <= m;i++){
                    if(Num[i] == x){
                        Num[i] = 0;
                        a[i] = 0;
                        flag = true;
                        break;
                    }
                    if(a[i] > 0) i = i + a[i] - 1;
                }

                if(!flag) System.out.println("ILLEGAL_ERASE_ARGUMENT");
            }
        }
    }
}
