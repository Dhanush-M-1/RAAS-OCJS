#include <bits/stdc++.h>
using namespace std;
signed main() {
  double n, m, k;
  cin >> n >> m >> k;
  double wiz = (m / n) * 100;
  if (wiz >= k)
    cout << 0;
  else {
    double cur = ((k - wiz) / 100) * n;
    cur = ceil(cur);
    long long ans = cur;
    cout << ans;
  }
}
