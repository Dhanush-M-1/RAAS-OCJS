import java.util.Scanner;
public class TwoGram {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        String s=input.next();
        String[] subs=new String[n-1];
        int index=0;
        for(int i=0,j=2;j<=subs.length+1;i++,j++){
            subs[index]=s.substring(i, j);
            index++;
        }
        int[] freq=new int[n-1];
        for(int i=0;i<freq.length;i++){
            for(int j=0;j<freq.length;j++){
                if(subs[i].equals(subs[j])){
                    freq[i]++;
                }
            }
        }
        int maxIndex=0;
        String most=subs[maxIndex];
        for(int i=1;i<freq.length;i++){
            if(freq[i]>freq[maxIndex]){
                maxIndex=i;
                most=subs[maxIndex];
            }
        }
        System.out.println(most);
    }
}