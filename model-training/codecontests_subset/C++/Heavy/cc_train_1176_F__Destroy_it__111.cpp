#include <bits/stdc++.h>
using namespace std;
const int N = 205001;
const long double PI = acos(-1);
int n;
long long dp[N][15];
struct b {
  long long t = -100000000000000000, tt = -100000000000000000;
  vector<long long> o;
  void done() {
    sort(o.begin(), o.end());
    reverse(o.begin(), o.end());
    while (o.size() > 3) o.pop_back();
    while (o.size() < 3) o.push_back(-100000000000000000);
    sort(o.begin(), o.end());
    reverse(o.begin(), o.end());
  }
} a[N];
long long calc(int idx, int tc) {
  if (idx == n) return 0;
  long long& ret = dp[idx][tc];
  if (ret != -1) return ret;
  ret = calc(idx + 1, tc);
  vector<long long>& o = a[idx].o;
  if (tc >= 7) {
    if (o[2] > -100000000000000000)
      ret = max(ret, calc(idx + 1, (tc + 3) % 10) + a[idx].o[0] + a[idx].o[0] +
                         a[idx].o[1] + a[idx].o[2]);
  }
  if (tc >= 9) {
    if (a[idx].t > -100000000000000000)
      ret = max(ret, calc(idx + 1, (tc + 1) % 10) + a[idx].t + a[idx].t);
    if (a[idx].tt > -100000000000000000)
      ret = max(ret, calc(idx + 1, (tc + 1) % 10) + a[idx].tt + a[idx].tt);
    if (o[0] > -100000000000000000)
      ret = max(ret, calc(idx + 1, (tc + 1) % 10) + o[0] + o[0]);
  }
  if (tc >= 8) {
    if (a[idx].t > -100000000000000000 && o[0] > -100000000000000000)
      ret = max(ret, calc(idx + 1, (tc + 2) % 10) + a[idx].t + a[idx].o[0] +
                         max(a[idx].t, a[idx].o[0]));
    if (o[0] > -100000000000000000)
      ret = max(ret, calc(idx + 1, (tc + 2) % 10) + a[idx].o[0] + a[idx].o[0] +
                         a[idx].o[1]);
  }
  if (a[idx].t > -100000000000000000 && tc != 9)
    ret = max(ret, calc(idx + 1, (tc + 1) % 10) + a[idx].t);
  if (a[idx].tt > -100000000000000000 && tc != 9)
    ret = max(ret, calc(idx + 1, (tc + 1) % 10) + a[idx].tt);
  if (o[0] > -100000000000000000 && tc != 9)
    ret = max(ret, calc(idx + 1, (tc + 1) % 10) + a[idx].o[0]);
  if (a[idx].t > -100000000000000000 && o[0] > -100000000000000000 && tc != 8)
    ret = max(ret, calc(idx + 1, (tc + 2) % 10) + a[idx].t + a[idx].o[0]);
  if (o[1] > -100000000000000000 && tc != 8)
    ret = max(ret, calc(idx + 1, (tc + 2) % 10) + a[idx].o[1] + a[idx].o[0]);
  if (o[2] > -100000000000000000 && tc != 7)
    ret = max(ret, calc(idx + 1, (tc + 3) % 10) + a[idx].o[1] + a[idx].o[2] +
                       a[idx].o[0]);
  return ret;
}
signed main() {
  cin >> n;
  for (long long i = 0, k, x, y; i < n; i++) {
    cin >> k;
    for (int j = 0; j < k; j++) {
      scanf("%lld%lld", &x, &y);
      if (x == 1) a[i].o.push_back(y);
      if (x == 2) a[i].t = max(a[i].t, y);
      if (x == 3) a[i].tt = max(a[i].tt, y);
    }
    a[i].done();
  }
  memset(dp, -1, sizeof dp);
  cout << calc(0, 0) << endl;
}
