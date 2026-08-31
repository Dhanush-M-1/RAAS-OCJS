#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int n;
int a[N];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
  int mid = (1 + (int)(1e6)) >> 1;
  int t = 0;
  int ans = 0;
  for (int i = 1; i <= n; ++i) {
    if (a[i] <= mid)
      t = a[i];
    else
      break;
  }
  ans += t - 1;
  t = 1e6;
  for (int i = n; i >= 1; --i) {
    if (a[i] > mid)
      t = a[i];
    else
      break;
  }
  ans = max(ans, (int)(1e6) - t);
  cout << ans;
  return 0;
}
