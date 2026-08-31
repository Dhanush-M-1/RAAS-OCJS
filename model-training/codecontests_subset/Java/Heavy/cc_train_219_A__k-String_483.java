import java.util.Scanner;


public class kString {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        
        String s1 = sc.nextLine();
        int k = Integer.parseInt(s1);
        String s = sc.nextLine();
        int[] indices = new int [150];
        for(int i=0; i<s.length(); i++){
            indices[s.charAt(i)]++;
        }
        
        //for(int i='a'; i<='z'; i++){
        //  System.out.println("char "+ (char)i +" "+indices[i] );
        //}
        
        
        int length = k;   // number of k strings
        //System.out.println("length "+ length);
        
        String [] out = new String [length];  // array of the k strings
        for(int i=0; i<out.length; i++){
            out[i]="";
        }
        boolean kString = true;
        for(int i ='a'; i<= 'z'; i++){
            int count = indices[i];
            int temp = count%length; 
            if(temp!=0){
                kString = false;
                break;
            }
            else{
                int repeats =  count/length;
                for(int j =0; j< repeats; j++){
                    for(int h =0; h<out.length; h++){
                        out[h]+= (char)i +"";
                    }
                }
            }
        }
        if(!kString){
            System.out.println("-1");
        }
        else {
            for(int i =0; i<out.length; i++){
                System.out.print(out[i]);
            }
        }
        
    }

}
