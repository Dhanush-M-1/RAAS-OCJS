#include <bits/stdc++.h>
using namespace std;
#define REP(i, n) for(int i = 0; i < n; i++)
using ll = long long;

int main() {
  int n,m;
  cin >> n >> m;
  int a[n],b[n],c[m],d[m];
  REP(i,n) cin >> a[i] >> b[i];
  REP(i,m) cin >> c[i] >> d[i];

  REP(i,n) {
    int md = 1001001001;
    int ans = 0;
    REP(j,m) {
      int dd = abs(a[i] - c[j]) + abs(b[i] - d[j]);
      if (dd < md) { ans = j+1; md = dd; }
    }
    cout << ans << endl;
  }
  return 0;
}