#include <bits/stdc++.h>
using namespace std;
const int maxn = 2000;
int mark[maxn], dp[maxn][maxn], ch[maxn], par[maxn], A[maxn], ans[maxn], x, t;
int K = 0;
void dfs(int u) {
  if (u == x) K = 1;
  if (mark[u]) return;
  t++;
  mark[u] = 1;
  if (par[u]) dfs(par[u]);
  if (ch[u]) dfs(ch[u]);
}
int ted(int u) {
  if (!par[u]) return 0;
  return ted(par[u]) + 1;
}
int main() {
  int n;
  cin >> n >> x;
  dp[0][0] = 1;
  for (int i = 1; i <= n; i++) {
    cin >> par[i];
    ch[par[i]] = i;
    dp[0][i] = 1;
  }
  for (int i = 1; i <= n; i++)
    if (!mark[i]) {
      K = 0, t = 0, dfs(i);
      if (!K) A[i] = t;
    }
  t = 0;
  t = ted(x);
  ans[0] = 1;
  for (int i = 1; i <= n; i++) {
    for (int s = 1; s <= n - t - 1; s++) {
      dp[s][i] = ((s - A[i] >= 0 ? dp[s - A[i]][i - 1] : 0) || dp[s][i - 1]);
      if (dp[s][i]) ans[s] = 1;
    }
  }
  for (int i = 0; i <= n; i++)
    if (ans[i]) cout << 1 + i + t << endl;
  return 0;
}
