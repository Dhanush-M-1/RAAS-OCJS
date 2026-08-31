#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <string>

#define rep(x,to) for(int x=0;x<to;x++)
#define rep2(x,from,to) for(int x=from;x<to;x++)

using namespace std;

//三角形面積（三点から）
double smen(double x1, double y1, double x2, double y2, double x3, double y3){
double wkk;
	
	wkk =((x3-x2) * (y1-y2) - (x1-x2) * (y3-y2) )* 0.5;
	if(wkk < 0) wkk *= -1;
	return wkk;
}


int main(void){

double xa,xb,xc,xd,ya,yb,yc,yd;
int cnt=0;
char k;
	while(!cin.eof() && cnt < 50){
		cin >> xa >> k >> ya >> k >> xb >> k >> yb >> k
		    >> xc >> k >> yc >> k >> xd >> k >> yd ;
		if(cin.eof()) break;
		 
		double s1 = smen(xa,ya,xb,yb,xc,yc);
		double s1b= smen(xa,ya,xc,yc,xd,yd);
		double s2 = smen(xa,ya,xb,yb,xd,yd);
		double s2b= smen(xb,yb,xc,yc,xd,yd);
		if(s1+s1b==s2+s2b) cout << "YES" << endl;
		else  cout <<  "NO" << endl;
//		cin.clear();
		cnt++;
	}
	return 0;
	
	
}