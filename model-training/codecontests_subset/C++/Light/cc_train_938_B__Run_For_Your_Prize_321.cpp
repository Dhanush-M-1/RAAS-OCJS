#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
int a[100 * 1000 + 228];
signed main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
  }
  int res = min(a[n] - 1, 1000 * 1000 - a[1]);
  for (int i = 1; i < n; ++i) {
    res = min(res, max(a[i] - 1, 1000 * 1000 - a[i + 1]));
  }
  cout << res << "\n";
  return 0;
}
