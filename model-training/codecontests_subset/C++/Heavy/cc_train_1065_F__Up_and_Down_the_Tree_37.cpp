#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool cmin(T& a, const T& b) {
  return a > b ? a = b, 1 : 0;
}
template <class T>
inline bool cmax(T& a, const T& b) {
  return a < b ? a = b, 1 : 0;
}
const int N = 1e6 + 5;
const int INF = 0x3f3f3f3f;
int head[N], nxt[N], ver[N], tot;
void add(int u, int v) { ver[++tot] = v, nxt[tot] = head[u], head[u] = tot; }
int dp[N], a[N], h[N], n, k;
void dfs(int u) {
  h[u] = INF;
  for (int i = head[u]; i; i = nxt[i]) {
    int v = ver[i];
    dfs(v);
    cmin(h[u], h[v] + 1);
    a[u] += a[v];
    cmax(dp[u], dp[v] - a[v]);
  }
  dp[u] += a[u];
  if (h[u] == INF) dp[u] = a[u] = 1, h[u] = 0;
  if (h[u] >= k) a[u] = 0;
}
int main() {
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    int fa;
    cin >> fa;
    add(fa, i);
  }
  dfs(1);
  cout << dp[1] << endl;
  return 0;
}
