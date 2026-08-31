#define	_USE_MATH_DEFINES
#include <iostream>
#include <iomanip>
#include <algorithm>
#include <functional>
#include <vector>
#include <cstdio>
#include <cstring>
#include <cmath>
#include <cfloat>
#include <map>
#include <queue>
#include <stack>
#include <list>
#include <string>
#include <set>
#include <complex>
using namespace std;

typedef complex<double> P;

#define x real()
#define y imag()

bool isIntersect(P p1,P p2,P p3,P p4){
	if((((p1.x - p2.x)*(p3.y - p1.y)+(p1.y - p2.y)*(p1.x - p3.x))*((p1.x - p2.x)*(p4.y - p1.y)+(p1.y - p2.y)*(p1.x - p4.x)))<0)
		return true;
	else
		return false;
}

int main(){
	
	double xa,ya,xb,yb,xc,yc,xd,yd;
	
	while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd)){
		P a(xa,ya);
		P b(xb,yb);
		P c(xc,yc);
		P d(xd,yd);
		
		if(isIntersect(a,c,b,d)&&isIntersect(b,d,a,c))
			cout<<"YES"<<endl;
		else
			cout<<"NO"<<endl;
	}
	

	
}