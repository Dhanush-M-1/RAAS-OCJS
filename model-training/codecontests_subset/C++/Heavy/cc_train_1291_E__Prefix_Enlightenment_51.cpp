#include <bits/stdc++.h>
using namespace std;
long long ans = 0;
long long val[600010];
int have[600010][2], fa[600010];
char str[600010];
int n, k;
int find(int x) { return x == fa[x] ? x : (fa[x] = find(fa[x])); }
int other(int u) { return u <= k ? u + k : u - k; }
void update(int u, long long x, long long y) {
  ans -= min(val[u], val[other(u)]);
  ans += min(x, y);
  val[u] = x;
  val[other(u)] = y;
}
int main() {
  scanf("%d%d", &n, &k);
  scanf("%s", str + 1);
  for (int i = 1; i <= k; i++) {
    int c;
    scanf("%d", &c);
    while (c--) {
      int a;
      scanf("%d", &a);
      if (have[a][0])
        have[a][1] = i;
      else
        have[a][0] = i;
    }
    val[i] = 0, val[i + k] = 1;
    fa[i] = i, fa[i + k] = i + k;
  }
  for (int i = 1; i <= n; i++) {
    if (str[i] == '0') {
      int x = find(have[i][0]), y = find(have[i][1]);
      if (!y)
        update(x, 1e7, val[other(x)]);
      else {
        long long uy = val[y], vy = val[other(y)];
        update(y, 0, 0);
        fa[y] = other(x);
        fa[other(y)] = x;
        update(x, val[x] + vy, val[other(x)] + uy);
      }
    } else {
      int x = find(have[i][0]), y = find(have[i][1]);
      if (!x) {
        printf("%lld\n", ans);
        continue;
      }
      if (!y)
        update(x, val[x], 1e7);
      else {
        long long uy = val[y], vy = val[other(y)];
        update(y, 0, 0);
        fa[y] = x;
        fa[other(y)] = other(x);
        update(x, val[x] + uy, val[other(x)] + vy);
      }
    }
    printf("%lld\n", ans);
  }
  return 0;
}
