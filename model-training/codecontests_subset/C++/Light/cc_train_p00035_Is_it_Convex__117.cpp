#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cstring>
#include <map>
#include <queue>
#include <stack>
#include <set>
#include <functional>
#include <sstream>
#include <complex>
#include <climits>
using namespace std;

#define REP(i,a,n) for(int i=(a);i<(int)(n);i++)
#define rep(i,n) REP(i,0,n)
#define pb push_back
#define mp make_pair
#define all(x) x.begin(),x.end()
#define EPS 1e-8

typedef complex<double> P;

double cross(P& a, P& b){
	return a.real()*b.imag() - a.imag()*b.real();
}
bool signeq(double a, double b){
	if( a+EPS<0.0 && b+EPS<0.0 ) return true;
	if( a-EPS>0.0 && b-EPS>0.0 ) return true;
	return false;
}
int main(){
	double x[4],y[4];
	while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",x,y,x+1,y+1,x+2,y+2,x+3,y+3)){
		int i;
		double s;
		for(i=0; i<4; i++){
			P A(x[(i+2)%4],y[(i+2)%4]), B(x[(i+1)%4],y[(i+1)%4]), C(x[i],y[i]);
			P AB = A-B;
			P BC = B-C;
			if( i==0 ){
				s = cross(AB,BC);
			}else{
				if( !signeq(s,cross(AB,BC)) ) break;
			}
		}
		puts(i==4?"YES":"NO");
	}
	return 0;
}