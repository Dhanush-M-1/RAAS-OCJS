#include<iostream>
#include<string>
#include<cstdio>
#include<cstring>
#include<algorithm>
#include<cmath>
using namespace std;
double check(double x1,double y1,double x2,double y2,double x3,double y3);
int main(void){
    double xa,xb,xc,xd,ya,yb,yc,yd;
	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd)!=EOF){
        double sq1S=check(xa,ya,xb,yb,xc,yc)+check(xa,ya,xd,yd,xc,yc);
        double sq2S=check(xb,yb,xc,yc,xd,yd)+check(xb,yb,xa,ya,xd,yd);

        double var=sq1S-sq2S;
        if(fabs(var)<=0.01)cout<<"YES"<<endl;
        else cout<<"NO"<<endl;

	}
	return 0;
}

double check(double x1,double y1,double x2,double y2,double x3,double y3){
    double ab,bc,ca;
    double S,s;
    ab=sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    bc=sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));
    ca=sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
    s=0.5*(ab+bc+ca);
    S=sqrt(s*(s-ab)*(s-bc)*(s-ca));
    return S;
}