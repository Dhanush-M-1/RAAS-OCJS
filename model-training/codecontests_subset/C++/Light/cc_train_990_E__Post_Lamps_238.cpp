#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
using namespace std;
const int N = 2e6 + 7;
const long long INF = 1e18 + 7;
long long res[N];
int us[N], cst[N], pos[N];
int n, m, k, mx;
long long ans = INF;
int main() {
  scanf("%d%d%d", &n, &m, &k);
  int a;
  for (int i = 1; i <= m; i++) {
    scanf("%d", &a);
    us[a] = us[max(0, a - 1)] + 1;
    mx = max(mx, us[a]);
  }
  for (int i = 1; i <= k; i++) scanf("%d", &cst[i]);
  if (us[0]) {
    puts("-1");
    return 0;
  }
  for (int i = mx + 1; i <= k; i++) {
    while (pos[i] < n) {
      pos[i] += i - us[pos[i] + i];
      res[i] += cst[i];
    }
    ans = min(ans, res[i]);
  }
  if (ans == INF)
    puts("-1");
  else
    cout << ans;
}
