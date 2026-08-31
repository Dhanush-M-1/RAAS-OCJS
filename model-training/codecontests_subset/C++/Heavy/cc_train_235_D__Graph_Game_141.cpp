#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void smin(T &a, const U &b) {
  if (a > b) a = b;
}
template <typename T, typename U>
inline void smax(T &a, const U &b) {
  if (a < b) a = b;
}
template <class T>
inline void gn(T &first) {
  char c, sg = 0;
  while (c = getchar(), (c > '9' || c < '0') && c != '-')
    ;
  for ((c == '-' ? sg = 1, c = getchar() : 0), first = 0; c >= '0' && c <= '9';
       c = getchar())
    first = (first << 1) + (first << 3) + c - '0';
  if (sg) first = -first;
}
template <class T1, class T2>
inline void gn(T1 &x1, T2 &x2) {
  gn(x1), gn(x2);
}
int power(int a, int b, int m, int ans = 1) {
  for (; b; b >>= 1, a = 1LL * a * a % m)
    if (b & 1) ans = 1LL * ans * a % m;
  return ans;
}
vector<int> adj[3030];
int vst[3030], fa[3030];
int flag[3030];
int id[3030];
int dfs(int u) {
  vst[u] = 1;
  for (int v : adj[u]) {
    if (v == fa[u]) continue;
    if (vst[v]) {
      int len = 0;
      while (u != v) {
        flag[u] = ++len;
        id[len] = u;
        u = fa[u];
      }
      flag[u] = ++len;
      id[len] = u;
      return len;
    }
    fa[v] = u;
    int res = dfs(v);
    if (res) return res;
  }
  return 0;
}
int top[3030], dep[3030];
void dfs(int u, int root, int f = -1) {
  top[u] = root;
  for (int v : adj[u]) {
    if (v == f || flag[v]) continue;
    dep[v] = dep[u] + 1;
    dfs(v, root, u);
  }
}
int dp[3030];
void dfs1(int u, int f = -1) {
  for (int v : adj[u]) {
    if (v == f || flag[v]) continue;
    dp[v] = dp[u] + 1;
    dfs1(v, u);
  }
}
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int u, v;
    gn(u, v);
    adj[u].push_back(v);
    adj[v].push_back(u);
  }
  int len = dfs(0);
  for (int i = 1; i <= len; i++) dfs(id[i], id[i]);
  double ans = 0;
  for (int i = 0; i < n; i++) {
    int tmp = flag[top[i]];
    flag[top[i]] = 0;
    dp[i] = 0;
    dfs1(i);
    flag[top[i]] = tmp;
    for (int j = 0; j < n; j++) {
      if (top[i] == top[j]) {
        ans += 1.0 / (dp[j] + 1);
        continue;
      }
      int a = dep[i] + dep[j] + 2;
      int b = abs(flag[top[i]] - flag[top[j]]) - 1;
      int c = len - b - 2;
      ans += 1.0 / (a + b) + 1.0 / (a + c) - 1.0 / (a + b + c);
    }
  }
  printf("%.15lf\n", ans);
  return 0;
}
