import java.util.*;

public class Main{
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int m = in.nextInt();
        int id = 0;
        int []mem =new int[m+1];
        Arrays.fill(mem,0);
        int []block = new int[200];
        Arrays.fill(block,0);
        int []blSize = new int[200];
        Arrays.fill(blSize,0);
        int used = 0;
        for (int iii = 0; iii < t; iii++){
            String op = in.next();
            if (op.equals("alloc")){
                int num = in.nextInt();
                used += num;
                int res = -1;
                for (int i = 1; i <= m-num+1; i++)
                    if (mem[i] == 0){
                    boolean ok = true;
                    for (int k = 1; k < num; k++)
                        if (mem[i+k]!= 0){ ok = false;break;} 
                    if (ok){ res = i; break;}
                   }
                if (res == -1) System.out.println("NULL");
                else{
                block[++id] = res;
                blSize[id] = num;
                for (int i = res; i < res+num; i++) mem[i] = id;
                System.out.println(id);
                }
            }else if (op.equals("erase")){
                int num = in.nextInt();
                if (num > 100 || num <= 0 || block[num] == 0)System.out.println("ILLEGAL_ERASE_ARGUMENT");
                else{
                    for (int i = block[num]; i < block[num] + blSize[num]; i++) mem[i] = 0;
                    block[num] = blSize[num] = 0;
                }
            }else if (op.equals("defragment")){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = 1; i <= id; i++)
                    if (block[i] != 0)
                        list.add(i+ block[i]*100);
                Integer []arr = new Integer[list.size()];
                arr = list.toArray(arr);
                Arrays.sort(arr);
                Arrays.fill(mem,0);
                int i = 1;
                for (int num : arr){
                    int idd = num%100;
                    block[idd] = i;
                    for (int k = 0; k < blSize[idd]; k++){
                    mem[i++] = idd;
                    }
                    
                }
            }
        }
    }
}