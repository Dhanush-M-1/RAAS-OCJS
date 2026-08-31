import java.util.*;

class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);

	while(sc.hasNext()){
	    String[] line = (sc.next()).split(",");
	    double[] x = new double[4];
	    double[] y = new double[4];
	    for(int i=0; i<4; i++){
		x[i] = Double.parseDouble(line[i*2]);
		y[i] = Double.parseDouble(line[i*2+1]);
	    }
	    
	    double sikaku = getMenseki(4,x,y);

	    double[] xx = new double[3];
	    double[] yy = new double[3];
	    int count = 0;
	    boolean hantei = true;
	    for(int i=0; i<4; i++){
		if(hantei){
		    xx = new double[3];
		    yy = new double[3];
		    count = 0;
		    for(int j=0; j<4; j++){
			if(j!=i){
			    xx[count] = x[j];
			    yy[count] = y[j];
			    count++;
			}
		    }
		    double sankaku = getMenseki(3,xx,yy);
		    //System.out.println(i+" "+sankaku+" "+sikaku);
		    if(sankaku>sikaku){hantei = false;}
		}
	    }
	    String ans = "NO";
	    if(hantei){ans = "YES";}
	    System.out.println(ans);
	}
    }
    
    public static double getMenseki(int n,double[] x, double[] y){
	double[] pro = new double[n];
	for(int i=0; i<n-1; i++){
	    pro[i] = (x[i]-x[i+1])*(y[i]+y[i+1]);
	}
	pro[n-1] = (x[n-1]-x[0])*(y[n-1]+y[0]);
	double ans = 0;
	for(int i=0; i<n; i++){
	    ans += pro[i];
	}
	if(ans<0){ans = (-1)*ans;}
	return (ans/2.0);	
    }
}