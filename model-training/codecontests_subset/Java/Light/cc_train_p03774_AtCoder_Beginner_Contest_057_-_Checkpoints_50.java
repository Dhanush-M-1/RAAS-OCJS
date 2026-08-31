import java.util.Scanner;




public class Main {

    public static void main(String[] args) {

    	Main main=new Main();

    	main.run();

    }

    void run() {
    	Scanner sc=new Scanner(System.in);

    	int N=sc.nextInt();
    	int M=sc.nextInt();

    	int[][] pos=new int[N][2];

    	for(int i=0;i<N;i++) {
    		pos[i][0]=sc.nextInt();
    		pos[i][1]=sc.nextInt();
    	}

    	int[][] checkpoints=new int[M][2];

    	for(int i=0;i<M;i++) {
    		checkpoints[i][0]=sc.nextInt();
    		checkpoints[i][1]=sc.nextInt();
    	}

    	int man=0;
    	for(int i=0;i<N;i++) {
    		int min=999999999;
    		int index=-1;

    		for(int j=0;j<M;j++) {
    			man=getmanhattan(pos[i][0], pos[i][1], checkpoints[j][0], checkpoints[j][1]);
    			if(min>man) {
    				min=man;
    				index=j+1;
    			}
    		}

    		System.out.println(index);
    	}



    }

    static int getmanhattan(int x,int y,int x2,int y2) {

    	return Math.abs(x2-x)+Math.abs(y2-y);

    }

}

