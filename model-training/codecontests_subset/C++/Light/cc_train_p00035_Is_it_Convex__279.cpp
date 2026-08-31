
#define _USE_MATH_DEFINES
#include <cstdio>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
#include <cstring>
#include <vector>
#include <map>
#include <utility>
#include <complex>
#include <stack>
#include <climits>
#include <set>
#include <numeric>

using namespace std;

typedef complex<double> P;
double sq(double x){return x*x;}

double cross(P x,P y){
	return x.real() * y.imag() - x.imag() * y.real();
}

int main(){
	double x[4],y[4];
	while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",x,y,x+1,y+1,x+2,y+2,x+3,y+3)){
		P p[4];
		for (int i = 0; i < 4; i++)
			p[i] = P(x[i],y[i]);
		bool f[4];
		memset(f,0,4);
		for (int i = 0; i < 4; i++)
			if(cross(p[(i+2)&3] - p[(i+1)&3],p[i] - p[(i+1)&3]) < 0)
				f[i] = true;
		int sum = accumulate(f,f+4,0);
		if(sum == 0 || sum == 4) puts("YES");
		else puts("NO");

	}

	return 0;
}