#include <iostream>
#include <climits>
#include <cmath>
using namespace std;
#define REP(i,n) for(int i=0;i<int(n);i++)

int main()
{
  int N, M;
  cin >> N >> M;
  int a[N], b[N], c[M], d[M];
  REP(i,N) cin >> a[i] >> b[i];
  REP(i,M) cin >> c[i] >> d[i];
  REP(i,N){
    int md = INT_MAX, ans;
    REP(j,M){
      if(abs(a[i]-c[j])+abs(b[i]-d[j]) < md){
        ans = j+1;
        md = abs(a[i]-c[j])+abs(b[i]-d[j]);
      }
    }
    cout << ans << endl;
  }
}