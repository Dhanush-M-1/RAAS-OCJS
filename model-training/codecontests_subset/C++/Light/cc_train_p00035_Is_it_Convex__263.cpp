#include <iostream>
#include <cstdio>
#include <complex>
using namespace std;

const double EPS = 1.0e-6;

int main()
{
	double xa,ya,xb,yb,xc,yc,xd,yd;
	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd) > 0){
		//printf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf\n",xa,ya,xb,yb,xc,yc,xd,yd);
		complex<double> v[4];
		v[0] = complex<double>(xb-xa, yb-ya);
		v[1] = complex<double>(xc-xb, yc-yb);
		v[2] = complex<double>(xd-xc, yd-yc);
		v[3] = complex<double>(xa-xd, ya-yd);
		
		int p = 0;
		int m = 0;
		for(int i=0; i<4; i++){
			if( imag(conj(v[i])*v[(i+1)%4]) < 0){
				m++;
			} else {
				p++;
			}
		}
		if(m==4||p==4) cout<<"YES";
		else           cout<<"NO";
		cout<<endl;
	}
	return 0;
}