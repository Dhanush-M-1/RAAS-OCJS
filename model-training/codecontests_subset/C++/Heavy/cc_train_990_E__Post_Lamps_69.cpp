#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
int n, m, k, f[N], a[N], mx, last[N];
long long ans = 1e18;
int main() {
  cin >> n >> m >> k;
  for (int i = 0, x; i < m; ++i) {
    scanf("%d", &x);
    f[x] = 1;
  }
  for (int i = 1; i <= k; ++i) {
    scanf("%d", a + i);
  }
  int sum = 0, l = 0;
  for (int i = 0; i < n; ++i) {
    sum += f[i];
    mx = max(sum, mx);
    if (f[i] == 0)
      sum = 0, l = i;
    else
      last[i] = l;
  }
  if (mx >= k || f[0]) return puts("-1"), 0;
  for (int i = mx + 1; i <= k; ++i) {
    long long cost = 0;
    for (int j = 0; j < n; j += i) {
      cost += (long long)a[i];
      if (f[j]) j = last[j];
    }
    ans = min(ans, cost);
  }
  printf("%lld\n", ans);
}
