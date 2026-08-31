#include<iostream>
#include<algorithm>
#include<vector>
#include<stack>
#include<queue>
#include<cstdio>
#include<climits>
#include<cmath>
#include<cstring>
#include<string>
#include<complex>
#include<map>

#define f first
#define s second
#define mp make_pair

#define REP(i,n) for(int i=0; i<(int)(n); i++)
#define FOR(i,c) for(__typeof((c).begin()) i=(c).begin(); i!=(c).end(); i++)
#define ALL(c) (c).begin(), (c).end()
#define EPS (1e-10)
using namespace std;

typedef unsigned int uint;
typedef long long ll;
typedef complex<double> P;

int main(){
  double x[6];
  double y[6];
  while(2==scanf("%lf,%lf,",&x[1],&y[1])){
    REP(i,3) scanf("%lf,%lf,",&x[i+2],&y[i+2]);
    x[5] = x[1];
    x[0] = x[4];
    y[5] = y[1];
    y[0] = y[4];
    int ans = 0;
    REP(i,4){
      double dx1 = x[i+1] - x[i];
      double dx2 = x[i+2] - x[i+1];
      double dy1 = y[i+1] - y[i];
      double dy2 = y[i+2] - y[i+1];
      if(dx1 * dy2 < dx2 * dy1) ans++;
      else ans--;
    }
    if(ans == 4 || ans == -4) ans = 1;
    else ans = 0;
    puts(ans?"YES":"NO");
  }
  return 0;
}