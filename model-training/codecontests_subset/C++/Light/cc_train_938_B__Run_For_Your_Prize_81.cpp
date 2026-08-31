#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000000;
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  int res = min(a[n - 1] - 1, maxn - a[0]);
  for (int i = 0; i < n - 1; i++) {
    int x = a[i] - 1;
    int y = maxn - a[i + 1];
    res = min(res, max(x, y));
  }
  cout << res << endl;
  return 0;
}
