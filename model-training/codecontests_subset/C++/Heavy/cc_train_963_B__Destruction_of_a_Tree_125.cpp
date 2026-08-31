#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void gmax(T &x, T y) {
  x = x > y ? x : y;
}
template <typename T>
inline void gmin(T &x, T y) {
  x = x < y ? x : y;
}
const int MAXN = 200010;
int n, rt;
int f[MAXN];
int dp[MAXN];
vector<int> G[MAXN];
void dfs(int x) {
  int sz = G[x].size();
  for (register unsigned i = 0; i < G[x].size(); i++) {
    int y = G[x][i];
    dfs(y);
    if (dp[y]) sz--;
  }
  dp[x] = sz & 1;
}
void dfs2(int x) {
  for (register unsigned i = 0; i < G[x].size(); i++) {
    int y = G[x][i];
    if (dp[y]) dfs2(y);
  }
  printf("%d\n", x);
  for (register unsigned i = 0; i < G[x].size(); i++) {
    int y = G[x][i];
    if (!dp[y]) dfs2(y);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &f[i]), G[f[i]].push_back(i);
  for (int i = 1; i <= n; i++)
    if (!f[i]) {
      rt = i;
      break;
    }
  dfs(rt);
  if (!dp[rt]) {
    puts("YES");
    dfs2(rt);
  } else
    puts("NO");
  return 0;
}
