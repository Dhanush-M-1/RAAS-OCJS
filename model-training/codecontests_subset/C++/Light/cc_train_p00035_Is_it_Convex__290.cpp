#include<cstdio>
#include<cmath>
#include<algorithm>
using namespace std;

double ab,ac,ad,bc,bd,cd;
bool heron();

int main(){
	double xa,ya,xb,yb,xc,yc,xd,yd;
	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd) != EOF){
		
		ab = sqrt((xa-xb)*(xa-xb) + (ya-yb)*(ya-yb));
		ac = sqrt((xa-xc)*(xa-xc) + (ya-yc)*(ya-yc));
		ad = sqrt((xa-xd)*(xa-xd) + (ya-yd)*(ya-yd));
		bc = sqrt((xb-xc)*(xb-xc) + (yb-yc)*(yb-yc));
		bd = sqrt((xb-xd)*(xb-xd) + (yb-yd)*(yb-yd));
		cd = sqrt((xc-xd)*(xc-xd) + (yc-yd)*(yc-yd));
		
		bool f = heron();
		(f) ? puts("YES") : puts("NO");
	}
	return 0;
}

bool heron(){
	double sq1=0.0,sq2=0.0;
	double S,s;
	
	/*sq1*/
	s = (ab+ac+bc)*0.5;
	S = sqrt(s * (s-ab) * (s-ac) * (s-bc));
	sq1 += S;
	s = (ac+ad+cd)*0.5;
	S = sqrt(s * (s-ac) * (s-ad) * (s-cd));
	sq1 += S;
	
	/*sq2*/
	s = (ab+ad+bd)*0.5;
	S = sqrt(s * (s-ab) * (s-ad) * (s-bd));
	sq2 += S;
	s = (bc+bd+cd)*0.5;
	S = sqrt(s * (s-bc) * (s-bd) * (s-cd));
	sq2 += S;
	bool j;
	(fabs(sq1-sq2) <= 0.01) ? j = true : j = false;
	
	return j;
}