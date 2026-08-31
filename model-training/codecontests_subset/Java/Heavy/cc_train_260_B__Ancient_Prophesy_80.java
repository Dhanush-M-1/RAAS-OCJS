import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String [] args ) {
		try{
			String str;

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedOutputStream bos = new BufferedOutputStream(System.out);

			String eol = System.getProperty("line.separator");
			byte [] eolb = eol.getBytes();
			byte[] spaceb= " ".getBytes();

			str = br.readLine();
			int [] countDate = new int[(14*32*3)+1];
			for(int i = 0 ; i < ((14*32*3)+1) ; i++) {
				countDate [i] = 0;
			}
			for(int i = 2 ; i < (str.length()-7) ; i++) {
				if(str.charAt(i) == '-') {
					// check date 
					int date = 0;
					int month = 0;
					int year = 0;
					boolean is = true;
					if(is) {
						is = false;
						if( (str.charAt(i-2) == '0' ) || (str.charAt(i-2) == '1') || (str.charAt(i-2) == '2' ) ) {
							if( (str.charAt(i-1) != '-') && ( (str.charAt(i-1) != '0') || (str.charAt(i-2) != '0') ) ){
								date = Integer.parseInt(str.substring(i-2,i));
								is = true;
							}
						} else if (str.charAt(i-2) == '3') {
							if( (str.charAt(i-1) == '0') || (str.charAt(i-1) == '1')) {
								date = Integer.parseInt(str.substring(i-2,i));
								is = true;
							}
						}
					}

					if(is) {
						is = false;
						if(str.charAt(i+1) == '0') {
							if(  (str.charAt(i+2) != '-') && ( (str.charAt(i+1) != '0') || (str.charAt(i+2) != '0') )) {
								month = Integer.parseInt(str.substring(i+1,i+3));
								is = true;
							}
						} else if(str.charAt(i+1) == '1') {
							if( (str.charAt(i+2) == '0' ) || (str.charAt(i+2) == '1' ) || (str.charAt(i+2) == '2')) {
								month = Integer.parseInt(str.substring(i+1,i+3));
								is = true;
							}
						}
					}
					if(is) {
						is = false;
						if( (str.charAt(i+3) == '-' ) && (str.charAt(i+4) == '2') && (str.charAt(i+5) == '0' ) && (str.charAt(i+6) == '1' ) ) {
							if( (str.charAt(i+7) == '3' ) || (str.charAt(i+7) == '4') || (str.charAt(i+7) == '5')  ){
								year = Integer.parseInt(str.substring(i+4,i+8));
								is = true;
							}
						}
					}
					if(is) {
						if( (month == 2) || (month ==4) || (month == 6) || (month == 9) || (month == 11) ) {
							if(date == 31) {
								is = false;
							}
						}
					}
					if(is) {
						if( (month==2) && ((date == 30) || (date==29))) {
							is = false;
						}
					}
					if(is) {
						countDate[ ( (32*14*(year-2013)) + (32*month) + date )]++;
					}
				}
			}
			int max = 0 ;
			int maxIndex = 0;
			for(int i = 0 ; i < ((3*32*14)+1) ; i++) {
				if(countDate[i] > max) {
					max = countDate[i];
					maxIndex = i;
				}
			}
			int year = maxIndex/(32*14);
			year += 2013;
			maxIndex = maxIndex % (32*14);
			int month = maxIndex/32;
			int date = maxIndex % 32;
			String d = new Integer(date).toString();
			if(d.length()==1) {
				d = "0".concat(d);
			}
			String m = new Integer(month).toString();
			if(m.length()==1) {
				m = "0".concat(m);
			}
			String y = new Integer(year).toString();
			bos.write(d.getBytes());
			bos.write("-".getBytes());
			bos.write(m.getBytes());
			bos.write("-".getBytes());
			bos.write(y.getBytes());
			bos.write(eolb);
			bos.flush();
		}  catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
