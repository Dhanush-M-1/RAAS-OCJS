#include <bits/stdc++.h>
using namespace std;
const int maxn = 300005;
int dp[maxn][2], fa[maxn * 2], cnt[maxn * 2], n, k;
char buf[maxn];
int Find(int x) { return x == fa[x] ? x : fa[x] = Find(fa[x]); }
int calc(int x) {
  int y;
  if (x <= k)
    y = x + k;
  else
    y = x - k;
  x = Find(x), y = Find(y);
  if (x == 0 || y == 0) return cnt[x + y];
  return min(cnt[x], cnt[y]);
}
void Unite(int x, int y) {
  x = Find(x), y = Find(y);
  if (y == 0) swap(x, y);
  fa[y] = x;
  if (x) cnt[x] += cnt[y];
}
int main() {
  scanf("%d%d", &n, &k);
  scanf("%s", buf + 1);
  for (int i = 1; i <= k; ++i) {
    int q, id;
    scanf("%d", &q);
    while (q--) {
      scanf("%d", &id);
      if (dp[id][0])
        dp[id][1] = i;
      else
        dp[id][0] = i;
    }
    fa[i] = i;
    fa[i + k] = i + k;
    cnt[i + k] = 1;
  }
  int ans = 0;
  for (int i = 1; i <= n; ++i) {
    if (dp[i][1] == 0) {
      int x = dp[i][0];
      if (x) {
        ans -= calc(x);
        if (buf[i] == '1')
          fa[Find(x + k)] = 0;
        else
          fa[Find(x)] = 0;
        ans += calc(x);
      }
    } else {
      int x = dp[i][0], y = dp[i][1];
      if (buf[i] == '1') {
        if (Find(x) != Find(y)) {
          ans -= calc(x), ans -= calc(y);
          Unite(x, y);
          Unite(x + k, y + k);
          ans += calc(x);
        }
      } else {
        if (Find(x) != Find(y + k)) {
          ans -= calc(x), ans -= calc(y);
          Unite(x, y + k);
          Unite(x + k, y);
          ans += calc(x);
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
