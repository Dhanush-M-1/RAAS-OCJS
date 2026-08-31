#include <bits/stdc++.h>
#define rep(i,n) for (int i=0;i<(n);++i)
using namespace std;
int main(){
 int n, m;
  cin >> n >> m;
  int a[60];
  int b[60];
  int c[60];
  int d[60];
  rep(i,n) cin >> a[i] >> b[i];
  rep(i,m) cin >> c[i] >> d[i];
  rep(i,n) {
    int way = 1e20;
    int ans = 0;
    rep(j,m) {
      int manhattan = abs(a[i] - c[j]) + abs(b[i] - d[j]);
      if (manhattan < way) {
        way = manhattan;
        ans = j + 1;
      }
    }
    cout << ans << endl;
  }
}