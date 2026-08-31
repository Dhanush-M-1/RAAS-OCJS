#include <cstdio>
#include <cstdlib>
#include <cmath>
#include <map>
#include <utility>
#include <set>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
#include <queue>
#include <cstring>
#include <functional>
#include <complex>

using namespace std;

#define REP(i,a,b) for((i)=(a);(i)<(int)(b);(i)++)
#define rep(i,n) REP(i,0,n)
// BEGIN CUT HERE
#define foreach(itr,c) for(typeof((c).begin()) itr=(c).begin();itr!=(c).end();itr++)
template<class T> inline string toString(T x){ostringstream sout;sout<<x;return sout.str();}
// END CUT HERE
typedef complex<double> P;

double crossP(P a, P b){return a.real()*b.imag() - a.imag()*b.real();}

int main(){
  int i,j,k,n;
  double xa,ya,xb,yb,xc,yc,xd,yd;
  P ab,bc,cd,da;

  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd) != EOF){
    bool f = false;
    ab = P((xb-xa),(yb-ya));
    bc = P((xc-xb),(yc-yb));
    cd = P((xd-xc),(yd-yc));
    da = P((xa-xd),(ya-yd));

    if(crossP(ab,bc) > 0 && crossP(bc,cd) > 0 && crossP(cd,da) > 0 && crossP(da,ab) > 0) f = true;
    if(crossP(ab,bc) < 0 && crossP(bc,cd) < 0 && crossP(cd,da) < 0 && crossP(da,ab) < 0) f = true;

    if(f) printf("YES\n");
    else printf("NO\n");
  }

  return 0;
}