#include <bits/stdc++.h>
using namespace std;
int pre[1000005];
const int mod = 1000000009;
string s1, s2;
int n, d, minx, maxx, ans;
inline void excute() {
  cin >> n >> d;
  for (int i = 1; i <= n; ++i) {
    int x;
    cin >> x;
    if (x) {
      minx += x;
      maxx = min(d, maxx + x);
      if (minx > d) {
        cout << -1;
        return;
      }
    } else {
      if (maxx < 0) {
        ++ans;
        minx = 0, maxx = d;
      } else
        minx = max(minx, 0);
    }
  }
  cout << ans << endl;
}
signed main() { excute(); }
