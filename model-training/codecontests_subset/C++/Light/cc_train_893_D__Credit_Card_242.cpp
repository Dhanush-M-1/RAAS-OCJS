#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, d;
  cin >> n >> d;
  vector<int> a(n), pre(n), mxpsuf(n, 0);
  int mx = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    (i - 1) > -1 ? pre[i] = pre[i - 1] + a[i] : pre[i] = a[i];
    mx = max(mx, pre[i]);
  }
  if (mx > d) {
    cout << -1 << endl;
    return 0;
  }
  for (int i = n - 1; i >= 0; i--) {
    mxpsuf[i] = (i + 1 < n) ? max(pre[i], mxpsuf[i + 1]) : pre[i];
  }
  int ans = 0;
  long long cnt = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] == 0) {
      if (pre[i] + cnt >= 0) {
        continue;
      } else {
        int inc = d - (mxpsuf[i - 1] + cnt);
        if (inc + pre[i] + cnt >= 0) {
          cnt += inc;
          ans++;
        } else {
          cout << -1 << endl;
          return 0;
        }
      }
    }
  }
  cout << ans << endl;
  return 0;
}
