import java.util.Scanner;
public class WordCount{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String str=sc.next();
        int large=0;
        int count;
        String str1=null,str2;
        String temp=null;
        for(int i=0;i<n-1;i++){
            count=0;
            for(int j=i;j<n-1;j++){
                 str1=str.substring(i,i+2);
                 str2=str.substring(j,j+2);
                if(str1.equals(str2)==true){
                    count++;
                }
            }
            if(count>large){
                large=count;
                temp=str1;
            }
            }
            System.out.print(temp);
    }

}
