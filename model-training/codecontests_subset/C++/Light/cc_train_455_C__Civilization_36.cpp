#include <bits/stdc++.h>
using namespace std;
const int MAXN = 3e5 + 5, MAXM = MAXN << 1;
int head[MAXM], nxt[MAXM], v[MAXM], cnt;
int dp[MAXN], len[MAXN], f[MAXN];
bool tag[MAXN];
int n, m, q;
inline int Find(int x) { return f[x] == x ? x : f[x] = Find(f[x]); }
inline void Addline(int x, int y) {
  v[cnt] = y, nxt[cnt] = head[x], head[x] = cnt++;
}
inline void DP(int x, int from) {
  for (int i = head[x]; ~i; i = nxt[i])
    if (v[i] != from) {
      DP(v[i], x);
      dp[x] = max(dp[x], len[x] + len[v[i]] + 1);
      dp[x] = max(dp[x], dp[v[i]]);
      len[x] = max(len[x], len[v[i]] + 1);
    }
  return;
}
signed main(void) {
  cin >> n >> m >> q;
  for (int i = 1; i <= n; i++) f[i] = i;
  memset(head, -1, sizeof head);
  for (int i = 1, x, y; i <= m; i++) {
    scanf("%d %d", &x, &y);
    Addline(x, y), Addline(y, x);
    f[Find(x)] = Find(y);
  }
  for (int i = 1; i <= n; i++)
    if (!tag[Find(i)]) DP(Find(i), 0), tag[Find(i)] = true;
  for (int i = 1, opt, x, y; i <= q; i++) {
    scanf("%d", &opt);
    if (opt == 1) scanf("%d", &x), printf("%d\n", dp[Find(x)]);
    if (opt == 2) {
      scanf("%d %d", &x, &y);
      x = Find(x), y = Find(y);
      if (x != y) {
        dp[x] = max(max(dp[x], dp[y]), (dp[x] + 1) / 2 + (dp[y] + 1) / 2 + 1);
        f[y] = x;
      }
    }
  }
  return 0;
}
