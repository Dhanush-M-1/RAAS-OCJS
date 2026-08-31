import java.io.*;
import java.text.DecimalFormat;

public class nsspe{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            DecimalFormat df = new DecimalFormat("#.##########");
            double halfAngle = ((2*n-2)*180)/(double)(4*n);
            double l = 1.0 / Math.cos(Math.toRadians(halfAngle));
            double angle = 180 / (double)(4*n);
            double ans = l * Math.cos(Math.toRadians(angle));
            System.out.println(df.format(ans));
            t--;
        }
    }
}