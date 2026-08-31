#include <bits/stdc++.h>
using namespace std;
const int maxn = 1100;
const int inf = 1e9 + 7;
const long long mod = 1e9 + 7;
int a[maxn];
int g[maxn];
int vis[maxn];
int dp[maxn][maxn];
int n, x;
int xpos = -1;
bool contains_x;
int dfs(int u) {
  if (vis[u]) {
    return 0;
  }
  vis[u] = 1;
  int res = 1;
  if (a[u] == -1) {
    res = 1;
  } else {
    res = dfs(a[u]) + 1;
  }
  if (u == x) {
    contains_x = true;
    xpos = res;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> x;
  x--;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    a[i]--;
    if (a[i] != -1) {
      g[a[i]] = true;
    }
  }
  vector<int> v;
  for (int i = 0; i < n; i++) {
    if (!vis[i] && !g[i]) {
      contains_x = false;
      int len = dfs(i);
      if (!contains_x) {
        v.push_back(len);
      }
    }
  }
  dp[0][xpos] = 1;
  for (int i = 0; i < v.size(); i++) {
    for (int j = 1; j <= n; j++) {
      dp[i + 1][j] |= dp[i][j];
      if (j + v[i] <= n) {
        dp[i + 1][j + v[i]] |= dp[i][j];
      }
    }
  }
  for (int j = 1; j <= n; j++) {
    if (dp[v.size()][j] == 1) {
      cout << j << endl;
    }
  }
}
