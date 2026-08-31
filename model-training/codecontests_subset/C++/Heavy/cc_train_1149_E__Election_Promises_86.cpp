#include <bits/stdc++.h>
using namespace std;
long long h[200005], s[200005];
int n, m, a, b, ru[200006], mex[200005], fu[200005], ma;
vector<int> x[200005];
int dfs(int now) {
  if (mex[now]) return mex[now];
  for (int i = 0; i < x[now].size(); i++) dfs(x[now][i]);
  for (int i = 0; i < x[now].size(); i++) fu[mex[x[now][i]]] = now;
  for (int i = 0; i <= n; i++)
    if (fu[i] != now) return mex[now] = i;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%lld", h + i);
  for (int j = 1; j <= m; j++) {
    scanf("%d%d", &a, &b);
    x[a].push_back(b);
    ru[b]++;
  }
  for (int i = 1; i <= n; i++)
    if (ru[i] == 0) dfs(i);
  for (int i = 1; i <= n; i++) s[mex[i]] ^= h[i];
  int ans = 0;
  ma = -1;
  memset(fu, 0, sizeof(fu));
  for (int i = 1; i <= n; i++)
    if (s[mex[i]] != 0) fu[mex[i]] = 1, ma = max(ma, mex[i]);
  if (~ma) {
    puts("WIN");
    for (int i = 1; i <= n; i++) {
      if (mex[i] == ma && (h[i] ^ s[mex[i]]) < h[i]) {
        h[i] ^= s[mex[i]];
        for (int j = 0; j < x[i].size(); j++)
          if (fu[mex[x[i][j]]])
            h[x[i][j]] ^= s[mex[x[i][j]]], fu[mex[x[i][j]]] = 0;
        for (int i = 1; i <= n; i++) printf("%lld ", h[i]);
        return 0;
      }
    }
  } else
    puts("LOSE");
  return 0;
}
