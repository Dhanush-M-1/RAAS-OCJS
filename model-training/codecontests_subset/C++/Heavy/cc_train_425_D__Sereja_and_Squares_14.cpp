#include <bits/stdc++.h>
using namespace std;
vector<long long int> sx[100005], sy[100005];
vector<long long int>::iterator it, jt;
long long int vx[100005], vy[100005];
long long int n, ans = 0;
int main() {
  cin >> n;
  long long int rx, ry;
  for (long long int i = 0; i < n; i++) {
    cin >> rx >> ry;
    vx[i] = rx;
    vy[i] = ry;
    sx[ry].push_back(rx);
    sy[rx].push_back(ry);
  }
  for (long long int i = 0; i <= 100000; i++) {
    sort(sx[i].begin(), sx[i].end());
    sort(sy[i].begin(), sy[i].end());
  }
  for (long long int i = 0; i < n; ++i) {
    long long int c1 = lower_bound(sx[vy[i]].begin(), sx[vy[i]].end(), vx[i]) -
                       sx[vy[i]].begin();
    long long int c2 = lower_bound(sy[vx[i]].begin(), sy[vx[i]].end(), vy[i]) -
                       sy[vx[i]].begin();
    if (c1 > c2) {
      for (jt = sy[vx[i]].begin(); *jt < vy[i]; jt++) {
        long long int len = vy[i] - (*jt);
        if (vx[i] - len >= 0 &&
            binary_search(sy[vx[i] - len].begin(), sy[vx[i] - len].end(),
                          vy[i]) &&
            binary_search(sy[vx[i] - len].begin(), sy[vx[i] - len].end(),
                          *jt)) {
          ans++;
        }
      }
    } else {
      for (jt = sx[vy[i]].begin(); *jt < vx[i]; jt++) {
        long long int len = vx[i] - (*jt);
        if (vy[i] - len >= 0 &&
            binary_search(sx[vy[i] - len].begin(), sx[vy[i] - len].end(),
                          vx[i]) &&
            binary_search(sx[vy[i] - len].begin(), sx[vy[i] - len].end(),
                          *jt)) {
          ans++;
        }
      }
    }
  }
  cout << ans << "\n";
}
