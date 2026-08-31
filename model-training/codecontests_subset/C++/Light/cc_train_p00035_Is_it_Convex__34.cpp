#include <bits/stdc++.h>
#define rep(i, n) for(int i=0;i<(int)(n);++i)
#define rep1(i, n) for(int i=1;i<=(int)(n);++i)
#define irep(i, a, n) for(int i=a;i<(int)(n);++i)
#define rrep(i, n) for(int i=(int)(n)-1;i>=0;--i)
#define rrep1(i, n) for(int i=(int)(n);i>=1;--i)
#define allrep(V, v) for(auto&& V:v)
#define all(x) (x).begin(),(x).end()
typedef long long lint;
const int INF=1<<29;
const double EPS=1e-9;
using namespace std;


int main (void)
{
  double xa,ya,xb,yb,xc,yc,xd,yd;
  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd)!=EOF){
    double area1,area2;
    area1=abs((xa-xb)*(yc-yb)-(ya-yb)*(xc-xb))+abs((xa-xd)*(yc-yd)-(ya-yd)*(xc-xd));
    area2=abs((xb-xa)*(yd-ya)-(yb-ya)*(xd-xa))+abs((xb-xc)*(yd-yc)-(yb-yc)*(xd-xc));

    cout << (area1==area2 ? "YES" : "NO") << endl;
  }
  return 0;
}
