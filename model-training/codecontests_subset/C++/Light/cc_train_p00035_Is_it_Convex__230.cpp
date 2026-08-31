#include <iostream>
#include <fstream>
#include <cstring>
#include <cstdlib>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <queue>
#include <stack>
#include <list>
#include <utility>
#include <cmath>
#include <sstream>
#define F first
#define S second
#define FOR(i,n) for(int i=0;i<(int)n;i++)
#define rep(i,n) for(int i=0;i<(int)n;i++)
#define FORI(i,k,n) for(int i=k;i<(int)n;i++)
#define repp(i,k,n) for(int i=k;i<(int)n;i++)
using namespace std;
typedef pair<double, double> pdd;
const double EPS = 10e-6;
double wid(pdd a, pdd b) {
	return sqrt((a.first - b.first) * (a.first - b.first) + (a.second - b.second) * (a.second - b.second));
}
double yoge(pdd a, pdd b, pdd c) {
	double A, B, C;
	C = wid(a, b); A = wid(b, c); B = wid(c, a);
	return abs(acos((B*B+C*C-A*A)/(2*B*C)));
}
int main() {
	pdd p[4];
	while (scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&p[0].first,&p[0].second,&p[1].first,&p[1].second,&p[2].first,&p[2].second,&p[3].first,&p[3].second)!=EOF) {
		double x=yoge(p[0],p[3],p[1])/3.1415926535*180+
			yoge(p[1],p[0],p[2])/3.1415926535*180+
			yoge(p[2],p[1],p[3])/3.1415926535*180+
			yoge(p[3],p[2],p[0])/3.1415926535*180-360;
		if(x<EPS&&x>-1*EPS)cout<<"YES"<<endl;
		else cout<<"NO"<<endl;
	}

}