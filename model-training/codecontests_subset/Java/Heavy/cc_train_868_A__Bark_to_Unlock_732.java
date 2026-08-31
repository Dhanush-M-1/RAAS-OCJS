import java.util.Scanner;

public  class test1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
		/*Solution x = new Solution();
		int [] arr = {3,2,7,5,4};
		int [] res = x.twoSum(arr, 8);
		System.out.println(res[0] + "," + res[1]);*/
        Scanner scan = new Scanner(System.in);
        String pass = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());
        String [] words =new String[n];
        for(int i = 0; i < n; i++){
            words[i] = scan.nextLine();
        }
        boolean found = false;
        for(int i = 0; i< n && !found ; i++){
            String x = words[i];
            if(x.charAt(0) == pass.charAt(0)) {
                if (x.charAt(1) == pass.charAt(1)) {
                    System.out.println("YES");
                    found = true;
                }
            }
            if (x.charAt(1) == pass.charAt(0)){
                for(int j = 0; j < n && !found; j++){
                    //if(j != i){
                    if(words[j].charAt(0) == pass.charAt(1)){
                        System.out.println("YES");
                        found = true;
                    }
                    //}
                }
            }
        }
        if(!found){
            System.out.println("NO");
        }
    }

}