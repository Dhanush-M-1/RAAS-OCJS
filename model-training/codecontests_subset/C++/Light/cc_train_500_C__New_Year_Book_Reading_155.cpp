#include <bits/stdc++.h>
using namespace std;
const long long int mod = 998244353LL;
int vis[1000005];
int w[1000005], used[1000005], a[1000005];
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &w[i]);
  for (int i = 1; i <= m; i++) scanf("%d", &used[i]);
  int cur = 1;
  for (int i = 1; i <= m; i++) {
    if (!vis[used[i]]) {
      a[cur] = used[i];
      vis[a[cur]] = 1;
      cur++;
    }
  }
  for (int i = 1; i <= n; i++) {
    if (!used[i]) {
      a[cur] = i;
      vis[i] = 1;
      cur++;
    }
  }
  int ans = 0;
  for (int i = 1; i <= m; i++) {
    cur = used[i];
    int j;
    for (j = 1; j <= n; j++) {
      if (a[j] != cur)
        ans += w[a[j]];
      else
        break;
    }
    for (int k = j; k > 1; k--) a[k] = a[k - 1];
    a[1] = cur;
  }
  printf("%d\n", ans);
  return 0;
}
